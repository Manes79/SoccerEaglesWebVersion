package pl.manes.soccereagleswebversion.eventcategory.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;

import java.util.List;
import java.util.UUID;

@Repository
public interface EventCategoryRepository extends JpaRepository<EventCategory, UUID> {

    @Query("select e from EventCategory e where e.category = ?1")
    List<EventCategory> findAllByCategory(UUID id);

}
