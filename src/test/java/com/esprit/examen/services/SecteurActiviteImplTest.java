package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.SecteurActivite;

@SpringBootTest
public class SecteurActiviteImplTest {

	
	@Autowired
	ISecteurActiviteService secteurActiviteService;
	
	
	@Test
	public void testAddFournisseur(){
		List<SecteurActivite> secteurs = secteurActiviteService.retrieveAllSecteurActivite();
		int expected = secteurs.size();
		SecteurActivite s = new SecteurActivite();
		s.setCodeSecteurActivite("codetest");
		s.setLibelleSecteurActivite("LibelleSecteurActiviteTest");
		SecteurActivite savedSecteurActiviteSecteurActivite= secteurActiviteService.addSecteurActivite(s);
		assertEquals(expected+1, secteurActiviteService.retrieveAllSecteurActivite().size());
		assertNotNull(savedSecteurActiviteSecteurActivite.getLibelleSecteurActivite());
		secteurActiviteService.deleteSecteurActivite(savedSecteurActiviteSecteurActivite.getIdSecteurActivite());
		
	}
	
	
	@Test
	public void testRetrieveSecteurActivite() {
		SecteurActivite s = new SecteurActivite();
		s.setCodeSecteurActivite("codetest");
		s.setLibelleSecteurActivite("LibelleSecteurActiviteTest");
		SecteurActivite savedSecteurActivite= secteurActiviteService.addSecteurActivite(s);
		SecteurActivite getSecteurActivite= secteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
		assertNotNull(savedSecteurActivite.getLibelleSecteurActivite());
		assertNotNull(savedSecteurActivite.getCodeSecteurActivite());
		assertEquals(savedSecteurActivite.getIdSecteurActivite(),getSecteurActivite.getIdSecteurActivite());
		
		secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
		}
	
	@Test
	public void testUpdateSecteurActivite() {
		SecteurActivite s = new SecteurActivite();
		s.setCodeSecteurActivite("codetest");
		s.setLibelleSecteurActivite("LibelleSecteurActiviteTest");
		SecteurActivite savedSecteurActivite= secteurActiviteService.addSecteurActivite(s);
		savedSecteurActivite.setLibelleSecteurActivite("eskander");;
		secteurActiviteService.updateSecteurActivite(savedSecteurActivite);
		assertEquals(s.getLibelleSecteurActivite(),savedSecteurActivite.getLibelleSecteurActivite());
		secteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
		}
	
	@Test
	public void testDeleteSecteurActivite() {
		SecteurActivite s = new SecteurActivite();
		s.setCodeSecteurActivite("codetest");
		s.setLibelleSecteurActivite("LibelleSecteurActiviteTest");
		SecteurActivite savedService= secteurActiviteService.addSecteurActivite(s);
		secteurActiviteService.deleteSecteurActivite(savedService.getIdSecteurActivite());
		assertNotNull(savedService.getIdSecteurActivite());
		
	}
	
	
}
