package pl.manes.soccereagleswebversion.event.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.event.domain.model.Event;
import pl.manes.soccereagleswebversion.event.domain.repository.EventRepository;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.event.users.domain.repository.ConfirmedUserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConfirmedUserService {

    private final ConfirmedUserRepository confirmedUserRepository;

    private final EventRepository eventRepository;

    @Transactional(readOnly = true)
    public List<ConfirmedUser> findAllConfirmedUsersById(UUID eventId) {

        return confirmedUserRepository.findConfirmedUsersById(eventId);
    }

    @Transactional(readOnly = true)
    public ConfirmedUser findConfirmedUserById(UUID id) {

        return confirmedUserRepository.getReferenceById(id);
    }

    @Transactional
    public ConfirmedUser createConfirmedUser(UUID eventId, ConfirmedUser confirmedUserRequest) {

        ConfirmedUser confirmedUser = new ConfirmedUser();
        confirmedUser.setConfirmedUserName(confirmedUserRequest.getConfirmedUserName());
        confirmedUser.setPresenceComments(confirmedUserRequest.getPresenceComments());

        Event event = eventRepository.getReferenceById(eventId);
        event.addConfirmedUser(confirmedUser);

        confirmedUserRepository.save(confirmedUser);
        eventRepository.save(event);

        return confirmedUser;
    }

    @Transactional
    public ConfirmedUser updateConfirmedUser(UUID id, ConfirmedUser confirmedUserRequest) {

        ConfirmedUser confirmedUser = confirmedUserRepository.getReferenceById(id);
        confirmedUser.setConfirmedUserName(confirmedUserRequest.getConfirmedUserName());
        confirmedUser.setPresenceComments(confirmedUserRequest.getPresenceComments());

        return confirmedUserRepository.save(confirmedUser);
    }

    @Transactional
    public void deleteConfirmedUser(UUID id) {

        confirmedUserRepository.deleteById(id);
    }
}