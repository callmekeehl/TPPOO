package gayi.services;

import gayi.entities.Sms;
import java.util.List;

public interface SmsService {
    void ajouterSms(Sms sms);
    void modifierSms(Sms sms);
    void supprimerSms(Sms sms);
    Sms getSms(int id);
    List<Sms> getAllSms();
    List<Sms> getSmssByStatut(String statut);
    List<Sms> getSmsEnvoyes(String statut);
    List<Sms> getSmsEnAttente(String statut);
}
