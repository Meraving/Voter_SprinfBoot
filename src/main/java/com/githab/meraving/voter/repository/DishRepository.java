package com.githab.meraving.voter.repository;

import com.githab.meraving.voter.model.Dish;
import com.githab.meraving.voter.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> getAllByMenu(Menu menu);

    List<Dish> getAllByMenu_Menudate(LocalDate date);
}
