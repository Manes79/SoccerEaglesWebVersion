package pl.manes.soccereagleswebversion.event.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.event.domain.model.Event;
import pl.manes.soccereagleswebversion.event.domain.repository.EventRepository;
import pl.manes.soccereagleswebversion.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.event.users.domain.repository.DeclinedUserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeclinedUserService {

    private final DeclinedUserRepository declinedUserRepository;

    private final EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<DeclinedUser> findAllDeclinedUsersById(UUID eventId) {

        return declinedUserRepository.findDeclinedUsersById(eventId);
    }

    @Transactional(readOnly = true)
    public DeclinedUser findDeclinedUserById(UUID id) {

        return declinedUserRepository.getReferenceById(id);
    }

    @Transactional
    public DeclinedUser createDeclinedUser(UUID eventId, DeclinedUser declinedUserRequest) {

        DeclinedUser declinedUsers = new DeclinedUser();
        declinedUsers.setDeclinedUserName(declinedUserRequest.getDeclinedUserName());
        declinedUsers.setPresenceComments(declinedUserRequest.getPresenceComments());

        Event event = eventRepository.getReferenceById(eventId);
        event.addDeclinedUser(declinedUsers);

        declinedUserRepository.save(declinedUsers);
        eventRepository.save(event);

        return declinedUsers;
    }

    @Transactional
    public DeclinedUser updateDeclinedUser(UUID id, DeclinedUser declinedUserRequest) {

        DeclinedUser declinedUsers = declinedUserRepository.getReferenceById(id);
        declinedUsers.setDeclinedUserName(declinedUserRequest.getDeclinedUserName());
        declinedUsers.setPresenceComments(declinedUserRequest.getPresenceComments());

        return declinedUserRepository.save(declinedUsers);
    }

    @Transactional
    public void deleteDeclinedUser(UUID id) {

        declinedUserRepository.deleteById(id);
    }
}
