package com.boot_project.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

public class Role implements GrantedAuthority {
    private Long id;

    private String name;

    @JsonIgnore
    private Set<User> users;

    public Role() {
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (name.contains("ADMIN") && name.contains("USER")) {
            return "ADMIN,USER";
        } else if (name.contains("ADMIN")) {
            return "ADMIN";
        }
        return "USER";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name.equals(role.name);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
