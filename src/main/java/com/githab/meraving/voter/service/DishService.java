package com.githab.meraving.voter.service;

import com.githab.meraving.voter.model.Dish;
import com.githab.meraving.voter.model.Menu;
import com.githab.meraving.voter.repository.DishRepository;
import org.springframework.util.Assert;

import java.util.List;

import static com.githab.meraving.voter.util.ValidationUtil.checkNotFoundWithId;

public class DishService {

    private final DishRepository repository;

    public DishService (DishRepository repository){this.repository = repository;}

    public Dish create (Dish dish){
        Assert.notNull(dish, "dish must be not null");
        return repository.save(dish);
    }

    public Dish get(Long id) {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public void update(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(repository.save(dish), dish.id());
    }

    public void delete(Long id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    List<Dish> getAllByMenu (Menu menu){
        return repository.getAllByMenu(menu);
    }
}
