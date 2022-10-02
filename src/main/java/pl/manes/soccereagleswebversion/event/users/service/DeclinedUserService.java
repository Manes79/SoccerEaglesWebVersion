package pl.manes.soccereagleswebversion.event.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.manes.soccereagleswebversion.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.event.users.domain.repository.DeclinedUserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeclinedUserService {

    private final DeclinedUserRepository declinedUserRepository;

    @Transactional(readOnly = true)
    public List<DeclinedUser> findAllDeclinedUsers() {
        return declinedUserRepository.findAll();
    }

    @Transactional(readOnly = true)
    public DeclinedUser findDeclinedUserById(UUID id) {
        return declinedUserRepository.findById(id)
                .orElseThrow();
    }

    @Transactional
    public DeclinedUser createDeclinedUser(DeclinedUser declinedUsersRequest) {
        DeclinedUser declinedUsers = new DeclinedUser();
        declinedUsers.setDeclinedUserName(declinedUsersRequest.getDeclinedUserName());
        declinedUsers.setPresenceComments(declinedUsersRequest.getPresenceComments());
        return declinedUserRepository.save(declinedUsers);
    }

    @Transactional
    public DeclinedUser updateDeclinedUser(UUID id, DeclinedUser declinedUsersRequest) {
        DeclinedUser declinedUsers = declinedUserRepository.findById(id)
                .orElseThrow();
        declinedUsers.setDeclinedUserName(declinedUsersRequest.getDeclinedUserName());
        declinedUsers.setPresenceComments(declinedUsersRequest.getPresenceComments());
        return declinedUserRepository.save(declinedUsers);
    }

    @Transactional
    public void deleteDeclinedUser(UUID id) {
        declinedUserRepository.deleteById(id);
    }
}