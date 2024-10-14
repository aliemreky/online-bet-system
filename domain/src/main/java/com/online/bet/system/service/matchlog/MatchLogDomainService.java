package com.online.bet.system.service.matchlog;

import com.online.bet.system.dto.MatchLogResponse;

import java.util.List;

public interface MatchLogDomainService {

    List<MatchLogResponse> getAllMatchesLog();
}
