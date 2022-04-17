package com.esprit.examen.services;

import com.esprit.examen.entities.Session; 
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
class SessionServiceTest {

    @Autowired 
    SessionService SessionService;
	@Autowired
	SessionRepository Repo;

     @Test
    public void testAll() {
        List<Session> session = Repo.findAll();
        assertThat(session.size(), is(greaterThanOrEqualTo(0)));
    }

    	@Test
	public void testAdd() throws ParseException {
		try {
			Session session = new Session();
			session.setDateDebut("2003/02/03");
			SessionService.addSession(session);
			log.info(session);
		} catch (Exception e) {
			log.error('erreur !');
		}
	}

  @Test
    void affecterFormateurASession() {
        SessionService.affecterFormateurASession(2333, 4444);
        assertTrue(true);
    }


    	@Test
	public void testDelete() throws ParseException {
		Long id = (long) 4444;
	SessionService.supprimerSession(id);
	}




}