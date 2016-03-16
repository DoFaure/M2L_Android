package com.example.doria.m2l.metier;

import java.util.ArrayList;

/**
 * Created by quentin on 09/03/2016.
 */
public class Club
{
    private int codeClub;
    private String libelleClub;
    private ArrayList<Equipe> lesEquipes;

    public Club()
    {
        this.lesEquipes=new ArrayList<Equipe>();
    }

    public void setCode(int code)
    {
        this.codeClub=code;
    }

    public void setLibelle(String lib)
    {
        this.libelleClub=lib;
    }

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

    public void ajoutEquipe(Equipe uneEquipe)
    {
        this.lesEquipes.add(uneEquipe);
    }
}
