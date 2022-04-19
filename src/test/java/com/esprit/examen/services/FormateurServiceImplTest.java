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

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Session;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.repositories.SessionRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FormateurServiceImplTest {
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

	
	@Test
	public void testNbreFormateurImpliqueDansCours() throws ParseException {
		try {
			assertNotNull(fs.nombreFormateursImpliquesDansUnCours(TypeCours.INFORMATIQUE));
			Long nbrBeforeAddingNewF = fs.nombreFormateursImpliquesDansUnCours(TypeCours.INFORMATIQUE);
			log.info("le nombre de fomateur ayant le type de cours informatique est: " + fs.nombreFormateursImpliquesDansUnCours(TypeCours.INFORMATIQUE));
			Formateur f = new Formateur();
			f.setNom("testBenFoulen");
			f.setPrenom("testFoulen");
			f.setAdmin(false);
			fs.addOrUpdateFormateur(f);
			Session s = sRepo.findById((long) 23552).orElse(null);
			s.setFormateur(f);
			sServ.modifierSession(s);
			Set<Session> setOfSessions = new HashSet<Session>();
			setOfSessions.add(s);
			f.setSessions(setOfSessions);
			fs.addOrUpdateFormateur(f);
			Long nbrAfterAddingNewF = fs.nombreFormateursImpliquesDansUnCours(TypeCours.INFORMATIQUE); 
			assertThat(nbrAfterAddingNewF).isGreaterThan(nbrBeforeAddingNewF);
			log.info("le nombre de fomateur ayant le type de cours informatique aprés avoir ajouté un nouveau formateur est: " + fs.nombreFormateursImpliquesDansUnCours(TypeCours.INFORMATIQUE));
		} catch (Exception e) {
			
			log.error("exception: "+ e.getMessage());
		}
	}
}
