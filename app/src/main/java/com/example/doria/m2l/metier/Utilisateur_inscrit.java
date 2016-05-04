package com.example.doria.m2l.metier;

/**
 * Created by quentin on 03/05/2016.
 */
public class Utilisateur_inscrit
{
    //Atributes
    private int codeUser;
    private String prenom;
    private String nom;
    private String mail;
    private String mdp;

    //Constructor
    public Utilisateur_inscrit()
    {

    }

    //Getters
    public int getCodeUser()
    {
        return  this.codeUser;
    }
    public String getPrenom()
    {
        return this.prenom;
    }
    public String getNom()
    {
        return this.nom;
    }
    public String getMail()
    {
        return this.mail;
    }
    public String getMdp()
    {
        return this.mdp;
    }

    //Setters
    public void setCodeUser(int code)
    {
        this.codeUser=code;
    }
    public void setPrenom(String str)
    {
        this.prenom=str;
    }
    public void setNom(String str)
    {
        this.nom=str;
    }
    public void setMail(String str)
    {
        this.mail=str;
    }
    public void setMdp(String str)
    {
        this.mdp=str;
    }


    //Function
    public String toString()
    {
        String str = " -------------------------------- \n |  Inscrit : "+nom+" "+prenom+"              | \n -------------------------------- \n";
        str+="Code User : "+codeUser+"\n";
        str+="Mail : "+mail+"\n";
        str+="mdp : "+mdp+"\n";
        str+=" \n \n ";
        return str;
    }
}
