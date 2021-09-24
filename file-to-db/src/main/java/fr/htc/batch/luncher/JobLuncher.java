package fr.htc.batch.luncher;

import java.util.ArrayList;
import java.util.List;

import fr.htc.batch.dao.ClientDao;
import fr.htc.batch.data.Client;
import fr.htc.batch.service.InputFileReader;

public class JobLuncher {

	private static ClientDao clientDao = new ClientDao();
	
	public static void main(String[] args) {
		
		if(args.length != 1 ) {
			System.out.println("Missing argument : file path");
			return;
		}
		
		String filePath = args[0];
				
		//Parse File 
		List<String> csvLines = InputFileReader.readFile(filePath);
		
		List<Client> clients = new ArrayList<Client>();
		
		for (String csvLine : csvLines) {
			clients.add(Client.parseLine(csvLine));
		}
		
		for (Client client : clients) {
			clientDao.save(client);
		}
	}
}
