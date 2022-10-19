package pl.manes.soccereagleswebversion.eventcategory.event.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.InactiveUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "events", uniqueConstraints = {@UniqueConstraint(columnNames = {"event_name", "event_category_id"})})
public class Event implements Serializable {

    @Id
    private UUID id;

    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_date")
    private String eventDate;
    @Column(name = "event_place")
    private String eventPlace;
    @Column(name = "event_comments")
    private String eventComments;


    @ManyToOne
    @JoinColumn(name = "event_category_id")
    private EventCategory eventCategory;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    @ToString.Exclude
    @JsonManagedReference
    private List<ConfirmedUser> confirmedUsers;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    @JsonManagedReference
    @ToString.Exclude
    private List<DeclinedUser> declinedUsers;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    @JsonManagedReference
    @ToString.Exclude
    private List<InactiveUser> inactiveUsers;

    public Event() {
        this.id = UUID.randomUUID();
    }

    public Event(String eventName, String eventDate, String eventPlace, String eventComments, EventCategory eventCategory, List<ConfirmedUser> confirmedUsers, List<DeclinedUser> declinedUsers, List<InactiveUser> inactiveUsers) {
        this();
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
        this.eventComments = eventComments;
        this.eventCategory = eventCategory;
        this.confirmedUsers = confirmedUsers;
        this.declinedUsers = declinedUsers;
        this.inactiveUsers = inactiveUsers;
    }

}
