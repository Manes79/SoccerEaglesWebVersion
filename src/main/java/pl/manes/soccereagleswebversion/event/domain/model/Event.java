package pl.manes.soccereagleswebversion.event.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
public class Event {

    @Id
    private UUID id;

    private String eventName;

    private String eventDate;

    private String eventPlace;

    private String eventComments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
    @ToString.Exclude
    Set<ConfirmedUser> confirmedUser;

    public Event() {
        this.id = UUID.randomUUID();
    }

    public Event(String eventName, String eventDate, String eventPlace, String eventComments) {
        this();
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
        this.eventComments = eventComments;
    }
}
