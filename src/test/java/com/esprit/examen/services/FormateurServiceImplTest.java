package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Session;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.repositories.SessionRepository;
import com.esprit.examen.services.FormateurService;
import com.esprit.examen.services.SessionService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class FormateurServiceImplTest {
	@Autowired
	FormateurService fs;

	@Autowired
	FormateurRepository frepo;
	
	@Autowired
	SessionRepository sRepo;
	
	@Autowired
	SessionService sServ;

	@Test
	public void testListesFormateurs() {
		List<Formateur> formateurs = fs.listFormateurs();
		assertThat(formateurs).size().isGreaterThan(0);
		log.info("nombre de formateurs est supérieur à 0");
	}

	@Test
	public void testAddFormateur() throws ParseException {
		try {
			Formateur f = new Formateur();
			f.setNom("mejri");
			f.setPrenom("nouha");
			f.setAdmin(true);
     		assertTrue(f.getAdmin().equals(true));
			fs.addOrUpdateFormateur(f);
			log.info("formateur ajouté avec succées avec id= " + f.getId());
		} catch (Exception e) {
			log.error("le formateur ne peut pas etre créer : "+e.getMessage());
		}
	}

	@Test
	public void testDeleteFormateur() throws ParseException {
		Long idF = (long) 321004;
		try {
			fs.supprimerFormateur(idF);
			log.info("formateur avec id égale à " + idF + " supprimé avec succées");
		} catch (Exception e) {
			log.error("un formateur avec un id: " + idF + " n'existe pas: " + e.getMessage());
		}
	}
}
