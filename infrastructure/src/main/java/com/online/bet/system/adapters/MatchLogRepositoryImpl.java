package com.online.bet.system.adapters;

import com.online.bet.system.dto.CreateMatchLogCommand;
import com.online.bet.system.dto.MatchLogResponse;
import com.online.bet.system.entity.Match;
import com.online.bet.system.entity.MatchLog;
import com.online.bet.system.mapper.MatchLogMapper;
import com.online.bet.system.ports.output.MatchLogRepository;
import com.online.bet.system.repository.MatchJpaRepository;
import com.online.bet.system.repository.MatchLogJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MatchLogRepositoryImpl implements MatchLogRepository {

    @Autowired
    private MatchLogJpaRepository matchLogJpaRepository;

    @Autowired
    private MatchJpaRepository matchJpaRepository;

    @Autowired
    private MatchLogMapper matchLogMapper;

    @Transactional
    @Override
    public void saveMatchLog(CreateMatchLogCommand createMatchLogCommand) {

        Optional<Match> optionalMatch = matchJpaRepository.findById(createMatchLogCommand.getMatchId());

        if (optionalMatch.isPresent()) {
            Match match = optionalMatch.get();
            MatchLog matchLog = MatchLog.builder()
                    .match(match)
                    .homeWinRate(match.getHomeWinRate())
                    .drawRate(match.getDrawRate())
                    .awayWinRate(match.getAwayWinRate())
                    .rateChangeTime(LocalDateTime.now())
                    .build();

            matchLogJpaRepository.save(matchLog);
        }

    }

    @Override
    public List<MatchLogResponse> getAllMatchesLog() {
        return matchLogJpaRepository.findAllOrderByAsc()
                .stream()
                .map(matchLog -> matchLogMapper.matchLogToMatchLogResponse(matchLog, matchLog.getMatch()))
                .toList();
    }
}
