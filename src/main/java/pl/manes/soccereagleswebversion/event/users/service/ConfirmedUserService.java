package pl.manes.soccereagleswebversion.event.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.event.users.domain.repository.ConfirmedUserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConfirmedUserService {

    private final ConfirmedUserRepository confirmedUserRepository;

    @Transactional(readOnly = true)
    public List<ConfirmedUser> findAllConfirmedUsers() {

        return confirmedUserRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ConfirmedUser findConfirmedUserById(UUID id) {

        return confirmedUserRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    public ConfirmedUser createConfirmedUser(ConfirmedUser confirmedUserRequest) {

        ConfirmedUser confirmedUser = new ConfirmedUser();
        confirmedUser.setConfirmedUserName(confirmedUserRequest.getConfirmedUserName());
        confirmedUser.setPresenceComments(confirmedUserRequest.getPresenceComments());

        return confirmedUserRepository.save(confirmedUser);
    }

    @Transactional
    public ConfirmedUser updateConfirmedUser(UUID id, ConfirmedUser confirmedUserRequest) {
        ConfirmedUser confirmedUser = confirmedUserRepository.findById(id)
                .orElseThrow();
        confirmedUser.setConfirmedUserName(confirmedUserRequest.getConfirmedUserName());
        confirmedUser.setPresenceComments(confirmedUserRequest.getPresenceComments());

        return confirmedUserRepository.save(confirmedUser);
    }

    @Transactional
    public void deleteConfirmedUser(UUID id) {

        confirmedUserRepository.deleteById(id);
    }
}