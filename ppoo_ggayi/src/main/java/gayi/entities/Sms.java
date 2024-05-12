/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gayi.entities;

public class Sms {
    private int id;
    private int idClient;
    private String libelle;
    private String statut;

    public Sms(){}

    public Sms(int id, int idClient, String libelle, String statut) {
        this.id = id;
        this.idClient = idClient;
        this.libelle = libelle;
        this.statut = statut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getStatut() {
        return statut;
    }

}

