package pl.manes.soccereagleswebversion.eventcategory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
import pl.manes.soccereagleswebversion.eventcategory.event.service.EventService;
import pl.manes.soccereagleswebversion.eventcategory.service.EventCategoryService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class EventCategoryWebViewController {

    private final EventCategoryService eventCategoryService;
    private final EventService eventService;

    @GetMapping("create")
    public String addCreateEventCategoryView(Model model) {

        model.addAttribute("category", new EventCategory());

        return "eventcategory/create";
    }

    @PostMapping
    public String createEventCategory(EventCategory eventCategory) {

        eventCategoryService.createCategory(eventCategory);

        return "redirect:/categories";
    }

    @GetMapping("{id}/delete")
    public String deleteEventCategoryView(@PathVariable UUID id) {

        eventCategoryService.deleteCategory(id);

        return "redirect:/categories";
    }

    @GetMapping
    public String viewAllEventCategories(Model model) {

        model.addAttribute("categories", eventCategoryService.findAllCategories());
//        model.addAttribute("events", eventService.findAllEventsByEventCategoryId());

        return "eventcategory/index";
    }

    @GetMapping("{id}/single")
    public String singleWebViewCategory(@PathVariable UUID id, Model model) {

//        EventCategory eventCategory = eventCategoryService.getEventCategory(id);
//        List<Event> events = Collections.singletonList(eventService.getEvent(id));
//
//        model.addAttribute("category", eventCategory);
//        model.addAttribute("event", events);
//        model.addAttribute("events", eventService.getEvent(id));

        return "eventcategory/single";
    }
}
