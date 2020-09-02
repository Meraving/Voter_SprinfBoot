package com.githab.meraving.voter.service;

import com.githab.meraving.voter.model.Meal;
import com.githab.meraving.voter.repository.MealRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.githab.meraving.voter.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService (MealRepository repository){this.repository = repository;}

    public Meal create (Meal meal){
        Assert.notNull(meal, "meal must be not null");
        return repository.save(meal);
    }

    public Meal get(Long id) {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public void update(Meal meal) {
        Assert.notNull(meal, "meal must not be null");
        checkNotFoundWithId(repository.save(meal), meal.id());
    }

    public void delete(Long id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Meal> getAll() {
        return repository.findAll();
    }
}
