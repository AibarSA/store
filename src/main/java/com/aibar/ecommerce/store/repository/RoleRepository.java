package com.aibar.ecommerce.store.repository;

import com.aibar.ecommerce.store.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
