package com.dochojski.bettingservice.controller;

import com.dochojski.bettingservice.exception.BetNotFoundException;
import com.dochojski.bettingservice.model.Bet;
import com.dochojski.bettingservice.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bets")
public class BetController {

    private final BetService betService;

    @Autowired
    public BetController(BetService betService) {
        this.betService = betService;
    }

    @PostMapping
    public ResponseEntity<Bet> addBet(@RequestBody Bet bet) {
        Bet savedBet = betService.addBet(bet);
        return ResponseEntity.ok(savedBet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bet> getBet(@PathVariable Long id) {
        return betService.getBet(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Bet> getAllBets() {
        return betService.getAllBets();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bet> updateBet(@PathVariable Long id, @RequestBody Bet bet) {
        return betService.updateBet(id, bet)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBet(@PathVariable Long id) {
        try {
            betService.deleteBet(id);
            return ResponseEntity.ok().build();
        } catch (BetNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
