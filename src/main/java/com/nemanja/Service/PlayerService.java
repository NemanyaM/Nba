package com.nemanja.Service;

import com.nemanja.Dao.IPlayer;
import com.nemanja.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlayerService {

    @Autowired
    @Qualifier("fakeData")
    private IPlayer IPlayer;

    public Collection<Player> getAllPlayers()
    {
        return IPlayer.getAllPlayers();
    }

    public  Player getPlayerById(int id)
    {
        return this.IPlayer.getPlayerById(id);
    }

    public void removePlayerById(int id)
    {
        this.IPlayer.removePlayerById(id);
    }

    public void updatePlayer(Player player)
    {
        this.IPlayer.updatePlayer(player);
    }

    public void insertPlayer(Player player)
    {
        this.IPlayer.insertPlayerToDb(player);
    }
}
