package com.gust4.jwt.security;

import org.assertj.core.util.*;

import java.util.*;

import static com.gust4.jwt.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Set.of()),
    ADMIN(Set.of(PERSON_READ, PERSON_WRITE)),
    ADMINTRAINEE(Set.of(PERSON_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {this.permissions = permissions;}

}
