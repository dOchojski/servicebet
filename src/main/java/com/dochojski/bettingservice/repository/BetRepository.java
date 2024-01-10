package com.dochojski.bettingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dochojski.bettingservice.model.Bet;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByUserId(Long userId);

}
