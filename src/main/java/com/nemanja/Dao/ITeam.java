package com.nemanja.Dao;

import com.nemanja.Entity.Team;

import java.util.Collection;

public interface ITeam {
    Collection<Team> getAllTeams();

    Team getTeamById(int id);

    void removeTeamById(int id);

    void updateTeam(Team team);

    void insertTeamToDb(Team team);
}
