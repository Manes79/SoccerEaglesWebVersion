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
    List<EventCategory> displayAllCategories() {
        return eventCategoryService.findAllCategories();
    }

    @GetMapping("{id}")
    EventCategory getCategoryById(@PathVariable UUID id) {
        return eventCategoryService.findCategoryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EventCategory createCategory(@RequestBody EventCategory eventCategory) {
        return eventCategoryService.createCategory(eventCategory);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    EventCategory updateCategory(@PathVariable UUID id, @RequestBody EventCategory eventCategory) {
        return eventCategoryService.updateCategory(id, eventCategory);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCategory(@PathVariable UUID id) {
        eventCategoryService.deleteCategory(id);
    }
}
