package pl.manes.soccereagleswebversion.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.event.users.service.InactiveUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/{event-id}/inactiveusers")
public class InactiveUserApiController {

    private final InactiveUserService inactiveUserService;

    @GetMapping
    List<InactiveUser> displayInactiveUsers(@PathVariable("event-id") UUID eventId) {

        return inactiveUserService.findAllInactiveUsersById(eventId);
    }

    @GetMapping("{inactive-id}")
    InactiveUser displayInactiveUsersById(@PathVariable("event-id") UUID eventId, @PathVariable("inactive-id") UUID inactiveId) {

        return inactiveUserService.findInactiveUserById(inactiveId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    InactiveUser displayCreateInactiveUser(@PathVariable("event-id") UUID eventId, @RequestBody InactiveUser inactiveUser) {

        return inactiveUserService.createInactiveUser(eventId, inactiveUser);
    }

    @PutMapping("{inactive-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    InactiveUser displayUpdateInactiveUser(@PathVariable("event-id") UUID eventId, @PathVariable("inactive-id") UUID inactiveId, @RequestBody InactiveUser inactiveUser) {

        return inactiveUserService.updateInactiveUser(inactiveId, inactiveUser);
    }

    @DeleteMapping("{inactive-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void displayDeleteInactiveUser(@PathVariable("inactive-id") UUID id, @PathVariable("event-id") String parameter) {

        inactiveUserService.deleteInactiveUser(id);
    }
}
