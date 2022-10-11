package pl.manes.soccereagleswebversion.event.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manes.soccereagleswebversion.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.event.users.domain.model.InactiveUser;

import java.util.List;
import java.util.UUID;

@Repository
public interface InactiveUserRepository extends JpaRepository<InactiveUser, UUID> {
    List<InactiveUser> findInactiveUsersById(UUID eventId);
}
