package pl.manes.soccereagleswebversion.eventcategory.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = {"category"})})
@Getter
@Setter
@ToString
public class EventCategory implements Serializable {

    @Id
    private UUID id;

    @Column(name = "category")
    private String category;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_category_id")
    @ToString.Exclude
    @JsonManagedReference
    private List<Event> events;

    public EventCategory() {
        this.id = UUID.randomUUID();
    }

    public EventCategory(String category) {
        this();
        this.category = category;
    }

}
