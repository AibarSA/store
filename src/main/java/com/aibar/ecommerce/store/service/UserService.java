package com.aibar.ecommerce.store.service;

import com.aibar.ecommerce.store.domain.User;
import com.aibar.ecommerce.store.domain.security.UserRole;

import java.util.Set;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles);

    User findByUsername(String username);

    User findByEmail(String email);

    User save(User user);

    User findById(Long id);
}
