/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  /*
   * Class attributes
   */
  private ArrayList<Student> residents; 

  private boolean hasDiningRoom;
  private boolean hasElevator;

  /*
   * accessor
   * return hasDiningRoom
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }
  /*
   * accessor
   * return nResidents
   */
  public int nResidents(){
    return residents.size();
  }
  
  /*
   * register a student as a resident
   * param s
   */
  @Override
  public void moveIn(Student s) {
    if(residents.contains(s)){
      throw new RuntimeException("Student already registered as a resident!");
    }
    System.out.println("Succesfully moved in " + " student " + s.getName() + " " + this.getName());
    residents.add(s);
  }
  
  /*
   * register a list of students as residents
   * param students
   */
  @Override
  public void moveIn(ArrayList<Student> students) {
    for (Student s : students) {
      if (residents.contains(s)) {
        throw new RuntimeException("Student " + s.getName() + " is already registered as a resident!");
      }
    }
    System.out.println("Succesfully moved in " + students.size() + " students in " + this.getName());
    residents.addAll(students);
  }

  /*
   * removes a student from residents
   * param s
   * return s
   */
  @Override
  public Student moveOut(Student s) {
    if(!residents.contains(s)){
      throw new RuntimeException("Student not registered as a resident!");
    }
    System.out.println("Succesfully moved out " + " student " + s.getName() + " " + this.getName());
    residents.remove(s);
    return s;
  }

  /*
   * empties the list of residents
   * param s
   * return s
   */
  @Override
  public void moveOut() {
    residents.removeAll(residents);
    System.out.println("Succesfully moved out" + " students in " + this.getName());
  }

  /*
   * checks if a student is a resident
   * param s
   * return boolean
   */
  @Override
  public boolean isResident(Student s) {
    return residents.contains(s);
  }

  /*
   * constructor
   * param name
   * param address
   * param nFloors
   * param hasDiningRoom
   */
  public House(String name, String address, Integer nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasElevator = hasElevator;
    this.hasDiningRoom = hasDiningRoom;
    residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /*
   * constructor
   * param name
   * param address
   * param nFloors
   * param hasDiningRoom
   */
  public House(String name, String address, Integer nFloors) {
    super(name, address, nFloors);
    this.hasElevator = false;
    this.hasDiningRoom = false;
    residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /*
   * constructor
   * param name
   * param address
   * param nFloors
   * param hasDiningRoom
   */
  public House(String name, String address, Integer nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = false;
    residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }
  /*
   * go to floor
   * param floorNum
   */
  @Override
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException(
          "You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (!hasElevator && Math.abs(floorNum - activeFloor) != 1) {
      throw new RuntimeException("Functionality not available, building does not have elevator!");
    }
    super.goToFloor(floorNum);
  }
  /*
   * main method
   */
  public static void main(String[] args) {
    House house = new House("Talbot House", "25 Prospect Street",4, true, true);
  }
  @Override
  public void showOptions() {
   super.showOptions();
   System.out.println(" + moveIn(s) \n + moveOut(s) \n + isResident(s) \n + hasDiningRoom()");
  }
}