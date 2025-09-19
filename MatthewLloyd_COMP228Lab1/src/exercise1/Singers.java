package exercise1;

public class Singers {
    private int id;
    private String name;
    private String address;
    private String dateOfBirth;
    private int numberOfAlbums;

    // Default constructor
    public Singers(){
        this.id = 0;
        this.name = "";
        this.address = "";
        this.dateOfBirth = "";
        this.numberOfAlbums = 0;
    }

    // Parameterized constructor
    public Singers(int id, String name, String address, String dateOfBirth, int numberOfAlbums) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getNumberOfAlbums() {
        return numberOfAlbums;
    }
    public void setNumberOfAlbums(int numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }
    public void setSinger(int id, String name, String address, String dateOfBirth, int numberOfAlbums) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }

    // toString method
    @Override
    public String toString() {  
        return "ID: " + id + "\nName: " + name + "\nAddress: " + address + "\nDate of Birth: " + dateOfBirth
                + "\n# of Albums: " + numberOfAlbums + "\n";
    }
}
