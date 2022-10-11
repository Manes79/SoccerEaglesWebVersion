package pl.manes.soccereagleswebversion.event.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.event.domain.model.Event;
import pl.manes.soccereagleswebversion.event.domain.repository.EventRepository;
import pl.manes.soccereagleswebversion.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.event.users.domain.repository.InactiveUserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InactiveUserService {

    private final InactiveUserRepository inactiveUserRepository;

    private final EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<InactiveUser> findAllInactiveUsersById(UUID eventId) {

        return inactiveUserRepository.findInactiveUsersById(eventId);
    }

    @Transactional(readOnly = true)
    public InactiveUser findInactiveUserById(UUID id) {

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
    public InactiveUser updateInactiveUser(UUID id, InactiveUser inactiveUserRequest) {

        InactiveUser inactiveUser = inactiveUserRepository.getReferenceById(id);
        inactiveUser.setUnknownUserName(inactiveUserRequest.getUnknownUserName());
        inactiveUser.setPresenceComments(inactiveUserRequest.getPresenceComments());

        return inactiveUserRepository.save(inactiveUser);
    }

    @Transactional
    public void deleteInactiveUser(UUID id) {

        inactiveUserRepository.deleteById(id);
    }
}
