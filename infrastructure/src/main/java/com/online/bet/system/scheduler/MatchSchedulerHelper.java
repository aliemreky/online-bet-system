package com.online.bet.system.scheduler;

import com.online.bet.system.dto.CreateMatchLogCommand;
import com.online.bet.system.model.MatchDto;
import com.online.bet.system.ports.output.MatchLogRepository;
import com.online.bet.system.ports.output.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MatchSchedulerHelper {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private MatchLogRepository matchLogRepository;

    @Scheduled(fixedRate = 1000)
    public void updateOddsForAllMatches() {
        List<MatchDto> matchDtoList = matchRepository.getMatchDtoList();
        if (!matchDtoList.isEmpty()) {
            matchDtoList.forEach(matchDto -> {
                matchLogRepository.saveMatchLog(new CreateMatchLogCommand(matchDto.getId()));
                matchDto.updateOdds();
            });
            matchRepository.saveAllMatch(matchDtoList);
        }
    }
}
