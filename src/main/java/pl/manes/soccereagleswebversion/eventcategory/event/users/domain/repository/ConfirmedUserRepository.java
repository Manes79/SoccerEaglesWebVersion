package pl.manes.soccereagleswebversion.eventcategory.event.users.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.ConfirmedUser;

import java.util.UUID;

@Repository
public interface ConfirmedUserRepository extends JpaRepository<ConfirmedUser, UUID> {
}