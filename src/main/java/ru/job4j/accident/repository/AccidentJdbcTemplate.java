package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class AccidentJdbcTemplate implements RowMapper<Accident> {
    private final JdbcTemplate jdbc;

    private final AccidentTypeJdbcTemplate type;

    public AccidentJdbcTemplate(JdbcTemplate jdbc, AccidentTypeJdbcTemplate type) {
        this.jdbc = jdbc;
        this.type = type;
    }

    public void create(Accident accident) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO accidents (name, text, address, type_id) "
                    + "VALUES (?, ?, ?, ?)", new String[]{"id"});
            ps.setString(1, accident.getName());
            ps.setString(2, accident.getText());
            ps.setString(3, accident.getAddress());
            ps.setInt(4, accident.getType().getId());
            return ps;
        }, keyHolder);
        for (Rule rule : accident.getRules()) {
            jdbc.update("insert into accidents_rules (accident_id, rule_id) values (?, ?)",
                    keyHolder.getKey(), rule.getId());
        }
    }

    public void update(Accident accident) {
        jdbc.update("UPDATE accidents SET name = ?, text = ?, address = ?, type_id = ? WHERE id = ?",
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getType().getId(),
                accident.getId());
        jdbc.update("DELETE FROM accidents_rules WHERE accident_id = ?", accident.getId());
        for (Rule rule : accident.getRules()) {
            jdbc.update("insert into accidents_rules (accident_id, rule_id) values (?, ?)",
                    accident.getId(), rule.getId());
        }
    }

    public Accident findById(int id) {
        return jdbc.queryForObject("SELECT * FROM accidents WHERE id = ?", this, id);
    }

    public List<Rule> findRulesByAccidentId(int id) {
        return jdbc.query("SELECT * FROM rules JOIN accidents_rules ON rules.id = rule_id and accident_id = ?",
                new BeanPropertyRowMapper<>(Rule.class), id);
    }

    public List<Accident> findAll() {
        return jdbc.query("SELECT * FROM accidents", this);
    }

    @Override
    public Accident mapRow(ResultSet rs, int rowNum) throws SQLException {
        Accident accident = new Accident();
        accident.setId(rs.getInt("id"));
        accident.setName(rs.getString("name"));
        accident.setText(rs.getString("text"));
        accident.setAddress(rs.getString("address"));
        accident.setType(type.findById(rs.getInt("type_id")));
        accident.setRules(Set.copyOf(findRulesByAccidentId(accident.getId())));
        return accident;
    }
}