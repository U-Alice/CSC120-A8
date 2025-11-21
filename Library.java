/* This is a stub for the Library class */

import java.util.ArrayList;
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {
    /* Class attributes */
    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;
    /*
     * constructor
     * param name
     * param address
     * param nFloors
     * param hasElevator
     */
    public Library(String name, String address, int nFloors, Boolean hasElevator) {
      super(name, address, nFloors);
      this.hasElevator = hasElevator;
      collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    /*
     * constructor
     * param name
     * param address
     * param nFloors
     * param hasElevator
     */
    public Library(String name, String address, Integer nFloors) {
      super(name, address, nFloors);
      this.hasElevator = false;
      collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }
    
    public static void main(String[] args) {
      Library library = new Library("Neilson Library", "Chapin", 3, false);
    }
    /*
     * adds a title to the collection
     * param title
     */
    public void addTitle(String title) {
      if(collection.get(title) != null){
        throw new RuntimeException("Title already exists, please update!");
      }
      collection.put(title, true);
    }
    
    /*
     * adds multiple titles to the collection
     * param title
     */
    public void addTitle(ArrayList<String> title) {
      if (collection.get(title) != null) {
        throw new RuntimeException("Title already exists, please update!");
      }
      title.forEach(t -> collection.put(t, true));
    }
    /*
     * removes a title from the collection
     * param title
     * return title
     */
    public String removeTitle(String title) {
      if(collection.get(title) == null){
        throw new RuntimeException("Title not found in collection!");
      }
      collection.remove(title);
      return title;
    }
    
    /*
     * removes multiple title from the collection
     * param title
     * return title
     */
    public void removeTitle(ArrayList<String> title) {
      title.forEach(t -> collection.put(t, false));
    }
    /*
     * checks out a title from the collection
     * param title
     */
    public void checkOut(String title) {
      if(!collection.get(title)){
        throw new RuntimeException("Book not available for checkout!");
      }
      collection.put(title, false);
    }

    /*
     * returns a book to the collection
     * param title
     */
    public void returnBook(String title) {
      collection.put(title, true);
    }
    /*
     * checks if the collection contains a title
     * param title
     * return boolean
     */
    public boolean containsTitle(String title) {
    return collection.containsKey(title);
    }
    /*
     * checks if a title is available
     * param title
     * return boolean
     */
    public boolean isAvailable(String title) {
     return collection.get(title);
    }
    /*
     * prints the collection
     */
    public void printCollection() {
      if(collection.size()!=0)
        System.out.println("Collection: " + collection);
      else 
        throw new RuntimeException("Collection is empty!");
    }
    /*
     * shows options
     */
    @Override
    public void showOptions(){
        super.showOptions();
        System.out.println(" + addTitle(title) \n + removeTitle(title) \n + containsTitle(title) \n + isAvailable(title)\n + printCollection() \n + checkOut(title) \n + returnBook(title)");
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
  }