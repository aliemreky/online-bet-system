package com.online.bet.system.repository;

import com.online.bet.system.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchJpaRepository extends JpaRepository<Match, Long> {
}
