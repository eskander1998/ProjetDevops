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
       IProduitService produitService;
  
       @Test
       @Order(1)
       public void testRetrieveAllProduit() throws ParseException {

         List<Produit> produit = produitService.retrieveAllProduits();
         Assertions.assertEquals(0,  produit.size());
      }
}
