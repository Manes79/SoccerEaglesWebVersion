package pl.manes.soccereagleswebversion.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.event.users.service.DeclinedUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/declinedusers")
public class DeclinedUserApiController {

    private final DeclinedUserService declinedUserService;

    @GetMapping
    List<DeclinedUser> displayAllDeclinedUsers() {

        return declinedUserService.findAllDeclinedUsers();
    }

    @GetMapping("{id}")
    DeclinedUser displayDeclinedUserById(@PathVariable UUID id) {

        return declinedUserService.findDeclinedUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DeclinedUser displayCreateDeclinedUser(@RequestBody DeclinedUser declinedUser) {

        return declinedUserService.createDeclinedUser(declinedUser);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    DeclinedUser displayUserDeclinedForEventToChange(@PathVariable UUID id, @RequestBody DeclinedUser declinedUser) {

        return declinedUserService.updateDeclinedUser(id, declinedUser);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void userDeletesDeclinedForEvent(@PathVariable UUID id) {

        declinedUserService.deleteDeclinedUser(id);
    }
}