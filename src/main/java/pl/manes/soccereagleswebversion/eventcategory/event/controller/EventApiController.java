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
@RequestMapping("api/v1/categories{eventCategory-id}/event")
public class EventApiController {

    private final EventService eventService;

    @GetMapping
    List<Event> getEvents(@PathVariable("eventCategory-id") UUID eventCategoryId) {
        return eventService.getEvents(eventCategoryId);
    }

    @GetMapping("{event-id}")
    Event getEvent(@PathVariable("eventCategory-id") UUID eventCategoryId, @PathVariable("event-id") UUID eventId) {
        return eventService.getEvent(eventId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Event createEvent(@PathVariable("eventCategory-id") UUID eventCategoryId, @RequestBody Event event) {
        return eventService.createEvent(eventCategoryId, event);
    }

    @PutMapping("{event-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Event updateEvent(@PathVariable("eventCategory-id") UUID eventCategoryId, @PathVariable("event-id") UUID eventId, @RequestBody Event event) {
        return eventService.updateEvent(eventId, event);
    }

    @DeleteMapping("{event-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEvent(@PathVariable("event-id") UUID eventId, @PathVariable("eventCategory-id") String parameter) {
        eventService.deleteEvent(eventId);
    }
}
