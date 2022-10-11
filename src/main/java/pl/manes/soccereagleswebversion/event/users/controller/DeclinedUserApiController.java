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
@RequestMapping("api/v1/events{event-id}/declinedusers")
public class DeclinedUserApiController {

    private final DeclinedUserService declinedUserService;

    @GetMapping
    List<DeclinedUser> displayAllDeclinedUsers(@PathVariable("event-id") UUID eventId) {

        return declinedUserService.findAllDeclinedUsersById(eventId);
    }

    @GetMapping("{declined-id}")
    DeclinedUser displayDeclinedUserById(@PathVariable("event-id") UUID eventId, @PathVariable("declined-id") UUID declinedId) {

        return declinedUserService.findDeclinedUserById(declinedId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DeclinedUser displayCreateDeclinedUser(@PathVariable("event-id") UUID eventId, @RequestBody DeclinedUser declinedUser) {

        return declinedUserService.createDeclinedUser(eventId, declinedUser);
    }

    @PutMapping("{declined-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    DeclinedUser displayUserDeclinedForEventToChange(@PathVariable("event-id") UUID eventId, @PathVariable("declined-id") UUID declinedId, @RequestBody DeclinedUser declinedUser) {

        return declinedUserService.updateDeclinedUser(declinedId, declinedUser);
    }

    @DeleteMapping("{declined-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void userDeletesDeclinedForEvent(@PathVariable("declined-id") UUID id, @PathVariable("event-id") String parameter) {

        declinedUserService.deleteDeclinedUser(id);
    }
}