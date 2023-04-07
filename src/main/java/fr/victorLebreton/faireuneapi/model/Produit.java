package fr.victorLebreton.faireuneapi.model;

import jakarta.persistence.*;

// 2 annotations par entité :
// @Entity : Permet de faire le lien entre classe et BDD
// @Table : Permet de préciser le nom de la table à mapper
@Entity
@Table(name = "produit")
public class Produit {

    // Définit l'ID de notre BDD (clé primaire)
    // @Id : Permet de définir la clé primaire
    // @GeneratedValue : Permet de préciser la génération de la clé primaire
    // Strategy IDENTITY : Permet de préciser que la génération se fait à partir d'une colonne spécifique en BDD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // @Column : Permet de mapper l'attribut à son champ en BDD
    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "prix_unitaire_ht")
    private Double prixUnitaireHt;

    @Column(name = "categorie")
    private Integer categorie;

    @ManyToOne
    @JoinColumn(name = "categorie", updatable = false, insertable = false)
    private Category category;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return prixUnitaireHt;
    }

    public void setUnitPrice(double unitPrice) {
        this.prixUnitaireHt = unitPrice;
    }

    public Produit() {
    }
}
