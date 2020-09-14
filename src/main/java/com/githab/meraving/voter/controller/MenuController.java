package com.githab.meraving.voter.controller;

import com.githab.meraving.voter.dto.CreateMenuDto;
import com.githab.meraving.voter.dto.MenuDto;
import com.githab.meraving.voter.dto.UpdateMenuDto;
import com.githab.meraving.voter.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){this.menuService = menuService;}

    @PostMapping("/menu")
    @PreAuthorize("hasAnyAuthority('MENU:WRITE')")
    public MenuDto createMenu(@RequestBody @Valid CreateMenuDto createMenuDto) {
        return menuService.create(createMenuDto);
    }

    @GetMapping("/menu/{id}")
    @PreAuthorize("hasAnyAuthority('MENU:READ')")
    public MenuDto getMenu(@PathVariable("id") Long id) {
        return menuService.get(id);
    }

    @PutMapping("/menu/{id}")
    @PreAuthorize("hasAnyAuthority('MENU:WRITE')")
    public MenuDto updateMenu(@PathVariable("id") Long id, @RequestBody @Valid UpdateMenuDto updateMenuDto) {
        return menuService.update(id, updateMenuDto);
    }

    @DeleteMapping("/menu/{id}")
    @PreAuthorize("hasAnyAuthority('MENU:WRITE')")
    public void deleteMenu(@PathVariable("id") Long id) {
        menuService.delete(id);
    }

    @GetMapping("/menus/{date}")
    @PreAuthorize("hasAnyAuthority('MENU:READ')")
    public List<MenuDto> getAllByDate(@PathVariable("date")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date ) {
        return menuService.getAllByMenudate(date);
    }
}
