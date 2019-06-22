package librarymanagement;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Paraskevas Paraskevas 1828
 * @author Xristos Badogias 1817
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Library UniversityLibrary = new Library(); //Dhmiourgia mias bibliothikhs gia tin apothikeush twn bibliwn
        UsersList KatalogosXrhstwn = new UsersList(); //Dmhmiourgia katalogou xrhstwn

        Scanner input = new Scanner(System.in);

        int option; //Metablhth gia tis epiloges tou xrhsth
        String userLend;
        boolean bool;

        //Dhmiourgia 5 bibliwn
        UniversityLibrary.createBook(123, "University physics", "Hugh D. Young", "Papazhsh", 1500, 
                "Einai eina biblio pou asxoleitai me th fusikh kai dinei bash sto nomo ths barhthtas ", true);
        UniversityLibrary.createBook(234, "Java Programming", "Deitel", "Giourdas", 1600, 
                "Tomos pou mas dixnei ta arxika bhmata programatismou se java kai thn dhmiourgia uml project", true);
        UniversityLibrary.createBook(345, "Texnhth Nohmosunh", "Iwannhs Blahabas", "Giourdas", 800, 
                "Asxoleitai me ta texnologika mesa pou dhmiourgounte kai dinei bash sth robotikh", true);
        UniversityLibrary.createBook(456, "Digital Design", "M. Morris Mano", "Papasotiriou", 700, 
                "Biblio pou mas milaei gia ta diktia kai thn epikoinwnia metaksh autwn,anafetetai sta arxika bhmata dhmiourgias enos diktiou", true);
        UniversityLibrary.createBook(567, "Computer Architecture", "Willian Stallings", "Tziola", 800, 
                "Mas bohtaei na katalaboume ta basika meroi enos upologisth kai pou xrhsimeuei to kathena", true);

        //Dhmiourgia 5 xrhstwn
        KatalogosXrhstwn.createUser("Paris", "Paraskeuas", "Paraskpp", "34737", "Student");
        KatalogosXrhstwn.createUser("Xristos", "Badogias", "Badogik", "23525", "Student");
        KatalogosXrhstwn.createUser("Grigoris", "Tsoumakas", "Greg", "12352", "Professor");
        KatalogosXrhstwn.createUser("Takhs", "Papadopoulos", "Pap", "12345", "Employee");
        KatalogosXrhstwn.createUser("Mpampis", "Anastasiadhs", "Anast", "12452", "Admin");

        //Eisodos sto susthma
        do {
            KatalogosXrhstwn.GiveUsername();
            KatalogosXrhstwn.GivePassword();
            bool = KatalogosXrhstwn.ElegxosEisodou();
        } while (bool == false);

        //Elegxos idiothtas

        //Admin
        if (KatalogosXrhstwn.abilityOfUser.equals("Admin")) {
            do {
                KatalogosXrhstwn.adminMenu();
                option = input.nextInt();
                input.nextLine();
                switch (option) {

                    case 0:
                        break;
                    case 1: {
                        KatalogosXrhstwn.showUserForAdmin();
                        break;
                    }
                    default: {
                        System.out.println("Lathos epilogh!");
                    }
                }
            } while (option != 0);

            //Employee
        } else if (KatalogosXrhstwn.abilityOfUser.equals("Employee")) {
            do {
                KatalogosXrhstwn.employeeMenu();
                option = input.nextInt();
                input.nextLine();
                switch (option) {

                    case 0:
                        break;
                    case 1: {
                        try {
                            UniversityLibrary.BookCreationFromUser();
                        } catch (InputMismatchException e) {
                            System.out.println("Lanthasmena Stoixeia!");
                        }
                        break;
                    }
                    case 2: {
                        UniversityLibrary.showBooksForUsers();
                        break;
                    }
                    case 3: {
                        System.out.print("Dwse to onoma xrhsth pou epithimei na daneistei to biblio: ");
                        userLend = input.nextLine();
                        KatalogosXrhstwn.ElegxosDaneismou(userLend);
                        try {
                            if (KatalogosXrhstwn.abilityOfLender.equals("Student") || KatalogosXrhstwn.abilityOfLender.equals("Professor")) {
                                UniversityLibrary.lendToUser(KatalogosXrhstwn.usernameToLend, KatalogosXrhstwn.abilityOfLender);
                            }
                        } catch (NullPointerException e) {
                            System.out.println("O xrhsths pou eisagate den mporei na daneistei biblia!");
                        }
                        break;
                    }
                    case 4: {
                        System.out.print("Dwse to onoma xrhsth pou epithimei na epistrepsei to biblio: ");
                        userLend = input.nextLine();
                        KatalogosXrhstwn.ElegxosDaneismou(userLend);
                        if (KatalogosXrhstwn.abilityOfLender.equals("Student") || KatalogosXrhstwn.abilityOfLender.equals("Professor")) {
                            UniversityLibrary.returnBook(KatalogosXrhstwn.usernameToLend, KatalogosXrhstwn.abilityOfLender);
                        } else {
                            System.out.println("O xrhsths pou eisagate den mporei na daneistei kai na epistrepsei biblia");
                        }
                        break;
                    }
                    case 5: {
                        UniversityLibrary.saveBooks();
                        break;
                    }
                    case 6: {
                        UniversityLibrary.loadBooks();
                        break;
                    }
                    default: {
                        System.out.println("Lathos epilogh!");
                    }
                }
            } while (option != 0);

            //Student or Professor
        } else if (KatalogosXrhstwn.abilityOfUser.equals("Student") || KatalogosXrhstwn.abilityOfUser.equals("Professor")) {
            do {
                KatalogosXrhstwn.studentMenu();
                option = input.nextInt();
                switch (option) {
                    case 0: 
                        break;
                    case 1: {
                        UniversityLibrary.showBooksForUsers();
                        break;
                    }
                    case 2: {
                        UniversityLibrary.bookSearch();
                        break;
                    }
                    case 3: {
                        UniversityLibrary.saveBooksToTxt();
                        break;
                    }
                    default: {
                        System.out.println("Lathos epilogh!");
                    }
                }
            } while (option != 0);
        }
    }
}
