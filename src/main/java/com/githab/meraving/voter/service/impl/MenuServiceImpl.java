package com.githab.meraving.voter.service.impl;

import com.githab.meraving.voter.dto.CreateMenuDto;
import com.githab.meraving.voter.dto.MenuDto;
import com.githab.meraving.voter.dto.UpdateMenuDto;
import com.githab.meraving.voter.model.Menu;
import com.githab.meraving.voter.model.Restaurant;
import com.githab.meraving.voter.repository.MenuRepository;
import com.githab.meraving.voter.repository.RestaurantRepository;
import com.githab.meraving.voter.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.githab.meraving.voter.util.ValidationUtil.getFromOptional;

@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository repository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public MenuDto create(CreateMenuDto createMenuDto) {
        Assert.notNull(createMenuDto, "menu must be not null");
        Restaurant restaurant = getFromOptional(restaurantRepository.findById(createMenuDto.getRestaurantId()));
        Menu menu = repository.save(Menu.of(createMenuDto, restaurant));
        return MenuDto.of(repository.save(menu));
    }

    @Override
    public MenuDto get(Long id) {
        return MenuDto.of(getFromOptional(repository.findById(id)));
    }

    @Override
    public MenuDto update(Long id, UpdateMenuDto updateMenuDto) {
        Menu menu = getFromOptional(repository.findById(id));
        Restaurant restaurant = getFromOptional(restaurantRepository.findById(updateMenuDto.getRestaurantId()));
        menu.setDate(updateMenuDto.getDate());
        menu.setRestaurant(restaurant);
        return MenuDto.of(repository.save(menu));
    }

    @Override
    public void delete(Long id){repository.deleteById(id);
    }

    @Override
    public List<MenuDto> getAllByDate(LocalDate date) {

        return repository.getAllByDate(date).stream().map(MenuDto::of).collect(Collectors.toList());
    }
}
