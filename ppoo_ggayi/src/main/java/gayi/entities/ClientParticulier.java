import java.util.Date;
import gayi.entities.Client;

public class ClientParticulier extends Client {
    private Date dateNaissance;
    private String lieuNaissance;

    // Constructeur
    public ClientParticulier(String nom, String prenom, String telephone, Date dateNaissance, String lieuNaissance) {
        super(nom, prenom, telephone);
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }

    // Méthodes spécifiques pour les clients particuliers
    public void souscrireProduitEpargne() {
        // Logique pour souscrire au produit Epargne
    }

    public void enregistrerSmsSouscription() {
        // Logique pour enregistrer un SMS lors de la souscription
    }

    // Getters et Setters
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    @Override
    public String toString() {
        return "ClientParticulier{" +
                "nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", telephone='" + getTelephone() + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", lieuNaissance='" + lieuNaissance + '\'' +
                '}';
    }
}
