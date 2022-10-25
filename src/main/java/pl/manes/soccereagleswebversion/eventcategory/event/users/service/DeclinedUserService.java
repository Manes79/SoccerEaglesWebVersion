package pl.manes.soccereagleswebversion.eventcategory.event.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.repository.EventRepository;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.repository.DeclinedUserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class DeclinedUserService {

    private final DeclinedUserRepository declinedUserRepository;

    private final EventRepository eventRepository;

    public DeclinedUserService(DeclinedUserRepository declinedUserRepository, EventRepository eventRepository) {
        this.declinedUserRepository = declinedUserRepository;
        this.eventRepository = eventRepository;
    }

    @Transactional(readOnly = true)
    public List<DeclinedUser> getDeclinedUsers() {

        return declinedUserRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DeclinedUser getDeclinedUser(UUID id) {

        return declinedUserRepository.getReferenceById(id);
    }

    @Transactional
    public DeclinedUser createDeclinedUser(UUID eventId, DeclinedUser declinedUserRequest) {

        DeclinedUser declinedUser = new DeclinedUser();
        declinedUser.setDeclinedUserName(declinedUserRequest.getDeclinedUserName());
        declinedUser.setPresenceComments(declinedUserRequest.getPresenceComments());

        Event event = eventRepository.getReferenceById(eventId);
        event.addDeclinedUser(declinedUser);

        declinedUserRepository.save(declinedUser);
        eventRepository.save(event);

        return declinedUser;
    }

    @Transactional
    public DeclinedUser updateDeclinedUser(UUID declinedId, DeclinedUser declinedUserRequest) {

        DeclinedUser declinedUser = declinedUserRepository.getReferenceById(declinedId);
        declinedUser.setDeclinedUserName(declinedUserRequest.getDeclinedUserName());
        declinedUser.setPresenceComments(declinedUserRequest.getPresenceComments());

        return declinedUserRepository.save(declinedUser);
    }

    @Transactional
    public void deleteDeclinedUser(UUID declinedId) {

        declinedUserRepository.deleteById(declinedId);
    }
}
