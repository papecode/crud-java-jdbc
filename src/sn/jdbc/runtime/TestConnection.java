package sn.jdbc.runtime; // Ctrl + shif + o pour gérer les imports

import javax.swing.JOptionPane;

import sn.jdbc.exceptions.RepositoryException;
import sn.jdbc.repository.IRepository;
import sn.jdbc.repository.entities.User;
import sn.jdbc.repository.implement.MySqlUserRepository;

public class TestConnection {

	public static void main(String[] args) {
		
		IRepository<User> repository = new MySqlUserRepository();
		
		try {
			User user = new User("wade","passer");
			repository.create(user);
			
			JOptionPane.showConfirmDialog(null, "Utilisateur créé avec succès");
		} catch (RepositoryException e) {
			System.out.println("Error : " +e.getMessage());
		}
	}

}
