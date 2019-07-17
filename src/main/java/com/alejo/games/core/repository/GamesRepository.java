package com.alejo.games.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alejo.games.core.modelo.Games;

public interface GamesRepository extends JpaRepository<Games, Long>{

}
