package com.githab.meraving.voter.repository;

import com.githab.meraving.voter.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Menu m WHERE m.id=:id")
    Long delete(@Param("id") Long id);

    List<Menu> getAllByDate (LocalDate date);
}
