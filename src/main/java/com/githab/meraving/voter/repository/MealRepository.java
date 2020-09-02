package com.githab.meraving.voter.repository;


import com.githab.meraving.voter.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MealRepository extends JpaRepository <Meal,Long>{

    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id")
    Long delete(@Param("id") Long id);
}
