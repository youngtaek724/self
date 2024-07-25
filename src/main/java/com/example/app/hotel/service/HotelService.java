package com.example.app.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.vo.HotelMstVO;
import com.example.app.hotel.mapper.HotelMapper;
import com.example.app.hotel.vo.Top10HotelsVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

  /*********************************************************
   * 호텔리스트 보기(지도) - TODO: 검색조건 추가하여 지역별 표시
   * 
   * @return
   */
  public List<HotelMstVO> showHotelList() {
    List<HotelMstVO> list = hotelMapper.showHotelList();
    return list;
  }
}