package sn.jdbc.repository.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
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