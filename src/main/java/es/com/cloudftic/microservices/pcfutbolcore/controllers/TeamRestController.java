package es.com.cloudftic.microservices.pcfutbolcore.controllers;

import es.com.cloudftic.microservices.pcfutbolcore.domain.TeamDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamRestController {

    @GetMapping("/teams/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Integer id) {
        TeamDTO team = new TeamDTO();
        team.setId(id);
        team.setName("FC Barcelona");
        team.setFoundationDate(LocalDate.of(1899, 11, 29));
        team.setCapital(new BigDecimal(10000000.342));

        return ResponseEntity.ok(team);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> getAllTeams(@RequestParam String name) {
        List<TeamDTO> teamsDTO = new ArrayList<>();

        TeamDTO team = new TeamDTO();
        team.setId(1);
        team.setName("FC Barcelona");
        team.setFoundationDate(LocalDate.of(1899, 11, 29));
        team.setCapital(new BigDecimal(10000000.342));

        teamsDTO.add(team);

        TeamDTO team2 = new TeamDTO();
        team2.setId(2);
        team2.setName("Real Madrid CF");
        team2.setFoundationDate(LocalDate.of(1902, 11, 15));
        team2.setCapital(new BigDecimal(10000554.342));

        teamsDTO.add(team2);

        TeamDTO team3 = new TeamDTO();
        team3.setId(3);
        team3.setName("Sevilla FC");
        team3.setFoundationDate(LocalDate.of(1874, 5, 2));
        team3.setCapital(new BigDecimal(10000984.342));

        teamsDTO.add(team3);

        return ResponseEntity.ok(teamsDTO);
    }

    @PostMapping("/teams")
    public ResponseEntity<?> createTeam(@RequestBody TeamDTO teamDTO) {
        System.out.println("Creando equipo: \n" + teamDTO);
        return ResponseEntity.created(createURI(teamDTO)).build();
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Integer id, @RequestBody TeamDTO teamDTO) {
        System.out.println("Actualizando equipo: \n" + teamDTO);

        return ResponseEntity.ok(teamDTO);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Integer id) {
        System.out.println("Borrando equipo con ID: " + id);

        return ResponseEntity.noContent().build();
    }

    private URI createURI(TeamDTO teamDTO) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(teamDTO.getId()).toUri();
    }
}
