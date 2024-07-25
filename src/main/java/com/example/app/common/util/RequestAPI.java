package com.example.app.common.util;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Configuration
@Slf4j
public class RequestAPI {
    public static String secretKey = "%2FEypC9ZLYQzQv%2B3cN4hf2LwHPB72ToeKxIy0TglDz6v5bydgzoeSn1rvbANiQFObbaW522K4vsTi1xRN9bALfQ%3D%3D";
    /*
        인증키
        일반 인증키(Encoding) : %2FEypC9ZLYQzQv%2B3cN4hf2LwHPB72ToeKxIy0TglDz6v5bydgzoeSn1rvbANiQFObbaW522K4vsTi1xRN9bALfQ%3D%3D
        일반 인증키(Decoding) : /EypC9ZLYQzQv+3cN4hf2LwHPB72ToeKxIy0TglDz6v5bydgzoeSn1rvbANiQFObbaW522K4vsTi1xRN9bALfQ==
     */

    public static Map<String, Object> holidayInfoAPI(String year, String month) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + secretKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("solYear", "UTF-8") + "=" + URLEncoder.encode(year, "UTF-8")); /*연 */
        urlBuilder.append("&" + URLEncoder.encode("solMonth", "UTF-8") + "=" + URLEncoder.encode(month.length() == 1 ? "0" + month : month, "UTF-8")); /*월*/
        urlBuilder.append("&" + URLEncoder.encode("_type", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* json으로 요청 */

        URL url = new URL(urlBuilder.toString());
        System.out.println("요청URL = " + urlBuilder);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println("Sb ==="+sb.toString());
        log.info("sb:{}",sb.toString());
        return string2Map(sb.toString());
    }

    /**
     * Json String을 Hashmap으로 반환
     *
     * @param json
     * @return
     */
    public static Map<String, Object> string2Map(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = null;

        try {
            map = mapper.readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map2Map(map);
    }

    /**
     * JSON에서 body 부분의 item만 꺼내오는 매소드
     * @param map
     * @return
     */
    public static Map<String, Object> map2Map(Map<String, Object> map) {
        Map<String, Object> items = null;
        Map<String, Object> response = castToMap(map.get("response"));
        if (response != null) {
            Map<String, Object> body = castToMap(response.get("body"));
            if (body != null) {
                items = castToMap(body.get("items"));
            }
        }
        return items;
    }
    private static Map<String, Object> castToMap(Object obj){
        if(obj instanceof Map){
            return (Map<String, Object>) obj;
        }
        return null;
    }
}
