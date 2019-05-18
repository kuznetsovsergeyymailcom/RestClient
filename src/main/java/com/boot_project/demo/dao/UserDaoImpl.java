package com.boot_project.demo.dao;

import com.boot_project.demo.model.Role;
import com.boot_project.demo.model.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {
    private final String get_all_users = "http://localhost:8081/rest/all";
    private final String get_user_by_id = "http://localhost:8081/rest/get-user-by-id/";
    private final String get_user_by_name = "http://localhost:8081/rest/get-user-by-name/";
    private final String save_user = "http://localhost:8081/rest/save-user";
    private final String update_user = "http://localhost:8081/rest/update-user";
    private final String delete_user_by_id = "http://localhost:8081/rest/delete-user/";

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<User> getAllUsers() {

        ResponseEntity<List<User>> response = restTemplate.exchange(
                get_all_users, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                });
        List<User> employees = response.getBody();

        return employees;
    }

    @Override
    public User getUserByName(String name) {
        User user = restTemplate.getForObject(get_user_by_name + "" + name, User.class);

        return user;
    }

    @Override
    public User getUserById(Long id) {
        User user = restTemplate.getForObject(get_user_by_id + "" + id, User.class);

        return user;
    }

    @Override
    public void addUser(User user) {
        restTemplate.postForObject(save_user, user, User.class);
    }

    @Override
    public void update(User user) {
        restTemplate.put(update_user, user, User.class);
    }

    @Override
    public void remove(Long id) {
        restTemplate.delete(delete_user_by_id + "" + id);
    }
}
