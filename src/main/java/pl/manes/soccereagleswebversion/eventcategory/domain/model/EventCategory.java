package pl.manes.soccereagleswebversion.eventcategory.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class EventCategory {

    @Id
    private UUID id;

    private String category;

    public EventCategory() {
        this.id = UUID.randomUUID();
    }

    public EventCategory(String category) {
        this.id = UUID.randomUUID();
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
