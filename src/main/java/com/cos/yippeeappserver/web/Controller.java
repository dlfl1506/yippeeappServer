package com.cos.yippeeappserver.web;

import com.cos.yippeeappserver.web.dto.CMRespDto;
import com.cos.yippeeappserver.web.dto.RespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

@RequiredArgsConstructor
@RestController
public class Controller extends Yippeeapp {

    private int coupon;

    @GetMapping("/search")
    public CMRespDto<?> test(String phone) {
        System.out.println("phone:" + phone);
        jf.setText(phone);
/*        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("크크크");
                coupon = Integer.parseInt(jf3.getText());
            }
        });*/
       Scanner scanner = new Scanner(System.in);
        System.out.print("resp : ");
        int coupon = scanner.nextInt();
        System.out.println("coupon:"+coupon);
        RespDto respDto = new RespDto();
        respDto.setCoupon(coupon);
        return new CMRespDto<>(1, respDto);
    }
}
