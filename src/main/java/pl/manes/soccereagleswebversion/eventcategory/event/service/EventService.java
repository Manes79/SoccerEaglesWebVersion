package pl.manes.soccereagleswebversion.eventcategory.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.domain.repository.EventCategoryRepository;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.repository.EventRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventCategoryRepository eventCategoryRepository;

    @Transactional(readOnly = true)
    public List<Event> getEvents (UUID eventCategoryId) {
        return eventRepository.findByEventCategoryId(eventCategoryId);
    }

    @Transactional(readOnly = true)
    public Event getEvent(UUID id) {
        return eventRepository.getReferenceById(id);
    }

    @Transactional
    public Event createEvent(UUID eventCategoryId, Event eventRequest) {

        Event event = new Event();
        event.setEventName(eventRequest.getEventName());
        event.setEventDate(eventRequest.getEventDate());
        event.setEventPlace(eventRequest.getEventPlace());
        event.setEventComments(eventRequest.getEventComments());

        EventCategory eventCategory = eventCategoryRepository.getReferenceById(eventCategoryId);
        eventCategory.addEvent(event);

        eventRepository.save(event);
        eventCategoryRepository.save(eventCategory);

        return event;
    }

    @Transactional
    public Event updateEvent(UUID eventId, Event eventRequest) {

        Event event = eventRepository.getReferenceById(eventId);
        event.setEventName(eventRequest.getEventName());
        event.setEventDate(eventRequest.getEventDate());
        event.setEventPlace(eventRequest.getEventPlace());
        event.setEventComments(eventRequest.getEventComments());

        return eventRepository.save(event);
    }

    @Transactional
    public void deleteEvent(UUID eventId) {
        eventRepository.deleteById(eventId);
    }

}