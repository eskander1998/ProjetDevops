package com.esprit.examen;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class ProduitServiceImplTest {
	 @Autowired
	    
	    IProduitService ps;

 @Test
 void retrieveAllProduits() {
 	List<Produit> listProduits = ps.retrieveAllProduits();
     Assertions.assertEquals(0, listProduits.size());
 }
 
	private String codeProduit;
	private String libelleProduit;
	private float prix;

	private Date dateCreation;
	
	private Date dateDerniereModification;
 @Test
 public void testAddProduit(){
 List<Produit> Produits = ps.retrieveAllProduits();
 int expected = Produits.size();
 Produit p = new Produit();
 p.setLibelleProduit("test");
 p.setCodeProduit("codeProduit");
 p.setPrix(10);
 Date m = new Date(2022,11,05);
 p.setDateCreation(m);

 Produit savedProduit= ps.addProduit(p);
 assertEquals(expected+1, ps.retrieveAllProduits().size());
 assertNotNull(savedProduit.getLibelleProduit());
 ps.deleteProduit(savedProduit.getIdProduit());

 }



 @Test
 public void testUpdateProduit() {
 Produit p = new Produit();
 p.setLibelleProduit("test");
 p.setLibelleProduit("test");
 p.setCodeProduit("codeProduit");
 p.setPrix(10);
 Date m = new Date(2022,11,05);
 p.setDateCreation(m);
 Produit savedProduit= ps.addProduit(p);
 savedProduit.setLibelleProduit("testproduit");;
 ps.updateProduit(savedProduit);
 assertEquals(p.getLibelleProduit(),savedProduit.getLibelleProduit());
 ps.deleteProduit(savedProduit.getIdProduit());
 }

 @Test
 public void testDeleteProduit() {
 Produit p = new Produit();
 p.setLibelleProduit("test");
 p.setLibelleProduit("test");
 p.setCodeProduit("codeProduit");
 p.setPrix(10);
 Date m = new Date(2022,11,05);
 p.setDateCreation(m);
 Produit savedService= ps.addProduit(p);
 ps.deleteProduit(savedService.getIdProduit());
 assertNotNull(savedService.getIdProduit());

 }
}
