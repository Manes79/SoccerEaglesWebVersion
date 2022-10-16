package pl.manes.soccereagleswebversion.eventcategory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("create")
    public String addCreateEventCategoryView(Model model) {

        model.addAttribute("category", new EventCategory());

        return "event/eventcategory/create";
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
        model.addAttribute("events", eventService.findAllEvents());

        return "event/eventcategory/index";
    }

    @GetMapping("{id}/single")
    public String singleWebViewCategory(@PathVariable UUID id, Model model) {

        EventCategory eventCategory = eventCategoryService.findCategoryById(id);
        List<Event> events = eventService.findAllEventsByEventCategoryId(id);

        model.addAttribute("category", eventCategory);
        model.addAttribute("event", events);
//        model.addAttribute("events", eventService.findAllEventsByEventCategoryId(id));

        return "event/eventcategory/single";
    }
}
