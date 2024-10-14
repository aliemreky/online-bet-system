package com.online.bet.system.adapters;

import com.online.bet.system.mapper.MatchMapper;
import com.online.bet.system.model.MatchDto;
import com.online.bet.system.ports.output.MatchRepository;
import com.online.bet.system.repository.MatchJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchRepositoryImpl implements MatchRepository {

    @Autowired
    private MatchJpaRepository matchJpaRepository;

    @Autowired
    private MatchMapper matchMapper;

    @Override
    public MatchDto saveMatch(MatchDto matchDto) {
        return matchMapper.matchEntityToMatchDto(matchJpaRepository
                .save(matchMapper.matchDtoToMatchEntity(matchDto)));
    }

    @Override
    public void saveAllMatch(List<MatchDto> matchDtoList) {
        matchJpaRepository.saveAll(matchDtoList.stream()
                .map(matchDto -> matchMapper.matchDtoToMatchEntity(matchDto))
                .toList());
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
