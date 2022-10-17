package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.service.DeclinedUserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events/declinedusers")
public class DeclinedUserWebViewController {

    private final DeclinedUserService declinedUserService;

    @GetMapping
    public String viewAllDeclinedUsers(Model model) {

        model.addAttribute("declinedusers", declinedUserService.findAllDeclinedUsers());

        return "eventcategory/event/details";
    }

    @GetMapping("{id}/declined")
    public String addDeclinedUserView(Model model, @PathVariable String id) {

        model.addAttribute("declined", new DeclinedUser());

        return "eventcategory/event/users/declined";
    }

    @PostMapping
    public String createDeclinedUser(DeclinedUser declinedUser) {

        declinedUserService.createDeclinedUser(declinedUser);

        return "redirect:/categories";
    }
}
