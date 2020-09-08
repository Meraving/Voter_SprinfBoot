package com.githab.meraving.voter.service.impl;

import com.githab.meraving.voter.dto.CreateRestaurantDto;
import com.githab.meraving.voter.dto.RestaurantDto;
import com.githab.meraving.voter.dto.UpdateRestaurantDto;
import com.githab.meraving.voter.model.Restaurant;
import com.githab.meraving.voter.repository.RestaurantRepository;
import com.githab.meraving.voter.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static com.githab.meraving.voter.util.ValidationUtil.getFromOptional;

@AllArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Override
    public RestaurantDto create(CreateRestaurantDto createRestaurantDto) {
        Assert.notNull(createRestaurantDto, "restaurant must be not null");
        Restaurant restaurant = repository.save(Restaurant.of(createRestaurantDto));
        return RestaurantDto.of(restaurant);
    }

    @Override
    public RestaurantDto get(Long id) {
        return RestaurantDto.of(getFromOptional(repository.findById(id)));
    }

    @Override
    public RestaurantDto update(Long id, UpdateRestaurantDto updateRestaurantDto) {
        Restaurant restaurant = getFromOptional(repository.findById(id));
        restaurant.setName(updateRestaurantDto.getName());
        return RestaurantDto.of(repository.save(restaurant));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<RestaurantDto> getAll() {
        return repository.findAll().stream().map(RestaurantDto::of).collect(Collectors.toList());
    }
}
