package com.vishalxbhargav.graphql.service;

import com.vishalxbhargav.graphql.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public Player create(Player player);
    public List<Player> getAll();
    public Optional<Player> findById(Integer playerId);
    public Player update(Player player,Integer playerId) throws Exception;
    public Player delete(Integer playerId) throws Exception;
    public Player getByJoursy(Integer joursy);
}
