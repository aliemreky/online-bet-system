package com.online.bet.system.controller;

import com.online.bet.system.dto.MatchLogResponse;
import com.online.bet.system.service.matchlog.MatchLogDomainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/matchLog")
public class MatchLogController {

    private final MatchLogDomainService matchDomainService;

    public MatchLogController(MatchLogDomainService matchDomainService) {
        this.matchDomainService = matchDomainService;
    }

    @GetMapping("/all")
    public List<MatchLogResponse> getAllMatches() {
        return matchDomainService.getAllMatchesLog();
    }

}
