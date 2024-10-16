package com.online.bet.system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "match")
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String league;

    private String homeTeam;

    private String awayTeam;

    private BigDecimal homeWinRate;

    private BigDecimal drawRate;

    private BigDecimal awayWinRate;

    private LocalDateTime startTime;

}
