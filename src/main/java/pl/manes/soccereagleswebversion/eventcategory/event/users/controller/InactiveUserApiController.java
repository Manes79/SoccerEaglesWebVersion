package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.service.InactiveUserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/events/inactiveusers")
public class InactiveUserApiController {

    private final InactiveUserService inactiveUserService;

    public InactiveUserApiController(InactiveUserService inactiveUserService) {
        this.inactiveUserService = inactiveUserService;
    }

    @GetMapping
    List<InactiveUser> getInactiveUsers() {

        return inactiveUserService.getInactiveUsers();
    }

    @GetMapping("{id}")
    InactiveUser getInactiveUser(@PathVariable UUID id) {

        return inactiveUserService.getInactiveUser(id);
    }

    @PostMapping("{createid}")
    @ResponseStatus(HttpStatus.CREATED)
    InactiveUser createInactiveUser(@PathVariable UUID createid, @RequestBody InactiveUser inactiveUser) {

        return inactiveUserService.createInactiveUser(createid, inactiveUser);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    InactiveUser updateInactiveUser(@PathVariable UUID id, @RequestBody InactiveUser inactiveUser) {

        return inactiveUserService.updateInactiveUser(id, inactiveUser);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteConfirmedUser(@PathVariable UUID id) {

        inactiveUserService.deleteInactiveUser(id);
    }
}
