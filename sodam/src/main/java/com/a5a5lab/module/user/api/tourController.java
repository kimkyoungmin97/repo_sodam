package com.a5a5lab.module.user.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.a5a5lab.module.user.member.MemberService;
import com.a5a5lab.module.xdm.code.CodeController;

@Controller
public class tourController {
	  @Autowired
	  tourService tourService;
	  @Autowired
	  MemberService memberService;
	 
	  
	
	@Autowired
	CodeController codeController;
	
	
	
	@Autowired
	WeatherService weatherService;
	
	tourController(CodeController codeController) {
		this.codeController = codeController;
	}


	
	
	@RequestMapping("/LocationTour")
	public String redirectToDefaultAreaTour() {
		return "redirect:/getTours?areaCodeTour=1";

	}

	
	
	// 관광지 api
		@GetMapping("/getTours")
		public String getTours(@RequestParam("areaCodeTour") String areaCodeTour,
		                             @RequestParam(value = "page", defaultValue = "1") int page,
		                             Model model, BaseVo vo) {

		    vo.setThisPage(page);
		    vo.setRowNumToShow(5);
		    vo.setPageNumToShow(5);

		    // 관광지 리스트 조회
		    List<apiDto> list = tourService.getToursByAreaCode(areaCodeTour, vo);

		    model.addAttribute("tourList", list);
		    model.addAttribute("vo", vo);
		    model.addAttribute("areaCodeTour", areaCodeTour);
		    model.addAttribute("areaNameTour", getAreaNameByCodeTour(areaCodeTour));

		    if (!list.isEmpty()) {
		        apiDto first = list.get(0);  // 첫 번째 맛집 위치 기반 날씨 예보

		        if (first.getMapY() != null && first.getMapX() != null) {
		            List<WeatherDto> forecast = weatherService.get5DayForecast(first.getMapY(), first.getMapX());

		            // 문자열 날짜를 Date 객체로 변환
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		            for (WeatherDto weather : forecast) {
		                try {
		                    weather.setDate(sdf.parse(weather.getDateString()));
		                } catch (ParseException e) {
		                    e.printStackTrace();
		                }
		            }

		            // forecast를 5개씩 끊어서 나누기
		            List<List<WeatherDto>> chunkedForecast = new ArrayList<>();
		            int chunkSize = 5;
		            for (int i = 0; i < forecast.size(); i += chunkSize) {
		                int end = Math.min(forecast.size(), i + chunkSize);
		                chunkedForecast.add(forecast.subList(i, end));
		            }

		            model.addAttribute("chunkedForecastList", chunkedForecast);
		        }
		    }

		    return "user/location/LocationTour";
		    
		}


		public String getAreaNameByCodeTour(String areaCodeTour) {
			switch (areaCodeTour) {
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
				return "세종특별자치시";
			case "31":
				return "경기";
			case "32":
				return "강원특별자치도";
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
		
		@GetMapping("/tourDetail")
		public String gettourDetail(@RequestParam("contentId") String contentId, Model model) {
			try {
				String serviceKey = "ypV%2BIc0IdKPrc0ARu5HqM%2B1vQGs5eCO6y8g1AxfMBEKmaltQYGhonU4ivnxsDAwCu6LSbrI1FjCDA8L5s5OkIA%3D%3D";
				String url = "http://apis.data.go.kr/B551011/KorService1/detailCommon1" + "?ServiceKey=" + serviceKey
						+ "&contentTypeId=12" + "&contentId=" + contentId + "&MobileOS=ETC" + "&MobileApp=AppTest"
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
					String homepageFromApi = getTagValueTour("homepage", element); // ← 여기 추가
					String homepageUrl = tourService.extractUrlFromHtmlTour(homepageFromApi);
					String title = getTagValueTour("title", element);
					String overview = getTagValueTour("overview", element);
					String addr1 = getTagValueTour("addr1", element);
					String addr2 = getTagValueTour("addr2", element);
					String firstImage = getTagValueTour("firstimage", element);
					String contentIdFromApi = getTagValueTour("contentid", element);
					String tel = getTagValueTour("tel", element);
					String telname = getTagValueTour("telname", element);
					String zipcode = getTagValueTour("zipcode", element);
					String mapx = getTagValueTour("mapx", element);
					String mapy = getTagValueTour("mapy", element);

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

			return "user/location/TourDetail";
			
		}

		private String getTagValueTour(String tag, Element element) {
			NodeList nodeList = element.getElementsByTagName(tag);
			if (nodeList.getLength() > 0) {
				Node node = nodeList.item(0);
				return node.getTextContent();
			}
			return "";
		}

	
	

	
	
	

	

}
