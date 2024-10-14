package com.online.bet.system.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchLogResponse {
    private String league;
    private String homeTeam;
    private String awayTeam;
    private BigDecimal homeWinRate;
    private BigDecimal drawRate;
    private BigDecimal awayWinRate;
    private LocalDateTime rateChangeTime;
}
