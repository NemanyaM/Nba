package com.nemanja.Dao;

import com.nemanja.Entity.Player;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("sqlData")
public class PlayerDBConnection implements IPlayer {

    //Connection;

    @Override
    public Collection<Player> getAllPlayers() {
        return null;
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
