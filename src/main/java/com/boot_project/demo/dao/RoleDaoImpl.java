package com.boot_project.demo.dao;

import com.boot_project.demo.model.Role;
import com.boot_project.demo.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final String get_role_by_id = "http://localhost:8081/rest/get-role-by-id/";

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Role getRoleById(Long id) {
        Role role = restTemplate.getForObject(get_role_by_id + "" + id, Role.class);
        return role;
    }
}
