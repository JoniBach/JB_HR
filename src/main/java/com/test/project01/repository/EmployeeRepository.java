package com.test.project01.repository;

import com.test.project01.module.EmployeeModule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmployeeRepository implements EmployeeJDBC {
    private JdbcTemplate jdbc;

    public EmployeeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Iterable<EmployeeModule> findAll() {
        String s= "SELECT * FROM employee_table";
        return jdbc.query(s, this::mapRowToEmployee);
    }

    private EmployeeModule mapRowToEmployee(ResultSet rs, int rowNum)
            throws SQLException {
        EmployeeModule employee= new EmployeeModule();
        employee.setEmployee_ID(rs.getInt("employee_ID"));
        employee.setTitle(rs.getString("title"));
        employee.setForename(rs.getString("forename"));
        employee.setSurname(rs.getString("surname"));
        employee.setDate_of_birth(rs.getString("date_of_birth"));
        employee.setAddress(rs.getString("address"));
        employee.setTown_city(rs.getString("town_city"));
        employee.setCounty(rs.getString("county"));
        employee.setPost_code(rs.getString("post_code"));
        employee.setContact_number(rs.getInt("contact_number"));
        employee.setEmail_address(rs.getString("email_address"));
        employee.setPosition(rs.getString("position"));
        employee.setStart_date(rs.getString("start_date"));

        return  employee;
    }


}


