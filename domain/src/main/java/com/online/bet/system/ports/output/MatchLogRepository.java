package com.online.bet.system.ports.output;

import com.online.bet.system.dto.CreateMatchLogCommand;
import com.online.bet.system.dto.MatchLogResponse;

import java.util.List;

public interface MatchLogRepository {

    void saveMatchLog(CreateMatchLogCommand createMatchLogCommand);

    List<MatchLogResponse> getAllMatchesLog();
}
