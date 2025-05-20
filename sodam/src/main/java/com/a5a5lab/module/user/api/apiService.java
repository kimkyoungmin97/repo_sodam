package com.a5a5lab.module.user.api;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.a5a5lab.module.common.BaseVo;



@Service
public class apiService {
	private final String serviceKey = "ypV%2BIc0IdKPrc0ARu5HqM%2B1vQGs5eCO6y8g1AxfMBEKmaltQYGhonU4ivnxsDAwCu6LSbrI1FjCDA8L5s5OkIA%3D%3D";
	
//	public List<apiDto> getRestaurantsByAreaCode(String areaCode, int page) {
//        List<apiDto> list = new ArrayList<>();
//
//        try {
//            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
//            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
//            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=5");
//            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + page);
//            urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
//            urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=testApp");
//            urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=B");
//            urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=39"); 
//            urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + areaCode);
//            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=xml");
//
//            URL url = new URL(urlBuilder.toString());
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            InputStream stream = conn.getInputStream();
//            
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(stream);
//            doc.getDocumentElement().normalize();
//
//            NodeList itemList = doc.getElementsByTagName("item");
//
//            for (int i = 0; i < itemList.getLength(); i++) {
//                Node node = itemList.item(i);
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element e = (Element) node;
//                    apiDto dto = new apiDto();
//
//                    dto.setTitle(getTagValue("title", e));
//                    dto.setAddress(getTagValue("addr1", e));
//                    dto.setImageUrl(getTagValue("firstimage", e));
//                    dto.setContentId(getTagValue("contentid", e));
//                    list.add(dto);
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
//	public List<apiDto> getRestaurantsByAreaCode(String areaCode, int page, BaseVo vo) {
//	    List<apiDto> list = new ArrayList<>();
//
//	    try {
//	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
//	        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=1000"); // 검색 필터링 위해 넉넉히 받아오기
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + 1);
//	        urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
//	        urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=testApp");
//	        urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=B");
//	        urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=39");
//	        urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + areaCode);
//	        urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=xml");
//
//	        URL url = new URL(urlBuilder.toString());
//	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        conn.setRequestMethod("GET");
//
//	        InputStream stream = conn.getInputStream();
//
//	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	        Document doc = dBuilder.parse(stream);
//	        doc.getDocumentElement().normalize();
//
//	        NodeList itemList = doc.getElementsByTagName("item");
//	        
//	        for (int i = 0; i < itemList.getLength(); i++) {
//	            Node node = itemList.item(i);
//	            if (node.getNodeType() == Node.ELEMENT_NODE) {
//	                Element e = (Element) node;
//	                apiDto dto = new apiDto();
//
//	                dto.setTitle(getTagValue("title", e));
//	                dto.setAddress(getTagValue("addr1", e));
//	                dto.setImageUrl(getTagValue("firstimage", e));
//	                dto.setContentId(getTagValue("contentid", e));
//
//	                // 검색어 필터링 (shOption: 1 = title 검색)
//	                if (vo.getShOption() != null && vo.getShOption() == 1 && vo.getShValue() != null) {
//	                    if (!dto.getTitle().toLowerCase().contains(vo.getShValue().toLowerCase())) {
//	                        continue; // 필터링된 데이터는 skip
//	                    }
//	                }
//
//	                list.add(dto);
//	            }
//	        }
//
//	        // 페이징 처리된 부분만 자르기
//	        int start = vo.getStartRnumForMysql();
//	        int end = Math.min(start + vo.getRowNumToShow(), list.size());
//	        if (start < list.size()) {
//	            list = list.subList(start, end);
//	        } else {
//	            list = new ArrayList<>();
//	        }
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return list;
//	}


   
//    public int getTotalCountByAreaCode(String areaCode) {
//        try {
//            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
//            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
//            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=1");
//            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=1");
//            urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
//            urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=testApp");
//            urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=B");
//            urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=39");
//            urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + areaCode);
//            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=xml");
//
//            URL url = new URL(urlBuilder.toString());
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//
//            InputStream stream = conn.getInputStream();
//            
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(stream);
//            doc.getDocumentElement().normalize();
//
//            NodeList totalCountList = doc.getElementsByTagName("totalCount");
//
//            if (totalCountList.getLength() > 0) {
//                String countStr = totalCountList.item(0).getTextContent();
//                return Integer.parseInt(countStr);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return 0;
//    }

//	public int getTotalCountByAreaCode(String areaCode, BaseVo vo) {
//	    int count = 0;
//	    try {
//	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
//	        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
//	        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=1000");
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=1");
//	        urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
//	        urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=testApp");
//	        urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=B");
//	        urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=39");
//	        urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + areaCode);
//	        urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=xml");
//
//	        URL url = new URL(urlBuilder.toString());
//	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//	        conn.setRequestMethod("GET");
//
//	        InputStream stream = conn.getInputStream();
//
//	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	        Document doc = dBuilder.parse(stream);
//	        doc.getDocumentElement().normalize();
//
//	        NodeList itemList = doc.getElementsByTagName("item");
//
//	        for (int i = 0; i < itemList.getLength(); i++) {
//	            Node node = itemList.item(i);
//	            if (node.getNodeType() == Node.ELEMENT_NODE) {
//	                Element e = (Element) node;
//	                String title = getTagValue("title", e);
//
//	                if (vo.getShOption() != null && vo.getShOption() == 1 && vo.getShValue() != null) {
//	                    if (!title.toLowerCase().contains(vo.getShValue().toLowerCase())) {
//	                        continue;
//	                    }
//	                }
//
//	                count++;
//	            }
//	        }
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return count;
//	}

	private final Map<String, List<apiDto>> cache = new ConcurrentHashMap<>();

	public List<apiDto> getRestaurantsByAreaCode(String areaCode, BaseVo vo) {
	    List<apiDto> fullList = cache.get(areaCode);
	    
	    if (fullList == null) {
	        fullList = new ArrayList<>();
	        try {
	            int pageNo = 1;
	            int numOfRows = 1000;
	            boolean hasMore = true;

	            while (hasMore) {
	                StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
	                urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
	                urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + numOfRows);
	                urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + pageNo);
	                urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
	                urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=testApp");
	                urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=B");
	                urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=39");
	                if (areaCode != null && !areaCode.trim().isEmpty() && !areaCode.equals("0")) {
	                    urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + areaCode);
	                }
	                urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=xml");

	                URL url = new URL(urlBuilder.toString());
	                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	                conn.setRequestMethod("GET");

	                InputStream stream = conn.getInputStream();
	                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	                Document doc = dBuilder.parse(stream);
	                doc.getDocumentElement().normalize();

	                NodeList itemList = doc.getElementsByTagName("item");
	                if (itemList.getLength() < numOfRows) hasMore = false;
	                else pageNo++;

	                for (int i = 0; i < itemList.getLength(); i++) {
	                    Element e = (Element) itemList.item(i);
	                    apiDto dto = new apiDto();
	                    dto.setTitle(getTagValue("title", e));
	                    dto.setAddress(getTagValue("addr1", e));
	                    dto.setImageUrl(getTagValue("firstimage", e));
	                    dto.setContentId(getTagValue("contentid", e));
	                    String mapXStr = getTagValue("mapx", e);
	                    String mapYStr = getTagValue("mapy", e);
	                    fullList.add(dto);
	                    
	                    try {
	                        dto.setMapX(mapXStr != null && !mapXStr.isEmpty() ? Double.parseDouble(mapXStr) : null);
	                        dto.setMapY(mapYStr != null && !mapYStr.isEmpty() ? Double.parseDouble(mapYStr) : null);
	                    } catch (NumberFormatException ex) {
	                        ex.printStackTrace(); // 파싱 실패 시 로그 출력
	                        dto.setMapX(null);
	                        dto.setMapY(null);
	                    }
	                }
	            }
	            cache.put(areaCode, fullList);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    // 검색 필터 적용
	    List<apiDto> filteredList = fullList.stream()
	            .filter(dto -> {
	                if (vo.getShOption() != null && vo.getShOption() == 1 && vo.getShValue() != null) {
	                    return dto.getTitle().toLowerCase().contains(vo.getShValue().toLowerCase());
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
    
    
    
    
}
