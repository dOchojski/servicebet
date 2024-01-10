package com.dochojski.bettingservice.service;

import com.dochojski.bettingservice.exception.BetNotFoundException;
import com.dochojski.bettingservice.model.Bet;
import com.dochojski.bettingservice.repository.BetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService {
    private final BetRepository betRepository;

    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public Bet addBet(Bet bet) {
        return betRepository.save(bet);
    }

    public Optional<Bet> getBet(Long id) {
        return betRepository.findById(id);
    }

    public Optional<Bet> updateBet(Long betId, Bet updatedBet) {
        return Optional.ofNullable(betRepository.findById(betId)
                .map(existingBet -> {
                    if (updatedBet.getAmount() != null) {
                        existingBet.setAmount(updatedBet.getAmount());
                    }
                    if (updatedBet.getOdds() != null) {
                        existingBet.setOdds(updatedBet.getOdds());
                    }
                    if (updatedBet.getBetType() != null) {
                        existingBet.setBetType(updatedBet.getBetType());
                    }
                    return betRepository.save(existingBet);
                })
                .orElseThrow(() -> new BetNotFoundException("Bet not found with id: " + betId)));
    }

    public void deleteBet(Long betId) {
        if (!betRepository.existsById(betId)) {
            throw new BetNotFoundException("Bet not found with id: " + betId);
        }
        betRepository.deleteById(betId);
    }

    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

}
