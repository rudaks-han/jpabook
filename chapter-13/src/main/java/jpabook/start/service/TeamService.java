package jpabook.start.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import jpabook.start.jpo.Team;
import jpabook.start.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void register(Team team) {
        teamRepository.save(team);
    }

    public Team find(Long id) {
        return teamRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("team id not exists: " + id));
    }
}
