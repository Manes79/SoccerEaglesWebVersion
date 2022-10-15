package pl.manes.soccereagleswebversion.event.users.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.event.domain.model.Event;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "confirmedusers")
@Getter
@Setter
@ToString
public class ConfirmedUser implements Serializable {

    @Id
    private UUID id;

    private String confirmedUserName;

    private String presenceComments;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
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