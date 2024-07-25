package com.example.app.hotel.mapper;

import com.example.app.admin.vo.AdminLoginVO;
import com.example.app.hotel.vo.HotelsInfoVO;
import com.example.app.hotel.vo.Top10HotelsVO;
import com.example.app.security.dto.CustomUserDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface HotelMapper {

  // 메인페이지 top10 호텔
  public List<Top10HotelsVO> selectTop10Hotels(String local);

  // 상시가
  public List<Map<String, Object>> selectPrice(int roomId, String startDate, String endDate);
  //호텔 id
  public List<Map<String, Object>> selectPriceByHotelId(int hotelId, String startDate, String endDate);
}
