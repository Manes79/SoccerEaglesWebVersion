package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.service.DeclinedUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/events/declinedusers")
public class DeclinedUserApiController {

    private final DeclinedUserService declinedUserService;

    public DeclinedUserApiController(DeclinedUserService declinedUserService) {
        this.declinedUserService = declinedUserService;
    }

    @GetMapping
    List<DeclinedUser> getDeclinedUsers() {

        return declinedUserService.getDeclinedUsers();
    }

    @GetMapping("{id}")
    DeclinedUser getDeclinedUser(@PathVariable UUID id) {

        return declinedUserService.getDeclinedUser(id);
    }

    @PostMapping("{createid}")
    @ResponseStatus(HttpStatus.CREATED)
    DeclinedUser createDeclinedUser(@PathVariable UUID createid, @RequestBody DeclinedUser declinedUser) {

        return declinedUserService.createDeclinedUser(createid, declinedUser);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    DeclinedUser updateDeclinedUser(@PathVariable UUID id, @RequestBody DeclinedUser declinedUser) {

        return declinedUserService.updateDeclinedUser(id, declinedUser);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDeclinedUser(@PathVariable UUID id) {

        declinedUserService.deleteDeclinedUser(id);
    }
}