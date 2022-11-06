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
	ISecteurActiviteService SecteurActiviteService;

	@Test
	public void testAddOperateur(){
		List<SecteurActivite> SecteurActivites = SecteurActiviteService.retrieveAllSecteurActivite();
		int expected = SecteurActivites.size();
		SecteurActivite o = new SecteurActivite();
		o.setLibelleSecteurActivite("lib");
		o.setCodeSecteurActivite("code");
		SecteurActivite savedSecteurActivite= SecteurActiviteService.addSecteurActivite(o);
		assertEquals(expected+1, SecteurActiviteService.retrieveAllSecteurActivite().size());
		assertNotNull(savedSecteurActivite.getLibelleSecteurActivite());
		SecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

	}


	
	
}
