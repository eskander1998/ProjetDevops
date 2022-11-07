package com.esprit.examen;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;




import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.IProduitService;
import com.esprit.examen.services.ProduitServiceImpl;
import com.esprit.examen.services.StockServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ProduitServiceImplTest.class)
@ExtendWith(MockitoExtension.class)

public class ProduitServiceImplTest {
	
	@Autowired
    IProduitService produitService;
	@Mock
    ProduitRepository produitRepository;
	@InjectMocks
	ProduitServiceImpl PSI;

    @Test
    public void testRetrieveAllProduit() throws ParseException {

      List<Produit> produit = produitService.retrieveAllProduits();
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      Date date11 = dateFormat.parse("30/09/2000");
      Date date12 = dateFormat.parse("30/09/2010");
      Produit sa = new Produit(date11, date12);
      Produit savedProduit = produitService.addProduit(sa);
      log.info(" Produit : " + sa);

      assertNotNull(sa.getIdProduit());

      produitService.retrieveProduit(sa.getIdProduit());

      List<Produit> Produits = produitService.retrieveAllProduits();
      log.info("Les  Produits : " + Produits);
   }
@Test
public void testDeleteProduit() throws ParseException {
/*
   List<Produit> Produits = produitService.retrieveAllProduits();
      int expected = Produits.size();
      Long idFour=(long) 2;
      //assertEquals(expected + 1, produitService.retrieveAllProduits().size());
   System.out.print("size "+Produits.size());
      log.info(" count" + Produits.size());
   produitService.deleteProduit(1L);
   log.info("size2 "+produitService.retrieveAllProduits().size());
*/

}
@Test
public void testAddProduit() throws ParseException{
   List<Produit> Produits = produitService.retrieveAllProduits();
   SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   Date date1 = dateFormat.parse("10/02/2020");
   Date date2 = dateFormat.parse("12/09/2022");
   Produit p = new Produit(date1, date2);
   log.info("produit \n "+p);

   Produit savedProduit= produitService.addProduit(p);
   log.info("size1 "+Produits.size());
   System.out.print("size1 "+Produits.size());
   produitService.deleteProduit(savedProduit.getIdProduit());
   List<Produit> Produits1 = produitService.retrieveAllProduits();

   log.info("size2 "+Produits1.size());
}
void addProduit(){
	Produit produit = new Produit();
    Mockito.doReturn(produit).when(produitRepository).save(produit);
    Produit produit1 = PSI.addProduit(produit);
    Assertions.assertNotNull(produit1);
    }
	

}
