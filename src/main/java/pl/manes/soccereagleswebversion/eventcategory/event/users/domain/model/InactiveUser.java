package pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.Hibernate;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "inactiveusers")
public class InactiveUser {

    @Id
    private UUID id;
    private String unknownUserName;
    private String presenceComments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Event event;

    public InactiveUser() {
        this.id = UUID.randomUUID();
    }

    public InactiveUser(String unknownUserName, String presenceComments, Event event) {
        this();
        this.unknownUserName = unknownUserName;
        this.presenceComments = presenceComments;
        this.event = event;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUnknownUserName() {
        return unknownUserName;
    }

    public void setUnknownUserName(String unknownUserName) {
        this.unknownUserName = unknownUserName;
    }

    public String getPresenceComments() {
        return presenceComments;
    }

    public void setPresenceComments(String presenceComments) {
        this.presenceComments = presenceComments;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InactiveUser that = (InactiveUser) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
