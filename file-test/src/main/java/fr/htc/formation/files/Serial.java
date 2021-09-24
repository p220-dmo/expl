package fr.htc.formation.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

public class Serial {
	
	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar (1976, 0, 1);
		Person p = new Person ("John", "Doe", date);
		System.out.println (p);
		
		File f = new File ("person.objet");
		 
		try
		{
		    ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (f));
		    oos.writeObject (p);
		    oos.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de l'écriture : " + exception.getMessage());
		    exception.printStackTrace();
		}
	}

}
