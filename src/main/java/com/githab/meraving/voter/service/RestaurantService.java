package com.githab.meraving.voter.service;

import com.githab.meraving.voter.model.Restaurant;
import com.githab.meraving.voter.repository.RestaurantRepository;
import org.springframework.util.Assert;

import java.util.List;

import static com.githab.meraving.voter.util.ValidationUtil.checkNotFoundWithId;

public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService (RestaurantRepository repository){this.repository = repository;}


    public Restaurant create (Restaurant restaurant){
        Assert.notNull(restaurant, "restaurant must be not null");
        return repository.save(restaurant);
    }

    public Restaurant get(Long id) {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        checkNotFoundWithId(repository.save(restaurant), restaurant.id());
    }

    public void delete(Long id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }
}
