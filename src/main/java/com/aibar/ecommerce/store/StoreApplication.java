package com.aibar.ecommerce.store;

import com.aibar.ecommerce.store.config.SecurityUtility;
import com.aibar.ecommerce.store.domain.User;
import com.aibar.ecommerce.store.domain.security.Role;
import com.aibar.ecommerce.store.domain.security.UserRole;
import com.aibar.ecommerce.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class StoreApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        User user3 = new User();
        user3.setFirstName("Chris");
        user3.setLastName("Brown");
        user3.setUsername("Breeze");
        user3.setPassword(SecurityUtility.passwordEncoder().encode("p"));
        user3.setEmail("CBrown@gmail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role3 = new Role();
        role3.setRoleId(1);
        role3.setName("ROLE_USER");
        userRoles.add(new UserRole(user3,role3));

        userService.createUser(user3, userRoles);

        userRoles.clear();


//        User user2 = new User();
//        user2.setFirstName("Admin");
//        user2.setLastName("Admin");
//        user2.setUsername("admin");
//        user2.setPassword(SecurityUtility.passwordEncoder().encode("password"));
//        user2.setEmail("Admin@gmail.com");
//        Role role2 = new Role();
//        role2.setRoleId(0);
//        role2.setName("ROLE_ADMIN");
//        userRoles.add(new UserRole(user2,role2));
//
//        userService.createUser(user2, userRoles);

    }
}


