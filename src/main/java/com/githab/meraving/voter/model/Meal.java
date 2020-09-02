package com.githab.meraving.voter.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NoArgsConstructor
@Data
@Entity
@Table(name = "meal", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "meal_unique_name_idx")})
public class Meal extends AbstractNamedEntity{
}
