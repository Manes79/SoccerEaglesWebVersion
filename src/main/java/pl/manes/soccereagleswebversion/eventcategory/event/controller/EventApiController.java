package pl.manes.soccereagleswebversion.eventcategory.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
import pl.manes.soccereagleswebversion.eventcategory.event.service.EventService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/categories{category-id}/events")
public class EventApiController {

    private final EventService eventService;

    @GetMapping
    List<Event> getAllEventsByEventCategoryId(@PathVariable("category-id") UUID categoryId) {
        return eventService.findAllEventsByEventCategoryId(categoryId);
    }

    @GetMapping("{event-id}")
    Event getEventById(@PathVariable("category-id") UUID categoryId, @PathVariable("event-id") UUID eventId) {
        return eventService.findEventById(eventId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Event displayCreateEvent(@PathVariable("category-id") UUID categoryId, @RequestBody Event event) {
        return eventService.createEvent(categoryId, event);
    }

    @PutMapping("{event-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Event displayUpdateEvent(@PathVariable("category-id") UUID categoryId, @PathVariable("event-id") UUID eventId, @RequestBody Event event) {
        return eventService.updateEvent(eventId, event);
    }

    @DeleteMapping("{event-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEvent(@PathVariable("event-id") UUID eventId, @PathVariable("category-id") String parameter) {
        eventService.deleteEvent(eventId);
    }
}
