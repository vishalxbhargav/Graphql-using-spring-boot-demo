package com.vishalxbhargav.graphql.controller;

import com.vishalxbhargav.graphql.model.Player;
import com.vishalxbhargav.graphql.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PlayerController {
    @Autowired
    private final PlayerService playerService;
    @MutationMapping
    public Player create(@Argument Integer id,@Argument Integer joursy,@Argument String name){
        System.out.println(id+""+joursy+" "+name);
        Player player=new Player(id,joursy,name);
        System.out.println(player);
        return playerService.create(player);
    }
    @MutationMapping
    public Player delete(@Argument Integer id) throws Exception {
        return playerService.delete(id);
    }
    @MutationMapping
    public Player update(@Argument Integer joursey,@Argument String name,@Argument Integer playerId ) throws Exception {
        Optional<Player> player= findOne(playerId);
        if(player.isPresent()){
            player.get().setName(name);
            player.get().setJoursy(joursey);
            return playerService.create(player.get());
        }
        throw new Exception("Player not found with this Id "+playerId);
    }
    @QueryMapping
    public List<Player> getAllPlayer(){
        return playerService.getAll();
    }
    @QueryMapping
    public Optional<Player> findOne(@Argument Integer id){
        return playerService.findById(id);
    }
}

