package com.esprit.examen.services;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class CoursServiceTest {

    @Autowired ICoursService iCoursService;

    @Test
    void saveCours() {
        Long id = iCoursService.SaveCours(new Cours("test description", TypeCours.Informatique, "test "));
        //assertThat(id);
    }

    @Test
    void supprimerCours() {
    }

    @Test
    void getCours() {
    }

    @Test
    void affecterCoursASession() {
    }
}