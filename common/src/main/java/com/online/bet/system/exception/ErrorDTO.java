package com.online.bet.system.exception;

import lombok.Builder;

@Builder
public record ErrorDTO(String code, String message) {
}
