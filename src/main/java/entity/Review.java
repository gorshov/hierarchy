package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "REVIEW")
@DiscriminatorValue("R")

public class Review extends Film {

    @Column(name = "TEXT")
    private String text;

    @Column(name = "MARK")
    private double mark;

    public Review(String title, String text, double mark) {
        super(title);
        this.text = text;
        this.mark = mark;
    }

    public Review() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
