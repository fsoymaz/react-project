package com.tobeto.pair8.controllers;

import com.tobeto.pair8.services.abstracts.UserService;
import com.tobeto.pair8.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair8.services.dtos.user.responses.GetListUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddUserRequest addUserRequest){
        userService.add(addUserRequest);
    }

    @GetMapping("getUsers")
    public List<GetListUserResponse> getAll()
    {
        return userService.getAll();
    }
}
