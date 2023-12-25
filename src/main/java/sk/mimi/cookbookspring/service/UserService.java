package sk.mimi.cookbookspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sk.mimi.cookbookspring.DTO.mapper.UserMapper;
import sk.mimi.cookbookspring.DTO.model.ChangePasswordRequest;
import sk.mimi.cookbookspring.DTO.model.response.UserProfileResponse;
import sk.mimi.cookbookspring.model.UserEntity;
import sk.mimi.cookbookspring.repository.UserRepository;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final UserMapper mapper;
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (UserEntity) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        repository.save(user);
    }

    public UserProfileResponse getUserProfile(Long id){
        UserEntity user = repository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return mapper.toProfileResponse(user);
    }

    public UserProfileResponse getMyProfile(Principal user){
        //UserEntity user = (UserEntity) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        //UserEntity user = repository.findById(((UserEntity) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal()).getId()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return getUserProfile(((UserEntity) ((UsernamePasswordAuthenticationToken) user).getPrincipal()).getId());
    }
}
