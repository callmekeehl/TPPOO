package gayi.services;

import gayi.entities.Produit;
import java.util.List;

public interface ProduitService {
    void ajouterProduit(Produit produit);
    void modifierProduit(Produit produit);
    void supprimerProduit(Produit produit);
    Produit getProduit(int id);
    List<Produit> getAllProduits();
}
