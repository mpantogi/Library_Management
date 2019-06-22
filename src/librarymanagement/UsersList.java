package librarymanagement;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Klash gia tin apothikeush twn xrhstwn se ena arrayList kai ton elegxo stoixeiwn kata tin eisodo
 * @author Paraskevas Paraskevas 1828
 * @author Xristos Badogias 1817
 */
public class UsersList {

    private ArrayList<User> users;
    private String username1, password1;
    protected String abilityOfUser, usernameToLend, abilityOfLender;
    Scanner input = new Scanner(System.in);

    
    public UsersList() {
        users = new ArrayList<User>();
    }

    /**
     * 
     * @return
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    
    /**
     * Methodos gia th dhmiourgia xrhstwn
     * @param name
     * @param surname
     * @param username
     * @param password
     * @param ability
     */
    public void createUser(String name, String surname, String username, String password, String ability) {
        users.add(new User(name, surname, username, password, ability));
    }

    
    /**
     * Methodos gia ektupwsh xrhstwn gia ton Admin
     */
    public void showUserForAdmin() {
        for (User user : users) {
            System.out.println(user.AdminView());
        }
    }

    /**
     * Methodos gia tin eisodo username
     */
    public void GiveUsername() {
        System.out.print("Give Username: ");
        username1 = input.nextLine();

    }

    /**
     * Methodos gia tin eisodo kodikou
     */
    public void GivePassword() {
        System.out.print("Give Password: ");
        password1 = input.nextLine();
    }

    
    /**
     * Methodos gia ton elegxo eisodou sto systhma
     * @return
     */
    public boolean ElegxosEisodou() {
        boolean FoundUser = false;
        for (User user : users) {
            if (username1.toLowerCase().equals(user.getUsername().toLowerCase())
                    && (password1.toLowerCase().equals(user.getPassword().toLowerCase()))) {
                FoundUser = true;
                System.out.println("Anhkete stin idiothta: " + user.ability + "\n");
                abilityOfUser = user.ability;
            }
        }
        if (FoundUser == false) {
            System.out.println("Lathos username h kodikos!");
            return false;
        } else {
            return true;
        }
    }

    
    /**
     * Methodos gia ton elegxo stoixeiwn gia daneismo
     * @param username
     */
    public void ElegxosDaneismou(String username) {
        for (User user : users) {
            if (username.toLowerCase().equals(user.getUsername().toLowerCase())) {
                abilityOfLender = user.ability;
                usernameToLend = user.username;
            }

        }
    }

    /**
     *
     * @return
     */
    public String ReturnAbility() {
        return abilityOfUser;
    }

    /**
     * Menu epilogwn gia tous upallhlous
     */
    public void employeeMenu() {
        System.out.print("\nEmployee Menu\n"
                + "0 gia exodo apo tin efarmogh\n"
                + "1 gia dhmiourgia neou bibliou\n"
                + "2 gia emfanish ths listas twn bibliwn\n"
                + "3 gia daneismo kapoiou bibliou\n"
                + "4 gia epistrofh kapoiou bibliou\n"
                + "5 gia apothikeush twn bibliwn sto disko\n"
                + "6 gia fortwsh twn bibliwn apo to disko\n"
                + "Parakalw pliktrologhste enan arithmo gia tin epilogh sas: ");
    }

    /**
     * Menu epilogwn gia tous foithtes kai kathightes
     */
    public void studentMenu() {
        System.out.print("\nStudents & Professors Menu\n"
                + "0 gia exodo apo tin efarmogh\n"
                + "1 gia emfanish ths listas twn bibliwn\n"
                + "2 gia anazhthsh enos bibliou\n"
                + "3 gia apothikeush twn bibliwn se morfh keimenou\n"
                + "Parakalw pliktrologhste enan arithmo gia tin epilogh sas: ");
    }
    /**
     * Menu epilogwn gia tous diaxeiristes
     */
    public void adminMenu() {
        System.out.print("\nAdmin Menu\n"
                + "0 gia exodo apo tin efarmogh\n"
                + "1 gia emfanish ths listas xrhstwn\n"
                + "Parakalw pliktrologhste enan arithmo gia tin epilogh sas: ");
    }
}
