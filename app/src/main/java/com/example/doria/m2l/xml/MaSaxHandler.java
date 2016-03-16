package com.example.doria.m2l.xml;

import com.example.doria.m2l.metier.Categorie;
import com.example.doria.m2l.metier.Club;
import com.example.doria.m2l.metier.Equipe;
import com.example.doria.m2l.metier.Licence;
import com.example.doria.m2l.metier.ligue;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MaSaxHandler extends DefaultHandler
{
	 /*private Livraison livraison;
	   private List<Livraison> lesLivraisons = new ArrayList<Livraison>();
	   private Colis unColis;*/
	 private String valeur;
	 private ligue uneLigue;
	 private List<ligue> lesLigues = new ArrayList<ligue>();
     private Club unClub;
     private Equipe uneEquipe;
	 private Categorie uneCategorie;
	 private Licence uneLicence;

	   public void parse(InputStream is) throws ParserConfigurationException, SAXException, IOException
	   {
		   SAXParserFactory factory = SAXParserFactory.newInstance();
		   SAXParser parser=factory.newSAXParser();
		   parser.parse(is,this);
	   }

		public void startElement( String uri, String localName, String qName, Attributes attributes)
			   throws SAXException
	   {
		   if(localName.equals("ligue")) uneLigue = new ligue();
           if (localName.equals("club"))  unClub = new Club();
           if (localName.equals("equipe"))  uneEquipe = new Equipe();
		   if (localName.equals("categorie"))  uneCategorie = new Categorie();
	   }

	   public void characters(char[] ch,int start, int length) throws SAXException
	   {
		   valeur = new String(ch,start,length);
	   }

	   public void endElement( String uri, String localName,String qName) throws SAXException
	   {

           /* ----------------------------------
                    Gestion des ligues
              ---------------------------------*/
		   if (localName.equals("ligue"))
		   {
			   lesLigues.add(uneLigue);
		   }

           else if(localName.equals("codeLigue"))
           {
               uneLigue.setCode(Integer.parseInt(valeur)); // on converti notre string en int
           }

		   else if(localName.equals("nomLigue"))
		   {
			   uneLigue.setNom(valeur);
		   }

		   else if(localName.equals("adresse"))
		   {
			   uneLigue.setAdresse(valeur);
		   }

		   else if(localName.equals("CP"))
		   {
			   uneLigue.setCP(valeur);
		   }

		   else if(localName.equals("tel"))
		   {
			   uneLigue.setTel(valeur);
		   }

		   else if(localName.equals("URL"))
		   {
			   uneLigue.setUrl(valeur);
		   }

		   else if(localName.equals("email"))
		   {
			   uneLigue.setEmail(valeur);
		   }

		   else if(localName.equals("nombre"))
		   {
			   uneLigue.setNb(Integer.parseInt(valeur)); // on converti notre string en int
		   }

           /* ----------------------------
                Gestion des clubs
            -----------------------------*/
           else if(localName.equals("club"))
           {
               uneLigue.ajoutClub(unClub);
           }

           else if(localName.equals("codeClub"))
           {
               unClub.setCode(Integer.parseInt(valeur));
           }

           else if(localName.equals("libelleClub"))
           {
               unClub.setLibelle(valeur);
           }

           /* ----------------------------
                Gestion des Equipes
            -----------------------------*/
           else if(localName.equals("equipe"))
           {
               unClub.ajoutEquipe(uneEquipe);
           }

           else if(localName.equals("codeEquipe"))
           {
               uneEquipe.setCode(Integer.parseInt(valeur));
           }

           else if(localName.equals("libelleEquipe"))
           {
               uneEquipe.setLibelleEquipe(valeur);
           }


		     /*-------------------------/
		    /  Gestion des catégories  /
		   /-------------------------*/
		   else if(localName.equals("categorie"))
		   {

		   }

		   else if(localName.equals("codeCategorie"))
		   {
			   uneCategorie.setCodeCategorie(Integer.parseInt(valeur));
		   }

		   else if(localName.equals("libelleCategorie"))
		   {
			   uneCategorie.setLibelleCategorie(valeur);
		   }

		   else if(localName.equals("ageMax"))
		   {
			   uneCategorie.setAgeMax(Integer.parseInt(valeur));
		   }

		   else if(localName.equals("ageMin"))
		   {
			   uneCategorie.setAgeMin(Integer.parseInt(valeur));
		   }



	    }

    public List<ligue> getLigues()
    {
        return lesLigues;
    }
}
