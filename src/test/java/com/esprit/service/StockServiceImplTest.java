package com.esprit.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.services.IStockService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
	
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
