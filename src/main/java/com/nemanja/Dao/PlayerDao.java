package com.nemanja.Dao;

import com.nemanja.Entity.Player;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PlayerDao {

    private static Map<Integer, Player> players;

    static {
        players = new HashMap<Integer, Player>() {
            {
                put(1, new Player(1,"Lebron James", "Clivlend Cavaliers"));
                put(2, new Player(2, "Kyrie Irving", "Boston Celtics"));
                put(3, new Player(3,"Nikola Jokic", "Denver Nuggets"));
            }
        };
    }

    public Collection<Player> getAllPlayers()
    {
        return this.players.values();
    }

    public  Player getPlayerById(int id)
    {
        return this.players.get(id);
    }

    public void removePlayerById(int id)
    {
        this.players.remove(id);
    }

    public void updatePlayer(Player player)
    {
        Player pl = players.get(player.getId());
        pl.setTeam(player.getTeam());
        pl.setName(player.getName());
        players.put(player.getId(), player);
    }

    public void insertPlayerToDb(Player player)
    {
        this.players.put(player.getId(), player);
    }
}
