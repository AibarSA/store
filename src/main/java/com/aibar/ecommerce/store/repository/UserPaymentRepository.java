package com.aibar.ecommerce.store.repository;

import com.aibar.ecommerce.store.domain.UserPayment;
import org.springframework.data.repository.CrudRepository;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {
}
