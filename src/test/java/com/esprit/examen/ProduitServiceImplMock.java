package com.esprit.examen;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.IProduitService;
import com.esprit.examen.services.ProduitServiceImpl;
import com.esprit.examen.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplMock {
	@Mock
	ProduitRepository produitRepository;
	
	@InjectMocks
	ProduitServiceImpl produitService;
	
	
	
	
	
	
	Produit produit = new Produit("p1", 10);
	List<Produit> listProduits = new ArrayList<Produit>() {
	{
	add(new Produit("p2", 20));
	add(new Produit("p3", 30));
	}
	};
	
	
	//@Test
	//public void testRetrieveUser() {

	//Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit))
	//;
	//Produit produit1 = produitService.retrieveProduit((long) 2);
	//Assertions.assertNotNull(produit1);
	//}
	@Test
    void retrieveAllProduits(){
        Mockito.when(produitRepository.findAll()).thenReturn(listProduits);
        List<Produit> list = produitService.retrieveAllProduits();
        Assertions.assertNotNull(list);
    }
}
