package ru.sibadi.demowebapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.sibadi.demowebapp.domain.Payment;
import ru.sibadi.demowebapp.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PaymentRepository {
    private final JdbcTemplate jdbcTemplate;

    public PaymentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Payment> getPaymentsByPersonId (int personId) {
        return jdbcTemplate.query("SELECT * FROM PAYMENTS WHERE person_id="+personId, new PaymentMapper());

    }

    public Payment getPaymentById(int paymentId){
        return jdbcTemplate.queryForObject("SELECT * FROM PAYMENTS WHERE id="+paymentId, new PaymentMapper());
    }

    public static class PaymentMapper implements RowMapper<Payment>
    {
        @Override
        public Payment mapRow(ResultSet resultSet, int i) throws SQLException {
            Payment p = new Payment(resultSet.getInt("id"),
                    resultSet.getInt("person_id"),
                    resultSet.getInt("salary"),
                    resultSet.getInt("prize"),
                    resultSet.getString("date"));
            return p;
        }
    }
}
