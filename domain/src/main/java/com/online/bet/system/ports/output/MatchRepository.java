package com.online.bet.system.ports.output;

import com.online.bet.system.dto.CreateMatchCommand;
import com.online.bet.system.model.MatchDto;

import java.util.List;
import java.util.Optional;

public interface MatchRepository {

    void saveMatch(CreateMatchCommand createMatchCommand);

    void saveAllMatch(List<MatchDto> matchDtoList);

    Optional<MatchDto> findById(Long matchId);

    List<MatchDto> getMatchDtoList();
}
