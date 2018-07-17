package com.nemanja.Controller;

import com.nemanja.Entity.Team;
import com.nemanja.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Team> getAllTeams()
    {
        return teamService.getAllTeams();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Team getTeamById(@PathVariable("id") int id)
    {
        return teamService.getTeamById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeamById(@PathVariable("id") int id) { teamService.removeTeamById(id); }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTeam(@RequestBody Team team)
    {
        teamService.updateTeam(team);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTeam(@RequestBody Team team)
    {
        teamService.insertTeam(team);
    }
}
