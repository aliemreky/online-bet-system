package com.online.bet.system.ports.output;

import com.online.bet.system.model.MatchDto;

import java.util.List;
import java.util.Optional;

public interface MatchRepository {

    MatchDto saveMatch(MatchDto matchDto);

    void saveAllMatch(List<MatchDto> matchDtoList);

    Optional<MatchDto> findById(Long matchId);

    List<MatchDto> getMatchDtoList();
}
