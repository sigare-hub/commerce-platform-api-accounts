package com.commerceplatform.api.accounts.controllers;

import com.commerceplatform.api.accounts.services.UsersRolesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users-roles")
public class UsersRolesController {
    private final UsersRolesService usersRolesService;

    public UsersRolesController(UsersRolesService usersRolesService) {
        this.usersRolesService = usersRolesService;
    }

    @PatchMapping()
    public ResponseEntity<Void> saveRoleInUser(
            @RequestParam("user_id") String userId,
            @RequestParam("role_id") String roleId
    ) {
        usersRolesService.saveRoleInUser(userId, roleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
