package pl.manes.soccereagleswebversion.eventcategory.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Getter
@Setter
@ToString
public class EventCategory {

    @Id
    private UUID id;

    private String category;

    public EventCategory() {
        this.id = UUID.randomUUID();
    }

    public EventCategory(String category) {
        this();
        this.category = category;
    }

}
