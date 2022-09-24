package com.cos.yippeeappserver.mapper;

import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    Map<String, Object> selectUserInfo(String phone);

    void addStamp(Map<String, Object> param);

    void addStampAnduseCoupon(Map<String, Object> param);

    void updateStamp(String phone);
}
