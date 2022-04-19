package com.esprit.examen.services;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

@Slf4j
@Service
public class CoursService implements ICoursService {

	@Autowired CoursRepository coursRepository;
	@Autowired SessionRepository sessionRepository;

	@Override
	public Long SaveCours(Cours cours) {
		try {
			log.debug("cour to be saved ", cours);
			coursRepository.save(cours);
			log.debug("cour saved ", cours);
		}catch (Exception e){
			log.error("error while saving cour : "+ e.getMessage());
		}
		log.info("save complete");

		return cours.getId();
	}

	@Override
	public void supprimerCours(Long coursId) {
		try {
			coursRepository.deleteById(coursId);
			log.debug("cour removed ", coursId);
		}catch (Exception e){
			log.error("error while removing cour : "+ e.getMessage());
		}
		log.info("remove complete");
	}

	@Override
	public List<Cours> getCours() {
		return coursRepository.findAll();
	}

	@Override
	public void affecterCoursASession(Long coursId, Long sessionId)
	{
		try {
			Cours cours = coursRepository.findById(coursId).orElse(null);
			log.debug("cour to be added ", cours);
			if(cours==null) return;
			log.info("cour not null, continue");
			sessionRepository.findById(sessionId).ifPresent(x->x.getCours().add(cours));

			log.debug("cour added ", cours);
		}catch (Exception e){
			log.error("error while adding cour : "+ e.getMessage());
		}
		log.info("adding complete");
	}

}
