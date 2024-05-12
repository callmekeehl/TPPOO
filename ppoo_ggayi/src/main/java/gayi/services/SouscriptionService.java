package gayi.services;

import gayi.entities.Souscription;
import java.util.List;

public interface SouscriptionService {
    void ajouterSouscription(Souscription souscription);
    void modifierSouscription(Souscription souscription);
    void supprimerSouscription(Souscription souscription);
    Souscription getSouscription(int id);
    List<Souscription> getAllSouscriptions();
}
