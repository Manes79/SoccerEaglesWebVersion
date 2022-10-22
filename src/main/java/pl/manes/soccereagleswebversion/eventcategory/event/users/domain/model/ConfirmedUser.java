package pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "confirmedusers")
public class ConfirmedUser {

    @Id
    private UUID id;

    private String confirmedUserName;

    private String presenceComments;

    @ManyToOne
    @JsonBackReference
    private Event event;

    public ConfirmedUser() {
        this.id = UUID.randomUUID();
    }

    public ConfirmedUser(String confirmedUserName, String presenceComments, Event event) {
        this();
        this.confirmedUserName = confirmedUserName;
        this.presenceComments = presenceComments;
        this.event = event;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getConfirmedUserName() {
        return confirmedUserName;
    }

    public void setConfirmedUserName(String confirmedUserName) {
        this.confirmedUserName = confirmedUserName;
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
}