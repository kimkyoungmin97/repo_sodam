package com.a5a5lab.module.user.api;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.text.StringEscapeUtils;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.a5a5lab.module.common.BaseVo;


// 맛집 api 셋팅
@Service
public class apiService {
	private final String serviceKey = "ypV%2BIc0IdKPrc0ARu5HqM%2B1vQGs5eCO6y8g1AxfMBEKmaltQYGhonU4ivnxsDAwCu6LSbrI1FjCDA8L5s5OkIA%3D%3D";
	



	private final Map<String, List<apiDto>> cache = new ConcurrentHashMap<>();
	
	public List<apiDto> getRestaurantsByAreaCode(String areaCode, BaseVo vo) {
	    List<apiDto> fullList = cache.get(areaCode);

	    if (fullList == null) {
	        fullList = new ArrayList<>();
	        try {
	            int pageNo = 1;
	            int numOfRows = 1000;

	            while (true) {
	                StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
	                urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
	                urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + numOfRows);
	                urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);
	                urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
	                urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=testApp");
	                urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=B");
	                urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=39");
	                if (areaCode != null && !areaCode.trim().isEmpty() && !"0".equals(areaCode)) {
	                    urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + areaCode);
	                }
	                urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=xml");

	                URL url = new URL(urlBuilder.toString());
	                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	                conn.setRequestMethod("GET");

	                try (InputStream stream = conn.getInputStream()) {
	                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	                    Document doc = dBuilder.parse(stream);
	                    doc.getDocumentElement().normalize();

	                    NodeList itemList = doc.getElementsByTagName("item");
	                    if (itemList.getLength() == 0) break;

	                    for (int i = 0; i < itemList.getLength(); i++) {
	                        Element e = (Element) itemList.item(i);
	                        apiDto dto = new apiDto();
	                        dto.setTitle(getTagValue("title", e));
	                        dto.setAddress(getTagValue("addr1", e));
	                        dto.setImageUrl(getTagValue("firstimage", e));
	                        dto.setContentId(getTagValue("contentid", e));
	                        
	                        // 이미지 비어있으면 api 안불러옴
	                        if (dto.getImageUrl() == null || dto.getImageUrl().trim().isEmpty()) {
	                            continue;
	                        }

	                        try {
	                            dto.setMapX(parseDoubleSafe(getTagValue("mapx", e)));
	                            dto.setMapY(parseDoubleSafe(getTagValue("mapy", e)));
	                        } catch (Exception ex) {
	                            dto.setMapX(null);
	                            dto.setMapY(null);
	                        }

	                        fullList.add(dto);
	                    }


	                    if (itemList.getLength() < numOfRows) break; // 마지막 페이지
	                    pageNo++;
	                }
	            }
	            cache.put(areaCode, fullList);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // 검색 필터 처리 (공백/특수문자 제거, 대소문자 무시)
	    List<apiDto> filteredList = fullList.stream()
	        .filter(dto -> {
	            if (vo.getShOption() != null && vo.getShOption() == 1 && vo.getShValue() != null) {
	                String cleanedTitle = cleanString(dto.getTitle());
	                String cleanedSearch = cleanString(vo.getShValue());
	                return cleanedTitle.contains(cleanedSearch);
	            }
	            return true;
	        })
	        .collect(Collectors.toList());

	    vo.setParamsPaging(filteredList.size());

	    int start = vo.getStartRnumForMysql();
	    int end = Math.min(start + vo.getRowNumToShow(), filteredList.size());

	    if (start >= filteredList.size()) return new ArrayList<>();
	    return filteredList.subList(start, end);
	}


	private String getTagValue(String tag, Element e) {
	    NodeList nlList = e.getElementsByTagName(tag);
	    if (nlList.getLength() > 0) {
	        Node nValue = nlList.item(0).getFirstChild();
	        if (nValue != null) return nValue.getNodeValue();
	    }
	    return "";
	}
    
	public String extractUrlFromHtml(String html) {
	    if (html == null) return null;
	    String unescaped = StringEscapeUtils.unescapeHtml4(html);
	    Pattern pattern = Pattern.compile("href=\\\"(.*?)\\\"");
	    Matcher matcher = pattern.matcher(unescaped);
	    if (matcher.find()) {
	        return matcher.group(1);
	    }
	    return null;
	}
	
	private Double parseDoubleSafe(String str) {
	    try {
	        return (str != null && !str.isEmpty()) ? Double.parseDouble(str) : null;
	    } catch (NumberFormatException e) {
	        return null;
	    }
	}

	private String cleanString(String input) {
	    if (input == null) return "";
	    return input.toLowerCase()
	                .replaceAll("\\s+", "")           // 공백 제거
	                .replaceAll("[^가-힣a-z0-9]", ""); // 특수문자 제거
	}

	
	
	
	
	
	
	
	
    
    
    
}
