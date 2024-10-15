package com.online.bet.system.service.coupon;

import com.online.bet.system.dto.CreateCouponCommand;
import com.online.bet.system.exception.DomainException;
import com.online.bet.system.model.CouponModel;
import com.online.bet.system.model.MatchModel;
import com.online.bet.system.ports.output.CouponRepository;
import com.online.bet.system.ports.output.MatchRepository;
import com.online.bet.system.valueobject.CouponStatus;
import com.online.bet.system.valueobject.Rate;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public class CouponDomainServiceImpl implements CouponDomainService {

    private final CouponRepository couponRepository;
    private final MatchRepository matchRepository;

    @Value("${coupon.timeout}")
    private long couponTimeout;

    public CouponDomainServiceImpl(CouponRepository couponRepository, MatchRepository matchRepository) {
        this.couponRepository = couponRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public void createCoupon(CreateCouponCommand createCouponCommand) {
        MatchModel match = matchRepository.findById(createCouponCommand.getMatchId())
                .orElseThrow(() -> new DomainException("Match not found"));

        Rate betRate = switch (createCouponCommand.getBetType()) {
            case HOME_WIN -> match.getHomeWinRate();
            case DRAW -> match.getDrawRate();
            case AWAY_WIN -> match.getAwayWinRate();
            default -> throw new DomainException("Invalid bet type");
        };

        CouponModel coupon = new CouponModel();
        coupon.setBetTime(LocalDateTime.now());
        coupon.setBetRate(betRate);
        coupon.setCouponCount(createCouponCommand.getCouponCount());
        coupon.setMatchId(match.getId());
        coupon.setCouponStatus(CouponStatus.CREATED);

        couponRepository.saveCoupon(coupon);
    }
}
