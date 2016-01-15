package hu.ericsson.springcourse.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import hu.ericsson.springcourse.dao.CustomerDao;
import hu.ericsson.springcourse.model.Customer;

@Repository
public class DefaultCustomerDao extends DefaultBaseDao<Customer, Long> implements CustomerDao {

	private static final String INSERT_CUSTOMER = "insert into customer(first_name,last_name,birth_date,"
			+ " name_of_mother,active,id_card_number,gender) " + " values (?,?,?,?,?,?,?)";

	private static final String SELECT_BY_ID = "select * from customer where id = ?";

	private static final String SELECT_ALL = "select * from customer";

	@Autowired
	public DefaultCustomerDao(DataSource ds) {
		setDataSource(ds);
	}

	public Long create(Customer object) {

		final Customer customer = object;
		
		getJdbcTemplate().update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement stmt = con.prepareStatement(INSERT_CUSTOMER);

				stmt.setString(1, customer.getFirstName());
				stmt.setString(2, customer.getLastName());
				stmt.setDate(3, new Date(customer.getBirthDate().getTime()));
				stmt.setString(4, customer.getNameOfMother());
				stmt.setBoolean(5, customer.getActive());
				stmt.setString(6, customer.getIdentityCardNumber());
				stmt.setString(7, customer.getGender().name());
				return stmt;
			}
		});

		return 1L;
	}

	public Long update(Customer object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	public Customer get(Long id) {

		return (Customer) getJdbcTemplate().query(SELECT_BY_ID, new CustomerRowMapper(), id).get(0);
	}

	public List<Customer> getEntities() {

		return getJdbcTemplate().query(SELECT_ALL, new CustomerRowMapper());
	}

}
