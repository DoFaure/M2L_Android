package com.example.doria.m2l.metier;

import java.util.ArrayList;

/**
 * Created by quentin on 28/04/2016.
 */
public class Participants
{
    private int codeParticipant;
    private String nomParticipant;
    private String prenomParticipant;
    private String password;
    private String adresseParticipant;
    private String telParticipant;
    private String emailParticipant;
    private int codeGroupe;
    private ArrayList<Licence> lesLicences;


    //Constructeuts
    public Participants()
    {
        this.lesLicences=new ArrayList<Licence>();
    }

    //Setters
    public void setCodeParticipant(int code)
    {
        this.codeParticipant=code;
    }

    public void setNomParticipant(String str)
    {
        this.nomParticipant=str;
    }

    public void setPrenomParticipant(String str)
    {
        this.prenomParticipant=str;
    }

    public void setAdresseParticipant(String str)
    {
        this.adresseParticipant=str;
    }

    public void setTelParticipant(String str)
    {
        this.telParticipant=str;
    }

    public void setEmailParticipant(String str)
    {
        this.emailParticipant=str;
    }

    public void setCodeGroupe(int code){this.codeGroupe=code;}

    public void setPassword(String str){this.password=str;}

    //Getters
    public int getCodeParticipant()
    {
        return  this.codeParticipant;
    }

    public String getNomParticipant()
    {
        return this.nomParticipant;
    }

    public String getPrenomParticipant()
    {
        return  this.prenomParticipant;
    }

    public String getAdresseParticipant()
    {
        return  this.adresseParticipant;
    }

    public String getTelParticipant()
    {
        return this.telParticipant;
    }

    public String getEmailParticipant()
    {
        return this.emailParticipant;
    }

    public int getCodeGroupe(){return this.codeGroupe;}

    public String getPassword(){return this.password;}

    public ArrayList<Licence>getLesLicences(){return this.lesLicences;}


    //Functions
    public void ajoutLicence(Licence uneLicence){this.lesLicences.add(uneLicence);}

    public String toString()
    {
        String str = " -------------------------------- \n | Participant : "+nomParticipant+" "+prenomParticipant+"              | \n -------------------------------- \n";
        str+="code participant : "+codeParticipant+"\n";
        str+="mdp : "+password+"\n";
        str+="Adresse : "+adresseParticipant+"\n";
        str+="Tel : "+telParticipant+"\n";
        str+="Email : "+emailParticipant+"\n";
        str+="code groupe : "+codeGroupe+"\n";
        str+="Nombre de licence : "+this.lesLicences.size()+"\n";

        for(int i=0;i<this.lesLicences.size();i++)
        {
            str+="      >>>"+lesLicences.get(i).toString()+"\n";
        }

        str+=" \n \n ";
        return str;
    }

}
