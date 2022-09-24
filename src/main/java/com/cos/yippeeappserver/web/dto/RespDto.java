package com.cos.yippeeappserver.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespDto {
    private int stamp;
    private int afterStamp;
    private int afterCoupon;

}
