package pl.manes.soccereagleswebversion.event.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "eventsdecision")
@Getter
@Setter
@ToString
public class EventDecision {

    @Id
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
