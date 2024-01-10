package com.dochojski.bettingservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Bet {
    private Integer id;
    private Long userId;
    private Long matchId;
    private BigDecimal amount;
    private BigDecimal odds;
    private String betType;
    private LocalDateTime timestamp;

    public Bet(Integer id, Long userId, Long matchId, BigDecimal amount, BigDecimal odds, String betType, LocalDateTime timestamp) {
        this.id = id;
        this.userId = userId;
        this.matchId = matchId;
        this.amount = amount;
        this.odds = odds;
        this.betType = betType;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getOdds() {
        return odds;
    }

    public void setOdds(BigDecimal odds) {
        this.odds = odds;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
