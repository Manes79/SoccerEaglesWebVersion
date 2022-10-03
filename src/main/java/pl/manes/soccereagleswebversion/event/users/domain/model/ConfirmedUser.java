package pl.manes.soccereagleswebversion.event.users.domain.model;

import lombok.Getter;
import lombok.Setter;
import pl.manes.soccereagleswebversion.event.domain.model.Event;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "confirmedusers")
@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmedUser that = (ConfirmedUser) o;
        return id.equals(that.id) && confirmedUserName.equals(that.confirmedUserName) && presenceComments.equals(that.presenceComments) && event.equals(that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, confirmedUserName, presenceComments, event);
    }

    @Override
    public String toString() {
        return "ConfirmedUser{" +
                "id=" + id +
                ", confirmedUserName='" + confirmedUserName + '\'' +
                ", presenceComments='" + presenceComments + '\'' +
                ", event=" + event +
                '}';
    }
}