package com.online.bet.system.dto;

import com.online.bet.system.valueobject.BetType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CreateCouponCommand {

    @Min(value = 1)
    @Max(value = 500)
    private Integer couponCount;
    @NotNull
    private Long matchId;
    @NotNull
    private BetType betType;

}
