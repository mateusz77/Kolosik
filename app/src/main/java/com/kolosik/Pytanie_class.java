package com.kolosik;

/**
 * Created by Ciasteczko on 19/05/2018.
 */

public class Pytanie_class {
    private String Pytanie;
    private String OdpowiedzA;
    private String OdpowiedzB;
    private String OdpowiedzC;
    private String OdpowiedzD;
    private String OdpowiedzPrawidlowa;

    public Pytanie_class(String pytanie, String odpowiedzA, String odpowiedzB, String odpowiedzC, String odpowiedzD, String odpowiedzPrawidlowa){
        this.Pytanie = pytanie;
        this.OdpowiedzA = odpowiedzA;
        this.OdpowiedzB = odpowiedzB;
        this.OdpowiedzC = odpowiedzC;
        this.OdpowiedzD = odpowiedzD;
        this.OdpowiedzPrawidlowa = odpowiedzPrawidlowa;

    }

    public String getPytanie( ) {
        return Pytanie;
    }

    public String getOdpowiedzA( ) {
        return OdpowiedzA;
    }

    public String getOdpowiedzB( ) {
        return OdpowiedzB;
    }

    public String getOdpowiedzC( ) {
        return OdpowiedzC;
    }

    public String getOdpowiedzD( ) {
        return OdpowiedzD;
    }

    public String getOdpowiedzPrawidlowa( ) {
        return OdpowiedzPrawidlowa;
    }
}
