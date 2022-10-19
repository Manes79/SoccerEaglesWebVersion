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
@Table(name = "inactiveusers", uniqueConstraints = {@UniqueConstraint(columnNames = {"unknown_user_name", "event_id"})})
public class InactiveUser implements Serializable {

    @Id
    private UUID id;

    @Column(name = "unknown_user_name")
    private String unknownUserName;

    @Column(name = "presence_comments")
    private String presenceComments;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name = "event_id")
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

}
