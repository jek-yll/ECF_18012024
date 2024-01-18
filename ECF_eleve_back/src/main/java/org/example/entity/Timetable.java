package org.example.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "timetable")
public class Timetable {
    @EmbeddedId
    private TimetableId id;

    @MapsId("teacherId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @Column(name = "timetable_hour")
    private LocalTime timetableHour;

    @Column(name = "timetable_day", length = 50)
    private String timetableDay;

    public TimetableId getId() {
        return id;
    }

    public void setId(TimetableId id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public LocalTime getTimetableHour() {
        return timetableHour;
    }

    public void setTimetableHour(LocalTime timetableHour) {
        this.timetableHour = timetableHour;
    }

    public String getTimetableDay() {
        return timetableDay;
    }

    public void setTimetableDay(String timetableDay) {
        this.timetableDay = timetableDay;
    }

}