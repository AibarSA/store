package com.aibar.ecommerce.store.service;

import com.aibar.ecommerce.store.domain.UserPayment;

public interface UserPaymentService {
    UserPayment findById(Long id);

    void removeById(Long id);
}
