package com.esprit.examen.services;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class CoursServiceTest {

    @Autowired ICoursService iCoursService;

    @Test
    void saveCours() {
        Cours cours = new Cours("test description", TypeCours.Informatique, "test ");
        Long id = iCoursService.SaveCours(cours);
        assertThat(id, greaterThan(0L));
        log.info("add complete");
        iCoursService.supprimerCours(id);
        log.info("delete complete");
    }

    @Test
    void supprimerCours() {
        iCoursService.supprimerCours(1L);
        assertTrue(true);
        log.info("delete complete");
    }

    @Test
    void getCours() {
       List<Cours> cours = iCoursService.getCours();
       assertThat(cours.size(), greaterThan(0));
    }

    @Test
    void affecterCoursASession() {
        iCoursService.affecterCoursASession(1L, 1L);
        assertTrue(true);
    }
}