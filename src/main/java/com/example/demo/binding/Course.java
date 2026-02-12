package com.example.demo.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COURSE_DTLS")
// Adding a comment just to test github commands
// Adding another line of comment to push changes directly without synching them - this is Commit & Push
// Adding one another line of comment with Commit & Pull Request
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String name;
    private double price;
}
