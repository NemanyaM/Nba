package com.nemanja.Service;

import com.nemanja.Dao.ITeam;
import com.nemanja.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeamService {

    @Autowired
    @Qualifier("mysqlTeam")
    private ITeam ITeam;

    public Collection<Team> getAllTeams() {
        return ITeam.getAllTeams();
    }

    public Team getTeamById(int id) {
        return this.ITeam.getTeamById(id);
    }

    public void removeTeamById(int id) {
        this.ITeam.removeTeamById(id);
    }

    public void updateTeam(Team team) {
        this.ITeam.updateTeam(team);
    }

    public void insertTeam(Team team) {
        this.ITeam.insertTeamToDb(team);
    }
}
