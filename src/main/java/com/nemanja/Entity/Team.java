package com.nemanja.Entity;

public class Team {
    private int id;
    private String name;
    private String conference;

    public Team(int id, String name, String conference) {
        this.id = id;
        this.name = name;
        this.conference = conference;
    }

    public Team(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }
}
