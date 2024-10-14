package com.online.bet.system.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMatchLogCommand {
    private Long matchId;
}
