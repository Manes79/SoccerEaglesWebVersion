package pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "declinedusers")
public class DeclinedUser {

    @Id
    private UUID id;

    private String declinedUserName;

    private String presenceComments;

    @ManyToOne
    @JsonBackReference
    private Event event;

    public DeclinedUser() {
        this.id = UUID.randomUUID();
    }

    public DeclinedUser(String declinedUserName, String presenceComments, Event event) {
        this();
        this.declinedUserName = declinedUserName;
        this.presenceComments = presenceComments;
        this.event = event;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDeclinedUserName() {
        return declinedUserName;
    }

    public void setDeclinedUserName(String declinedUserName) {
        this.declinedUserName = declinedUserName;
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
