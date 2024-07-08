package com.example.app.hotel.mapper;

import com.example.app.admin.vo.AdminLoginVO;
import com.example.app.hotel.vo.Top10HotelsVO;
import com.example.app.security.dto.CustomUserDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotelMapper {

  // 메인페이지 top10 호텔
  public List<Top10HotelsVO> selectTop10Hotels(String local);

}
