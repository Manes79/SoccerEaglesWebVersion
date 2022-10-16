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
    @JsonBackReference
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