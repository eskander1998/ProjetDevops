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

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.IStockService;
import com.esprit.examen.services.StockServiceImpl;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes=StockServiceImpl.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {
	@Mock
    StockRepository stockRepository;
	@InjectMocks
    StockServiceImpl StI;
	@Autowired
	IStockService stockService;
	
	 Stock stock = new Stock("libelleStock1", 10, 3);
	    List<Stock> listStocks = new ArrayList<Stock>() {
	        {
	            add(new Stock("libelleStock2", 20, 5));
	            add(new Stock("libelleStock3", 30, 8));
	        }
	    };
	
	
	@Test
	void retrieveStock() {
	    Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
	    Stock stock1 = StI.retrieveStock(0L);
	    Assertions.assertNotNull(stock1);
	}
	@Test
    void retrieveAllStocks(){
        Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
        List<Stock> list = StI.retrieveAllStocks();
        Assertions.assertNotNull(list);
    }
	
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
