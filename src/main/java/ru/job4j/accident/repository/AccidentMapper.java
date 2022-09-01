package ru.job4j.accident.repository;

import org.springframework.jdbc.core.RowMapper;
import ru.job4j.accident.model.Accident;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class AccidentMapper implements RowMapper<Accident> {
    @Override
    public Accident mapRow(ResultSet rs, int rowNum) throws SQLException {
        Accident accident = new Accident();
        accident.setId(rs.getInt("id"));
        accident.setName(rs.getString("name"));
        accident.setText(rs.getString("text"));
        accident.setAddress(rs.getString("address"));
        accident.setType(AccidentTypeJdbcTemplate.findById(rs.getInt("type_id")));
        accident.setRules(Set.copyOf(AccidentJdbcTemplate.findRulesByAccidentId(accident.getId())));
        return accident;
    }
}