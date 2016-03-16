package com.example.doria.m2l.metier;

import java.util.ArrayList;

/**
 * Created by quentin on 16/03/2016.
 */
public class Categorie
{
    private int codeCategorie;
    private String libelleCategorie;
    private int ageMin;
    private int ageMax;
    private ArrayList<Licence> lesLicences;

    public Categorie()
    {
        this.lesLicences=new ArrayList<Licence>();
    }

    public int getCode()
    {
        return this.codeCategorie;
    }

    public String getLibelleCategorie()
    {
        return this.libelleCategorie;
    }

    public int getAgeMin()
    {
        return this.ageMin;
    }

    public int getAgeMax()
    {
        return this.ageMax;
    }

    public void addLicence(Licence uneLicence)
    {
        this.lesLicences.add(uneLicence);
    }

    public void setCodeCategorie(int codeCategorie)
    {
        this.codeCategorie=codeCategorie;
    }

    public void setLibelleCategorie(String libelle)
    {
        this.libelleCategorie=libelle;
    }

    public void setAgeMin(int min)
    {
        this.ageMin=min;
    }

    public void setAgeMax(int max)
    {
        this.ageMax=max;
    }
}
