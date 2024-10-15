package com.online.bet.system.ports.output;

import com.online.bet.system.dto.CreateMatchCommand;
import com.online.bet.system.model.MatchModel;

import java.util.List;
import java.util.Optional;

public interface MatchRepository {

    void saveMatch(CreateMatchCommand createMatchCommand);

    void saveAllMatch(List<MatchModel> matchModelList);

    Optional<MatchModel> findById(Long matchId);

    List<MatchModel> getMatchDtoList();
}
