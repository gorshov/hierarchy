package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "STAR")
@DiscriminatorValue("S")
@Data
@NoArgsConstructor
public class Star extends Film {
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    public Star(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
