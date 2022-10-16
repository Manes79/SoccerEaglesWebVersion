package pl.manes.soccereagleswebversion.eventcategory.event.users.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.manes.soccereagleswebversion.eventcategory.event.domain.model.Event;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "inactiveusers")
@Getter
@Setter
@ToString
public class InactiveUser {

    @Id
    private UUID id;

    private String unknownUserName;

    private String presenceComments;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference
    private Event event;

    public InactiveUser() {
        this.id = UUID.randomUUID();
    }

    public InactiveUser(String unknownUserName, String presenceComments) {
        this();
        this.unknownUserName = unknownUserName;
        this.presenceComments = presenceComments;
    }
}
