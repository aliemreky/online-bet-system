package com.online.bet.system.controller;

import com.online.bet.system.dto.CreateMatchCommand;
import com.online.bet.system.service.match.MatchDomainService;
import jakarta.validation.Valid;
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
    public Boolean createMatch(@Valid @RequestBody CreateMatchCommand createMatchCommand) {
        matchDomainService.createMatch(createMatchCommand);
        return true;
    }

}
