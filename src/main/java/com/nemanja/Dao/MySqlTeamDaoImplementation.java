package com.nemanja.Dao;

import com.nemanja.Entity.Team;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysqlTeam")
public class MySqlTeamDaoImplementation implements ITeam{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class TeamRowMapper implements RowMapper<Team>{
        @Override
        public Team mapRow(ResultSet resultSet, int i) throws SQLException {
            Team team = new Team();
            team.setId(resultSet.getInt("id"));
            team.setName(resultSet.getString("name"));
            team.setConference(resultSet.getString("conference"));
            return team;
        }
    }

    @Override
    public Collection<Team> getAllTeams() {

        final String sql = "SELECT * FROM teams";
        List<Team> teams = jdbcTemplate.query(sql, new TeamRowMapper());
        return teams;
    }

    @Override
    public Team getTeamById(int id) {
        final String sql = "SELECT * FROM teams where id = ?";
        Team team = jdbcTemplate.queryForObject(sql, new TeamRowMapper(), id);
        return team;
    }

    @Override
    public void removeTeamById(int id) {
        final String sql = "DELETE FROM teams WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateTeam(Team team) {
        final String sql = "UPDATE teams SET name = ?, conference = ? WHERE id = ?";
        int id = team.getId();
        final String name = team.getName();
        final String conference = team.getConference();
        jdbcTemplate.update(sql, new Object[] { name, conference, id});
    }

    @Override
    public void insertTeamToDb(Team team) {
        final String sql = "INSERT INTO teams (name, conference) VALUES (?, ?)";
        final String name = team.getName();
        final String conference = team.getConference();
        jdbcTemplate.update(sql, new Object[] { name, conference });
    }
}
