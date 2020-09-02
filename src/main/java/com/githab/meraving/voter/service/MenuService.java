package com.githab.meraving.voter.service;

import com.githab.meraving.voter.model.Menu;
import com.githab.meraving.voter.repository.MenuRepository;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.githab.meraving.voter.util.ValidationUtil.checkNotFoundWithId;

public class MenuService {
    private final MenuRepository repository;

    public MenuService (MenuRepository repository){this.repository = repository;}

    public Menu create (Menu menu){
        Assert.notNull(menu, "menu must be not null");
        return repository.save(menu);
    }

    public Menu get(Long id) {
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public void update(Menu menu) {
        Assert.notNull(menu, "menu must not be null");
        checkNotFoundWithId(repository.save(menu), menu.id());
    }

    public void delete(Long id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public List<Menu> getAllByDate(LocalDate date) {
        return repository.getAllByDate(date);
    }
}
