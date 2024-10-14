package com.online.bet.system.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.bet.system.entity.MatchLog;
import com.online.bet.system.exception.DomainException;
import com.online.bet.system.mapper.MatchLogMapper;
import com.online.bet.system.repository.MatchLogJpaRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MatchPushService {

    private final WebSocketMessageHandler webSocketMessageHandler;
    private final MatchLogJpaRepository matchLogJpaRepository;
    private final ObjectMapper objectMapper;
    private final MatchLogMapper matchLogMapper;

    public MatchPushService(WebSocketMessageHandler webSocketMessageHandler,
                            MatchLogJpaRepository matchLogJpaRepository, ObjectMapper objectMapper, MatchLogMapper matchLogMapper) {
        this.webSocketMessageHandler = webSocketMessageHandler;
        this.matchLogJpaRepository = matchLogJpaRepository;
        this.objectMapper = objectMapper;
        this.matchLogMapper = matchLogMapper;
    }

    @Scheduled(fixedRate = 5000)
    public void pushDataToClients() {
        List<MatchLog> matchLogs = matchLogJpaRepository.findAllOrderByAsc();

        matchLogs.forEach(matchLog ->
        {
            try {
                webSocketMessageHandler.sendMessageToAllClients(
                        objectMapper.writeValueAsString(matchLogMapper.matchLogToMatchLogDto(matchLog))
                );
            } catch (IOException e) {
                throw new DomainException("Error : " + e.getMessage());
            }
        });
    }
}
