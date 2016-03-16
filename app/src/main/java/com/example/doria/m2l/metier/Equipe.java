package com.example.doria.m2l.metier;

/**
 * Created by quentin on 09/03/2016.
 */
public class Equipe
{
    private int codeEquipe;
    private String libelleEquipe;

    public Equipe()
    {

    }

    public void setCode(int code)
    {
        this.codeEquipe=code;
    }

    public void setLibelleEquipe(String lib)
    {
        this.libelleEquipe=lib;
    }

    public int getCodeEquipe()
    {
        return this.codeEquipe;
    }

    public String getLibelleEquipe()
    {
        return this.libelleEquipe;
    }
}
