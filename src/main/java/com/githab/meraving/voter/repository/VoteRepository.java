package com.githab.meraving.voter.repository;

import com.githab.meraving.voter.model.Menu;
import com.githab.meraving.voter.model.User;
import com.githab.meraving.voter.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote,Long> {

    List<Vote> getAllByMenu (Menu menu);

    Optional<Vote> getByMenu_DateAndUser (LocalDate date, User user);
}
