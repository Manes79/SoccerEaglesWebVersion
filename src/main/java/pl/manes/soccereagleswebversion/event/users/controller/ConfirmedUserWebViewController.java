package pl.manes.soccereagleswebversion.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manes.soccereagleswebversion.event.domain.model.Event;
import pl.manes.soccereagleswebversion.event.service.EventService;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.event.users.service.ConfirmedUserService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events/confirmedusers")
public class ConfirmedUserWebViewController {

    private final ConfirmedUserService confirmedUserService;

    private final EventService eventService;

    @GetMapping
    public String viewAllConfirmedUsers(Model model) {

        model.addAttribute("confirmedusers", confirmedUserService.findAllConfirmedUsers());

        return "event/users/index";
    }

    @GetMapping("{id}")
    public String singleConfirmedUserView(@PathVariable UUID id, Model model) {

        ConfirmedUser confirmedUsers = confirmedUserService.findConfirmedUserById(id);
        model.addAttribute("confirmed", confirmedUsers);

        return "event/users/single";
    }

    @GetMapping("{id}/accept")
    public String addConfirmedUserView(@PathVariable UUID id, Model model) {

        Event event = eventService.findEventById(id);
        model.addAttribute("event", event);

        model.addAttribute("confirmed", new ConfirmedUser());

        return "event/users/accept";
    }

    @PostMapping()
    public String createConfirmedUser(ConfirmedUser confirmedUser) {

        confirmedUserService.createConfirmedUser(confirmedUser);

        return "redirect:/events";
    }
}
