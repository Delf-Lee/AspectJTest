package service;

import java.util.HashMap;
import java.util.Map;

import model.Client;

public class ClientService {
	private Map<String, Client> clients;

	// singleton instance
	private static final ClientService instance = new ClientService();

	public ClientService() {
		clients = new HashMap<String, Client>();
		inputTestData();
	}

	/** @return the singleton instance of ClientService */
	public static ClientService getInstance() {
		return instance;
	}

	/** @param add client to the database(hashMap) */
	public void addClient(Client client) {
		clients.put(client.getId(), client);
	}

	/** @param id client's id. 
	 * @param password password according to id.
	 * @return if id exist in server database and password correct, return true. else false.*/
	public boolean login(String id, String password) {
		if (isIdExist(id)) {
			if (isPasswordCorrect(id, password)) {
				return true;
			}
		}
		return false;
	}

	/** @param id client's id 
	 * @return if id exist in server database, return true. else false */
	private boolean isIdExist(String id) {
		return clients.containsKey(id);
	}

	/** @param id client's id. 
	 * @param password password according to id.
	 * @return if id and password are matched, return true. else false. */
	private boolean isPasswordCorrect(String id, String password) {
		return clients.get(id).isPasswordCorrect(password);
	}
	
	/** input the data for debuging. */
	private void inputTestData() {
		addClient(new Client("id001", "ps001", "Lee"));
		addClient(new Client("id002", "ps002", "Park"));
		addClient(new Client("id003", "ps003", "Choi"));
		addClient(new Client("id004", "ps004", "Kwon"));
		addClient(new Client("id005", "ps005", "Jeong"));
	}
}