package com.example.doria.m2l.metier;

import java.util.ArrayList;

/**
 * Created by quentin on 09/03/2016.
 */
public class Equipe
{
    private int codeEquipe;
    private String libelleEquipe;
    private int codeClub;
    private ArrayList<Licence> lesLicences;


    //constructor
    public Equipe()
    {
        this.lesLicences = new ArrayList<Licence>();
    }


    /* Setters */
    public void setCode(int code)
    {
        this.codeEquipe=code;
    }

    public void setLibelleEquipe(String lib)
    {
        this.libelleEquipe=lib;
    }

    public void setCodeClub(int code)
    {
        this.codeClub=code;
    }


    /* Getters */
    public int getCodeEquipe()
    {
        return this.codeEquipe;
    }

    public String getLibelleEquipe()
    {
        return this.libelleEquipe;
    }

    public int getCodeClub()
    {
        return this.codeClub;
    }


    //Functions
    public void ajoutLicence(Licence uneLicence){this.lesLicences.add(uneLicence);}

    public String toString()
    {
        String str = " -------------------------------- \n | Equipe :               | \n -------------------------------- \n";
        str+="code : "+codeEquipe+"\n";
        str+="libelle : "+libelleEquipe+"\n";
        str+="nb licence : "+this.lesLicences.size()+"\n";
        for (int i=0;i<this.lesLicences.size();i++)
        {
            str+="  \n   >>"+this.lesLicences.get(i).toString();
        }
        str+=" \n \n ";
        return str;
    }
}
