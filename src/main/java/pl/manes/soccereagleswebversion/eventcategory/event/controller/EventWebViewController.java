//package pl.manes.soccereagleswebversion.eventcategory.event.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
//import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
//import pl.manes.soccereagleswebversion.eventcategory.event.service.EventService;
//import pl.manes.soccereagleswebversion.eventcategory.service.EventCategoryService;
//
//import java.util.UUID;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/{category-id}/events")
//public class EventWebViewController {
//
//    private final EventService eventService;
//
//    private final EventCategoryService eventCategoryService;
//
//    @GetMapping("{id}")
//    public String viewAllEvents(@PathVariable UUID id, Model model, @PathVariable("category-id") String parameter) {
//
//        model.addAttribute("events", eventService.findAllEventsByEventCategoryId(id));
//
//        return "eventcategory/single";
//    }
//
//    @GetMapping("{id}/details")
//    public String singleEventView(@PathVariable UUID id, Model model, @PathVariable("category-id") String parameter) {
//
//        Event event = eventService.findEventById(id);
//
//        model.addAttribute("event", event);
//
//        return "eventcategory/event/details";
//    }
//
//    @GetMapping("create")
//    public String addCreateEventView(Model model, @PathVariable("category-id") String parameter) {
//
//        model.addAttribute("event", new Event());
//
//        return "eventcategory/event/create";
//    }
//
//    @PostMapping("{id}/create")
//    public String createEvent(@PathVariable UUID id, @RequestBody Event event, @PathVariable("category-id") String parameter) {
//
//        eventService.createEvent(id, event);
//
//        return "redirect:/categories";
//    }
//
//    @GetMapping("{id}/edit")
//    public String editViewEvent(Model model, @PathVariable UUID id, @PathVariable("category-id") String parameter) {
//
//        model.addAttribute("event", eventService.findEventById(id));
//
//        return "/eventcategory/event/edit";
//    }
//
//    @PostMapping("{id}/edit")
//    public String editSingleEvent(@PathVariable UUID id, @ModelAttribute("event") Event event, RedirectAttributes redirectAttributes, @PathVariable("category-id") String parameter) {
//
//        eventService.updateEvent(id, event);
//        redirectAttributes.addAttribute("id", event.getId());
//        redirectAttributes.addAttribute("eventName", event.getEventName());
//        redirectAttributes.addAttribute("eventData", event.getEventDate());
//        redirectAttributes.addAttribute("eventPlace", event.getEventPlace());
//        redirectAttributes.addAttribute("eventComments", event.getEventComments());
//
//        return "redirect:/categories";
//    }
//
//    @GetMapping("{id}/delete")
//    public String deleteEventView(@PathVariable UUID id, @PathVariable("category-id") String parameter) {
//
//        eventService.deleteEvent(id);
//
//        return "redirect:/categories";
//    }
//}