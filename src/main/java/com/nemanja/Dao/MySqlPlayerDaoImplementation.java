package com.nemanja.Dao;

import com.nemanja.Entity.Player;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class MySqlPlayerDaoImplementation implements IPlayer{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class PlayerRowMapper implements RowMapper<Player>{
        @Override
        public Player mapRow(ResultSet resultSet, int i) throws SQLException {
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("name"));
            player.setTeam(resultSet.getString("team"));
            return player;
        }
    }

    @Override
    public Collection<Player> getAllPlayers() {

        final String sql = "SELECT * FROM players";
        List<Player> players = jdbcTemplate.query(sql, new PlayerRowMapper());
        return players;
    }

    @Override
    public Player getPlayerById(int id) {
        final String sql = "SELECT * FROM players where id = ?";
        Player player = jdbcTemplate.queryForObject(sql, new PlayerRowMapper(), id);
        return player;
    }

    @Override
    public void removePlayerById(int id) {
        final String sql = "DELETE FROM players WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updatePlayer(Player player) {
        final String sql = "UPDATE players SET name = ?, team = ? WHERE id = ?";
        int id = player.getId();
        final String name = player.getName();
        final String team = player.getTeam();
        jdbcTemplate.update(sql, new Object[] { name, team, id});
    }

    @Override
    public void insertPlayerToDb(Player player) {
        final String sql = "INSERT INTO players (name, team) VALUES (?, ?)";
        final String name = player.getName();
        final String team = player.getTeam();
        jdbcTemplate.update(sql, new Object[] { name, team });
    }
}
