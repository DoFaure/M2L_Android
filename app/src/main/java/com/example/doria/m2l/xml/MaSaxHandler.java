package com.example.doria.m2l.xml;

import com.example.doria.m2l.metier.Categorie;
import com.example.doria.m2l.metier.Club;
import com.example.doria.m2l.metier.Equipe;
import com.example.doria.m2l.metier.Groupe;
import com.example.doria.m2l.metier.Groupe_Utilisateur;
import com.example.doria.m2l.metier.Licence;
import com.example.doria.m2l.metier.Ligue_comporter_categorie;
import com.example.doria.m2l.metier.Participants;
import com.example.doria.m2l.metier.Utilisateur_inscrit;
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
	//variable pour instanciation objets
	 private String valeur;
	 private ligue uneLigue;
	 private List<ligue> lesLigues = new ArrayList<ligue>();
     private Club unClub;
     private Equipe uneEquipe;

	 private Categorie uneCategorie;
	 private List<Categorie> lesCategories = new ArrayList<Categorie>();
	 private Ligue_comporter_categorie ligueCateg;
	 private ArrayList<Ligue_comporter_categorie> lesLiguesCateg = new ArrayList<Ligue_comporter_categorie>();

	 private Participants unParticipant;
	 private ArrayList<Participants> lesParticipants =  new ArrayList<Participants>();
	 private Licence uneLicence;
	 private ArrayList<Licence> lesLicences = new ArrayList<Licence>();
	 private Utilisateur_inscrit unInscrit;
	 private ArrayList<Utilisateur_inscrit> lesInscrits = new ArrayList<Utilisateur_inscrit>();
	 private Groupe_Utilisateur unGroupeUser;
	 private  ArrayList<Groupe_Utilisateur> lesGroupesUser = new ArrayList<Groupe_Utilisateur>();
	 private Groupe unGroupe;
	 private ArrayList<Groupe> lesGroupes = new ArrayList<Groupe>();

	// Variable pour lecture xml
	 private String attribuBalise;
	 private String attribuCollonne;


	   public void parse(InputStream is) throws ParserConfigurationException, SAXException, IOException
	   {
		   SAXParserFactory factory = SAXParserFactory.newInstance();
		   SAXParser parser=factory.newSAXParser();
		   parser.parse(is,this);
	   }

		public void startElement( String uri, String localName, String qName, Attributes attributes)
			   throws SAXException
	   {
		   if(localName.equals("table"))
		   {
			  // Log.i("lithttp", attributes.getValue("name"));
			   attribuBalise="";
			   if(attributes.getValue("name").equals("ligue"))
			   {
				  // Log.i("lithttp", "0");
				   uneLigue = new ligue();
				   attribuBalise="ligue";
			   }
			   if(attributes.getValue("name").equals("club")) {
				   //Log.i("lithttp", "1");
				   unClub = new Club();
				   attribuBalise="club";
			   }
			   if(attributes.getValue("name").equals("equipe"))
			   {
				  // Log.i("lithttp", "2");
				   uneEquipe = new Equipe();
				   attribuBalise="equipe";
			   }
			   if(attributes.getValue("name").equals("categoriesportive"))
			   {
				   //Log.i("lithttp", "3");
				   uneCategorie = new Categorie();
				   attribuBalise="categoriesportive";
			   }
			   if(attributes.getValue("name").equals("liguecomportercategorie"))
			   {
				   //Log.i("lithttp", "3");
				   ligueCateg = new Ligue_comporter_categorie();
				   attribuBalise="liguecomportercategorie";
			   }
			   if(attributes.getValue("name").equals("participant"))
			   {
				   //Log.i("lithttp", "3");
				   unParticipant = new Participants();
				   attribuBalise="participant";
			   }
			   if(attributes.getValue("name").equals("licence"))
			   {
				   //Log.i("lithttp", "3");
				   uneLicence = new Licence();
				   attribuBalise="licence";
			   }
			   if(attributes.getValue("name").equals("auth_user"))
			   {
				   //Log.i("lithttp", "3");
				   unInscrit = new Utilisateur_inscrit();
				   attribuBalise="auth_user";
			   }
			   if(attributes.getValue("name").equals("auth_membership"))
			   {
				   //Log.i("lithttp", "3");
				   unGroupeUser = new Groupe_Utilisateur();
				   attribuBalise="auth_membership";
			   }
			   if(attributes.getValue("name").equals("auth_group"))
			   {
				   //Log.i("lithttp", "3");
				   unGroupe = new Groupe();
				   attribuBalise="auth_group";
			   }


		   }
		   else if(localName.equals("column"))
		   { //Log.i("lithttp", "55");
			   attribuCollonne=attributes.getValue("name");

		   }
	   }

	   public void characters(char[] ch,int start, int length) throws SAXException
	   {
		   valeur = new String(ch,start,length);
	   }



	   public void endElement( String uri, String localName,String qName) throws SAXException
	   {

           /* ----------------------------------
                    Gestion des Objets
              ---------------------------------*/
		   if(localName.equals("table")) {
			   if (attribuBalise != null)
			   {
				   //Ajout de ligue
				   if (attribuBalise.equals("ligue"))
				   {
					   //Log.i("lithttp", "666");
					   lesLigues.add(uneLigue);
					   attribuBalise=null;
				   }

				   //Ajout de club
				   else if (attribuBalise.equals("club"))
				   {
					   for(int i=0;i<lesLigues.size();i++)
					   {
						   lesLigues.get(i).ajoutClub(unClub);
					   }
					   attribuBalise=null;
				   }

				   //Ajout des équipes
				   else if (attribuBalise.equals("equipe"))
				   {
					   for(int i=0;i<lesLigues.size();i++)
					   {

						   for(int j=0; j<lesLigues.get(i).getLesClubs().size();j++)
						   {
							   if(lesLigues.get(i).getLesClubs().get(j).getCode() == uneEquipe.getCodeClub())
							   {
								   //Log.i("lithttp", String.valueOf(lesLigues.get(i).getLesClubs().get(j).getCode()) + " : " + String.valueOf(uneEquipe.getCodeClub()));
								   lesLigues.get(i).getLesClubs().get(j).ajoutEquipe(uneEquipe);
							   }
						   }
					   }
					   attribuBalise=null;
				   }

				   //Ajout des catégories
				   else if (attribuBalise.equals("categoriesportive"))
				   {
					   lesCategories.add(uneCategorie);
					   attribuBalise=null;
				   }

				   //Ajout des infos de catégorie
				   else if (attribuBalise.equals("liguecomportercategorie"))
				   {
					   lesLiguesCateg.add(ligueCateg);
					   attribuBalise=null;
				   }

				   //Ajout des personnes
				   else if (attribuBalise.equals("participant"))
				   {
					   //Log.i("lithttp", "111");
					   for(int i=0;i<lesGroupes.size();i++)
					   {
						   //Log.i("lithttp", "222");
						   if(lesGroupes.get(i).getCodeGroupe()==unParticipant.getCodeGroupe())
						   {
							   //Log.i("lithttp", "333");
							   //lesGroupes.get(i).add(unParticipant);
							   lesGroupes.get(i).ajoutParticipant(unParticipant);
							   attribuBalise=null;
						   }
					   }

				   }

				   //Ajout des licences
				   else if (attribuBalise.equals("licence"))
				   {
					   for(int a=0;a<lesGroupes.size();a++)
					   {
					   	//Insetion de la licence dans la liste des licences d'une personne
						   for(int i=0;i<lesGroupes.get(a).getLesParticipants().size();i++)
						   {
							   if(lesGroupes.get(a).getLesParticipants().get(i).getCodeParticipant() == uneLicence.getCodeUser())
							   {
								   lesGroupes.get(a).getLesParticipants().get(i).ajoutLicence(uneLicence);
								   attribuBalise=null;
							   }
						   }
					   }

					   //Insertion de la licence au sein de l'équipe correspondante
					   for(int a=0;a<lesLigues.size();a++)
					   {
						  for(int b=0;b<lesLigues.get(a).getLesClubs().size();b++)
						   {
							   for(int c=0;c<lesLigues.get(a).getLesClubs().get(b).getLesEquipes().size();c++)
							   {
								   if(lesLigues.get(a).getLesClubs().get(b).getLesEquipes().get(c).getCodeEquipe()==uneLicence.getCodeEquipe())
								   {
									   lesLigues.get(a).getLesClubs().get(b).getLesEquipes().get(c).ajoutLicence(uneLicence);
								   }
							   }

						   }
					   }



				   }

				   //Useless
				   else if (attribuBalise.equals("auth_user"))
				   {
					   lesInscrits.add(unInscrit);
					   attribuBalise=null;
				   }

				   //Useless
				   else if (attribuBalise.equals("auth_membership"))
				   {
					   lesGroupesUser.add(unGroupeUser);
					   attribuBalise=null;
				   }

				   //Ajout d'un groupe d'utilisateur
				   else if (attribuBalise.equals("auth_group"))
				   {
					   lesGroupes.add(unGroupe);
					   attribuBalise=null;
				   }
			   }

		   }
		   else if(localName.equals("column"))
		   {
			   /* --------------------------
			  	 	Gestion des ligues
			   -----------------------------*/
			   if (attribuCollonne.equals("idLigue")) {
				   uneLigue.setCode(Integer.parseInt(valeur)); // on converti notre string en int
			   }
			   else if (attribuCollonne.equals("nomLigue")) {
				   uneLigue.setNom(valeur);
			   } else if (attribuCollonne.equals("adresseRueLigue")) {
				   uneLigue.setAdresse(valeur);
			   }
			   else if (attribuCollonne.equals("villeLigue")) {
				   uneLigue.setVille(valeur);
			   }
			   else if (attribuCollonne.equals("cpLigue")) {
				   uneLigue.setCP(valeur);
			   } else if (attribuCollonne.equals("telLigue")) {
				   uneLigue.setTel(valeur);
			   } else if (attribuCollonne.equals("URLSiteWebLigue")) {
				   uneLigue.setUrl(valeur);
			   } else if (attribuCollonne.equals("emailContactLigue")) {
				   uneLigue.setEmail(valeur);
			   } else if (attribuCollonne.equals("nbrlicenciesLigue")) {
				   uneLigue.setNb(Integer.parseInt(valeur)); }// on converti notre string en int
			   else if (attribuCollonne.equals("idUserLigue")) {
				   uneLigue.setUser(Integer.parseInt(valeur)); }


				     /* ----------------------------
			 				  Gestion des clubs
 						-----------------------------*/

			   else if (attribuCollonne.equals("codeClub")) {
				   unClub.setCode(Integer.parseInt(valeur));
			   } else if (attribuCollonne.equals("libelleClub")) {
				   unClub.setLibelle(valeur);
			   }
			   else if (attribuCollonne.equals("idLigueClub"))
			   {
				   //Log.i("lithttp", valeur);
				   unClub.setIdLigue(Integer.parseInt(valeur));

			   }
			   else if (attribuCollonne.equals("codeResponsableClub"))
			   {
				   //Log.i("lithttp", valeur);
				   unClub.setResponsable(Integer.parseInt(valeur));
			   }

			   /* ----------------------------
					Gestion des Equipes
				-----------------------------*/
			   else if (attribuCollonne.equals("codeEquipe")) {
			   uneEquipe.setCode(Integer.parseInt(valeur));
			   } else if (attribuCollonne.equals("libelleEquipe")) {
			   uneEquipe.setLibelleEquipe(valeur);
			   }
			   else if (attribuCollonne.equals("codeClubEquipe")) {
				   uneEquipe.setCodeClub(Integer.parseInt(valeur));
			   }


				 /*-------------------------/
				/  Gestion des catégories  /
			   /-------------------------*/
			   else if (attribuCollonne.equals("codeCategorie")) {
			   uneCategorie.setCodeCategorie(Integer.parseInt(valeur));
			   } else if (attribuCollonne.equals("libelleCategorie")) {
			   uneCategorie.setLibelleCategorie(valeur);
			   } else if (attribuCollonne.equals("ageMaxCategorie")) {
			   uneCategorie.setAgeMax(Integer.parseInt(valeur));
			   } else if (attribuCollonne.equals("ageMinCategorie")) {
			   uneCategorie.setAgeMin(Integer.parseInt(valeur));
			   }

			   /* ---------------------------
			   	Gestion ligue appart categ
			   ------------------------------- */
			   else if (attribuCollonne.equals("codeCategorieLigue")) {
				   ligueCateg.setCodeCateg(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("codeLigueCategorie")) {
				   ligueCateg.setCodeLigue(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("nbMin")) {
				   ligueCateg.setNbMin(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("nbMax")) {
				   ligueCateg.setNbMax(Integer.parseInt(valeur));
			   }

			   /* --------------------------------
			   			Gestion des participant
			    ---------------------------------*/
			   else if (attribuCollonne.equals("idParticipant")) {
				   unParticipant.setCodeParticipant(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("nomParticipant")) {
				   unParticipant.setNomParticipant(valeur);
			   }
			   else if (attribuCollonne.equals("passwordUser")) {
				   unParticipant.setPassword(valeur);
			   }
			   else if (attribuCollonne.equals("prenomParticipant")) {
				   unParticipant.setPrenomParticipant(valeur);
			   }
			   else if (attribuCollonne.equals("adresseRueParticipant")) {
				   unParticipant.setAdresseParticipant(valeur);
			   }
			   else if (attribuCollonne.equals("telParticipant")) {
				   unParticipant.setTelParticipant(valeur);
			   }
			   else if (attribuCollonne.equals("emailContactParticipant")) {
				   unParticipant.setEmailParticipant(valeur);
			   }
			   else if (attribuCollonne.equals("idGroupe")) {
				   unParticipant.setCodeGroupe(Integer.parseInt(valeur));
			   }

			   /*-------------------------------------
			   			Gestion Licence
			   ------------------------------------- */
			   else if (attribuCollonne.equals("codeLicence")) {
				   uneLicence.setCodeLicence(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("codeCategorieLicence")) {
				   uneLicence.setCodeCategorie(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("codeUserLicence")) {
				   uneLicence.setCodeUser(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("codeClubLicence")) {
				   uneLicence.setCodeClub(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("codeEquipeLicence")) {
				   uneLicence.setCodeEquipe(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("codeLigueLicence")) {
				   uneLicence.setCodeLigue(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("dateInscription")) {
				   uneLicence.setDateInscription(valeur);
			   }

			   /*------------------------------
			   			Gestion Inscrit
			   ------------------------------- */
			   else if (attribuCollonne.equals("idUser")) {
				   unInscrit.setCodeUser(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("first_name")) {
				   unInscrit.setPrenom(valeur);
			   }
			   else if (attribuCollonne.equals("last_name")) {
				   unInscrit.setNom(valeur);
			   }
			   else if (attribuCollonne.equals("email")) {
				   unInscrit.setMail(valeur);
			   }
			   else if (attribuCollonne.equals("password")) {
				   unInscrit.setMdp(valeur);
			   }

			   /* ----------------------------------
			   			Gestion groupe utilisateur
			   ------------------------------------ */
			   else if (attribuCollonne.equals("user_id")) {
				   unGroupeUser.setCodeUser(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("group_id")) {
				   unGroupeUser.setCodeGroupe(Integer.parseInt(valeur));
			   }

			    /* ----------------------------------
			   			Gestion groupe
			   ------------------------------------ */
			   else if (attribuCollonne.equals("id")) {
				   unGroupe.setCodeGroupe(Integer.parseInt(valeur));
			   }
			   else if (attribuCollonne.equals("role")) {
				   unGroupe.setLibelleGroupe(valeur);
			   }

		   }



	    }

    public List<ligue> getLigues()
    {
        return lesLigues;
    }

	public List<Categorie> getLesCategories()
	{
		return lesCategories;
	}

	public List<Ligue_comporter_categorie> getDetailsCateg()
	{
		return lesLiguesCateg;
	}

	public List<Participants> getParticipant()
	{
		return lesParticipants;
	}

	public List<Licence> getLicence()
	{
		return lesLicences;
	}

	public List<Utilisateur_inscrit> getInscrit()
	{
		return lesInscrits;
	}

	public List<Groupe_Utilisateur> getGroupes()
	{
		return lesGroupesUser;
	}

	public List<Groupe> getLesGroupes()
	{
		return lesGroupes;
	}
}
