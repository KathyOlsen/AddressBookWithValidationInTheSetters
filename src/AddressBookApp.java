import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookApp {
    public static void main(String[] args) {

        getNewAddressBook();

        System.out.println("Goodbye!");
    }

    public static void getNewAddressBook(){
        Scanner key = new Scanner(System.in);
        ArrayList<AddressBook> aBooks = new ArrayList<>();
        String again = "yes";

        while(again.equalsIgnoreCase("yes")) {
            AddressBook aBook = new AddressBook();

            System.out.println("Please enter your name (e.g., John Q. Adams): ");
            aBook.setName(key.nextLine());

            System.out.println("Please enter your street address and apartment number, if any " +
                    "(e.g., 123 Oak St. #4)" );
            aBook.setAddress(key.nextLine());

            System.out.println("Please enter your city: ");
            aBook.setCity(key.nextLine());

            System.out.println("Please enter your state (e.g., NY): ");
            aBook.setState(key.nextLine());

            System.out.println("Please enter your zip code: ");
            aBook.setZip(key.nextLine());

            String againPhone = "yes";
            while (againPhone.equalsIgnoreCase("yes")) {
                System.out.println("Please enter your phone number in the format (xxx) xxx-xxxx: ");
                String phone = key.nextLine();
                aBook.setPhone(phone);
                if (aBook.setPhone(phone)) {
                    againPhone = "no";
                }else{
                    System.out.println("Invalid response.  Please try again.");
                }
            }

            String againEmail = "yes";
            while (againEmail.equalsIgnoreCase("yes")) {
                System.out.println("Please enter your email in the format xxxxx@xxxxx.xxx: ");
                String e = key.nextLine();
                aBook.setEmail(e);
                if (aBook.setEmail(e)) {
                    againEmail = "no";
                }else{
                    System.out.println("Invalid response.  Please try again.");
                }
            }

            aBooks.add(aBook);

            System.out.println("Here is what you have entered:\n" + formatAddressBook(aBook));
            System.out.println("Would you like to enter another person? (yes/no)");
            again = key.next();
            key.nextLine();
            if (!again.equalsIgnoreCase("yes")){
                if (aBooks.size() ==1){
                    System.out.println("There is one person in your address book:\n" + aBook.getName());
                }else{
                    System.out.println("There are " + aBooks.size() + " people in your address book:");
                    aBooks.stream().map(AddressBook::getName).forEach(System.out::println);
                }
            }
        }
    }

    public static String formatAddressBook(AddressBook addressBook){
        String s = addressBook.getName() + "\n" +
                addressBook.getAddress() + "\n" +
                addressBook.getCity() + ", " + addressBook.getState() + " " + addressBook.getZip() + "\n" +
                addressBook.getPhoneNumber() + "\n" +
                addressBook.getEmail() + "\n";
        return s;
    }
}
