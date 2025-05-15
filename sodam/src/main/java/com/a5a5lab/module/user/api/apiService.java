package com.a5a5lab.module.user.api;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



@Service
public class apiService {
	private final String serviceKey = "ypV%2BIc0IdKPrc0ARu5HqM%2B1vQGs5eCO6y8g1AxfMBEKmaltQYGhonU4ivnxsDAwCu6LSbrI1FjCDA8L5s5OkIA%3D%3D";

	public List<apiDto> getRestaurantsByAreaCode(String areaCode, int page) {
        List<apiDto> list = new ArrayList<>();

        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=5");
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + page);
            urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
            urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=testApp");
            urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=B");
            urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=39"); 
            urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + areaCode);
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

            for (int i = 0; i < itemList.getLength(); i++) {
                Node node = itemList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    apiDto dto = new apiDto();

                    dto.setTitle(getTagValue("title", e));
                    dto.setAddress(getTagValue("addr1", e));
                    dto.setImageUrl(getTagValue("firstimage", e));
                    dto.setContentId(getTagValue("contentid", e));
                    list.add(dto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 총 레스토랑 수 
    public int getTotalCountByAreaCode(String areaCode) {
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551011/KorService1/areaBasedList1");
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=1");
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=1");
            urlBuilder.append("&" + URLEncoder.encode("MobileOS", "UTF-8") + "=ETC");
            urlBuilder.append("&" + URLEncoder.encode("MobileApp", "UTF-8") + "=testApp");
            urlBuilder.append("&" + URLEncoder.encode("arrange", "UTF-8") + "=B");
            urlBuilder.append("&" + URLEncoder.encode("contentTypeId", "UTF-8") + "=39");
            urlBuilder.append("&" + URLEncoder.encode("areaCode", "UTF-8") + "=" + areaCode);
            urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=xml");

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream stream = conn.getInputStream();
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stream);
            doc.getDocumentElement().normalize();

            NodeList totalCountList = doc.getElementsByTagName("totalCount");

            if (totalCountList.getLength() > 0) {
                String countStr = totalCountList.item(0).getTextContent();
                return Integer.parseInt(countStr);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    // 태그
    private String getTagValue(String tag, Element e) {
        NodeList nlList = e.getElementsByTagName(tag);
        if (nlList.getLength() > 0) {
            Node nValue = nlList.item(0).getFirstChild();
            if (nValue != null) return nValue.getNodeValue();
        }
        return "";
    }
    
    
}
