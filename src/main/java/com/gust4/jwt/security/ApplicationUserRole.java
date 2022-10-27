package com.gust4.jwt.security;

import org.assertj.core.util.*;

import java.util.*;

import static com.gust4.jwt.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Set.of()),
    ADMIN(Set.of(COURSE_WRITE, COURSE_READ, STUDENT_WRITE, STUDENT_READ)),
    ADMINTRAINEE(Set.of(COURSE_READ, STUDENT_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {this.permissions = permissions;}

}
