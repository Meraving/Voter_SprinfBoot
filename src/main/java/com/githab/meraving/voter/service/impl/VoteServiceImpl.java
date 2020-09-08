package com.githab.meraving.voter.service.impl;

import com.githab.meraving.voter.model.Restaurant;
import com.githab.meraving.voter.model.User;
import com.githab.meraving.voter.model.Vote;
import com.githab.meraving.voter.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.githab.meraving.voter.util.ValidationUtil.checkNotFoundWithId;

@AllArgsConstructor
@Service
public class VoteServiceImpl {
/*    private final VoteRepository repository;

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
    public Vote getByDateAndUser (LocalDate date, User user){
        return getByDateAndUser(date,user);
    }
*/
}

