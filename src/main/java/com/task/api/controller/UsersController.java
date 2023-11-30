package com.task.api.controller;

import com.task.api.mapper.DetailsMapper;
import com.task.api.model.UserDetailsDto;
import com.task.api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class UsersController {

    private UsersService usersService;
    private DetailsMapper mapper;

    @GetMapping(path = "/users/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsDto getUserDetails(@PathVariable String login) {
        return mapper.toDto(usersService.userDetails(login));
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setMapper(DetailsMapper mapper) {
        this.mapper = mapper;
    }
}
