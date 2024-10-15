package com.online.bet.system.adapters;

import com.online.bet.system.dto.CreateMatchCommand;
import com.online.bet.system.entity.Match;
import com.online.bet.system.mapper.MatchMapper;
import com.online.bet.system.model.MatchDto;
import com.online.bet.system.ports.output.MatchRepository;
import com.online.bet.system.repository.MatchJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MatchRepositoryImpl implements MatchRepository {

    @Autowired
    private MatchJpaRepository matchJpaRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Override
    public void saveMatch(CreateMatchCommand createMatchCommand) {
        Match saved = matchJpaRepository.save(matchMapper.createMatchCommandToMatchEntity(createMatchCommand));
        log.info("The match ({}) was created successfully", saved.getHomeTeam() + " - " + saved.getAwayTeam());
    }

    @Override
    public void saveAllMatch(List<MatchDto> matchDtoList) {
        matchJpaRepository.saveAll(matchDtoList.stream()
                .map(matchDto -> matchMapper.matchDtoToMatchEntity(matchDto))
                .toList());
        log.info("The matches was created successfully");

    }

    @Override
    public Optional<MatchDto> findById(Long matchId) {
        return matchJpaRepository.findById(matchId).map(matchMapper::matchEntityToMatchDto);
    }

    @Override
    public List<MatchDto> getMatchDtoList() {
        return matchJpaRepository.findAll()
                .stream()
                .map(match -> matchMapper.matchEntityToMatchDto(match))
                .toList();
    }
}
