package pl.manes.soccereagleswebversion.eventcategory.event.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import pl.manes.soccereagleswebversion.eventcategory.domain.model.EventCategory;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.ConfirmedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.DeclinedUser;
import pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model.InactiveUser;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event {

    @Id
    private UUID id;

    private String eventName;

    private String eventDate;

    private String eventPlace;

    private String eventComments;

    @ManyToOne()
    private EventCategory eventCategory;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
    @JsonManagedReference
    private Set<ConfirmedUser> confirmedUsers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
    @JsonManagedReference
    private Set<DeclinedUser> declinedUsers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", orphanRemoval = true)
    @JsonManagedReference
    private Set<InactiveUser> inactiveUsers;

    public Event() {
        this.id = UUID.randomUUID();
    }

    public Event(String eventName, String eventDate, String eventPlace, String eventComments, EventCategory eventCategory, Set<ConfirmedUser> confirmedUsers, Set<DeclinedUser> declinedUsers, Set<InactiveUser> inactiveUsers) {
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

    public Event addConfirmedUser(ConfirmedUser confirmedUser) {
        if (confirmedUsers == null) {
            confirmedUsers = new LinkedHashSet<>();
        }
        confirmedUser.setEvent(this);
        confirmedUsers.add(confirmedUser);

        return this;
    }

    public Event addDeclinedUser(DeclinedUser declinedUser) {
        if (declinedUsers == null) {
            declinedUsers = new LinkedHashSet<>();
        }
        declinedUser.setEvent(this);
        declinedUsers.add(declinedUser);

        return this;
    }

    public Event addInactiveUser(InactiveUser inactiveUser) {
        if (inactiveUsers == null) {
            inactiveUsers = new LinkedHashSet<>();
        }
        inactiveUser.setEvent(this);
        inactiveUsers.add(inactiveUser);

        return this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventComments() {
        return eventComments;
    }

    public void setEventComments(String eventComments) {
        this.eventComments = eventComments;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public Set<ConfirmedUser> getConfirmedUsers() {
        return confirmedUsers;
    }

    public void setConfirmedUsers(Set<ConfirmedUser> confirmedUsers) {
        this.confirmedUsers = confirmedUsers;
    }

    public Set<DeclinedUser> getDeclinedUsers() {
        return declinedUsers;
    }

    public void setDeclinedUsers(Set<DeclinedUser> declinedUsers) {
        this.declinedUsers = declinedUsers;
    }

    public Set<InactiveUser> getInactiveUsers() {
        return inactiveUsers;
    }

    public void setInactiveUsers(Set<InactiveUser> inactiveUsers) {
        this.inactiveUsers = inactiveUsers;
    }
}
