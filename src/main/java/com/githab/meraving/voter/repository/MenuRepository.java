package com.githab.meraving.voter.repository;

import com.githab.meraving.voter.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {

    List<Menu> getAllByMenudate(LocalDate date);
}
