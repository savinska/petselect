package com.softuni.petselect.web;

import com.softuni.petselect.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/admin")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/admin")
//    public ResponseEntity<UserDto> getUser() {
//        return  new ResponseEntity<>(userService.getCurrentUserAsDto(), HttpStatus.OK);
//    }
//
//    @PostMapping(path = "/edit-roles")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
//    public ResponseEntity<String> editRoles(@RequestBody UpdateAuthorityDto dto)  {
//        userService.updateAuthorities(dto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}

