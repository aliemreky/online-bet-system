package com.online.bet.system.controller;

import com.online.bet.system.dto.CreateCouponCommand;
import com.online.bet.system.service.coupon.CouponDomainService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    private final CouponDomainService couponDomainService;

    public CouponController(CouponDomainService couponDomainService) {
        this.couponDomainService = couponDomainService;
    }

    @PostMapping("/create")
    public Boolean createCoupon(@Valid @RequestBody CreateCouponCommand createCouponCommand) {
        couponDomainService.createCoupon(createCouponCommand);
        return true;
    }
}
