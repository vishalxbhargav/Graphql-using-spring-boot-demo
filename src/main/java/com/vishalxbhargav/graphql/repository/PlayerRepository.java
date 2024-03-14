package com.vishalxbhargav.graphql.repository;

import com.vishalxbhargav.graphql.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
    public Player getPlayerByJoursy(Integer joursy);
}
