package gayi.managedbeans;

import gayi.entities.Sms;
import gayi.services.SmsService;
import gayi.services.implementations.SmsServiceImplementation;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class SmsController {
    private SmsService smsService = new SmsServiceImplementation();
    private Sms sms = new Sms();

    public void ajouterSms(Sms sms) {
        smsService.ajouterSms(sms);
        sms = new Sms(); // Réinitialiser sms après l'ajout
    }

    public SmsService getSmsService() {
        return smsService;
    }

    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
    }

    public Sms getSms() {
        return sms;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    public List<Sms> getAllSms() {
        return smsService.getAllSms();
    }
    
     /*// Méthode pour récupérer les SMS envoyés
    public List<Sms> getSmssEnvoyes() {
        return smsService.getSmssByStatut("Envoyé");
    }

    // Méthode pour récupérer les SMS en attente d'envoi
    public List<Sms> getSmssEnAttente() {
        return smsService.getSmssByStatut("En attente");
    }*/
   

}
