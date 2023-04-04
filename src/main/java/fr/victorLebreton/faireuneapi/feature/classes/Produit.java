package fr.victorLebreton.faireuneapi.feature.classes;

import java.math.BigDecimal;

public class Produit {
    private int id;

    private String nom;

    private String description;

    private BigDecimal prixUnitaireHT;

    public Produit(int id, String nom, String description, BigDecimal prixUnitaireHT) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prixUnitaireHT = prixUnitaireHT;
    }
}
