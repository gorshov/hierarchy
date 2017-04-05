package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEW")
@DiscriminatorValue("R")
@Data
@NoArgsConstructor
public class Review extends Film {
    @Column(name = "`TEXT`")
    private String text;

    @Column(name = "MARK")
    private double mark;

    public Review(String text, double mark) {
        this.text = text;
        this.mark = mark;
    }
}
