package com.kolosik;

/**
 * Created by Ciasteczko on 18/05/2018.
 */

public class Student_Wyniki {
    private String imie;
    private String nazwisko;
    private String klasa;
    private String punkty;

    public Student_Wyniki(String imie, String nazwisko,String klasa, String punkty) {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.klasa = klasa;
        this.punkty = punkty;
    }

    public String getImie() {return imie;}

    public String getNazwisko() {
        return nazwisko;
    }
    public String getKlasa() {return klasa;}

     public String getPunkty() {
        return punkty;
    }
}
