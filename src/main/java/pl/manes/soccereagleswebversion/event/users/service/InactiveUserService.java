package pl.manes.soccereagleswebversion.event.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.event.users.domain.repository.InactiveUserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InactiveUserService {

    private final InactiveUserRepository inactiveUserRepository;

    @Transactional(readOnly = true)
    public List<InactiveUser> findAllInactiveUsers() {
        return inactiveUserRepository.findAll();
    }

    @Transactional(readOnly = true)
    public InactiveUser findInactiveUserById(UUID id) {
        return inactiveUserRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    public InactiveUser createInactiveUser(InactiveUser inactiveUserRequest) {
        InactiveUser inactiveUser = new InactiveUser();
        inactiveUser.setUnknownUserName(inactiveUserRequest.getUnknownUserName());
        inactiveUser.setPresenceComments(inactiveUserRequest.getPresenceComments());
        return inactiveUserRepository.save(inactiveUser);
    }

    @Transactional
    public InactiveUser updateInactiveUser(UUID id, InactiveUser inactiveUserRequest) {
        InactiveUser inactiveUser = inactiveUserRepository.findById(id)
                .orElseThrow();
        inactiveUser.setUnknownUserName(inactiveUserRequest.getUnknownUserName());
        inactiveUser.setPresenceComments(inactiveUserRequest.getPresenceComments());
        return inactiveUserRepository.save(inactiveUser);
    }

    @Transactional
    public void deleteInactiveUser(UUID id) {
        inactiveUserRepository.deleteById(id);
    }
}
