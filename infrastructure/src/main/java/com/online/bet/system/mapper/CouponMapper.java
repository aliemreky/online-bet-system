package com.online.bet.system.mapper;

import com.online.bet.system.entity.Coupon;
import com.online.bet.system.entity.Match;
import com.online.bet.system.model.CouponDto;
import org.springframework.stereotype.Component;

@Component
public class CouponMapper {

    public Coupon couponToCouponDto(CouponDto couponDto, Match match) {
        return Coupon.builder()
                .couponCount(couponDto.getCouponCount())
                .betTime(couponDto.getBetTime())
                .couponStatus(couponDto.getCouponStatus())
                .betRate(couponDto.getBetRate().getRate())
                .match(match)
                .build();
    }
}
