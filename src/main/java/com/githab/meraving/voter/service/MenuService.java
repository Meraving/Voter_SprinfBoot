package com.githab.meraving.voter.service;

import com.githab.meraving.voter.dto.CreateMenuDto;
import com.githab.meraving.voter.dto.MenuDto;
import com.githab.meraving.voter.dto.UpdateMenuDto;

import java.time.LocalDate;
import java.util.List;

public interface MenuService {
    MenuDto create(CreateMenuDto createMenuDto);

    MenuDto get(Long id);

    MenuDto update(Long id, UpdateMenuDto updateMenuDto);

    void delete(Long id);

    List<MenuDto> getAllByDate(LocalDate date);
}
