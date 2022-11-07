package com.esprit.examen;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.services.SecteurActiviteServiceImpl;




@ExtendWith(MockitoExtension.class)
public class SecteurActiviteServiceImplMock {
	
	
	@Mock
    com.esprit.examen.repositories.SecteurActiviteRepository SecteurActiviteRepository;
	
    @InjectMocks
    SecteurActiviteServiceImpl SecteurActiviteService;
    
    
   
    
    
    @Test
	 void testRetrieveSecteurActivite() {
		when(SecteurActiviteRepository.findAll()).thenReturn(Stream.of(
                new SecteurActivite("codeSecteurActivite2", "libelleSecteurActivite2"),
                new SecteurActivite("codeSecteurActivite3", "libelleSecteurActivite3"),
                new SecteurActivite("codeSecteurActivite3", "libelleSecteurActivite3"))
                .collect(Collectors.toList()));
		assertEquals(3,SecteurActiviteService.retrieveAllSecteurActivite().size());
		
	}
    
    @Test
	 void testAddSecteurActivite() {
    	SecteurActivite ss =  new SecteurActivite("codeSecteurActivite2", "libelleSecteurActivite2");

		when(SecteurActiviteRepository.save(ss)).thenReturn(ss);
		assertEquals(ss, SecteurActiviteService.addSecteurActivite(ss));
	}
    
    
    @Test
	 void testDeleteSecteurActivite() {
    	SecteurActivite ss =  new SecteurActivite("codeSecteurActivite2", "libelleSecteurActivite2");
    	SecteurActiviteService.deleteSecteurActivite((long) 1);
		verify(SecteurActiviteRepository).deleteById((long) 1);

	}
    
    @Test
	 void testUpdateSecteurActivite() {
    	SecteurActivite ss =  new SecteurActivite("codeSecteurActivite2", "libelleSecteurActivite2");
		Mockito.when(SecteurActiviteRepository.save(Mockito.any(SecteurActivite.class))).thenReturn(ss);
		ss.setLibelleSecteurActivite("eskanderrrr");
		SecteurActivite exisitingOp= SecteurActiviteService.updateSecteurActivite(ss) ;
		
		assertNotNull(exisitingOp);
		assertEquals("eskanderrrr", ss.getLibelleSecteurActivite());
	}
    
   
    

    

}