package com.githab.meraving.voter.repository;

import com.githab.meraving.voter.model.Restaurant;
import com.githab.meraving.voter.model.User;
import com.githab.meraving.voter.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface VoteRepository extends JpaRepository<Vote,Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    Long delete(@Param("id") Long id);

    List<Vote> getAllByDate (LocalDate date);
    List<Vote> getAllByDateAndRestaurant (LocalDate date, Restaurant restaurant);
    Vote getByDateAndUser (LocalDate date, User user);
}
