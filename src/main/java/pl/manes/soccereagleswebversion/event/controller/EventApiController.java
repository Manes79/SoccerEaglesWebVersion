package pl.manes.soccereagleswebversion.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.event.domain.model.Event;
import pl.manes.soccereagleswebversion.event.service.EventService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/events")
public class EventApiController {

    private final EventService eventService;

    @GetMapping
    List<Event> displayAllEvents() {
        return eventService.findAllEvents();
    }

    @GetMapping("{id}")
    Event displayEventById(@PathVariable UUID id) {
        return eventService.findEventById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Event displayCreateEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Event displayUpdateEvent(@PathVariable UUID id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEvent(@PathVariable UUID id) {
        eventService.deleteEvent(id);
    }
}
