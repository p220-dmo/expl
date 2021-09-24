package fr.htc.filedb.luncher;

import java.util.ArrayList;
import java.util.List;

import fr.htc.filedb.dao.ClientDao;
import fr.htc.filedb.data.Client;
import fr.htc.filedb.service.InputFileReader;

public class JobLuncher {
	
	private static ClientDao clientDao = new ClientDao();
	
	public static void main(String[] args) {
				
		//Parse File 
		List<String> csvLines = InputFileReader.readFile("data/clients.csv");
		
		List<Client> clients = new ArrayList<Client>();
		
		for (String csvLine : csvLines) {
			Client client = Client.parseLine(csvLine);
			clients.add(client);
		}
		
		for (Client client : clients) {
			clientDao.save(client);
		}
		
		//La liste des client inserés est : 
		
		List<Client> insertedClients = clientDao.findAll();
		
		for (Client client : insertedClients) {
			System.out.println(client);
		}
		}
}
