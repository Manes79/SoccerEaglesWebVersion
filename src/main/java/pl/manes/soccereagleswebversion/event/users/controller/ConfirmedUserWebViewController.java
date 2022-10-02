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
@RequestMapping("/confirmedusers")
public class ConfirmedUserWebViewController {

    private final ConfirmedUserService confirmedUserService;

    @GetMapping
    public String viewAllConfirmedUsers(Model model) {

        model.addAttribute("confirmedusers", confirmedUserService.findAllConfirmedUsers());

        return "users/index";
    }

    @GetMapping("{id}")
    public String singleConfirmedUserView(@PathVariable UUID id, Model model) {

        ConfirmedUser confirmedUsers = confirmedUserService.findConfirmedUserById(id);
        model.addAttribute("confirmed", confirmedUsers);

        return "users/single";
    }

    @GetMapping("accept")
    public String addConfirmedUserView(Model model) {

        model.addAttribute("confirmed", new ConfirmedUser());

        return "users/accept";
    }

    @PostMapping()
    public String createConfirmedUser(ConfirmedUser confirmedUser) {

        confirmedUserService.createConfirmedUser(confirmedUser);

        return "redirect:/events";
    }
}
