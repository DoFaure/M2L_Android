package com.example.doria.m2l.http;

import android.os.AsyncTask;

import com.example.doria.m2l.metier.Categorie;
import com.example.doria.m2l.metier.Groupe;
import com.example.doria.m2l.metier.Groupe_Utilisateur;
import com.example.doria.m2l.metier.Licence;
import com.example.doria.m2l.metier.Ligue_comporter_categorie;
import com.example.doria.m2l.metier.Participants;
import com.example.doria.m2l.metier.Utilisateur_inscrit;
import com.example.doria.m2l.metier.ligue;
import com.example.doria.m2l.xml.MaSaxHandler;

import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

public class LitFichier extends AsyncTask<String, Void, Boolean>{
	
	//private List<Personne> lesPersonnes = new ArrayList<Personne>();
	//private List<Livraison> lesLivraisons;
	private List<ligue> lesLigues;
	private List<Categorie> lesCategorie;
	private List<Ligue_comporter_categorie> lesLiguesCateg;
	private List<Participants> lesParticipants;
	private List<Licence> lesLicences;
	private List<Utilisateur_inscrit> lesInscrits;
	private List<Groupe_Utilisateur> lesGroupesUser;
	private List<Groupe> lesGroupes;


	@Override
	protected Boolean doInBackground(String... urls)
	{
		URL url;
		try
		{
			url = new URL(urls[0]);
			BufferedReader bufferedReader;
			bufferedReader = new BufferedReader(
					new InputStreamReader(url.openConnection().getInputStream()));
			String ligne;
			while ((ligne = bufferedReader.readLine())!= null)
			{
				MaSaxHandler handler = new MaSaxHandler();
				handler.parse(url.openConnection().getInputStream());
				lesLigues = handler.getLigues();
				lesCategorie = handler.getLesCategories();
				lesLiguesCateg = handler.getDetailsCateg();
				lesParticipants = handler.getParticipant();
				lesLicences = handler.getLicence();
				lesInscrits = handler.getInscrit();
				lesGroupesUser = handler.getGroupes();
				lesGroupes = handler.getLesGroupes();
			}
			bufferedReader.close();
	        return true;
		}
		catch (MalformedURLException e)
		{
			return false;
		}
		catch (IOException e)
		{
			return false;
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
			return false;
		}
		catch (SAXException e)
		{
			e.printStackTrace();
			return false;
		}
	}


	public List<String> donneLigue()
	{
		List<String> liste = new ArrayList<String>();
		for (ligue uneLigue : lesLigues) liste.add(uneLigue.toString());
		return liste;
	}

	public List<String> donneCategorie()
	{
		List<String> listeCat = new ArrayList<String>();
		for (Categorie uneCategorie : lesCategorie) listeCat.add(uneCategorie.toString());
		return listeCat;
	}

	public List<String> donneDetailCateg()
	{
		List<String> listeCat = new ArrayList<String>();
		for (Ligue_comporter_categorie ligueCateg : lesLiguesCateg) listeCat.add(ligueCateg.toString());
		return listeCat;
	}

	public List<String> donneParticipants()
	{
		List<String> listeCat = new ArrayList<String>();
		for (Participants unParticipant : lesParticipants) listeCat.add(unParticipant.toString());
		return listeCat;
	}

	public List<String> donneLicence()
	{
		List<String> listeCat = new ArrayList<String>();
		for (Licence uneLicence : lesLicences) listeCat.add(uneLicence.toString());
		return listeCat;
	}

	public List<String> donneInscrit()
	{
		List<String> listeInscr = new ArrayList<String>();
		for (Utilisateur_inscrit unInscrit : lesInscrits) listeInscr.add(unInscrit.toString());
		return listeInscr;
	}

	public List<String> donneGroupUser()
	{
		List<String> liste = new ArrayList<String>();
		for (Groupe_Utilisateur unGroupe : lesGroupesUser) liste.add(unGroupe.toString());
		return liste;
	}

	public List<String> listeGroupe()
	{
		List<String> liste = new ArrayList<String>();
		for (Groupe unGroupe : lesGroupes) liste.add(unGroupe.toString());
		return liste;
	}
}
