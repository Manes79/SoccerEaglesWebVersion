package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.service.InactiveUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/events/{event-id}/inactiveusers")
public class InactiveUserApiController {

    private final InactiveUserService inactiveUserService;

    public InactiveUserApiController(InactiveUserService inactiveUserService) {
        this.inactiveUserService = inactiveUserService;
    }

    @GetMapping
    List<InactiveUser> getInactiveUsers(@PathVariable("event-id") UUID eventId) {

        return inactiveUserService.getInactiveUsers(eventId);
    }

    @GetMapping("{inactive-id}")
    InactiveUser getInactiveUser(@PathVariable("event-id") UUID eventId, @PathVariable("inactive-id") UUID inactiveId) {

        return inactiveUserService.getInactiveUser(inactiveId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    InactiveUser createInactiveUser(@PathVariable("event-id") UUID eventId, @RequestBody InactiveUser inactiveUser) {

        return inactiveUserService.createInactiveUser(eventId, inactiveUser);
    }

    @PutMapping("{inactive-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    InactiveUser updateInactiveUser(@PathVariable("event-id") UUID eventId, @PathVariable("inactive-id") UUID inactiveId, @RequestBody InactiveUser inactiveUser) {

        return inactiveUserService.updateInactiveUser(inactiveId, inactiveUser);
    }

    @DeleteMapping("{inactive-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteConfirmedUser(@PathVariable("inactive-id") UUID inactiveId, @PathVariable("event-id") String parameter) {

        inactiveUserService.deleteInactiveUser(inactiveId);
    }
}
