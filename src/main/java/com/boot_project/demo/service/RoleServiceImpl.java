package com.boot_project.demo.service;

import com.boot_project.demo.dao.RoleDao;
import com.boot_project.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

}
