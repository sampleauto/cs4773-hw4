package com.cs4773.Model;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private final List<Team> teams = new ArrayList<>();
    public Scoreboard() {
        for(int i = 0;i < 5;i++) {
            Team temp = new Team();
            teams.add(temp);
        }
    }
    public Team getTeam(int i) {
        return teams.get(i);
    }
    public String[] getTeams() {
        String[] teams = new String[this.teams.size()];
        for(int i = 0; i < this.teams.size(); i++) {
            teams[i] = this.teams.get(i).toString();
        }
        return teams;
    }
}
