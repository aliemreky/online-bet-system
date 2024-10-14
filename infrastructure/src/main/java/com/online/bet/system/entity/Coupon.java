package com.online.bet.system.entity;

import com.online.bet.system.valueobject.CouponStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon")
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Match match;

    private BigDecimal betRate;

    private LocalDateTime betTime;

    private boolean isSuccessful;

    private Integer couponCount;

    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus;
}
