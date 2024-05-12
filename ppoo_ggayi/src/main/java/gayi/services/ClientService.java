package gayi.services;

import gayi.entities.Client;
import java.util.List;

public interface ClientService {
    void ajouterClient(Client client);
    void supprimerClient(Client client);
    void modifierClient(Client client);
    Client getClient(int id);
    List<Client> getAllClients();

}