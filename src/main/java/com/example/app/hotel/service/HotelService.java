package com.example.app.hotel.service;

import com.example.app.hotel.mapper.HotelMapper;
import com.example.app.hotel.vo.Top10HotelsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

  private final HotelMapper hotelMapper;

  /* 메인페이지 top10 호텔목록 */
  public List<Top10HotelsVO> showTop10Hotels(String local) {
    // List<Top10HotelsVO> list = hotelMapper.selectTop10Hotels(local);

    // for (int i = 0; i < list.size(); i++) {
    // list.get(i).setRanking(i + 1);
    // }

    // return list;
    return null;
  }
}