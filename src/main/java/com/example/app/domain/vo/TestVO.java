package com.example.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class TestVO {


    private int userNumber;
    private int proId;
    private int proCount;
    private int proPrice;
}
