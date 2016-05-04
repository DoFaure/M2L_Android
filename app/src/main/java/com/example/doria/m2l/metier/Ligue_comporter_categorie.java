package com.example.doria.m2l.metier;

/**
 * Created by quentin on 28/04/2016.
 */
public class Ligue_comporter_categorie
{
    //private ArrayList<ligue> lesLigues;
    //private ArrayList<Categorie> lesCategories;
    private int nbMin;
    private int nbMax;
    private int codeCateg;
    private int codeLigue;


    //Constructeurs
    public Ligue_comporter_categorie()
    {
        //this.lesCategories=new ArrayList<Categorie>();
       // this.lesLigues=new ArrayList<ligue>();
    }


    //Getters
    public int getNbMin()
    {
        return  this.nbMin;
    }

    public int getNbMax()
    {
        return this.nbMax;
    }

    public int getCodeCateg()
    {
        return this.codeCateg;
    }

    public int getCodeLigue()
    {
        return this.codeLigue;
    }


    //Setters
    public void setNbMin(int nb)
    {
        this.nbMin=nb;
    }

    public void setNbMax(int nb)
    {
        this.nbMax=nb;
    }

    public  void setCodeCateg(int code)
    {
        this.codeCateg=code;
    }

    public void setCodeLigue(int code)
    {
        this.codeLigue=code;
    }


    //Functions
    public String toString()
    {
        String str = " -------------------------------- \n | Detail Categorie :               | \n -------------------------------- \n";
        str+="code ligue : "+codeLigue+"\n";
        str+="code categorie : "+codeCateg+"\n";
        str+="nb min : "+nbMin+"\n";
        str+="nb max : "+nbMax+"\n";
        str+=" \n \n ";
        return str;
    }
}
