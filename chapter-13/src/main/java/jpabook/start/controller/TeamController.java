package jpabook.start.controller;

import jpabook.start.jpo.Team;
import jpabook.start.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    public void register(Team team) {
        teamService.register(team);
    }

    public Team find(Long id) {
        Team team = teamService.find(id);

        System.out.println("--- find Team ---");
        System.out.println("team : " + team.getName());
        //System.out.println("team member: " + team.getMembers().size());

        return team;
    }
}
