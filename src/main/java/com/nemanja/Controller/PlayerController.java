package com.nemanja.Controller;

import com.nemanja.Entity.Player;
import com.nemanja.Service.PlayerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Player> getAllPlayers()
    {
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Player getPlayerById(@PathVariable("id") int id)
    {
        return playerService.getPlayerById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePlayerById(@PathVariable("id") int id)
    {
        playerService.removePlayerById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePlayer(@RequestBody Player player)
    {
        playerService.updatePlayer(player);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertPlayer(@RequestBody Player player)
    {
        playerService.insertPlayer(player);
    }
}
