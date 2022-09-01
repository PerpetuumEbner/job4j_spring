package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private static JdbcTemplate jdbc;

    private static final String INSERT_INTO_ACCIDENTS = "INSERT INTO accidents (name, text, address, type_id)"
            + " VALUES (?, ?, ?, ?)";

    private final String INSERT_INTO_ACCIDENTS_RULES = "INSERT INTO accidents_rules (accident_id, rule_id)"
            + " VALUES (?, ?)";

    private static final String UPDATE_ACCIDENTS = "UPDATE accidents SET name = ?, text = ?, address = ?, type_id = ?"
            + " WHERE id = ?";

    private static final String DELETE_ACCIDENTS_RULES = "DELETE FROM accidents_rules WHERE accident_id = ?";

    private static final String SELECT_ACCIDENTS_ID = "SELECT * FROM accidents WHERE id = ?";

    private static final String SELECT_RULES_JOIN_ACCIDENTS_RULES = "SELECT * FROM rules JOIN accidents_rules ON"
            + " rules.id = rule_id and accident_id = ?";

    private static final String SELECT_ACCIDENTS_ALL =
            "SELECT a.id as id, a.name as name, a.text as text, a.address as address, t.id as type_id"
                    + " from accidents a INNER JOIN types t on a.type_id = t.id;";

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        AccidentJdbcTemplate.jdbc = jdbc;
    }

    public void create(Accident accident) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(con -> {
            PreparedStatement ps = con.prepareStatement(INSERT_INTO_ACCIDENTS, new String[]{"id"});
            ps.setString(1, accident.getName());
            ps.setString(2, accident.getText());
            ps.setString(3, accident.getAddress());
            ps.setInt(4, accident.getType().getId());
            return ps;
        }, keyHolder);
        for (Rule rule : accident.getRules()) {
            jdbc.update(INSERT_INTO_ACCIDENTS_RULES, keyHolder.getKey(), rule.getId());
        }
    }

    public void update(Accident accident) {
        jdbc.update(UPDATE_ACCIDENTS,
                accident.getName(),
                accident.getText(),
                accident.getAddress(),
                accident.getType().getId(),
                accident.getId());
        jdbc.update(DELETE_ACCIDENTS_RULES, accident.getId());
        for (Rule rule : accident.getRules()) {
            jdbc.update(INSERT_INTO_ACCIDENTS_RULES, accident.getId(), rule.getId());
        }
    }

    public Accident findById(int id) {
        return jdbc.queryForObject(SELECT_ACCIDENTS_ID, new AccidentMapper(), id);
    }

    public static List<Rule> findRulesByAccidentId(int id) {
        return jdbc.query(SELECT_RULES_JOIN_ACCIDENTS_RULES, new BeanPropertyRowMapper<>(Rule.class), id);
    }

    public List<Accident> findAll() {
        return jdbc.query(SELECT_ACCIDENTS_ALL, new AccidentMapper());
    }
}