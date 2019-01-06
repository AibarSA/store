package com.aibar.ecommerce.store.service;

import com.aibar.ecommerce.store.domain.UserShipping;

public interface UserShippingService {

    UserShipping findById(Long id);

    void removeById(Long id);
}
