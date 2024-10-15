package com.online.bet.system.mapper;

import com.online.bet.system.entity.Coupon;
import com.online.bet.system.entity.Match;
import com.online.bet.system.model.CouponModel;
import org.springframework.stereotype.Component;

@Component
public class CouponMapper {

    public Coupon couponToCouponDto(CouponModel couponModel, Match match) {
        return Coupon.builder()
                .couponCount(couponModel.getCouponCount())
                .betTime(couponModel.getBetTime())
                .couponStatus(couponModel.getCouponStatus())
                .betRate(couponModel.getBetRate().getRate())
                .match(match)
                .build();
    }
}
