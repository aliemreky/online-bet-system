package com.online.bet.system.controller;

import com.online.bet.system.model.MatchDto;
import com.online.bet.system.service.match.MatchDomainService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    private final MatchDomainService matchDomainService;

    public MatchController(MatchDomainService matchService) {
        this.matchDomainService = matchService;
    }

    @PostMapping("/add")
    public Boolean addMatch(@RequestBody MatchDto createMatchCommand) {
        matchDomainService.createMatch(createMatchCommand);
        return true;
    }

}
