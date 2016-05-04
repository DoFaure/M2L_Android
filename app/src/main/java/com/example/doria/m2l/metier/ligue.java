package com.example.doria.m2l.metier;

import java.util.ArrayList;

/**
 * Created by quentin on 02/03/2016.
 */
public class ligue
{
    private int codeLigue;
    private String nomLigue;
    private String adresse;
    private String CP;
    private String tel;
    private String url;
    private String email;
    private String ville;
    private int nbLicencie;
    private ArrayList<Club> lesClubs;
    private int codeUser;

    //Constructor
    public ligue()
    {
        this.lesClubs=new ArrayList<Club>();
    }


    /* Getters */
    public String getNom()
    {
        return this.nomLigue;
    }

    public int getUser()
    {
        return this.codeUser;
    }

    public ArrayList<Club> getLesClubs()
    {
        return this.lesClubs;
    }


    /* Setters */
    public void setCode(int val)
    {
        this.codeLigue=val;
    }

    public void  setNom(String val)
    {
        this.nomLigue=val;
    }

    public void  setAdresse(String val)
    {
        this.adresse=val;
    }

    public void  setVille(String val)
    {
        this.ville=val;
    }

    public void  setCP(String val)
    {
        this.CP=val;
    }

    public void  setUrl(String val)
    {
        this.url=val;
    }

    public void  setTel(String val)
    {
        this.tel=val;
    }

    public void  setEmail(String val)
    {
        this.email=val;
    }

    public void  setNb(int val)
    {
        this.nbLicencie=val;
    }

    public void setUser(int val){this.codeUser=val;}


    //Function
    public String toString()
    {
        String str = " -------------------------------- \n | Ligue : "+nomLigue+"              | \n -------------------------------- \n ";
        str+="Adresse : "+adresse+"\n";
        str+="Code Postal : "+CP+"\n";
        str+="TEL : "+tel+"\n";
        str+="Site : "+url+"\n";
        str+="Email : "+email+"\n";
        str+="Nombre licenciées : "+nbLicencie+"\n";
        int nbClubLigue = this.lesClubs.size();
        str+="Les clubs ("+nbClubLigue+") :";
        if(nbClubLigue>0)
        {
            for(int i=0; i<nbClubLigue;i++)
            {
                str+=" \n    > "+this.lesClubs.get(i).getLibelleClub()+"("+this.lesClubs.get(i).getLesEquipes().size()+"equipes)";
                for(int j=0;j<this.lesClubs.get(i).getLesEquipes().size();j++)
                {
                    str+=" \n           >>"+this.lesClubs.get(i).getLesEquipes().get(j).toString();
                }
            }
        }
        else
        {
            str+=" \n    Aucun club présent dans cette ligue";
        }

        str+=" \n \n ";
        return str;
    }

    public void ajoutClub(Club unClub)
    {
        int codeLigueCorrespondre = unClub.getIdLigue();
        if(this.codeLigue==codeLigueCorrespondre)
        {
            this.lesClubs.add(unClub);
        }
    }
}
