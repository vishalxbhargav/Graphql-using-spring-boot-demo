package com.vishalxbhargav.graphql.repository;

import com.vishalxbhargav.graphql.model.Player;
import com.vishalxbhargav.graphql.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImp implements PlayerService {
    @Autowired
    private final PlayerRepository playerRepository;
    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(Integer playerId) {
        return playerRepository.findById(playerId);
    }

    @Override
    public Player update(Player player, Integer playerId) throws Exception {
        Optional<Player> player1=findById(playerId);
        if(player1.isPresent()){
            if(player.getName()!=null) player1.get().setName(player.getName());
            if(player.getJoursy()!=null) player1.get().setJoursy(player.getJoursy());
            return playerRepository.save(player1.get());
        }else {
            throw new Exception("Player Not found with id"+playerId);
        }
    }

    @Override
    public Player delete(Integer playerId) throws Exception {
        Optional<Player> player=findById(playerId);
        if(player.isPresent()){
            playerRepository.deleteById(playerId);
            return player.get();
        }else {
            throw new Exception("Player Not found with id"+playerId);
        }
    }

    @Override
    public Player getByJoursy(Integer joursy) {
        return playerRepository.getPlayerByJoursy(joursy);
    }
}
