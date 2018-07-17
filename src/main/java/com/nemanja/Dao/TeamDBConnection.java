package com.nemanja.Dao;

import com.nemanja.Entity.Team;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("sqlData")
public class TeamDBConnection implements ITeam {

    //Connection;

    @Override
    public Collection<Team> getAllTeams() {
        return null;
    }

    @Override
    public Team getTeamById(int id) {
        return null;
    }

    @Override
    public void removeTeamById(int id) {

    }

    @Override
    public void updateTeam(Team team) {

    }

    @Override
    public void insertTeamToDb(Team team) {

    }
}
