package pl.manes.soccereagleswebversion.eventcategory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.service.EventCategoryService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/categories")
public class EventCategoryController {

    private final EventCategoryService eventCategoryService;

    @GetMapping
    List<EventCategory> getEventCategories() {

        return eventCategoryService.getEventCategories();
    }

    @GetMapping("{id}")
    EventCategory getEventCategory(@PathVariable UUID id) {

        return eventCategoryService.getEventCategory(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EventCategory createEventCategory(@RequestBody EventCategory eventCategory) {

        return eventCategoryService.createEventCategory(eventCategory);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    EventCategory updateEventCategory(@PathVariable UUID id, @RequestBody EventCategory eventCategory) {

        return eventCategoryService.updateEventCategory(id, eventCategory);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEventCategory(@PathVariable UUID id) {

        eventCategoryService.deleteEventCategory(id);
    }
}
