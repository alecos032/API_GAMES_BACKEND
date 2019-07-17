package com.alejo.games.core.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejo.games.core.dao.GamesDAO;
import com.alejo.games.core.modelo.Games;
import com.alejo.games.core.modelo.ResponseObject;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AppController {
	@Autowired
	GamesDAO gamesDao;
	
	//OBTIENE LA LISTA DE TODOS LOS JUEGOS
	@GetMapping("/games")
	public List<Games> getAllGames(){
		return gamesDao.findAll();
	}
	
	//OBTIENE UN JUEGO DADO EL ID
	@GetMapping("/games/{id}")
	public ResponseEntity<?> findGameByID(@PathVariable(value = "id") Long id){
		Games game = gamesDao.findById(id).get();
		return new ResponseEntity<>(game, new HttpHeaders(), HttpStatus.OK);
	}
	//GUARDA UN JUEGO
	@PostMapping("/games")
	public ResponseEntity<?> saveGame(@Valid @RequestBody Games game){
		try {
			return new ResponseEntity<>(gamesDao.save(game), new HttpHeaders(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), new HttpHeaders(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//ELIMINA UN JUEGO DADO EL ID
	@DeleteMapping("/games/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable(value = "id") Long id){
		gamesDao.deleteByID(id);
		ResponseObject resp= new ResponseObject();
		resp.setText("Juego eliminado");
		resp.setStatus(HttpStatus.OK.toString());
		return new ResponseEntity<>(resp, new HttpHeaders(), HttpStatus.OK);
	}
	
	//ACTUALIZA UN JUEGO
	@PutMapping("/games/{id}")
	public ResponseEntity<?> updateGame(@PathVariable(value="id") Long id,@Valid @RequestBody Games gameNew){
		Games game= gamesDao.findById(id).get();
		if(game != null) {
			game.setTitle(gameNew.getTitle());
			game.setDescription(gameNew.getDescription());
			game.setImage(gameNew.getImage());
			return new ResponseEntity<>(gamesDao.save(game), new HttpHeaders(), HttpStatus.OK);
		}else{
			String msg="Juego no encontrado!";
			return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
	}
}
