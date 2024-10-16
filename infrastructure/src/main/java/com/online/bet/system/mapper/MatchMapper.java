package com.online.bet.system.mapper;

import com.online.bet.system.dto.CreateMatchCommand;
import com.online.bet.system.entity.Match;
import com.online.bet.system.model.MatchModel;
import com.online.bet.system.valueobject.Rate;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public MatchModel matchEntityToMatchDto(Match match) {
        return MatchModel.builder()
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

    public Match matchDtoToMatchEntity(MatchModel matchModel) {
        return Match.builder()
                .id(matchModel.getId())
                .awayTeam(matchModel.getAwayTeam())
                .awayWinRate(matchModel.getAwayWinRate().getRate())
                .homeWinRate(matchModel.getHomeWinRate().getRate())
                .drawRate(matchModel.getDrawRate().getRate())
                .league(matchModel.getLeague())
                .startTime(matchModel.getStartTime())
                .homeTeam(matchModel.getHomeTeam())
                .build();
    }

    public Match createMatchCommandToMatchEntity(CreateMatchCommand createMatchCommand){
        return Match.builder()
                .awayTeam(createMatchCommand.getAwayTeam())
                .awayWinRate(createMatchCommand.getAwayWinRate())
                .homeWinRate(createMatchCommand.getHomeWinRate())
                .drawRate(createMatchCommand.getDrawRate())
                .league(createMatchCommand.getLeague())
                .startTime(createMatchCommand.getStartTime())
                .homeTeam(createMatchCommand.getHomeTeam())
                .build();
    }

}
