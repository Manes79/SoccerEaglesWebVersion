package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.service.InactiveUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/inactiveusers")
public class InactiveUserApiController {

    private final InactiveUserService inactiveUserService;

    @GetMapping
    List<InactiveUser> displayInactiveUsers() {
        return inactiveUserService.findAllInactiveUsers();
    }

    @GetMapping("{id}")
    InactiveUser displayInactiveUsersById(@PathVariable UUID id) {
        return inactiveUserService.findInactiveUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    InactiveUser displayCreateInactiveUser(@RequestBody InactiveUser inactiveUser) {
        return inactiveUserService.createInactiveUser(inactiveUser);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    InactiveUser displayUpdateInactiveUser(@PathVariable UUID id, @RequestBody InactiveUser inactiveUser) {
        return inactiveUserService.updateInactiveUser(id, inactiveUser);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void displayDeleteInactiveUser(@PathVariable UUID id) {
        inactiveUserService.deleteInactiveUser(id);
    }
}
