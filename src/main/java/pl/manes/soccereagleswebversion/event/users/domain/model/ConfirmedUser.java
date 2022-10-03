package pl.manes.soccereagleswebversion.event.users.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.event.domain.model.Event;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "confirmedusers")
@Getter
@Setter
@ToString
public class ConfirmedUser {

    @Id
    private UUID id;

    private String confirmedUserName;

    private String presenceComments;

    @ManyToOne
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