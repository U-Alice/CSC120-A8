import java.util.ArrayList;
public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * 
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * 
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " ("
                    + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        // Creating Building instances
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Alumnae Gym", "Main street", 3));
        myMap.addBuilding(new Building("Ainsworth Gym", "Green street", 3));
        myMap.addBuilding(new Building("Menden Hall", "Green street", 3));

        // Creating House instances
        House talbot = new House("Talbot House", "25 Prospect Street", 4);
        talbot.showOptions();
        House lamont = new House("Lamont", "23rd Prospect street", 4, true);
        House cutter = new House("Cutter/Ziskind", "Elm street", 4, true, true);
        House northropGillet = new House("Northrop/Gillet", "Elm street", 4, true, true);
        myMap.addBuilding(talbot);
        myMap.addBuilding(lamont);
        myMap.addBuilding(cutter);
        myMap.addBuilding(northropGillet);

        // Testing goToFloor method with and without elevator
        cutter.enter();
        cutter.goToFloor(2); // should work
        cutter.goToFloor(4); // should work because has elevator
        try{
            cutter.exit();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        lamont.enter();
        try {
            lamont.goToFloor(3); // should throw exception because no elevator
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        lamont.goToFloor(2); // should work
        lamont.goToFloor(1); // should work
        lamont.exit();
        
        // Testing movein and moveout methods
        Student student1 = new Student("A", "9912345", 2029);
        Student student2 = new Student("B", "9954321", 2028);
        Student student3 = new Student("C", "9987654", 2029);
        
        // calling moveIn for multiple students
        talbot.moveIn(new ArrayList<Student>(java.util.Arrays.asList(student1, student2)));
        // calling moveIn for a single student
        lamont.moveIn(student3);
        // calling moveOut for a single student
        lamont.moveOut(student3);
        // calling moveOut for all students
        talbot.moveOut();
        // Constructor called for cafe with all parameters
        Cafe campusCenterCafe = new Cafe(100, 100, 100, 100, "Campus Center Cafe", "1 Chapin Way", 4);
        campusCenterCafe.showOptions();
        // Constructor called for cafe with default nFloors (1) 
        Cafe compassCafe = new Cafe(100, 100, 100, 100, "Compass Cafe", "2 Chapin Way");
        myMap.addBuilding(compassCafe);
        myMap.addBuilding(campusCenterCafe);

        try {
            compassCafe.goToFloor(2); // should throw exception
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        //Testing sellCoffee
        campusCenterCafe.sellCoffee(12, 2, 2);
        compassCafe.sellCoffee(16);

        Library neilson = new Library("Neilson Library", "Chapin", 3, true);
        neilson.showOptions();
        myMap.addBuilding(neilson);
        neilson.addTitle("Alice in Wonderland");
        neilson.addTitle("The Book Thief");

        ArrayList<String> titles = new ArrayList<String>();
        titles.add("The Alchemist");
        titles.add("Purple Hibiscus");
        neilson.addTitle(titles);
        neilson.printCollection();

        System.out.println("Thank you for visiting the campus!");
    }

}
