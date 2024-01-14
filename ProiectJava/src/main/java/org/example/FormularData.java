package org.example;

public class FormularData {

    private String Nume;
    private boolean PermisConducere;
    private String StareCivila;
    private String Vehicul;
    private String Parola;



    public FormularData(String text, boolean checkBox, String radioButton, String comboBox, String passwordField) {
        this.Nume = text;
        this.PermisConducere = checkBox;
        this.StareCivila = radioButton;
        this.Vehicul = comboBox;
        this.Parola = passwordField;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public boolean isPermisConducere() {
        return PermisConducere;
    }

    public void setPermisConducere(boolean permisConducere) {
        PermisConducere = permisConducere;
    }

    public String getStareCivila() {
        return StareCivila;
    }

    public void setStareCivila(String stareCivila) {
        StareCivila = stareCivila;
    }

    public String getVehicul() {
        return Vehicul;
    }

    public void setVehicul(String vehicul) {
        Vehicul = vehicul;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String parola) {
        Parola = parola;
    }
}
