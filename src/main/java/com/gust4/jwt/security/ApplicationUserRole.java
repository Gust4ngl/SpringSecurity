package com.gust4.jwt.security;

import org.assertj.core.util.*;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.*;

import java.util.*;
import java.util.stream.*;

import static com.gust4.jwt.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Set.of()),
    ADMIN(Set.of(PERSON_READ, PERSON_WRITE)),
    ADMINTRAINEE(Set.of(PERSON_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {this.permissions = permissions;}

    public Set<ApplicationUserPermission> getPermissions() {return permissions;}

    public Set<SimpleGrantedAuthority> getGrandGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
