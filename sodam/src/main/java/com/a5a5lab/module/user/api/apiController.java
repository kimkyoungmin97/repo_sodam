package com.a5a5lab.module.user.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.a5a5lab.module.common.BaseVo;
import com.a5a5lab.module.xdm.code.CodeController;

@Controller
public class apiController {

    private final CodeController codeController;
	  @Autowired
	  apiService apiservice;
	  
	  

    apiController(CodeController codeController) {
        this.codeController = codeController;
    }
	  
//	@RequestMapping(value="/LocationRestaurant")
//	public String LocationRestaurant(Model model) {
//		 
//		return "/user/location/LocationRestaurant";
//	}
	
	@RequestMapping("/LocationRestaurant")
	public String redirectToDefaultArea() {
	    return "redirect:/getRestaurants?areaCode=1";
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
//	    return "/user/location/LocationRestaurant";
//	}
	@GetMapping("/getRestaurants")
	public String getRestaurants(@RequestParam("areaCode") String areaCode,
	                             @RequestParam(value = "page", defaultValue = "1") int page,
	                             Model model, BaseVo vo) {

	    vo.setThisPage(page);
	    vo.setRowNumToShow(5);
	    vo.setPageNumToShow(5);

	    // 데이터 조회 및 페이징 처리 통합
	    List<apiDto> list = apiservice.getRestaurantsByAreaCode(areaCode, vo);
	    
	    model.addAttribute("restaurantList", list);
	    model.addAttribute("vo", vo);
	    model.addAttribute("areaCode", areaCode);
	    model.addAttribute("areaName", getAreaNameByCode(areaCode));
	    
	    // 위도 경도 디버깅용
//	    for (apiDto dto : list) {
//	        System.out.println("Title: " + dto.getTitle() + ", mapX: " + dto.getMapX() + ", mapY: " + dto.getMapY());
//	    }
	    return "/user/location/LocationRestaurant";
	}

	private String getAreaNameByCode(String areaCode) {
	    switch (areaCode) {
	        case "1": return "서울";
	        case "2": return "인천";
	        case "3": return "대전";
	        case "4": return "대구";
	        case "5": return "광주";
	        case "6": return "부산";
	        case "7": return "울산";
	        case "8": return "세종";
	        case "31": return "경기";
	        case "32": return "강원";
	        case "33": return "충북";
	        case "34": return "충남";
	        case "35": return "경북";
	        case "36": return "경남";
	        case "37": return "전북";
	        case "38": return "전남";
	        case "39": return "제주";
	        default: return "전국";
	    }
	}
	
	

	
	
	@GetMapping("/restaurantDetail")
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

	        String title = getTagValue("title", element);
	        String overview = getTagValue("overview", element);
	        String addr1 = getTagValue("addr1", element);
	        String addr2 = getTagValue("addr2", element);
	        String firstImage = getTagValue("firstimage", element);
	        String contentIdFromApi = getTagValue("contentid", element);
	        String tel = getTagValue("tel", element);
	        String telname = getTagValue("telname", element);
	        String zipcode = getTagValue("zipcode", element);
	        String homepage = getTagValue("homepage", element);
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
            model.addAttribute("homepage", homepage);
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

	    return "/user/location/RestaurantDetail";
	}

	private String getTagValue(String tag, Element element) {
	    NodeList nodeList = element.getElementsByTagName(tag);
	    if (nodeList.getLength() > 0) {
	        Node node = nodeList.item(0);
	        return node.getTextContent();
	    }
	    return "";
	}
	
	

	

}
