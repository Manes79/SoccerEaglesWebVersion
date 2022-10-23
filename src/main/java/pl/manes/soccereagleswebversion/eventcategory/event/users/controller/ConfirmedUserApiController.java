package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.service.ConfirmedUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/events/{event-id}/confirmedusers")
public class ConfirmedUserApiController {

    private final ConfirmedUserService confirmedUserService;

    public ConfirmedUserApiController(ConfirmedUserService confirmedUserService) {
        this.confirmedUserService = confirmedUserService;
    }

    @GetMapping
    List<ConfirmedUser> getConfirmedUsers(@PathVariable("event-id") UUID eventId) {

        return confirmedUserService.getConfirmedUsers(eventId);
    }

    @GetMapping("{confirmed-id}")
    ConfirmedUser getConfirmedUser(@PathVariable("event-id") UUID eventId, @PathVariable("confirmed-id") UUID confirmedId) {

        return confirmedUserService.getConfirmedUser(confirmedId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ConfirmedUser createConfirmedUser(@PathVariable("event-id") UUID eventId, @RequestBody ConfirmedUser confirmedUser) {

        return confirmedUserService.createConfirmedUser(eventId, confirmedUser);
    }

    @PutMapping("{confirmed-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ConfirmedUser updateConfirmedUser(@PathVariable("event-id") UUID eventId, @PathVariable("confirmed-id") UUID confirmedId, @RequestBody ConfirmedUser confirmedUser) {

        return confirmedUserService.updateConfirmedUser(confirmedId, confirmedUser);
    }

    @DeleteMapping("{confirmed-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteConfirmedUser(@PathVariable("confirmed-id") UUID confirmedId, @PathVariable("event-id") String parameter) {

        confirmedUserService.deleteConfirmedUser(confirmedId);
    }
}
