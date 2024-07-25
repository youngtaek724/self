package com.example.app.hotel.service;

import com.example.app.admin.mapper.AdminMapper;
import com.example.app.admin.vo.AdminLoginVO;
import com.example.app.common.util.RequestAPI;
import com.example.app.controller.ApiController;
import com.example.app.exception.SeskException;
import com.example.app.exception.enums.ExceptionCode;
import com.example.app.common.util.RequestAPI;
import com.example.app.controller.ApiController;
import com.example.app.hotel.mapper.HotelMapper;
import com.example.app.hotel.vo.HotelsInfoVO;
import com.example.app.hotel.vo.Top10HotelsVO;
import com.example.app.security.enums.RoleType;
import com.example.app.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelMapper hotelMapper;
    private final ApiController apiController;
    /*메인페이지 top10 호텔목록*/
    public List<Top10HotelsVO> showTop10Hotels(String local) {
      List<Top10HotelsVO> list = hotelMapper.selectTop10Hotels(local);
      for (int i = 0; i < list.size(); i++) {list.get(i).setRanking(i + 1);}
      return list;
    }
    /*Hotels 페이지 방정보 */
    public void hotelsInfo(int hotelId, int adultCnt, int childAges, LocalDate checkIn, LocalDate checkOut) throws IOException {
        log.info("*******hotelsInfo Service********");
        log.info(checkIn.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));

        String year = String.valueOf(checkIn.getYear());
        String month = String.valueOf(checkIn.getMonthValue());
        Map<String, Object> holidays = RequestAPI.holidayInfoAPI(year, month);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String checkInDate = checkIn.format(formatter);
        String checkOutDate = checkOut.format(formatter);
/*
        List<Map<String, Object>> arr2 = hotelMapper.selectPrice(2, checkInDate, checkOutDate);
        arr2.forEach(row->{
            Object date = row.get("date");
            Object price = row.get("price");
            System.out.println("date = "+date+ "price = "+price);
        });
*/
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Map<String, Object>> arr3 = hotelMapper.selectPriceByHotelId(hotelId, checkInDate, checkOutDate);
        arr3.forEach(map -> {
            map.forEach((k, v) -> {
                System.out.println("Key: " + k + ", Value: " + v);
            });
        });
        String priceType = "a";
    }
}