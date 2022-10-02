package pl.manes.soccereagleswebversion.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.event.domain.model.EventDecision;
import pl.manes.soccereagleswebversion.event.domain.repository.EventDecisionRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventDecisionService {

    private final EventDecisionRepository eventDecisionRepository;

    @Transactional(readOnly = true)
    public List<EventDecision> findAllEventsDecision() {

        return eventDecisionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public EventDecision findEventDecisionById(UUID id) {

        return eventDecisionRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    public EventDecision createEventDecision(EventDecision eventDecisionRequest) {
        EventDecision eventDecision = new EventDecision();
        eventDecision.setEventDecision(eventDecisionRequest.getEventDecision());
        eventDecision.setPresenceComments(eventDecisionRequest.getPresenceComments());

        return eventDecisionRepository.save(eventDecision);
    }

    @Transactional
    public EventDecision updateEventDecision(UUID id, EventDecision eventDecisionRequest) {
        EventDecision eventDecision = eventDecisionRepository.findById(id)
                .orElseThrow();
        eventDecision.setEventDecision(eventDecisionRequest.getEventDecision());

        return eventDecisionRepository.save(eventDecision);
    }

    @Transactional
    public void deleteEventDecision(UUID id) {

        eventDecisionRepository.deleteById(id);
    }
}