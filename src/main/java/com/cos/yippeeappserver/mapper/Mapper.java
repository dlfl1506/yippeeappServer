package com.cos.yippeeappserver.mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    Map<String, Object> selectUserInfo(String phone);

    int addStamp(Map<String, Object> param);

    List<Map<String, Object>> selectCouponHist(Map<String, Object> param);
    int useCoupon(String id);
    int deleteStamp(String phone);

    void insertStampHist(Map<String, Object> param);

    void insertCouponHist(Map<String, Object> param);

    void deleteStampHist();

    void deleteCouponHist();
}
