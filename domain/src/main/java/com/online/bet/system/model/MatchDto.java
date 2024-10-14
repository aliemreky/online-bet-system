package com.online.bet.system.model;

import com.online.bet.system.valueobject.Rate;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchDto {

    private Long id;
    private String league;
    private String homeTeam;
    private String awayTeam;
    private Rate homeWinRate;
    private Rate drawRate;
    private Rate awayWinRate;
    private LocalDateTime startTime;

    public void updateOdds() {
        this.homeWinRate = new Rate(this.homeWinRate.generateRandomRate());
        this.drawRate = new Rate(this.drawRate.generateRandomRate());
        this.awayWinRate = new Rate(this.awayWinRate.generateRandomRate());
    }
}
