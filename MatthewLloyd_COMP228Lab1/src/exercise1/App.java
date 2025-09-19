package exercise1;
public class App {
    public static void main(String[] args) throws Exception {
        Singers singer1 = new Singers();

        System.out.println(singer1.toString());

        singer1.setSinger(1, "Matthew Lloyd", "123 Main St", "2001-04-26", 5);

        System.out.println(singer1.toString());

        singer1.setId(2);
        singer1.setName("John Doe");
        singer1.setAddress("456 Elm St");
        singer1.setDateOfBirth("1990-01-01");
        singer1.setNumberOfAlbums(10);

        //The exercise asked to use getters for each field to print the details so I did not use the toString method here
        System.out.println("ID: " + singer1.getId());
        System.out.println("Name: " + singer1.getName());
        System.out.println("Address: " + singer1.getAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("# of Albums: " + singer1.getNumberOfAlbums());
    }
}
