package com.vishalxbhargav.graphql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Ipl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Team team;
    @OneToMany
    private List<Player> players=new ArrayList<>(11);
}
