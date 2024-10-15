package com.online.bet.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CreateMatchCommand {
    @NotNull
    private String league;
    @NotNull
    private String homeTeam;
    @NotNull
    private String awayTeam;
    @NotNull
    private BigDecimal homeWinRate;
    @NotNull
    private BigDecimal drawRate;
    @NotNull
    private BigDecimal awayWinRate;
    @NotNull
    private LocalDateTime startTime;
}
