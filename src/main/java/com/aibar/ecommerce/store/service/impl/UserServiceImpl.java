package com.aibar.ecommerce.store.service.impl;

import com.aibar.ecommerce.store.domain.User;
import com.aibar.ecommerce.store.domain.UserBilling;
import com.aibar.ecommerce.store.domain.UserPayment;
import com.aibar.ecommerce.store.domain.security.UserRole;
import com.aibar.ecommerce.store.repository.RoleRepository;
import com.aibar.ecommerce.store.repository.UserBillingRepository;
import com.aibar.ecommerce.store.repository.UserPaymentRepository;
import com.aibar.ecommerce.store.repository.UserRepository;
import com.aibar.ecommerce.store.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserBillingRepository userBillingRepository;

    @Autowired
    private UserPaymentRepository userPaymentRepository;

    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {

        User localUser = userRepository.findByUsername(user.getUsername());

        if (localUser !=null){
            LOG.info("User with {} username already exists. Nothing will be done " , user.getUsername());
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);

            user.setUserPaymentList(new ArrayList<UserPayment>());

            localUser = userRepository.save(user);
        }

        return localUser;
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id){
        return userRepository.findOne(id);
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user) {
        save(user);
        userBillingRepository.save(userBilling);
        userPaymentRepository.save(userPayment);
    }

    @Override
    public void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user) {
        userPayment.setUser(user);
        userPayment.setUserBilling(userBilling);
        userPayment.setDefaultPayment(true);
        userBilling.setUserPayment(userPayment);
        user.getUserPaymentList().add(userPayment);
        save(user);
    }

    @Override
    public void setUserDefaultPayment(Long userPaymentId, User user) {
        List<UserPayment> userPaymentList = (List<UserPayment>) userPaymentRepository.findAll();

        for (UserPayment userPayment : userPaymentList) {
            if(userPayment.getId() == userPaymentId) {
                userPayment.setDefaultPayment(true);
                userPaymentRepository.save(userPayment);
            } else {
                userPayment.setDefaultPayment(false);
                userPaymentRepository.save(userPayment);
            }
        }
    }
}
