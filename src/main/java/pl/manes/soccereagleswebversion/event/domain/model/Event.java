package pl.manes.soccereagleswebversion.event.domain.model;

import lombok.Getter;
import lombok.Setter;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Event {

    @Id
    private UUID id;

    private String eventName;

    private String eventDate;

    private String eventPlace;

    private String eventComments;

    @OneToMany(mappedBy = "event")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id) && eventName.equals(event.eventName) && eventDate.equals(event.eventDate) && eventPlace.equals(event.eventPlace) && eventComments.equals(event.eventComments) && confirmedUser.equals(event.confirmedUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventName, eventDate, eventPlace, eventComments, confirmedUser);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "eventName = " + eventName + ", " +
                "eventDate = " + eventDate + ", " +
                "eventPlace = " + eventPlace + ", " +
                "eventComments = " + eventComments + ")";
    }
}
