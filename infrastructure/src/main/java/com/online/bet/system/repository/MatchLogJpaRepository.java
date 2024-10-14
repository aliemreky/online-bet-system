package com.online.bet.system.repository;

import com.online.bet.system.entity.MatchLog;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchLogJpaRepository extends JpaRepository<MatchLog, Long> {

    @Cacheable("allMatchLog")
    @Query(value = "select log from MatchLog log order by log.id asc")
    List<MatchLog> findAllOrderByAsc();

    @Override
    @CacheEvict("allMatchLog")
    <S extends MatchLog> S save(S entity);
}
