package pl.manes.soccereagleswebversion.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.event.domain.model.Event;
import pl.manes.soccereagleswebversion.event.domain.repository.EventRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<Event> findAllEvents() {

        return eventRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Event findEventById(UUID id) {

        return eventRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    public Event createEvent(Event eventRequest) {

        Event event = new Event();
        event.setEventName(eventRequest.getEventName());
        event.setEventDate(eventRequest.getEventDate());
        event.setEventPlace(eventRequest.getEventPlace());
        event.setEventComments(eventRequest.getEventComments());

        return eventRepository.save(event);
    }

    @Transactional
    public Event updateEvent(UUID id, Event eventRequest) {

        Event event = eventRepository.findById(id)
                .orElseThrow();
        event.setEventName(eventRequest.getEventName());
        event.setEventDate(eventRequest.getEventDate());
        event.setEventPlace(eventRequest.getEventPlace());
        event.setEventComments(eventRequest.getEventComments());

        return eventRepository.save(event);
    }

    @Transactional
    public void deleteEvent(UUID id) {

        eventRepository.deleteById(id);
    }
}