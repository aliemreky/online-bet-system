package com.online.bet.system.model;

import com.online.bet.system.valueobject.CouponStatus;
import com.online.bet.system.valueobject.Rate;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponModel {

    private Long id;
    private Long matchId;
    private Rate betRate;
    private LocalDateTime betTime;
    private Integer couponCount;
    private CouponStatus couponStatus;

}
