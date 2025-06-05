package com.a5a5lab.module.user.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.a5a5lab.module.common.BaseVo;
import com.a5a5lab.module.user.member.MemberDto;
import com.a5a5lab.module.user.member.MemberService;
import com.a5a5lab.module.xdm.code.CodeController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class apiController {
	  @Autowired
	  apiService apiservice;
	  @Autowired
	  MemberService memberService;
	 
	  
	
	@Autowired
	CodeController codeController;
	
	
	
	@Autowired
	WeatherService weatherService;
	
	apiController(CodeController codeController) {
		this.codeController = codeController;
	}

//	@RequestMapping(value="/LocationRestaurant")
//	public String LocationRestaurant(Model model) {
//		 
//		return "user/location/LocationRestaurant";
//	}

	@RequestMapping("/LocationRestaurant")
	public String redirectToDefaultArea() {
		return "redirect:/getRestaurants?areaCode=1";

	}

//	 @GetMapping("/getRestaurants")
//	    public String getRestaurants(@RequestParam("areaCode") String areaCode, Model model) {
//	        List<apiDto> list = apiservice.getRestaurantsByAreaCode(areaCode);
//	        model.addAttribute("restaurantList", list);
//	        return "user/location/LocationRestaurant"; 
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
//	    return "user/location/LocationRestaurant";
//	}

//	@GetMapping("/getRestaurants")
//	public String getRestaurants(@RequestParam("areaCode") String areaCode,
//	                             @RequestParam(value = "page", defaultValue = "1") int page,
//	                             Model model, BaseVo vo) {
//
////	    BaseVo vo = new BaseVo();
//	    vo.setThisPage(page);
//	    vo.setRowNumToShow(5);
//	    vo.setPageNumToShow(5);
//
//	    int totalCount = apiservice.getTotalCountByAreaCode(areaCode);
//	    vo.setParamsPaging(totalCount);
//
//	    
//	    List<apiDto> list = apiservice.getRestaurantsByAreaCode(areaCode, page);
//	    
//	    String areaName = getAreaNameByCode(areaCode);
//
//	    model.addAttribute("restaurantList", list);
//	    model.addAttribute("vo", vo);
//	    model.addAttribute("areaCode", areaCode);
//	    model.addAttribute("areaName", areaName);
//	    
//	    System.out.println(totalCount);
//	    
//	    System.out.println("Total Count: " + totalCount);
//	    System.out.println("Total Pages: " + vo.getTotalPages());
//	    System.out.println("Start Page: " + vo.getStartPage());
//	    System.out.println("End Page: " + vo.getEndPage());
//
//	    return "user/location/LocationRestaurant";
//	}
	@GetMapping("/getRestaurants")
	public String getRestaurants(@RequestParam("areaCode") String areaCode,
	        @RequestParam(value = "page", defaultValue = "1") int page, Model model, BaseVo vo) {

	    vo.setThisPage(page);
	    vo.setRowNumToShow(5);
	    vo.setPageNumToShow(5);

	    // 맛집 리스트 조회
	    List<apiDto> list = apiservice.getRestaurantsByAreaCode(areaCode, vo);

	    model.addAttribute("restaurantList", list);
	    model.addAttribute("vo", vo);
	    model.addAttribute("areaCode", areaCode);
	    model.addAttribute("areaName", getAreaNameByCode(areaCode));

	    if (!list.isEmpty()) {
	        apiDto first = list.get(0);  // 첫 번째 맛집 정보를 가져옴

	        if (first.getMapY() != null && first.getMapX() != null) {
	            // 날씨 정보 가져오기
	            List<WeatherDto> forecast = weatherService.get5DayForecast(first.getMapY(), first.getMapX());

	            // 날짜 문자열(String)을 Date 객체로 변환
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            for (WeatherDto weather : forecast) {
	                try {
	                    weather.setDate(sdf.parse(weather.getDateString()));
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                }
	            }

	            model.addAttribute("forecastList", forecast);
	        }
	    }

	    return "user/location/LocationRestaurant";
	}


	// 총 개수 및 페이지 수
//	    int totalCount = apiservice.getTotalCountByAreaCode(areaCode); 
//	    int totalPages = (int) Math.ceil(totalCount / 10.0);
//
//	    // 현재 페이지와 총 페이지 수
//	    model.addAttribute("page", page);
//	    model.addAttribute("totalPages", totalPages);
//
//	    return "user/location/LocationRestaurant";
//
//	}

	private String getAreaNameByCode(String areaCode) {
		switch (areaCode) {
		case "1":
			return "서울";
		case "2":
			return "인천";
		case "3":
			return "대전";
		case "4":
			return "대구";
		case "5":
			return "광주";
		case "6":
			return "부산";
		case "7":
			return "울산";
		case "8":
			return "세종";
		case "31":
			return "경기";
		case "32":
			return "강원";
		case "33":
			return "충북";
		case "34":
			return "충남";
		case "35":
			return "경북";
		case "36":
			return "경남";
		case "37":
			return "전북";
		case "38":
			return "전남";
		case "39":
			return "제주";
		default:
			return "전국";
		}
	}

	@GetMapping("/restaurantDetail")
	public String getRestaurantDetail(@RequestParam("contentId") String contentId, Model model) {
		try {
			String serviceKey = "ypV%2BIc0IdKPrc0ARu5HqM%2B1vQGs5eCO6y8g1AxfMBEKmaltQYGhonU4ivnxsDAwCu6LSbrI1FjCDA8L5s5OkIA%3D%3D";
			String url = "http://apis.data.go.kr/B551011/KorService1/detailCommon1" + "?ServiceKey=" + serviceKey
					+ "&contentTypeId=39" + "&contentId=" + contentId + "&MobileOS=ETC" + "&MobileApp=AppTest"
					+ "&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y" + "&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y";

			URL apiUrl = new URL(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(apiUrl.openStream(), "UTF-8"));

			StringBuilder responseBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				responseBuilder.append(line);
			}
			reader.close();

			String xmlResponse = responseBuilder.toString();

			System.out.println("====== XML 응답 시작 ======");
			System.out.println(xmlResponse);
			System.out.println("====== XML 응답 끝 ======");

			InputSource is = new InputSource(new StringReader(xmlResponse));
			is.setEncoding("UTF-8");

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);

			Node item = document.getElementsByTagName("item").item(0);
			if (item != null && item.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) item;
				String homepageFromApi = getTagValue("homepage", element); // ← 여기 추가
				String homepageUrl = apiservice.extractUrlFromHtml(homepageFromApi);
				String title = getTagValue("title", element);
				String overview = getTagValue("overview", element);
				String addr1 = getTagValue("addr1", element);
				String addr2 = getTagValue("addr2", element);
				String firstImage = getTagValue("firstimage", element);
				String contentIdFromApi = getTagValue("contentid", element);
				String tel = getTagValue("tel", element);
				String telname = getTagValue("telname", element);
				String zipcode = getTagValue("zipcode", element);
				String mapx = getTagValue("mapx", element);
				String mapy = getTagValue("mapy", element);

				model.addAttribute("title", title);
				model.addAttribute("overview", overview);
				model.addAttribute("addr1", addr1);
				model.addAttribute("addr2", addr2);
				model.addAttribute("firstImage", firstImage);
				model.addAttribute("contentId", contentIdFromApi);
				model.addAttribute("tel", tel);
				model.addAttribute("telname", telname);
				model.addAttribute("zipcode", zipcode);
				model.addAttribute("homepage", homepageUrl);
				model.addAttribute("mapx", mapx);
				model.addAttribute("mapy", mapy);
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
	@RequestMapping("/kakaoLogin")
	public void kakaoLogin() {
		
	}

	// 카카오
	// 카카오로그인 클릭시 불러오는 메서드
	@RequestMapping("/kakaoCallback")
	public String kakaoCallback(@RequestParam("code") String code,HttpSession httpSession,MemberDto dto, HttpServletRequest request) throws JsonMappingException, JsonProcessingException {
		
		 // 1. access token 요청 준비
	    RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		// 현재 서버 도메인을 기준으로 redirect_uri를 동적으로 설정
		String redirectUri = request.getRequestURL().toString().replace(request.getRequestURI(), "") + "/kakaoCallback";



		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "dd6ae05f675628e6a259a81bde3a53cb"); // ★카카오 앱 REST API 키
		params.add("redirect_uri", redirectUri); // ★redirectUri와 일치해야 함
		params.add("code", code);
		
		HttpEntity<MultiValueMap<String, String>> request1 = new HttpEntity<>(params, headers);

	    // 2. POST 요청 보내기
	    ResponseEntity<String> response = restTemplate.postForEntity(
	            "https://kauth.kakao.com/oauth/token",
	            request1,
	            String.class
	    );
	    
	    //전체응답에서 원하는 값만 출력하기
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode jsonNode = objectMapper.readTree(response.getBody());
		

		// 3. 응답 출력
//		System.out.println("토큰 전체 응답: " + response.getBody());

	    String accessToken = jsonNode.get("access_token").asText();
	    
	    // 엑세스토큰으로 닉네임 불러오기
	    dto.setMemName(getKakaoInfo(accessToken));
	    //닉네임에 맞는 회원이 있나 확인
	    MemberDto rtt = memberService.kakaoLogin(dto);
	    if(rtt == null) {
	    	//닉네임에 맞는 회원이 없을시 회원가입폼으로 이동
	    	return"redirect:/SignupUserSelect";
	    	
	    }else {
	    	//닉네임에 맞는 회원이 있을시 세션에 값저장하고 로그인처리
	    	httpSession.setAttribute("sessLoginType","kakao");
	    	httpSession.setAttribute("sessSeqUser", rtt.getMemSeq()); //사용자Seq
	    	httpSession.setAttribute("sessIdUser", rtt.getMemId()); // ID
	    	httpSession.setAttribute("sessNameUser", rtt.getMemName());   //이름
	    	httpSession.setAttribute("sessMemTypeUser", rtt.getMemTypeCd());   //회원타입
	    	
	    	return "redirect:/indexUser";
	    }
	
	}
	
	//악세스토큰으로 사용자정보가져오기
	public String getKakaoInfo(String accessToken) throws JsonMappingException, JsonProcessingException {
		  // 2. 사용자 정보 요청
	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", "Bearer " + accessToken);
	    HttpEntity<String> request = new HttpEntity<>(headers);
	    // 2. POST 요청 보내기
	    ResponseEntity<String> response = restTemplate.postForEntity(
	    		"https://kapi.kakao.com/v2/user/me",
	            request,
	            String.class
	    );
	    // 3. 응답 출력
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode userInfo = objectMapper.readTree(response.getBody());
	    // 4. 원하는 정보 추출
	    String nickname = userInfo.path("properties").path("nickname").asText();
	    
	    return nickname;
	    
	}
	

	
	
	

	

}
