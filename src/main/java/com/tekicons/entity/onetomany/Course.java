package com.tekicons.entity.onetomany;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "training_center_id")
//    private TrainingCenter trainingCenter;

    public Course() {

    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public TrainingCenter getTrainingCenter() {
//        return trainingCenter;
//    }
//
//    public void setTrainingCenter(TrainingCenter trainingCenter) {
//        this.trainingCenter = trainingCenter;
//    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + "]";
    }
}