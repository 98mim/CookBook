package sk.mimi.cookbookspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.mimi.cookbookspring.DTO.model.ChangePasswordRequest;
import sk.mimi.cookbookspring.DTO.model.response.UserProfileResponse;
import sk.mimi.cookbookspring.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PatchMapping("/password-change")
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/info")
    public ResponseEntity getProfile(@RequestParam Long id){
        UserProfileResponse user = service.getUserProfile(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/me")
    public ResponseEntity getMyProfile(Principal user){
        UserProfileResponse userResponse = service.getMyProfile(user);
        return ResponseEntity.ok(userResponse);
    }
}
