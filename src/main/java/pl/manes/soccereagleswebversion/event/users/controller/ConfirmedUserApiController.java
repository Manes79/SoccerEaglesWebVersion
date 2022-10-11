package pl.manes.soccereagleswebversion.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.event.users.service.ConfirmedUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/events{event-id}/confirmedusers")
public class ConfirmedUserApiController {

    private final ConfirmedUserService confirmedUserService;

    @GetMapping
    List<ConfirmedUser> displayAllConfirmedUsers(@PathVariable("event-id") UUID eventId) {

        return confirmedUserService.findAllConfirmedUsersById(eventId);
    }

    @GetMapping("{confirmed-id}")
    ConfirmedUser displayConfirmedUserById(@PathVariable("event-id") UUID eventId, @PathVariable("confirmed-id") UUID confirmedId) {

        return confirmedUserService.findConfirmedUserById(confirmedId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ConfirmedUser displayConfirmedUser(@PathVariable("event-id") UUID eventId, @RequestBody ConfirmedUser confirmedUser) {

        return confirmedUserService.createConfirmedUser(eventId, confirmedUser);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("{confirmed-id}")
    ConfirmedUser displayUpdateConfirmedUser(@PathVariable("event-id") UUID eventId, @PathVariable("confirmed-id") UUID confirmedId, @RequestBody ConfirmedUser confirmedUser) {

        return confirmedUserService.updateConfirmedUser(confirmedId, confirmedUser);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{confirmed-id}")
    void displayDeleteConfirmedUser(@PathVariable("confirmed-id") UUID id, @PathVariable("event-id") String parameter) {

        confirmedUserService.deleteConfirmedUser(id);
    }
}