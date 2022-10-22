package pl.manes.soccereagleswebversion.eventcategory.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.domain.repository.EventCategoryRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EventCategoryService {

    private final EventCategoryRepository eventCategoryRepository;

    public EventCategoryService(EventCategoryRepository eventCategoryRepository) {
        this.eventCategoryRepository = eventCategoryRepository;
    }

    @Transactional(readOnly = true)
    public List<EventCategory> getEventCategories() {

        return eventCategoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public EventCategory getEventCategory(UUID id) {

        return eventCategoryRepository.getReferenceById(id);
    }

    @Transactional
    public EventCategory createEventCategory(EventCategory eventCategoryRequest) {

        EventCategory eventCategory = new EventCategory();
        eventCategory.setCategory(eventCategoryRequest.getCategory());

        return eventCategoryRepository.save(eventCategory);
    }

    @Transactional
    public EventCategory updateEventCategory(UUID id, EventCategory eventCategoryRequest) {

        EventCategory eventCategory = eventCategoryRepository.getReferenceById(id);
        eventCategory.setCategory(eventCategoryRequest.getCategory());

        return eventCategoryRepository.save(eventCategory);
    }

    @Transactional
    public void deleteEventCategory(UUID id) {

        eventCategoryRepository.deleteById(id);
    }
}
