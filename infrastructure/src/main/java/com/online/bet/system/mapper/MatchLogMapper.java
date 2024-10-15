package com.online.bet.system.mapper;

import com.online.bet.system.dto.MatchLogResponse;
import com.online.bet.system.entity.Match;
import com.online.bet.system.entity.MatchLog;
import com.online.bet.system.model.MatchLogModel;
import org.springframework.stereotype.Component;

@Component
public class MatchLogMapper {

    public MatchLogModel matchLogToMatchLogDto(MatchLog logEntity) {
        return MatchLogModel.builder()
                .id(logEntity.getId())
                .matchId(logEntity.getMatch().getId())
                .homeWinRate(logEntity.getHomeWinRate())
                .awayWinRate(logEntity.getAwayWinRate())
                .drawRate(logEntity.getDrawRate())
                .rateChangeTime(logEntity.getRateChangeTime())
                .build();
    }

    public MatchLog matchLogDtoToMatchLog(MatchLogModel dto, Match matchEntity) {
        return MatchLog.builder()
                .id(dto.getId())
                .match(matchEntity)
                .homeWinRate(dto.getHomeWinRate())
                .awayWinRate(dto.getAwayWinRate())
                .drawRate(dto.getDrawRate())
                .rateChangeTime(dto.getRateChangeTime())
                .build();
    }

    public MatchLogResponse matchLogToMatchLogResponse(MatchLog entity, Match matchEntity) {
        return MatchLogResponse.builder()
                .homeTeam(matchEntity.getHomeTeam())
                .awayTeam(matchEntity.getAwayTeam())
                .league(matchEntity.getLeague())
                .homeWinRate(entity.getHomeWinRate())
                .awayWinRate(entity.getAwayWinRate())
                .drawRate(entity.getDrawRate())
                .rateChangeTime(entity.getRateChangeTime())
                .build();
    }

}
