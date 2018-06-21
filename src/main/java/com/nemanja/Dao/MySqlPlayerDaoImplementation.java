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

    @Override
    public Collection<Player> getAllPlayers() {

        final String sql = "SELECT * FROM players";
        List<Player> players = jdbcTemplate.query(sql, new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                Player player = new Player();
                player.setId(resultSet.getInt("id"));
                player.setName(resultSet.getString("name"));
                player.setTeam(resultSet.getString("team"));
                return player;
            }
        });
        return players;
    }

    @Override
    public Player getPlayerById(int id) {
        return null;
    }

    @Override
    public void removePlayerById(int id) {

    }

    @Override
    public void updatePlayer(Player player) {

    }

    @Override
    public void insertPlayerToDb(Player player) {

    }
}
