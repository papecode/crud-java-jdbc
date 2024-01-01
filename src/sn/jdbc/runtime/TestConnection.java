package sn.jdbc.runtime; // Ctrl + shif + o pour gérer les imports


import java.util.List;

import sn.jdbc.exceptions.RepositoryException;
import sn.jdbc.repository.IRepository;
import sn.jdbc.repository.entities.User;
import sn.jdbc.repository.implement.MySqlUserRepository;

public class TestConnection {

	public static void main(String[] args) {
		
		IRepository<User> repository = new MySqlUserRepository();
		try {
			
			 List<User> userList = repository.list();
			
		if (!userList.isEmpty()) {
            System.out.println("User list:");
            for (User user : userList) {
                System.out.println("ID: " + user.getId());
                System.out.println("Login: " + user.getLogin());
                System.out.println("Password: " + user.getPassword());
                System.out.println("--------");
            }
        } else {
            System.out.println("No users found in the database.");
        }
    } catch (RepositoryException e) {
        System.out.println("Error retrieving user list: " + e.getMessage());
    }
}
			
		
		
}
	
	 /*try {
         int userIdToRead = 1;
         User user = repository.read(userIdToRead);

         if (user != null) {
             System.out.println("User found:");
             System.out.println("ID: " + user.getId());
             System.out.println("Login: " + user.getLogin());
             System.out.println("Password: " + user.getPassword());
         } else {
             System.out.println("User not found with ID: " + userIdToRead);
         }
     } catch (RepositoryException e) {
         System.out.println("Error reading user: " + e.getMessage());
     }
 }
		
		
		/*try {
			User user = new User("wade","passer");
			repository.create(user);
			
			JOptionPane.showConfirmDialog(null, "Utilisateur créé avec succès");
		} catch (RepositoryException e) {
			System.out.println("Error : " +e.getMessage());
		}
	}*/


