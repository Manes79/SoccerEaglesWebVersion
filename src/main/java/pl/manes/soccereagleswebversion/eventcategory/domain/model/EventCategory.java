package pl.manes.soccereagleswebversion.eventcategory.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = {"category"})})
public class EventCategory implements Serializable {

    @Id
    private UUID id;

    @Column(name = "category")
    private String category;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_category_id")
    @ToString.Exclude
    @JsonManagedReference
    private Set<Event> events;

    public EventCategory() {
        this.id = UUID.randomUUID();
    }

    public EventCategory(String category, Set<Event> events) {
        this();
        this.category = category;
        this.events = events;
    }

    public void addEvent(Event event) {
        if (events == null) {
            events = new LinkedHashSet<>();
        }

        event.setEventCategory(this);
        events.add(event);
    }

}
