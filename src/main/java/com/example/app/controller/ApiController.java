package com.example.app.controller;

import com.example.app.common.util.RequestAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ApiController {
    @PostMapping("holidayInfoAPI")
    public ResponseEntity holidayInfoAPI(
            @PathParam("year") String year,
            @PathParam("month") String month
    ) {
        ArrayList<HashMap> responseHolidayArr = new ArrayList<>();

        try {
            Map<String, Object> holidayMap = RequestAPI.holidayInfoAPI(year,month);
            Map<String, Object> response = (Map<String, Object>) holidayMap.get("response");
            Map<String, Object> body = (Map<String, Object>) response.get("body");

            int totalCount = (int) body.get("totalCount");
            if (totalCount <= 0) {
                System.out.println("공휴일 없음");
            }
            if (totalCount == 1) {
                HashMap<String, Object> items = (HashMap<String, Object>) body.get("items");
                HashMap<String, Object> item = (HashMap<String, Object>) items.get("item");
                responseHolidayArr.add(item);
            }
            if (totalCount > 1) {
                HashMap<String, Object> items = (HashMap<String, Object>) body.get("items");
                ArrayList<HashMap<String, Object>> item = (ArrayList<HashMap<String, Object>>) items.get("item");
                for (HashMap<String, Object> itemMap : item) {
                    responseHolidayArr.add(itemMap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(responseHolidayArr);
    }
}























