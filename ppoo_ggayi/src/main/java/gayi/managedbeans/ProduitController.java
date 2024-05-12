package gayi.managedbeans;

import gayi.entities.Produit;
import gayi.services.ProduitService;
import gayi.services.implementations.ProduitServiceImplementation;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class ProduitController {
    private ProduitService produitService = new ProduitServiceImplementation();
    private Produit produit = new Produit();

    public void ajouterProduit(Produit produit) {
        produitService.ajouterProduit(produit);
        produit = new Produit(); // Réinitialiser produit après l'ajout
    }

    public ProduitService getProduitService() {
        return produitService;
    }

    public void setProduitService(ProduitService produitService) {
        this.produitService = produitService;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    // Méthode pour récupérer tous les produits (si nécessaire)
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }
}
