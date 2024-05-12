package gayi.managedbeans;

import gayi.entities.Souscription;
import gayi.services.SouscriptionService;
import gayi.services.implementations.SouscriptionServiceImplementation;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class SouscriptionController {
    private SouscriptionService souscriptionService = new SouscriptionServiceImplementation();
    private Souscription souscription = new Souscription();

    public void ajouterSouscription(Souscription souscription) {
        souscriptionService.ajouterSouscription(souscription);
        souscription = new Souscription(); // Réinitialiser souscription après l'ajout
    }

    public SouscriptionService getSouscriptionService() {
        return souscriptionService;
    }

    public void setSouscriptionService(SouscriptionService souscriptionService) {
        this.souscriptionService = souscriptionService;
    }

    public Souscription getSouscription() {
        return souscription;
    }

    public void setSouscription(Souscription souscription) {
        this.souscription = souscription;
    }

    public List<Souscription> getAllSouscriptions() {
        return souscriptionService.getAllSouscriptions();
    }
}
