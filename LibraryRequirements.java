import java.util.ArrayList;

interface LibraryRequirements {

    void addTitle(String title);
    void addTitle(ArrayList<String> title);
    String removeTitle(String title); 
    void removeTitle(ArrayList<String> title);
    void checkOut(String title);
    void returnBook(String title); 
    boolean containsTitle(String title);
    boolean isAvailable(String title);
    void printCollection(); 
}
