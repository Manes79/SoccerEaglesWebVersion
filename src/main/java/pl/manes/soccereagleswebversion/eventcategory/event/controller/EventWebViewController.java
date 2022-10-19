package pl.manes.soccereagleswebversion.eventcategory.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
import pl.manes.soccereagleswebversion.eventcategory.event.service.EventService;
import pl.manes.soccereagleswebversion.eventcategory.service.EventCategoryService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventWebViewController {

    private final EventService eventService;

    private final EventCategoryService eventCategoryService;

    @GetMapping
    public String viewAllEvents(Model model) {

        model.addAttribute("events", eventService.findAllEvents());

        return "eventcategory/single";
    }

    @GetMapping("{id}/details")
    public String singleEventView(@PathVariable UUID id, Model model) {

        EventCategory eventCategory = eventCategoryService.findEventCategoryById(id);
        Event event = eventService.findEventById(id);

        model.addAttribute("event", event);
        model.addAttribute("category", eventCategory);

        return "eventcategory/event/details";
    }

    @GetMapping("create")
    public String addCreateEventView(Model model) {

        model.addAttribute("event", new Event());

        return "eventcategory/event/create";
    }

    @PostMapping
    public String createEvent(Event event) {

        eventService.createEvent(event);

        return "redirect:/categories";
    }

    @GetMapping("{id}/edit")
    public String editViewEvent(Model model, @PathVariable UUID id) {

        model.addAttribute("event", eventService.findEventById(id));

        return "/eventcategory/event/edit";
    }

    @PostMapping("{id}/edit")
    public String editSingleEvent(@PathVariable UUID id, @ModelAttribute("event") Event event, RedirectAttributes redirectAttributes) {

        eventService.updateEvent(id, event);
        redirectAttributes.addAttribute("id", event.getId());
        redirectAttributes.addAttribute("eventName", event.getEventName());
        redirectAttributes.addAttribute("eventData", event.getEventDate());
        redirectAttributes.addAttribute("eventPlace", event.getEventPlace());
        redirectAttributes.addAttribute("eventComments", event.getEventComments());

        return "redirect:/categories";
    }

    @GetMapping("{id}/delete")
    public String deleteEventView(@PathVariable UUID id) {

        eventService.deleteEvent(id);

        return "redirect:/categories";
    }
}