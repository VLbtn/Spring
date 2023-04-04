package fr.victorLebreton.faireuneapi.feature.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseService {

    private EntityManager entityManager;

    public List<String> getProductNameList(){
        Query query = entityManager.createNativeQuery("SELECT nom FROM produit;");
        List<String> results = ((List<String>) query.getResultList());
        return results;
    }

    public List<Tuple> getProductList(){
        Query query = entityManager.createNativeQuery("SELECT * FROM produit;", Tuple.class);
        List<Tuple> results = ((List<Tuple>) query.getResultList());
        return results;
    }
}
