package pl.manes.soccereagleswebversion.event.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.event.users.domain.model.InactiveUser;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@ToString
public class Event implements Serializable {

    @Id
    private UUID id;

    private String eventName;

    private String eventDate;

    private String eventPlace;

    private String eventComments;

    @ManyToOne
    private EventCategory eventCategory;

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "event", orphanRemoval = true)
    @ToString.Exclude
    private List<ConfirmedUser> confirmedUsers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
    @ToString.Exclude
    private List<DeclinedUser> declinedUsers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
    @ToString.Exclude
    private List<InactiveUser> inactiveUsers;

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
