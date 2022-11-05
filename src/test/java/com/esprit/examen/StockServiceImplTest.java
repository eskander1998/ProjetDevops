package com.esprit.examen;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.services.IStockService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {
	
	@InjectMocks
	@Autowired
	IStockService stockService;
	
	@Test
	public void testAddStock() {
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);		
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
	} 
	
	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",20,10);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}
}
