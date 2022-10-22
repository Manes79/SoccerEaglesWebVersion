package pl.manes.soccereagleswebversion.eventcategory.event.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
import pl.manes.soccereagleswebversion.eventcategory.event.service.EventService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/events")
public class EventApiController {

    private final EventService eventService;

    public EventApiController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    List<Event> getEvents() {

        return eventService.getEvents();
    }

    @GetMapping("{id}")
    Event getEvent(@PathVariable UUID id) {

        return eventService.getEvent(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Event updateEvent(@PathVariable UUID id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEvent(@PathVariable UUID id) {
        eventService.deleteEvent(id);
    }
}
