package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.service.DeclinedUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/events/{event-id}/declinedusers")
public class DeclinedUserApiController {

    private final DeclinedUserService declinedUserService;

    public DeclinedUserApiController(DeclinedUserService declinedUserService) {
        this.declinedUserService = declinedUserService;
    }

    @GetMapping
    List<DeclinedUser> getDeclinedUsers(@PathVariable("event-id") UUID eventId) {

        return declinedUserService.getDeclinedUsers(eventId);
    }

    @GetMapping("{declined-id}")
    DeclinedUser getDeclinedUser(@PathVariable("event-id") UUID eventId, @PathVariable("declined-id") UUID declinedId) {

        return declinedUserService.getDeclinedUser(declinedId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    DeclinedUser createDeclinedUser(@PathVariable("event-id") UUID eventId, @RequestBody DeclinedUser declinedUser) {

        return declinedUserService.createDeclinedUser(eventId, declinedUser);
    }

    @PutMapping("{declined-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    DeclinedUser updateDeclinedUser(@PathVariable("event-id") UUID eventId, @PathVariable("declined-id") UUID declinedId, @RequestBody DeclinedUser declinedUser) {

        return declinedUserService.updateDeclinedUser(declinedId, declinedUser);
    }

    @DeleteMapping("{declined-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDeclinedUser(@PathVariable("declined-id") UUID declinedId, @PathVariable("event-id") String parameter) {

        declinedUserService.deleteDeclinedUser(declinedId);
    }
}