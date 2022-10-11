package pl.manes.soccereagleswebversion.event.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.event.users.domain.model.InactiveUser;

import javax.persistence.*;
import java.util.LinkedHashSet;
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
    Set<ConfirmedUser> confirmedUsers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
    @ToString.Exclude
    Set<DeclinedUser> declinedUsers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
    @ToString.Exclude
    Set<InactiveUser> unknownUsers;

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

    public void addConfirmedUser(ConfirmedUser confirmedUser) {
        if (confirmedUsers == null) {
            confirmedUsers = new LinkedHashSet<>();
        }
        confirmedUser.setEvent(this);
        confirmedUsers.add(confirmedUser);
    }

    public void addDeclinedUser(DeclinedUser declinedUser) {
        if (declinedUsers == null) {
            declinedUsers = new LinkedHashSet<>();
        }
        declinedUser.setEvent(this);
        declinedUsers.add(declinedUser);
    }

    public void addInactiveUser(InactiveUser inactiveUser) {
        if (unknownUsers == null) {
            unknownUsers = new LinkedHashSet<>();
        }
        inactiveUser.setEvent(this);
        unknownUsers.add(inactiveUser);
    }

}
