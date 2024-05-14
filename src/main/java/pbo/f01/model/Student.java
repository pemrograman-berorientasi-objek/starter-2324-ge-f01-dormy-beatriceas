package pbo.f01.model;

import java.util.Set;

import javax.persistence.*;

@Entity	
@Table(name = "students")
public class Student<Assigning> {
    @Id
    @Column(name = "StudentId", nullable=false, length =255)
    private String StudentId;
    @Column(name = "StudentName", nullable=false, length =255)
    private String StudentName;
    @Column(name = "EntranceYear", nullable=false, length =255)
    private int EntranceYear;
    @Column(name = "Gender", nullable=false, length =255)
    private String Gender;

    @OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
    @JoinTable(name = "assigning", joinColumns = @JoinColumn(name = "student_StudentName", referencedColumnName = "StudentName"), inverseJoinColumns = @JoinColumn(name = "Dorm_dorm_name", referencedColumnName = "dorm_name"))
    private Set<Assigning> assignings;

    public Student(){
        //empty
    }

    public Student(String StudentId, String StudentName, int EntranceYear, String Gender) {
        this.StudentId = StudentId;
        this.StudentName = StudentName;
        this.EntranceYear = EntranceYear;
        this.Gender = Gender;
    }

    public Student(String StudentId, String StudentName, int EntranceYear, String Gender, Set<Assigning> assignings) {
        this.StudentId = StudentId;
        this.StudentName = StudentName;
        this.EntranceYear = EntranceYear;
        this.Gender = Gender;
        this.assignings = assignings;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String StudentId) {
        this.StudentId = StudentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public int getEntranceYear() {
        return EntranceYear;
    }

    public void setEntranceYear(int EntranceYear) {
        this.EntranceYear = EntranceYear;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    
    public Set<Assigning> getAssignings() {
        return assignings;
    }

    public void setAssignings(Set<Assigning> assignings) {
        this.assignings = assignings;
    }

    @Override
    public String toString() {
        return StudentId + "|" + StudentName + "|" + EntranceYear + "|" + Gender;

    }
    
}