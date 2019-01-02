package com.aibar.ecommerce.store.service.impl;

import com.aibar.ecommerce.store.domain.UserPayment;
import com.aibar.ecommerce.store.repository.UserPaymentRepository;
import com.aibar.ecommerce.store.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    private UserPaymentRepository userPaymentRepository;

    public UserPayment findById(Long id) {
        return userPaymentRepository.findOne(id);
    }

    public void removeById(Long id) {
        userPaymentRepository.delete(id);
    }

}
