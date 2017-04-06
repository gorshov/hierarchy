package entity;


import lombok.*;
import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "FILM")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("F")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FILM_ID", unique = true)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    public Film() {
    }

    public Film(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
