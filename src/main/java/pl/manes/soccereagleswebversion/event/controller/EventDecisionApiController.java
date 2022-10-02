package pl.manes.soccereagleswebversion.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.manes.soccereagleswebversion.event.domain.model.EventDecision;
import pl.manes.soccereagleswebversion.event.service.EventDecisionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/decision")
public class EventDecisionApiController {

    private final EventDecisionService eventDecisionService;

    @GetMapping
    List<EventDecision> displayAllEventsDecision() {

        return eventDecisionService.findAllEventsDecision();
    }

    @GetMapping("{id}")
    EventDecision displayEventDecisionById(@PathVariable UUID id) {

        return eventDecisionService.findEventDecisionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EventDecision displayCreateEventDecision(@RequestBody EventDecision eventDecision) {

        return eventDecisionService.createEventDecision(eventDecision);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    EventDecision displayUpdateEventDecision(@PathVariable UUID id, @RequestBody EventDecision eventDecision) {

        return eventDecisionService.updateEventDecision(id, eventDecision);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteEventDecision(@PathVariable UUID id) {

        eventDecisionService.deleteEventDecision(id);
    }

}
