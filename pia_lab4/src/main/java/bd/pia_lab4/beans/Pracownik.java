/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd.pia_lab4.beans;

/**
 *
 * @author Emilia
 */
public class Pracownik {
 private int id;
 private String nazwisko;
 private float pensja;
 private String firma;
 //dodaj metody get i set
    public String get;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public float getPensja() {
        return pensja;
    }

    public void setPensja(float pensja) {
        this.pensja = pensja;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
 
}