package com.githab.meraving.voter.repository;

import com.githab.meraving.voter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    Long delete(@Param("id") Long id);

    User getByName(String name);
}


