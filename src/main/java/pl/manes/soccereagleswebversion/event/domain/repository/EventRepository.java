package pl.manes.soccereagleswebversion.event.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manes.soccereagleswebversion.event.domain.model.Event;

import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {

}