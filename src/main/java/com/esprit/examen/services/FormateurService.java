package com.esprit.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FormateurService implements IFormateurService{

	@Autowired
	FormateurRepository formateurRepository;

	@Override
	public Long addOrUpdateFormateur(Formateur formateur) {
		try {
			log.debug("Formateur to save: "+ formateur);
			formateurRepository.save(formateur);
			
		}
		catch (Exception e) {
			log.error("error while saving Formateur: ", e.getMessage());
		}
		
		return formateur.getId();
	}

	@Override
	public void supprimerFormateur(Long formateurId) {
		try {
			formateurRepository.deleteById(formateurId);
		}catch (Exception e) {
			log.error("error while deleting Fromateur "+e.getMessage());
		}
		
	}

	@Override
	public Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours) {
		log.info("number of 'Fromateur' involved in a course of "+typeCours);
		return formateurRepository.nombreFormateursImpliquesDansUnCours(typeCours);
	}



	@Override
	public List<Formateur> listFormateurs() {
		
		return formateurRepository.findAll();
	}


	
	

}
