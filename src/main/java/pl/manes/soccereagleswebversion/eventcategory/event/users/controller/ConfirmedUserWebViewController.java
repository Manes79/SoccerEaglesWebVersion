//package pl.manes.soccereagleswebversion.eventcategory.event.users.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.ConfirmedUser;
//import pl.manes.soccereagleswebversion.eventcategory.event.users.service.ConfirmedUserService;
//
//import java.util.UUID;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/events/confirmedusers")
//public class ConfirmedUserWebViewController {
//
//    private final ConfirmedUserService confirmedUserService;
//
//    @GetMapping
//    public String viewAllConfirmedUsers(Model model) {
//
//        model.addAttribute("confirmedusers", confirmedUserService.findAllConfirmedUsers());
//
//        return "eventcategory/event/details";
//    }
//
//    @GetMapping("{id}")
//    public String singleConfirmedUserView(@PathVariable UUID id, Model model) {
//
//        ConfirmedUser confirmedUser = confirmedUserService.findConfirmedUserById(id);
//        model.addAttribute("confirmed", confirmedUser);
//
//        return "eventcategory/event/details";
//    }
//
//    @GetMapping("{id}/accept")
//    public String addConfirmedUserView(Model model, @PathVariable String id) {
//
//        model.addAttribute("confirmed", new ConfirmedUser());
//
//        return "eventcategory/event/users/accept";
//    }
//
//    @PostMapping
//    public String createConfirmedUser(ConfirmedUser confirmedUser) {
//
//        confirmedUserService.createConfirmedUser(confirmedUser);
//
//        return "redirect:/categories";
//    }
//
//}
