package com.alejo.games.core.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejo.games.core.modelo.Games;
import com.alejo.games.core.repository.GamesRepository;

@Service
public class GamesDAO {
	@Autowired
	GamesRepository gamesRepo;

	public Games save(Games game) {
		return gamesRepo.save(game);
	}
	
	public List<Games> findAll(){
		return gamesRepo.findAll();
	}
	
	public Optional<Games> findById(Long id) {
		return gamesRepo.findById(id);
	}
	
	public void deleteByID(Long id) {
		gamesRepo.deleteById(id);
	}
}
