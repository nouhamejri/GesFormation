package com.esprit.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.services.ICoursService;

@RestController
public class CoursRestController {
	@Autowired
	ICoursService coursService;
 
	@PostMapping("/SaveCours")
	@ResponseBody
	public Cours SaveCours(@RequestBody Cours cours) {
		coursService.SaveCours(cours);
		return cours;
	}

	@DeleteMapping("/supprimerCours/{coursId}")
	@ResponseBody
	public void supprimerCours(@PathVariable("coursId") Long coursId) {
		coursService.supprimerCours(coursId);
	}

	@GetMapping("/listeCours")
	@ResponseBody
	public List<Cours> listeCours() {

		return  coursService.getCours();
	}

	@PutMapping("/affecterCoursASession/{coursId}/{sessionId}")
	@ResponseBody
	public String affecterFormateurASession(@PathVariable("coursId")  Long coursId, @PathVariable("sessionId") Long sessionId) {
		coursService.affecterCoursASession(coursId, sessionId);
		return "cours affecté correctement";
	}
}