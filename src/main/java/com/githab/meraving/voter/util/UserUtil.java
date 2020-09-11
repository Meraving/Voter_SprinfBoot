package com.githab.meraving.voter.util;

import com.githab.meraving.voter.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserUtil {
    public static Collection<? extends GrantedAuthority> convertRolesToAuthorities(Collection<Role> roles) {

        Set<GrantedAuthority> result = new HashSet<>();

        if (!CollectionUtils.isEmpty(roles)) {
            roles.forEach(role -> {
                if (role != null) {
                    result.add(new SimpleGrantedAuthority("ROLE_" + role.toString().toUpperCase()));
                }
            });
        }

        return result;
    }
}
