package com.online.bet.system.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchLogDto {

    private Long id;

    private Long matchId;
    private BigDecimal homeWinRate;
    private BigDecimal drawRate;
    private BigDecimal awayWinRate;

    private LocalDateTime rateChangeTime;
}
