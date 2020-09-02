package com.githab.meraving.voter.service;

import com.githab.meraving.voter.model.User;
import com.githab.meraving.voter.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.githab.meraving.voter.util.ValidationUtil.checkNotFound;
import static com.githab.meraving.voter.util.ValidationUtil.checkNotFoundWithId;


@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }

    public User get(Long id) {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user), user.id());
    }

    public void delete(Long id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User getByName(String name) {
        Assert.notNull(name, "name must not be null");
        return checkNotFound(repository.getByName(name), "name=" + name);
    }

    public List<User> getAll() {
        return repository.findAll();
    }



}
