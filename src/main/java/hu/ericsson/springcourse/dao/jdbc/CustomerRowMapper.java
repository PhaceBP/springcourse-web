package hu.ericsson.springcourse.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.ericsson.springcourse.model.Customer;
import hu.ericsson.springcourse.model.GenderType;

public class CustomerRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer customer = new Customer();
		customer.setId(rs.getLong("id"));
		customer.setActive(rs.getBoolean("active"));
		customer.setBirthDate(rs.getDate("birth_date"));
		customer.setFirstName(rs.getString("first_name"));
		customer.setLastName(rs.getString("last_name"));
		customer.setGender(GenderType.valueOf(rs.getString("gender")));
		customer.setIdentityCardNumber(rs.getString("id_card_number"));
		customer.setNameOfMother(rs.getString("name_of_mother"));

		return customer;
	}

}
