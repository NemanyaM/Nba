package com.nemanja.Dao;

import com.nemanja.Entity.Player;

import java.util.Collection;

public interface IPlayer {
    Collection<Player> getAllPlayers();

    Player getPlayerById(int id);

    void removePlayerById(int id);

    void updatePlayer(Player player);

    void insertPlayerToDb(Player player);
}
