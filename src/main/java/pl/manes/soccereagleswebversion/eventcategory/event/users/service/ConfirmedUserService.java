package pl.manes.soccereagleswebversion.eventcategory.event.users.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.repository.EventRepository;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.repository.ConfirmedUserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ConfirmedUserService {

    private final ConfirmedUserRepository confirmedUserRepository;

    private final EventRepository eventRepository;

    public ConfirmedUserService(ConfirmedUserRepository confirmedUserRepository, EventRepository eventRepository) {
        this.confirmedUserRepository = confirmedUserRepository;
        this.eventRepository = eventRepository;
    }

    @Transactional(readOnly = true)
    public List<ConfirmedUser> getConfirmedUsers(UUID eventId) {

        return confirmedUserRepository.findByEventId(eventId);
    }

    @Transactional(readOnly = true)
    public ConfirmedUser getConfirmedUser(UUID id) {

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
    public ConfirmedUser updateConfirmedUser(UUID confirmedId, ConfirmedUser confirmedUserRequest) {

        ConfirmedUser confirmedUser = confirmedUserRepository.getReferenceById(confirmedId);
        confirmedUser.setConfirmedUserName(confirmedUserRequest.getConfirmedUserName());
        confirmedUser.setPresenceComments(confirmedUserRequest.getPresenceComments());

        return confirmedUserRepository.save(confirmedUser);
    }

    @Transactional
    public void deleteConfirmedUser(UUID confirmedId) {

        confirmedUserRepository.deleteById(confirmedId);
    }
}
