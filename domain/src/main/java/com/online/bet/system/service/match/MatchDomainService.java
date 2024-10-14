package com.online.bet.system.service.match;

import com.online.bet.system.model.MatchDto;

import java.util.List;
import java.util.Optional;

public interface MatchDomainService {

    void createMatch(MatchDto matchDto);

    Optional<MatchDto> findById(Long matchId);

    List<MatchDto> getMatchDtoList();
}
