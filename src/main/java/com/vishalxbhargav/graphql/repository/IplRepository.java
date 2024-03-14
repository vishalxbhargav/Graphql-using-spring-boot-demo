package com.vishalxbhargav.graphql.repository;

import com.vishalxbhargav.graphql.model.Ipl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IplRepository extends JpaRepository<Ipl,Integer> {
}
