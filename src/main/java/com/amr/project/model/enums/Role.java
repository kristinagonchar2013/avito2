package com.amr.project.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ANONYMOUS,
    USER,
    ADMINISTRATOR,
    MODERATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
