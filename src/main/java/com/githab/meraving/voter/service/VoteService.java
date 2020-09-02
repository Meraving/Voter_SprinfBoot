package com.githab.meraving.voter.service;

import com.githab.meraving.voter.model.Restaurant;
import com.githab.meraving.voter.model.Vote;
import com.githab.meraving.voter.repository.VoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.githab.meraving.voter.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteService {
    private final VoteRepository repository;

    public VoteService (VoteRepository repository){this.repository = repository;}

    public Vote create (Vote vote){
        Assert.notNull(vote, "vote must be not null");
        return repository.save(vote);
    }

    public Vote get(Long id) {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public void update(Vote vote) {
        Assert.notNull(vote, "vote must not be null");
        checkNotFoundWithId(repository.save(vote), vote.id());
    }

    public void delete(Long id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Vote> getAllByDate(LocalDate date) {
        return repository.getAllByDate(date);
    }
    public List<Vote> getAllByDateAndRestaurant(LocalDate date, Restaurant restaurant) {
        return repository.getAllByDateAndRestaurant(date, restaurant);
    }


}

