package com.example.app.hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.vo.HotelMstVO;
import com.example.app.hotel.vo.Top10HotelsVO;

@Mapper
public interface HotelMapper {

  // 메인페이지 top10 호텔
  public List<Top10HotelsVO> selectTop10Hotels(String local);

  // 호텔리스트 보기(지도)
  public List<HotelMstVO> showHotelList();

}
