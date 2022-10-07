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

@Controller
@RequiredArgsConstructor
@RequestMapping("/events/inactiveusers")
public class InactiveUserWebViewController {

    private final InactiveUserService inactiveUserService;

    @GetMapping
    public String viewAllInactiveUsers(Model model) {

        model.addAttribute("inactiveusers", inactiveUserService.findAllInactiveUsers());

        return "event/users/inactiveusersview";
    }

    @GetMapping("{id}/inactive")
    public String addInactiveUserView(Model model, @PathVariable String id) {

        model.addAttribute("inactive", new InactiveUser());

        return "event/users/inactive";
    }

    @PostMapping
    public String createInactiveUser(InactiveUser inactiveUser) {

        inactiveUserService.createInactiveUser(inactiveUser);

        return "redirect:/events";
    }

}
