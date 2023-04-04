package fr.victorLebreton.faireuneapi.database;

import fr.victorLebreton.faireuneapi.feature.database.DataBaseService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class DataBaseTests extends DataBaseService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DataBaseService databaseService;

    @Test
    void getProductNameListTest(){
        String expected = "Cheese - Cheddar, Mild";
        List<String> result = databaseService.getProductNameList();
        assertTrue(result.contains(expected));
    }

    @Test
    void getProductListTest(){
        Tuple produit1 = databaseService.getProductList().get(0);
        assertEquals(produit1.get("nom"), "Cheese - Cheddar, Mild");
    }
}




