package com.example.doria.m2l.metier;

/**
 * Created by quentin on 03/05/2016.
 */
public class Groupe_Utilisateur
{
    //Atributes
    private int codeUser;
    private int codeGroupe;

    //Constructor
    public Groupe_Utilisateur()
    {

    }

    //Getters
    public int getCodeUser()
    {
        return this.codeUser;
    }
    public int getCodeGroupe()
    {
        return this.codeGroupe;
    }

    //Setters
    public void setCodeUser(int code)
    {
        this.codeUser=code;
    }
    public void setCodeGroupe(int code)
    {
        this.codeGroupe=code;
    }

    // Function
    public String toString()
    {
        String str = " -------------------------------- \n |  Groupe Utilisateur :              | \n -------------------------------- \n";
        str+="Code User : "+codeUser+"\n";
        str+="code Groupe : "+codeGroupe+"\n";
        str+=" \n \n ";
        return str;
    }
}
