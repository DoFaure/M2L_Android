package com.example.doria.m2l.http;

import android.os.AsyncTask;

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

	/*public List<String> donneLivraison()
	{
		List<String> liste = new ArrayList<String>();
		//for (Livraison livraison : lesLivraisons) liste.add(livraison.toString());
		return liste;
	}*/

	public List<String> donneLigue()
	{
		List<String> liste = new ArrayList<String>();
		for (ligue uneLigue : lesLigues) liste.add(uneLigue.toString());
		return liste;
	}
}
