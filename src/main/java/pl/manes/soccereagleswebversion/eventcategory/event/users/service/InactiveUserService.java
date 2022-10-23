package pl.manes.soccereagleswebversion.eventcategory.event.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.repository.EventRepository;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.repository.InactiveUserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class InactiveUserService {

    private final InactiveUserRepository inactiveUserRepository;

    private final EventRepository eventRepository;

    public InactiveUserService(InactiveUserRepository inactiveUserRepository, EventRepository eventRepository) {
        this.inactiveUserRepository = inactiveUserRepository;
        this.eventRepository = eventRepository;
    }

    @Transactional(readOnly = true)
    public List<InactiveUser> getInactiveUsers(UUID eventId) {

        return inactiveUserRepository.findByEventId(eventId);
    }

    @Transactional(readOnly = true)
    public InactiveUser getInactiveUser(UUID id) {

        return inactiveUserRepository.getReferenceById(id);
    }

    @Transactional
    public InactiveUser createInactiveUser(UUID eventId, InactiveUser inactiveUserRequest) {

        InactiveUser inactiveUser = new InactiveUser();
        inactiveUser.setUnknownUserName(inactiveUserRequest.getUnknownUserName());
        inactiveUser.setPresenceComments(inactiveUserRequest.getPresenceComments());

        Event event = eventRepository.getReferenceById(eventId);
        event.addInactiveUser(inactiveUser);

        inactiveUserRepository.save(inactiveUser);
        eventRepository.save(event);

        return inactiveUser;
    }

    @Transactional
    public InactiveUser updateInactiveUser(UUID inactiveId, InactiveUser inactiveUserRequest) {

        InactiveUser inactiveUser = inactiveUserRepository.getReferenceById(inactiveId);
        inactiveUser.setUnknownUserName(inactiveUserRequest.getUnknownUserName());
        inactiveUser.setPresenceComments(inactiveUserRequest.getPresenceComments());

        return inactiveUserRepository.save(inactiveUser);
    }

    @Transactional
    public void deleteInactiveUser(UUID inactiveId) {

        inactiveUserRepository.deleteById(inactiveId);
    }
}
