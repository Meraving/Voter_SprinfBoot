package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.CreateVoteDto;
import com.githab.meraving.voter.dto.UpdateVoteDto;
import com.githab.meraving.voter.dto.VoteDto;
import com.githab.meraving.voter.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public VoteDto createVote(@RequestBody @Valid CreateVoteDto createVoteDto) {
        return voteService.create(createVoteDto);
    }

    @GetMapping("/vote/{id}")
    public VoteDto get(@PathVariable("id") Long id) {
        return voteService.get(id);
    }

    @PutMapping("/vote/{id}")
    public VoteDto updateVote(@PathVariable("id") Long id, @RequestBody @Valid UpdateVoteDto updateVoteDto) {
        return voteService.update(id, updateVoteDto);
    }

    @DeleteMapping("/vote/{id}")
    public void deleteVote(@PathVariable("id") Long id) {
        voteService.delete(id);
    }

    @GetMapping("/votes/{menuId}")
    public List<VoteDto> getAllByMenu(@PathVariable("menuId") Long id) {
        return voteService.getAllByMenu(id);
    }

    @GetMapping("/votes/{date}/{userId}")
    public VoteDto getAllByMenu(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                @PathVariable("userId") Long id) {
        return voteService.getByUserAndMenu_Date(id, date);
    }

    @PostMapping("/castvote/{menuId}:{userId}")
    public VoteDto castVote(@PathVariable("menuId") Long menuId, @PathVariable("userId") Long userId) {
        return voteService.castVote(menuId, userId);
    }

}
