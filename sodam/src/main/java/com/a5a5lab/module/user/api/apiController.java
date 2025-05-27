package com.a5a5lab.module.user.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
public class apiController {
	  @Autowired
	  apiService apiservice;
	  
	@RequestMapping(value="/LocationRestaurant")
	public String LocationRestaurant() {
		
		return "user/location/LocationRestaurant";
	}
	
//	 @GetMapping("/getRestaurants")
//	    public String getRestaurants(@RequestParam("areaCode") String areaCode, Model model) {
//	        List<apiDto> list = apiservice.getRestaurantsByAreaCode(areaCode);
//	        model.addAttribute("restaurantList", list);
//	        return "/user/location/LocationRestaurant"; 
//	    }
	 
//	@GetMapping("/getRestaurants")
//	public String getRestaurants(@RequestParam("areaCode") String areaCode,
//	                             @RequestParam(value = "page", defaultValue = "1") int page,
//	                             Model model) {
//	    List<apiDto> list = apiservice.getRestaurantsByAreaCode(areaCode, page);
//	    model.addAttribute("restaurantList", list);
//
//	    // 여기 추가
//	    model.addAttribute("nextPage", page + 1);
//
//	    return "/user/location/LocationRestaurant";
//	}
	
	@GetMapping("/getRestaurants")
	public String getRestaurants(@RequestParam("areaCode") String areaCode,
	                             @RequestParam(value = "page", defaultValue = "1") int page,
	                             Model model) {
	    // 음식점 
	    List<apiDto> list = apiservice.getRestaurantsByAreaCode(areaCode, page);
	    model.addAttribute("restaurantList", list);

	    // 총 개수 및 페이지 수 
	    int totalCount = apiservice.getTotalCountByAreaCode(areaCode); 
	    int totalPages = (int) Math.ceil(totalCount / 10.0);

	    // 현재 페이지와 총 페이지 수
	    model.addAttribute("page", page);
	    model.addAttribute("totalPages", totalPages);

	    return "user/location/LocationRestaurant";
	}
	
	@GetMapping("/user/location/restaurantDetail")
	public String getRestaurantDetail(@RequestParam("contentId") String contentId, Model model) {
	    try {
	        String serviceKey = "ypV%2BIc0IdKPrc0ARu5HqM%2B1vQGs5eCO6y8g1AxfMBEKmaltQYGhonU4ivnxsDAwCu6LSbrI1FjCDA8L5s5OkIA%3D%3D";
	        String url = "http://apis.data.go.kr/B551011/KorService1/detailCommon1"
	                + "?ServiceKey=" + serviceKey
	                + "&contentTypeId=39"
	                + "&contentId=" + contentId
	                + "&MobileOS=ETC"
	                + "&MobileApp=AppTest"
	                + "&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y"
	                + "&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y";

	        URL apiUrl = new URL(url);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(apiUrl.openStream(), "UTF-8"));

	        StringBuilder responseBuilder = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            responseBuilder.append(line);
	        }
	        reader.close();

	        String xmlResponse = responseBuilder.toString();


	        // 응답 디버깅
	        System.out.println("====== XML 응답 시작 ======");
	        System.out.println(xmlResponse);
	        System.out.println("====== XML 응답 끝 ======");

	        // 인코딩 
	        InputSource is = new InputSource(new StringReader(xmlResponse));
	        is.setEncoding("UTF-8");

	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document document = builder.parse(is);

	        Node item = document.getElementsByTagName("item").item(0);
	        if (item != null && item.getNodeType() == Node.ELEMENT_NODE) {
	            Element element = (Element) item;

	        String title = getTagValue("title", element);
	        String overview = getTagValue("overview", element);
	        String addr1 = getTagValue("addr1", element);
	        String firstImage = getTagValue("firstimage", element);
	        String contentIdFromApi = getTagValue("contentid", element);
	        
	        model.addAttribute("title", title);
            model.addAttribute("overview", overview);
            model.addAttribute("addr1", addr1);
            model.addAttribute("firstImage", firstImage);
            model.addAttribute("contentId", contentIdFromApi);
        } else {
            model.addAttribute("title", "데이터 없음");
            model.addAttribute("overview", "item 태그가 없습니다.");
            model.addAttribute("addr1", "-");
            model.addAttribute("firstImage", "");
	    }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("title", "API 오류");
	        model.addAttribute("overview", "API 호출 중 문제가 발생했습니다.");
	        model.addAttribute("addr1", "-");
	        model.addAttribute("firstImage", "");
	    }    

	    return "user/location/RestaurantDetail";
	}

	private String getTagValue(String tag, Element element) {
	    NodeList nodeList = element.getElementsByTagName(tag);
	    if (nodeList.getLength() > 0) {
	        Node node = nodeList.item(0);
	        return node.getTextContent();
	    }
	    return "";
	}
	
	//카카오
	//카카오로그인 클릭시 불러오는 메서드
	@RequestMapping("/kakaoCallback")
	public String kakaoCallback(@RequestParam("code") String code) throws JsonMappingException, JsonProcessingException {
		System.out.println("코드 한번 보자" + code);
		 // 1. access token 요청 준비
	    RestTemplate restTemplate = new RestTemplate();

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	    params.add("grant_type", "authorization_code");
	    params.add("client_id", "dd6ae05f675628e6a259a81bde3a53cb"); // ★카카오 앱 REST API 키
	    params.add("redirect_uri", "http://localhost:8080/kakaoCallback"); // ★redirectUri와 일치해야 함
	    params.add("code", code);

	    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

	    // 2. POST 요청 보내기
	    ResponseEntity<String> response = restTemplate.postForEntity(
	            "https://kauth.kakao.com/oauth/token",
	            request,
	            String.class
	    );

	    // 3. 응답 출력
	    System.out.println("토큰 전체 응답: " + response.getBody());
	    
	    //전체응답에서 원하는 값만 출력하기
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode jsonNode = objectMapper.readTree(response.getBody());

	    String accessToken = jsonNode.get("access_token").asText();
	    String idToken = jsonNode.get("id_token").asText();
	    System.out.println("액세스 토큰: " + accessToken);
	    System.out.println("아이디 토큰: " + idToken);
//	    String scope = jsonNode.get("scope").asText();
//	    System.out.println("scope: " + scope);
	    
	    //4. 아이디 토큰으로 사용자 정보 불러오기
	    
	    
	    

	    return "redirect:/indexUser";
	}
	
	
	

	

}
