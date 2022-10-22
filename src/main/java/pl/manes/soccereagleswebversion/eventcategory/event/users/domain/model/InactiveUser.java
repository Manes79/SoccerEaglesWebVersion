package pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "inactiveusers")
public class InactiveUser {

    @Id
    private UUID id;

    private String unknownUserName;

    private String presenceComments;

    @ManyToOne
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
}
