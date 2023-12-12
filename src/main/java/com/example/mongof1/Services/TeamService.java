package com.example.mongof1.Services;

import com.example.mongof1.Models.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();

    Team getTeamById(String id);

    Team saveTeam(Team team);

    void deleteTeam(String id);
}