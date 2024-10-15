package com.online.bet.system.service.match;

import com.online.bet.system.dto.CreateMatchCommand;
import com.online.bet.system.model.MatchModel;
import com.online.bet.system.ports.output.MatchRepository;

import java.util.List;
import java.util.Optional;

public class MatchDomainServiceImpl implements MatchDomainService {

    private MatchRepository matchRepository;

    public MatchDomainServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public void createMatch(CreateMatchCommand createMatchCommand) {
        matchRepository.saveMatch(createMatchCommand);
    }

    @Override
    public Optional<MatchModel> findById(Long matchId) {
        return matchRepository.findById(matchId);
    }

    @Override
    public List<MatchModel> getMatchDtoList() {
        return matchRepository.getMatchDtoList();
    }


}
