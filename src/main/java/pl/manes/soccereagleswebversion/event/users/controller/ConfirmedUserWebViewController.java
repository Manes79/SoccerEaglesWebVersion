package pl.manes.soccereagleswebversion.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.event.users.service.ConfirmedUserService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events/confirmedusers")
public class ConfirmedUserWebViewController {

    private final ConfirmedUserService confirmedUserService;

    @GetMapping
    public String viewAllConfirmedUsers(UUID eventId, Model model) {

        model.addAttribute("confirmedusers", confirmedUserService.findAllConfirmedUsersById(eventId));

        return "event/details";
    }

    @GetMapping("{id}/accept")
    public String addConfirmedUserView(Model model, @PathVariable String id) {

        model.addAttribute("confirmed", new ConfirmedUser());

        return "event/users/accept";
    }

    @PostMapping
    public String createConfirmedUser(UUID eventId, ConfirmedUser confirmedUser) {

        confirmedUserService.createConfirmedUser(eventId, confirmedUser);

        return "redirect:/events";
    }

}
