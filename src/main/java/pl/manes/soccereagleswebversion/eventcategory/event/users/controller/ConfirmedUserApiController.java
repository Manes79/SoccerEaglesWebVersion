package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.service.ConfirmedUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/confirmedusers")
public class ConfirmedUserApiController {

    private final ConfirmedUserService confirmedUserService;

    public ConfirmedUserApiController(ConfirmedUserService confirmedUserService) {
        this.confirmedUserService = confirmedUserService;
    }

    @GetMapping
    List<ConfirmedUser> getConfirmedUsers(@PathVariable UUID id) {

        return confirmedUserService.getConfirmedUsers(id);
    }

    @GetMapping("{id}")
    ConfirmedUser getConfirmedUser(@PathVariable UUID id) {

        return confirmedUserService.getConfirmedUser(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ConfirmedUser createConfirmedUser(@PathVariable UUID id, @RequestBody ConfirmedUser confirmedUser) {

        return confirmedUserService.createConfirmedUser(id, confirmedUser);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ConfirmedUser updateConfirmedUser(@PathVariable UUID id, @RequestBody ConfirmedUser confirmedUser) {

        return confirmedUserService.updateConfirmedUser(id, confirmedUser);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteConfirmedUser(@PathVariable UUID id) {

        confirmedUserService.deleteConfirmedUser(id);
    }
}
