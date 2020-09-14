package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.CreateVoteDto;
import com.githab.meraving.voter.dto.UpdateVoteDto;
import com.githab.meraving.voter.dto.VoteDto;
import com.githab.meraving.voter.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/vote")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public VoteDto createVote(@RequestBody @Valid CreateVoteDto createVoteDto) {
        return voteService.create(createVoteDto);
    }

    @GetMapping("/vote/{id}")
    @PreAuthorize("hasAnyAuthority('VOTE:READ')")
    public VoteDto get(@PathVariable("id") Long id) {
        return voteService.get(id);
    }

    @PutMapping("/vote/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public VoteDto updateVote(@PathVariable("id") Long id, @RequestBody @Valid UpdateVoteDto updateVoteDto) {
        return voteService.update(id, updateVoteDto);
    }

    @DeleteMapping("/vote/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void deleteVote(@PathVariable("id") Long id) {
        voteService.delete(id);
    }

    @GetMapping("/votes/{menuId}")
    @PreAuthorize("hasAnyAuthority('VOTE:READ')")
    public List<VoteDto> getAllByMenu(@PathVariable("menuId") Long id) {
        return voteService.getAllByMenu(id);
    }

    @GetMapping("/votes/menu_date/{date}/user_id/{userId}")
    @PreAuthorize("hasAnyAuthority('VOTE:READ')")
    public VoteDto getByUserAndMenu_Date(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                         @PathVariable("userId") Long id) {
        return voteService.getByUserAndMenu_Date(id, date);
    }

    @PostMapping("/castvote/{menuId}")
    @PreAuthorize("hasAnyAuthority('VOTE:WRITE')")
    public VoteDto castVote(@PathVariable("menuId") Long menuId, Principal principal) {
        return voteService.castVote(menuId, principal);
    }

}
