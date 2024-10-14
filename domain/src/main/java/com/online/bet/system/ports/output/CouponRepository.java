package com.online.bet.system.ports.output;

import com.online.bet.system.model.CouponDto;

public interface CouponRepository {

    void saveCoupon(CouponDto couponDto);
}
