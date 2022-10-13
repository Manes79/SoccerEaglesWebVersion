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
@RequestMapping("api/v1/events/confirmedusers")
public class ConfirmedUserApiController {

    private final ConfirmedUserService confirmedUserService;

    @GetMapping
    List<ConfirmedUser> displayAllConfirmedUsers() {
        return confirmedUserService.findAllConfirmedUsers();
    }

    @GetMapping("{id}")
    ConfirmedUser displayConfirmedUserById(@PathVariable UUID id) {
        return confirmedUserService.findConfirmedUserById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ConfirmedUser displayConfirmedUser(@RequestBody ConfirmedUser confirmedUser) {
        return confirmedUserService.createConfirmedUser(confirmedUser);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("{id}")
    ConfirmedUser displayUpdateConfirmedUser(@PathVariable UUID id, @RequestBody ConfirmedUser confirmedUser) {
        return confirmedUserService.updateConfirmedUser(id, confirmedUser);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void displayDeleteConfirmedUser(@PathVariable UUID id) {
        confirmedUserService.deleteConfirmedUser(id);
    }
}