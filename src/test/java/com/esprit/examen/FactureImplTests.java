package com.esprit.examen;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.services.FactureServiceImpl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
 

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FactureImplTests {

	
       
	@Mock
    FactureRepository fr;
    @InjectMocks
	FactureServiceImpl fs;



    Facture facture = new Facture( 10, 3,new Date(),new Date(),true);
    List<Facture> listfactures = new ArrayList<Facture>() {
        {
            add(new Facture(10, 3,new Date(),new Date(),true));
            add(new Facture(10, 3,new Date(),new Date(),true));
        }
    };
    
	@Test
	@Order(1)
	public void testRetrieveAllFactures() {
	List<Facture> listfacture = fs.retrieveAllFactures();
	Assertions.assertEquals(0, listfacture.size());
	}

    @Test
    void retrieveFacture() {
        Mockito.when(fr.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        Facture fact = fs.retrieveFacture(0L);
        Assertions.assertNotNull(fact);
    }

    
    @Test
    void retrieveAllFacture()
    {
        Mockito.when(fr.findAll()).thenReturn(listfactures);
        List<Facture> list = fs.retrieveAllFactures();
        Assertions.assertNotNull(list);
    }
	

}
