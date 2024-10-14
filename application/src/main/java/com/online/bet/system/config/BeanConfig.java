package com.online.bet.system.config;

import com.online.bet.system.adapters.CouponRepositoryImpl;
import com.online.bet.system.adapters.MatchLogRepositoryImpl;
import com.online.bet.system.adapters.MatchRepositoryImpl;
import com.online.bet.system.ports.output.CouponRepository;
import com.online.bet.system.ports.output.MatchLogRepository;
import com.online.bet.system.ports.output.MatchRepository;
import com.online.bet.system.service.coupon.CouponDomainService;
import com.online.bet.system.service.coupon.CouponDomainServiceImpl;
import com.online.bet.system.service.match.MatchDomainService;
import com.online.bet.system.service.match.MatchDomainServiceImpl;
import com.online.bet.system.service.matchlog.MatchLogDomainService;
import com.online.bet.system.service.matchlog.MatchLogDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MatchRepository matchRepository() {
        return new MatchRepositoryImpl();
    }

    @Bean
    public MatchDomainService matchDomainService() {
        return new MatchDomainServiceImpl(matchRepository());
    }

    @Bean
    public MatchLogRepository matchLogRepository() {
        return new MatchLogRepositoryImpl();
    }

    @Bean
    public MatchLogDomainService matchLogDomainService() {
        return new MatchLogDomainServiceImpl(matchLogRepository());
    }

    @Bean
    public CouponRepository couponRepository() {
        return new CouponRepositoryImpl();
    }

    @Bean
    public CouponDomainService couponDomainService() {
        return new CouponDomainServiceImpl(couponRepository(), matchRepository());
    }

}
