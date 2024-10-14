package com.online.bet.system.service.match;

import com.online.bet.system.model.MatchDto;
import com.online.bet.system.ports.output.MatchRepository;

import java.util.List;
import java.util.Optional;

public class MatchDomainServiceImpl implements MatchDomainService {

    private MatchRepository matchRepository;

    public MatchDomainServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public void createMatch(MatchDto matchDto) {
        matchRepository.saveMatch(matchDto);
    }

    @Override
    public Optional<MatchDto> findById(Long matchId) {
        return matchRepository.findById(matchId);
    }

    @Override
    public List<MatchDto> getMatchDtoList() {
        return matchRepository.getMatchDtoList();
    }


}
