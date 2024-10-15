package com.online.bet.system.ports.output;

import com.online.bet.system.model.CouponModel;

public interface CouponRepository {

    void saveCoupon(CouponModel couponModel);
}
