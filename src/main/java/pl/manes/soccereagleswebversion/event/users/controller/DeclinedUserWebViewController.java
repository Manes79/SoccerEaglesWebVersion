package pl.manes.soccereagleswebversion.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manes.soccereagleswebversion.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.event.users.service.DeclinedUserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events/declinedusers")
public class DeclinedUserWebViewController {

    private final DeclinedUserService declinedUserService;

    @GetMapping
    public String viewAllDeclinedUsers(Model model) {

        model.addAttribute("declinedusers", declinedUserService.findAllDeclinedUsers());

        return "event/users/declinedusersview";
    }

    @GetMapping("{id}/declined")
    public String addDeclinedUserView(Model model, @PathVariable String id) {

        model.addAttribute("declined", new DeclinedUser());

        return "event/users/declined";
    }

    @PostMapping
    public String createConfirmedUser(DeclinedUser declinedUser) {

        declinedUserService.createDeclinedUser(declinedUser);

        return "redirect:/events";
    }
}
