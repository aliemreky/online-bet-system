package com.online.bet.system.adapters;

import com.online.bet.system.entity.Match;
import com.online.bet.system.mapper.CouponMapper;
import com.online.bet.system.model.CouponDto;
import com.online.bet.system.ports.output.CouponRepository;
import com.online.bet.system.repository.CouponJpaRepository;
import com.online.bet.system.repository.MatchJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CouponRepositoryImpl implements CouponRepository {

    @Autowired
    private CouponJpaRepository couponJpaRepository;

    @Autowired
    private MatchJpaRepository matchJpaRepository;

    @Autowired
    private CouponMapper couponMapper;

    @Transactional
    @Override
    public void saveCoupon(CouponDto couponDto) {
        Optional<Match> optionalMatch = matchJpaRepository.findById(couponDto.getMatchId());

        if (optionalMatch.isPresent()) {
            Match match = optionalMatch.get();
            couponJpaRepository.save(couponMapper.couponToCouponDto(couponDto, match));
        }
    }

}
