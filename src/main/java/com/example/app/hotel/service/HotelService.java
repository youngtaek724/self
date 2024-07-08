package com.example.app.hotel.service;

import com.example.app.admin.mapper.AdminMapper;
import com.example.app.admin.vo.AdminLoginVO;
import com.example.app.exception.SeskException;
import com.example.app.exception.enums.ExceptionCode;
import com.example.app.hotel.mapper.HotelMapper;
import com.example.app.hotel.vo.Top10HotelsVO;
import com.example.app.security.enums.RoleType;
import com.example.app.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelMapper hotelMapper;

    /*메인페이지 top10 호텔목록*/
    public List<Top10HotelsVO> showTop10Hotels(String local) {
      List<Top10HotelsVO> list = hotelMapper.selectTop10Hotels(local);

      for (int i = 0; i < list.size(); i++) {
        list.get(i).setRanking(i + 1);
      }

      return list;
    }
}