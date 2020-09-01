package com.githab.meraving.voter.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "meal", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "meal_unique_name_idx")})
public class Meal extends AbstractNamedEntity{
}
