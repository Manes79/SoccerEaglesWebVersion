package pl.manes.soccereagleswebversion.event.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "eventsdecision")
@Getter
@Setter
@ToString
public class EventDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String eventDecision;

    private String presenceComments;

    public EventDecision() {
        this.id = UUID.randomUUID();
    }

    public EventDecision(String eventDecision, String presenceComments) {
        this();
        this.eventDecision = eventDecision;
        this.presenceComments = presenceComments;
    }
}
