package Model;

import java.util.List;

import ModelServices.CatalogueService;
import ModelServices.UtilisateurService;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		
		UtilisateurService us = new UtilisateurService();
		
		Utilisateur u = us.verify("jihad@gmail", "1234");
		
		System.out.println(u.getId());
		
		
	}

	

}
