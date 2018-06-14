package com.nemanja.Controller;

import com.nemanja.Entity.Player;
import com.nemanja.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
