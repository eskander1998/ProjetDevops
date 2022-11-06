package com.esprit.examen.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.SecteurActivite;


@SpringBootTest
public class SecteurActiviteServiceJUnit {

    @Autowired
    SecteurActiviteServiceImpl SecteurActiviteService;

    //testing Add method
    @Test
    public void testAddSecteurActivite(){
        List<SecteurActivite> SecteurActivites = SecteurActiviteService.retrieveAllSecteurActivite();
        int expected = SecteurActivites.size();
        SecteurActivite o = new SecteurActivite();
        o.setLibelleSecteurActivite("aa");
        o.setCodeSecteurActivite("bbb");
        SecteurActivite savedSecteurActivite= SecteurActiviteService.addSecteurActivite(o);
        assertEquals(expected+1, SecteurActiviteService.retrieveAllSecteurActivite().size());
        assertNotNull(savedSecteurActivite.getLibelleSecteurActivite());
        SecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

    }

    //Testing retrieveSecteurActivite
//    @Test
//    public void testRetrieveSecteurActivites() {
//        SecteurActivite o = new SecteurActivite();
//        o.setNom("yas");
//        o.setPrenom("mine");
//        o.setPassword("pass");
//        SecteurActivite savedSecteurActivite= SecteurActiviteService.addSecteurActivite(o);
//        SecteurActivite getSecteurActivite= SecteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
//        assertNotNull(savedSecteurActivite.getNom());
//        assertNotNull(savedSecteurActivite.getPrenom());
//        assertEquals(savedSecteurActivite.getIdSecteurActivite(),getSecteurActivite.getIdSecteurActivite());
//
//        SecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
//    }
//
//
//    //Testing updateSecteurActivite
//    @Test
//    public void testUpdateSecteurActivite() {
//        SecteurActivite o = new SecteurActivite();
//        o.setNom("ines");
//        o.setPrenom("alioua");
//        o.setPassword("pass");
//        SecteurActivite savedSecteurActivite= SecteurActiviteService.addSecteurActivite(o);
//        savedSecteurActivite.setNom("med");
//        SecteurActiviteService.updateSecteurActivite(savedSecteurActivite);
//        assertEquals(o.getNom(),savedSecteurActivite.getNom());
//        SecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
//    }
//
//    //Testing deleteSecteurActivite
//    @Test
//    public void testDeleteSecteurActivite() {
//        SecteurActivite o = new SecteurActivite();
//        o.setNom("nc");
//        o.setPrenom("med");
//        o.setPassword("pass");
//        SecteurActivite savedSecteurActivite= SecteurActiviteService.addSecteurActivite(o);
//        SecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
//        assertNotNull(savedSecteurActivite.getIdSecteurActivite());
//
//    }
}