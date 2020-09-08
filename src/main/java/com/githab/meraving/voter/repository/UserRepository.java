package com.githab.meraving.voter.repository;

import com.githab.meraving.voter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByName(String name);
}


