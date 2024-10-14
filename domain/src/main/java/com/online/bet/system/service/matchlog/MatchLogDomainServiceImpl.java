package com.online.bet.system.service.matchlog;

import com.online.bet.system.dto.MatchLogResponse;
import com.online.bet.system.ports.output.MatchLogRepository;

import java.util.List;

public class MatchLogDomainServiceImpl implements MatchLogDomainService {

    private final MatchLogRepository matchLogRepository;

    public MatchLogDomainServiceImpl(MatchLogRepository matchLogRepository) {
        this.matchLogRepository = matchLogRepository;
    }

    @Override
    public List<MatchLogResponse> getAllMatchesLog() {
        return matchLogRepository.getAllMatchesLog();
    }
}
