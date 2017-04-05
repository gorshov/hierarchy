package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "FILM")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("F")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FILM_ID", unique = true)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    private Genre genre;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @Column(name = "COUNTRY")
    private String country;


    public Film(String title, Genre genre, LocalDate releaseDate, String country) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.country = country;
    }
}
