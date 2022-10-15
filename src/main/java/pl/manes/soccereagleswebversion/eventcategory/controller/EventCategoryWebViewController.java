package pl.manes.soccereagleswebversion.eventcategory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.manes.soccereagleswebversion.event.domain.model.Event;
import pl.manes.soccereagleswebversion.event.service.EventService;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.service.EventCategoryService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class EventCategoryWebViewController {

    private final EventCategoryService eventCategoryService;

    private final EventService eventService;

    @GetMapping
    public String viewAllEventCategories(Model model) {

        model.addAttribute("categories", eventCategoryService.findAllCategories());

        return "event/eventcategory/index";
    }

    @GetMapping("{id}/single")
    public String singleWebViewCategory(@PathVariable UUID id, Model model) {

        EventCategory eventCategory = eventCategoryService.findCategoryById(id);
        List<Event> events = eventService.findAllEventsByEventCategoryId(id);

        model.addAttribute("category", eventCategory);
        model.addAttribute("event", events);
        model.addAttribute("events", eventService.findAllEventsByEventCategoryId(id));

        return "event/eventcategory/single";
    }
}
