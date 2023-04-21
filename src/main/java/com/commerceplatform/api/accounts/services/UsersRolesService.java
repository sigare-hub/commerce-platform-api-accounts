package com.commerceplatform.api.accounts.services;

import com.commerceplatform.api.accounts.exceptions.NotFoundException;
import com.commerceplatform.api.accounts.models.jpa.RoleModel;
import com.commerceplatform.api.accounts.repositories.jpa.RoleRepository;
import com.commerceplatform.api.accounts.repositories.jpa.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsersRolesService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UsersRolesService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @CacheEvict(value = "user", allEntries = true)
    public void saveRoleInUser(String userId, String roleId) {
        var user = userRepository.findById(Long.valueOf(userId))
                .orElseThrow(() -> new NotFoundException("No user found with id " + userId));

        var role = roleRepository.findById(Long.valueOf(roleId))
                .orElseThrow(() -> new NotFoundException("No role found with value " + roleId));

        var updatedRoles = new ArrayList<RoleModel>();
        updatedRoles.add(role);
        user.setRoles(updatedRoles);
        userRepository.save(user);
    }
}
