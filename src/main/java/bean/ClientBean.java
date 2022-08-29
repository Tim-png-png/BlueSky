package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dao.ClientDAO;
import main.Client;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ClientBean implements Serializable {
		private Client client;
		private ClientDAO clientDAO;
		@SuppressWarnings("unused")
		private List<Client> clientList;
		
		@PostConstruct
		public void start() {
			clientDAO = new ClientDAO();			
			clean();		
		}
		
		public void save() {
			clientDAO.save(client);
			clean();
		}
		
		public void clean() {
			 client = new Client();
		}
		
		public void list() {
			clientList = clientDAO.list();
		}
		
		public void select(Client clientSelected) {
			client = clientSelected;
		}
		
		public void delete() {
			clientDAO.delete(client.getId());
			clean();
		}
		
		public void update() {
			clientDAO.update(client);
			clean();
		}
}
