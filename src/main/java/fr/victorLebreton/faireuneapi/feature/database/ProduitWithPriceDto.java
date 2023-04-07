package fr.victorLebreton.faireuneapi.feature.database;

import jakarta.persistence.Tuple;

import java.math.BigDecimal;
import java.util.Objects;

// Classe qui va agir exactement comme ProduitDto mais qui a la fonctionnalité du prix en plus
// Permet de ne pas toucher au code existant en faisant évoluer un produit dans notre code
public class ProduitWithPriceDto extends ProduitDto{
    // Utilisation de BigDecimal à la place de double (plus secure)
    private BigDecimal prixUnitaireHt;
    // Constructeur identique à celui de notre ProduitDto, avec l'ajout du champ unitPrice
    public ProduitWithPriceDto(Integer id, String nom, String description, BigDecimal prixUnitaireHt) {
        // Construction de la classe parente avec le mot super() qui prend en paramètre les mêmes que celui du constructeur du parent
        super(id, nom, description);
        this.prixUnitaireHt = prixUnitaireHt;
    }

    public ProduitWithPriceDto(Tuple tuple) {
        // Utilisation du constructeur ProduitDto(Tuple tuple)
        super(tuple);
        // On récupère en plus notre champ unitPrice de notre Tuple
        this.prixUnitaireHt = BigDecimal.valueOf((Double) tuple.get(3));
    }

    public BigDecimal getUnitPrice() {
        return prixUnitaireHt;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.prixUnitaireHt = prixUnitaireHt;
    }

    // Redéfinition de la méthode equals pour tester les mêmes champs que notre parent avec en plus le test sur le unitPrice
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProduitWithPriceDto that = (ProduitWithPriceDto) o;
        return prixUnitaireHt.equals(that.prixUnitaireHt);
    }

    // Concatenation du hashcode de notre classe parente en ajoutant notre champ unitPrice
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prixUnitaireHt);
    }
}
