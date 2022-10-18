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
@Table(name = "confirmedusers", uniqueConstraints = {@UniqueConstraint(columnNames = {"confirmed_user_name", "event_id"})})
@Getter
@Setter
@ToString
public class ConfirmedUser implements Serializable {

    @Id
    private UUID id;
    @Column(name = "confirmed_user_name")
    private String confirmedUserName;
    @Column(name = "presence_comments")
    private String presenceComments;

    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name = "event_id")
    private Event event;

    public ConfirmedUser() {
        this.id = UUID.randomUUID();
    }

    public ConfirmedUser(String confirmedUserName, String presenceComments) {
        this();
        this.confirmedUserName = confirmedUserName;
        this.presenceComments = presenceComments;
    }
}