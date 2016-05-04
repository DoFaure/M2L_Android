package com.example.doria.m2l.metier;

import java.util.ArrayList;

/**
 * Created by quentin on 09/03/2016.
 */
public class Club
{
    private int codeClub;
    private String libelleClub;
    private int idLigue;
    private int responsable;
    private ArrayList<Equipe> lesEquipes;

    /* Constructeur */
    public Club()
    {
        this.lesEquipes=new ArrayList<Equipe>();
    }

    /* Setter */
    public void setCode(int code)
    {
        this.codeClub=code;
    }

    public void setLibelle(String lib)
    {
        this.libelleClub=lib;
    }

    public void setResponsable(int code)
    {
        this.responsable=code;
    }
    public void setIdLigue(int code)
    {
        this.idLigue=code;
    }


    /* Getters */
    public int getCode()
    {
        return this.codeClub;
    }

    public String getLibelleClub()
    {
        return this.libelleClub;
    }

    public ArrayList<Equipe> getLesEquipes()
    {
        return this.lesEquipes;
    }

    public int getIdLigue(){return this.idLigue;}
    public int getResponsable(){return this.responsable;}


    /* Function */
    public void ajoutEquipe(Equipe uneEquipe)
    {
        this.lesEquipes.add(uneEquipe);
    }
}
