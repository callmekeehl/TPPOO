/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ppoo_ggayi;
import gayi.managedbeans.*;
import gayi.entities.Client;
import gayi.entities.Produit;
import gayi.entities.Souscription;
import gayi.entities.Sms;

import java.util.Date;


/**
 *
 * @author justkeehl
 */
public class Ppoo_ggayi {

        public static void main(String[] args) {

            // Création des contrôleurs
            ClientController clientController = new ClientController();
            ProduitController produitController = new ProduitController();
            SouscriptionController souscriptionController = new SouscriptionController();
            SmsController smsController = new SmsController();

            // Ajout des clients
            // Ajout des clients
            clientController.ajouterClient(new Client("Kodjo", "Jean", "0123456789"));
            clientController.ajouterClient(new Client("Awute", "Marie", "9876543210"));
            clientController.ajouterClient(new Client("Martin", "Pierre", "1112223333"));
            clientController.ajouterClient(new Client("Akakpo", "Sophie", "4445556666"));

            // Ajout des produits
            Produit produit1 = new Produit("Epargne", 'A');
            Produit produit2 = new Produit("Courant", 'A');
            produitController.ajouterProduit(produit1);
            produitController.ajouterProduit(new Produit("Courant", 'A'));

            // Ajout des souscriptions
            souscriptionController.ajouterSouscription(new Souscription(1, new Date(), 'A', 1, 1));
            souscriptionController.ajouterSouscription(new Souscription(2, new Date(), 'A', 1, 2));
            souscriptionController.ajouterSouscription(new Souscription(3, new Date(), 'A', 2, 2));

            // Enregistrement des SMS de souscriptions
            smsController.ajouterSms(new Sms(1, 1, "Souscription Epargne effectuée", "Envoyé"));
            smsController.ajouterSms(new Sms(2, 1, "Souscription Courant effectuée", "En attente"));
            smsController.ajouterSms(new Sms(3, 2, "Souscription Courant effectuée", "Envoyé"));

           /* // Affichage des sms envoyés
            smsController.getSmssEnvoyes();

            // Affichage des sms en attente
            smsController.getSmssEnAttente();
            
            */
        }


}
