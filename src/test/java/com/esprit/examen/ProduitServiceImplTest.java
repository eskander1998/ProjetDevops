package com.esprit.examen;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
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
import com.esprit.examen.repositories.ProduitRepository;

import com.esprit.examen.services.ProduitServiceImpl;


@SpringBootTest(classes=ProduitServiceImplTest.class)
@ExtendWith(MockitoExtension.class)

public class ProduitServiceImplTest {
	
	

}
