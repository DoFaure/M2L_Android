package com.example.doria.m2l.metier;

import java.util.ArrayList;

/**
 * Created by quentin on 03/05/2016.
 */
public class Groupe
{
    //Attributes
    private int codeGroupe;
    private String libelleGroupe;
    private ArrayList<Participants> lesParticipants;

    //constructor
    public Groupe()
    {
        lesParticipants=new ArrayList<Participants>();
    }

    //Getters
    public int getCodeGroupe()
    {
        return this.codeGroupe;
    }
    public String getLibelleGroupe()
    {
        return this.libelleGroupe;
    }
    public ArrayList<Participants> getLesParticipants()
    {
        return this.lesParticipants;
    }


    //Setters
    public void setCodeGroupe(int code)
    {
        this.codeGroupe=code;
    }
    public void setLibelleGroupe(String lib)
    {
        this.libelleGroupe=lib;
    }

    //Functions
    public void ajoutParticipant(Participants unParticipant)
    {
        lesParticipants.add(unParticipant);
    }

    public String toString()
    {
        String str = " -------------------------------- \n | Groupe :               | \n -------------------------------- \n";
        str+="code : "+codeGroupe+"\n";
        str+="libelle : "+libelleGroupe+"\n";
        str+="nb participant : "+this.lesParticipants.size()+"\n";
        for (int i=0;i<this.lesParticipants.size();i++)
        {
            str+="  \n   >>"+this.lesParticipants.get(i).toString();
        }
        str+=" \n \n ";
        return str;
    }
}
