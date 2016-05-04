package com.example.doria.m2l.metier;

/**
 * Created by quentin on 16/03/2016.
 */
public class Licence
{
    //Atributes
    private int codeLicence;
    private int codeCategorie;
    private int codeUser;
    private int codeLigue;
    private int codeClub;
    private int codeEquipe;
    private String dateInscription;

    //Constructeur
    public Licence()
    {

    }

    //Getters
    public int getCodeLicence()
    {
        return this.codeLicence;
    }
    public int getCodeCategorie()
    {
        return this.codeCategorie;
    }
    public int getCodeUser()
    {
        return this.codeUser;
    }
    public int getCodeClub()
    {
        return this.codeClub;
    }
    public int getCodeEquipe()
    {
        return this.codeEquipe;
    }
    public String getDateInscription()
    {
        return this.dateInscription;
    }
    public int getCodeLigue(){return  this.codeLigue;}

    //Setters
    public void setCodeLicence(int str)
    {
        this.codeLicence=str;
    }
    public void setCodeCategorie(int str)
    {
        this.codeCategorie=str;
    }
    public void setCodeUser(int str)
    {
        this.codeUser=str;
    }
    public void setCodeClub(int str)
    {
        this.codeClub=str;
    }
    public void setCodeEquipe(int str)
    {
        this.codeEquipe=str;
    }
    public void setDateInscription(String str)
    {
        this.dateInscription=str;
    }
    public void setCodeLigue(int nbr){this.codeLigue=nbr;}


    //Function
    public String toString()
    {
        String str = " -------------------------------- \n | Licences : "+codeLicence+"              | \n -------------------------------- \n";
        str+="Code cat : "+codeCategorie+"\n";
        str+="Code club : "+codeClub+"\n";
        str+="Code user : "+codeUser+"\n";
        str+="Code equipe : "+codeEquipe+"\n";
        str+="Code ligue : "+codeLigue+"\n";
        str+="Date inscription : "+dateInscription+"\n";
        str+=" \n \n ";
        return str;
    }

}
