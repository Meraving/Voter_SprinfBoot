package com.githab.meraving.voter.model;

import com.githab.meraving.voter.dto.CreateMenuDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "menudate"}, name = "menu_restaurant_menudate_idx")})
public class Menu extends AbstractBaseEntity{

    @Column(name = "menudate", nullable = false)
    @NotNull
    private LocalDate menudate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Restaurant restaurant;

    public static Menu of (CreateMenuDto createMenuDto, Restaurant restaurant){
        Menu menu = new Menu();
        menu.setMenudate(createMenuDto.getDate());
        menu.setRestaurant(restaurant);
        return menu;
    }

}
