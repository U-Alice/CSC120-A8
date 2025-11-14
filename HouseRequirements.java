import java.util.ArrayList;

interface HouseRequirements {
    boolean hasDiningRoom(); 
    int nResidents(); 
    void moveIn(ArrayList<Student> s);
    void moveIn(Student s);
    Student moveOut(Student s); 
    void moveOut();
    boolean isResident(Student s); 
}
