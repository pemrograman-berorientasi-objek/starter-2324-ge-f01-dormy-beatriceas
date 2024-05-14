package pbo.f01.model;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "Dorms")
public class Dorm<Assigning> {
    @Id
    @Column(name = "DormName", nullable =false, length = 255)
    private String DormName;
    @Column(name = "Capacity", nullable =false, length = 255)
    private int Capacity;
    @Column(name = "Gender", nullable =false, length = 255)
    private String Gender;

    @OneToMany(targetEntity = Dorm.class, cascade = CascadeType.ALL)
    @JoinTable(name = "assigning", joinColumns = @JoinColumn(name = "Dorm_DormName", referencedColumnName = "DormName"), inverseJoinColumns = @JoinColumn(name = "Dorm_DormName", referencedColumnName = "DormName"))    
    private Set<Assigning> assignings;

    public Dorm(){
    }

    public Dorm(String DormName, int Capacity, String Gender){
        this.DormName = DormName;
        this.Capacity = Capacity;
        this.Gender = Gender;
    }

    public Dorm(String DormName, int Capacity, String Gender, Set<Assigning> assignings){
        this.DormName = DormName;
        this.Capacity = Capacity;
        this.Gender = Gender;
        this.assignings = assignings;
    }

    public String getDormName(){
        return DormName;
    }

    public void setDormName(String DormName){
        this.DormName = DormName;
    }

    public int getCapacity(){
        return Capacity;
    }
    
    public void setCapacity(int Capacity){
        this.Capacity = Capacity;
    }

    public String getGender(){
        return Gender;
    }

    public void setGender(String Gender){
        this.Gender = Gender;
    }

    public Set<Assigning> getAssignings(){
        return assignings;
    }

    public void setAssignings(Set<Assigning> assignings2) {
        this.assignings = assignings;
    }

    @Override
    public String toString(){
        return DormName + "|" + Capacity + "|" + Gender;
    }
 
}
