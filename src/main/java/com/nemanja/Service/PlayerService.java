package com.nemanja.Service;

import com.nemanja.Dao.PlayerDao;
import com.nemanja.Entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;

    public Collection<Player> getAllPlayers()
    {
        return playerDao.getAllPlayers();
    }

    public  Player getPlayerById(int id)
    {
        return this.playerDao.getPlayerById(id);
    }

    public void removePlayerById(int id) {
        this.playerDao.removePlayerById(id);
    }
}
