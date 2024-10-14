package com.online.bet.system.mapper;

import com.online.bet.system.entity.Match;
import com.online.bet.system.model.MatchDto;
import com.online.bet.system.valueobject.Rate;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public MatchDto matchEntityToMatchDto(Match match) {
        return MatchDto.builder()
                .id(match.getId())
                .awayTeam(match.getAwayTeam())
                .awayWinRate(new Rate(match.getAwayWinRate()))
                .homeWinRate(new Rate(match.getHomeWinRate()))
                .drawRate(new Rate(match.getDrawRate()))
                .league(match.getLeague())
                .startTime(match.getStartTime())
                .homeTeam(match.getHomeTeam())
                .build();
    }

    public Match matchDtoToMatchEntity(MatchDto matchDto) {
        return Match.builder()
                .id(matchDto.getId())
                .awayTeam(matchDto.getAwayTeam())
                .awayWinRate(matchDto.getAwayWinRate().getRate())
                .homeWinRate(matchDto.getHomeWinRate().getRate())
                .drawRate(matchDto.getDrawRate().getRate())
                .league(matchDto.getLeague())
                .startTime(matchDto.getStartTime())
                .homeTeam(matchDto.getHomeTeam())
                .build();
    }

}
