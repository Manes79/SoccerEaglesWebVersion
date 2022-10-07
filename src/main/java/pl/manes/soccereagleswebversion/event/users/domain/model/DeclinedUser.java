package pl.manes.soccereagleswebversion.event.users.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.event.domain.model.Event;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "declinedusers")
@Getter
@Setter
@ToString
public class DeclinedUser {

    @Id
    private UUID id;

    private String declinedUserName;

    private String presenceComments;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Event event;

    public DeclinedUser() {
        this.id = UUID.randomUUID();
    }

    public DeclinedUser(String declinedUserName, String presenceComments) {
        this();
        this.declinedUserName = declinedUserName;
        this.presenceComments = presenceComments;
    }
}
