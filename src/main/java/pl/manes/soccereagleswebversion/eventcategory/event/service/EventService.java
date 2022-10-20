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
    public List<Event> findAllEventsByEventCategoryId(UUID id) {
        return eventRepository.findEventByEventCategoryId(id);
    }

    @Transactional(readOnly = true)
    public Event findEventById(UUID id) {

        return eventRepository.getReferenceById(id);
    }

    @Transactional
    public Event createEvent(UUID categoryId, Event eventRequest) {

        Event event = new Event();
        event.setEventName(eventRequest.getEventName());
        event.setEventDate(eventRequest.getEventDate());
        event.setEventPlace(eventRequest.getEventPlace());
        event.setEventComments(eventRequest.getEventComments());

        EventCategory eventCategory = eventCategoryRepository.getReferenceById(categoryId);
        eventCategory.addEvent(event);

        eventRepository.save(event);
        eventCategoryRepository.save(eventCategory);

        return event;
    }

    @Transactional
    public Event updateEvent(UUID id, Event eventRequest) {

        Event event = eventRepository.getReferenceById(id);
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