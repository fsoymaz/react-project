package com.tobeto.pair8.services.abstracts;

import com.tobeto.pair8.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair8.services.dtos.user.responses.GetListUserResponse;

import java.util.List;

public interface UserService {
    void add(AddUserRequest addUserRequest);
    List<GetListUserResponse> getAll();
}
