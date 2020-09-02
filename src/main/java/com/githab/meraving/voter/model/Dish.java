package com.githab.meraving.voter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "dish", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "meal_id"}, name = "dish_unique_menu_meal_idx")})
public class Dish extends AbstractNamedEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Meal meal;


    @Column(name = "price", nullable = false)
    @Range(min = 0)
    private BigDecimal price;
}
