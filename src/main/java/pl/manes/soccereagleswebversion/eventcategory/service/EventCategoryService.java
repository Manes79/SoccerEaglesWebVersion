package pl.manes.soccereagleswebversion.eventcategory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.domain.repository.EventCategoryRepository;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventCategoryService {

    private final EventCategoryRepository eventCategoryRepository;

    @Transactional(readOnly = true)
    public List<EventCategory> findAllCategories() {
        return eventCategoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public EventCategory findCategoryById(UUID id) {
        return eventCategoryRepository.getReferenceById(id);
    }

    @Transactional
    public EventCategory createCategory(EventCategory eventCategoryRequest) {
        EventCategory eventCategory = new EventCategory();
        eventCategory.setCategory(eventCategoryRequest.getCategory());
        return eventCategoryRepository.save(eventCategory);
    }

    @Transactional
    public EventCategory updateCategory(UUID id, EventCategory eventCategoryRequest) {
        EventCategory eventCategory = eventCategoryRepository.getReferenceById(id);
        eventCategory.setCategory(eventCategoryRequest.getCategory());
        return eventCategoryRepository.save(eventCategory);
    }

    @Transactional
    public void deleteCategory(UUID id) {
        eventCategoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public EventCategory findEventCategoryById(UUID id) {
        return eventCategoryRepository.findEventCategoryById(id);
    }
}
