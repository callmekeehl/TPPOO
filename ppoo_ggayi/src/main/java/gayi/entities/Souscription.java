/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gayi.entities;

import java.util.Date;

public class Souscription {
    private int id;
    private Date dateHeureSous;
    private char actif;
    private int idClient;

    public Souscription(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setDateHeureSous(Date dateHeureSous) {
        this.dateHeureSous = dateHeureSous;
    }

    public void setActif(char actif) {
        this.actif = actif;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    private int idProduit;

    public int getId() {
        return id;
    }

    public Date getDateHeureSous() {
        return dateHeureSous;
    }

    public char getActif() {
        return actif;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public Souscription(int id, Date dateHeureSous, char actif, int idClient, int idProduit) {
        this.id = id;
        this.dateHeureSous = dateHeureSous;
        this.actif = actif;
        this.idClient = idClient;
        this.idProduit = idProduit;
    }

}
