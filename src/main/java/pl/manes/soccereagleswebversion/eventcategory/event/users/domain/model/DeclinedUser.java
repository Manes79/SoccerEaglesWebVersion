package pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "declinedusers", uniqueConstraints = {@UniqueConstraint(columnNames = {"declined_user_name", "event_id"})})
public class DeclinedUser implements Serializable {

    @Id
    private UUID id;

    @Column(name = "declined_user_name")
    private String declinedUserName;

    @Column(name = "presence_comments")
    private String presenceComments;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name = "event_id")
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

}
