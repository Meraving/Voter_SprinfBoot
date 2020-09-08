package com.githab.meraving.voter.model;

import com.githab.meraving.voter.dto.CreateVoteDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "vote", uniqueConstraints = {@UniqueConstraint(columnNames = { "user_id", "menu_id"}, name = "vote_unique_user_menu_idx")})
public class Vote extends AbstractBaseEntity{


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Menu menu;

    public static Vote of (User user, Menu menu){
        Vote vote = new Vote();
        vote.setUser(user);
        vote.setMenu(menu);
        return vote;
    }
}
