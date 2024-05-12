/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gayi.entities;


public class Produit {

    private int id;
    private String libelle;
    private char actif;

    public Produit(){}

    public Produit(int id, String libelle, char actif) {
        this.id = id;
        this.libelle = libelle;
        this.actif = actif;
    }

    public Produit(String libelle, char actif) {
        this.libelle = libelle;
        this.actif = actif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setActif(char actif) {
        this.actif = actif;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public char getActif() {
        return actif;
    }

}