package com.tobeto.pair8.services.concretes;

import com.tobeto.pair8.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair8.entities.Car;
import com.tobeto.pair8.entities.User;
import com.tobeto.pair8.repositories.UserRepository;
import com.tobeto.pair8.services.abstracts.UserService;
import com.tobeto.pair8.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair8.services.dtos.user.responses.GetListUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;
    @Override
    public void add(AddUserRequest addUserRequest) {
        LocalDate now = LocalDate.now();
        LocalDate eighteenYearsAgo = now.minusYears(18);

        if (addUserRequest.getBirthDate().isAfter(eighteenYearsAgo)) {
            throw new RuntimeException("18 yaşından küçük kullanıcı eklenemez.");
        }
        if (userRepository.existsByNameAndSurName(addUserRequest.getName(), addUserRequest.getSurName()) ||
        userRepository.existsByEmail(addUserRequest.getEmail()))
            throw new RuntimeException("bu kullanıcı ile kayıt oluşturamazsın.");
        User user = this.modelMapperService.forRequest().map(addUserRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public List<GetListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetListUserResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetListUserResponse.class))
                .collect(Collectors.toList());
        return userResponses;
    }

}
