package gayi.managedbeans;

import gayi.entities.Client;
import gayi.services.ClientService;
import gayi.services.implementations.ClientServiceImplementation;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class ClientController {
    private ClientService clientService = new ClientServiceImplementation();
    private Client client = new Client();

    // Méthode pour ajouter un client avec les détails spécifiés
    public void ajouterClient() {
        clientService.ajouterClient(client);
        client = new Client(); // Réinitialiser client après l'ajout
    }

    // Autres méthodes du contrôleur

    // Méthode pour ajouter un client avec des détails spécifiques
    public void ajouterClient(Client client) {
        clientService.ajouterClient(client);
    }


    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}
