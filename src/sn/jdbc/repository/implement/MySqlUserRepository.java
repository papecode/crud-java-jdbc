package sn.jdbc.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sn.jdbc.DBManager;
import sn.jdbc.exceptions.RepositoryException;
import sn.jdbc.repository.IRepository;
import sn.jdbc.repository.entities.User;

public class MySqlUserRepository implements IRepository<User> {

	@Override
	public void create(User entity) throws RepositoryException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into T_Users (login, password) values (?,?)";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getPassword());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new RepositoryException(e.getClass().getSimpleName() + ":" +
					e.getMessage());
		}
		
	}

	@Override
	public User read(int id) throws RepositoryException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From T_Users where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			//  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String login = rs.getString("login");
				String password = rs.getString("password");
				User user = new User (id, login, password);
				return user;
			}
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return null;
	}

	@Override
	public List<User> list() throws RepositoryException {
		List<User> users = new ArrayList<>();
		
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From T_Users";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int identifiant = rs.getInt("id");
				String login = rs.getString("login");
				String password = rs.getString("password");
				
				User user = new User (identifiant, login, password);
				users.add(user);
			}
		} catch (Exception e) {
			throw new RepositoryException(e.getMessage());
		}
		return users;
		
	}

	@Override
	public void update(User entity) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

}
