package pl.manes.soccereagleswebversion.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manes.soccereagleswebversion.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.event.users.service.InactiveUserService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events/inactiveusers")
public class InactiveUserWebViewController {

    private final InactiveUserService inactiveUserService;

    @GetMapping
    public String viewAllInactiveUsers(UUID eventId, Model model) {

        model.addAttribute("inactiveusers", inactiveUserService.findAllInactiveUsersById(eventId));

        return "event/details";
    }

    @GetMapping("{id}/inactive")
    public String addInactiveUserView(Model model, @PathVariable String id) {

        model.addAttribute("inactive", new InactiveUser());

        return "event/users/inactive";
    }

    @PostMapping
    public String createInactiveUser(UUID eventId, InactiveUser inactiveUser) {

        inactiveUserService.createInactiveUser(eventId, inactiveUser);

        return "redirect:/events";
    }

}
