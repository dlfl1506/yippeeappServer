package com.cos.yippeeappserver.web;

import com.cos.yippeeappserver.mapper.Mapper;
import com.cos.yippeeappserver.web.dto.CMRespDto;
import com.cos.yippeeappserver.web.dto.RespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Mapper mapper;
    private int coupon;

    @GetMapping("/search")
    public CMRespDto<?> test(String phone){

        try {
            mapper.deleteStampHist();
            mapper.deleteCouponHist();
            String name;
            String coupon;
            String stamp;
            String remark;
            Map<String, Object> info = mapper.selectUserInfo(phone);

            if (info == null) {
                name = "미지정";
                stamp = "0";
                coupon = "0";
                remark = "미지정";
            } else {
                if (info.get("name") == null) {
                    name = "미지정";
                } else {
                    name = info.get("name").toString();
                }
                if (info.get("stamp") == null) {
                    stamp = "0";
                } else {
                    stamp = info.get("stamp2").toString();
                }
                if (info.get("coupon") == null) {
                    coupon = "0";
                } else {
                    coupon = info.get("coupon").toString();
                }

                if (info.get("remark") == null) {
                    remark = "미지정";
                } else {
                    remark = info.get("remark").toString();
                }
            }
            System.out.println("=============================================================");
            System.out.println("폰 번호 :" + phone);
            System.out.println("고객 명 :" + name);
            System.out.println("보유 스탬프:" + stamp);
            System.out.println("보유 쿠폰:" + coupon);
            System.out.println("고객 특이사항 :" + remark);
            System.out.print("적립 스탬프 갯수 :");
            Scanner scanner = new Scanner(System.in);
            int addStamp = scanner.nextInt();

            System.out.print("사용 쿠폰갯수 :");
            Scanner scanner2 = new Scanner(System.in);
            int useCoupon = scanner2.nextInt();

            if (info == null) { // 이미 등록된 유저정보가 없으면 insert
                Map<String, Object> param = new HashMap<>();
                param.put("phone", phone);
                int result = mapper.addStamp(param);
                if (result == 1) {
                    param.put("phone", phone);
                    param.put("qty", addStamp);
                    mapper.insertStampHist(param);
                }
            } else {
                Map<String, Object> param = new HashMap<>();
                param.put("phone", phone);
                param.put("qty", addStamp);
                param.put("count", useCoupon);
                mapper.insertStampHist(param); // 스탬프 적립

                Map<String, Object> info2 = mapper.selectUserInfo(phone); // 스탬프 적립후 다시조회
                if (Integer.parseInt(info2.get("stamp").toString()) >= 1) {  // 스탬프 가 10 개보다 크면
                    int result = mapper.deleteStamp(phone); // 스탬프 이력 전부삭제
                    if (result >= 1) {
                        Map<String, Object> param2 = new HashMap<>();
                        param2.put("phone", phone);
                        param2.put("qty", info2.get("stamp2").toString());
                        mapper.insertStampHist(param2); // 나머지만큼 스탬프 저장
                        param2.put("qty", info2.get("stamp").toString());
                        for(int i=0; i<Integer.parseInt(info2.get("stamp").toString()); i++){ // 몫 만큼 쿠폰 1씩 저장
                             mapper.insertCouponHist(param2);
                        }
                    }
                }

                List<Map<String, Object>> exist = mapper.selectCouponHist(param);
                if (exist != null) {
                    for (int i = 0; i < exist.size(); i++) {
                        mapper.useCoupon(exist.get(i).get("id").toString());// 쿠폰사용
                    }
                }
            }

            Map<String, Object> afterInfo = mapper.selectUserInfo(phone);

            System.out.println(addStamp + "개의 스탬프가 적립되고 " + useCoupon + "개의 쿠폰이 사용되었습니다.");
            System.out.println("=============================================================");
            RespDto respDto = new RespDto();
            respDto.setStamp(addStamp);
            respDto.setAfterStamp(Integer.parseInt(afterInfo.get("stamp2").toString()));
            respDto.setAfterCoupon(Integer.parseInt(afterInfo.get("coupon").toString()));
            return new CMRespDto<>(1, respDto);
        } catch (Exception e) {
            RespDto respDto = new RespDto();
            return new CMRespDto<>(2, respDto);
        }
    }
}
