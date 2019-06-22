package librarymanagement;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * Klash gia tin apothikeush twn bibliwn se ena arrayList
 * @author Paraskevas Paraskevas 1828
 * @author Xristos Badogias 1817
 */
public class Library {

    Scanner input = new Scanner(System.in);
    private ArrayList<Book> books;

    /**
     * 
     */
    public Library() {
        books = new ArrayList<Book>();
    }

    /**
     * Methodos gia tin dhmiourgia enos neou bibliou
     * @param id
     * @param title
     * @param author
     * @param oikos
     * @param pages
     * @param summary
     * @param availability
     */
    public void createBook(int id, String title, String author, String oikos, int pages, String summary, boolean availability) {
        books.add(new Book(id, title, author, oikos, pages, summary, availability, 0, null, null));
    }

    /**
     * Methodos gia tin dhmiourgia bibliou apo ton employee
     */
    public void BookCreationFromUser() {

        String title, author, oikos, summary;
        int id, pages;
        boolean availability = true;
        System.out.print("Parakalw eisagete ton kodiko tou bibliou: ");
        id = input.nextInt();
        input.nextLine();
        System.out.print("Parakalw eisagete ton titlo tou bibliou: ");
        title = input.nextLine();
        System.out.print("Parakalw eisagete ton suggrafea tou bibliou: ");
        author = input.nextLine();
        System.out.print("Parakalw eisagete ton ekdotiko oiko tou bibliou: ");
        oikos = input.nextLine();
        System.out.print("Parakalw eisagete ton arithmo selidwn tou bibliou: ");
        pages = input.nextInt();
        input.nextLine();
        System.out.print("Parakalw eisagete mia perilhpsh tou bibliou: ");
        summary = input.nextLine();
        createBook(id, title, author, oikos, pages, summary, availability);
    }

    /**
     * Methodos gia ektupwsh twn bibliwn gia kathightes kai foithtes
     */
    public void showBooksFromSearch() {
        for (Book book : books) {
            System.out.println(book.SearchView());
        }
    }

    /**
     * Methodos gia ektupwsh twn bibliwn gia upallhlous
     */
    public void showBooksForUsers() {
        for (Book book : books) {
            System.out.println(book.UserView());
            System.out.println("Lista anamonhs: " + book.getLends());
        }
    }

    /**
     * Basikh methodos gia to daneismo bibliwn
     * @param usernameToLend
     * @param abilityOfLender
     */
    public void lendToUser(String usernameToLend, String abilityOfLender) {
        int bookCode;
        boolean foundBook = false;

        System.out.print("Dwse ton kwdiko tou bibliou pros daneismo: ");

        bookCode = input.nextInt();

        for (Book book : books) {
            if (bookCode == book.getID()) {
                foundBook = true;
                if (book.getAvailability() == true) {
                    if (abilityOfLender.equals("Student")) {
                        System.out.println("Parakalw paralabete to biblio sas");
                        book.addWaitingLine(15);
                        book.setAvailability(false);
                        book.setLendedBy(usernameToLend);
                    } else if (abilityOfLender.equals("Professor")) {
                        System.out.println("Parakalw paralabete to biblio sas");
                        book.addWaitingLine(30);
                        book.setAvailability(false);
                        book.setLendedBy(usernameToLend);
                    }
                } else {
                    if (book.getLends().size() != 0) {
                        if (book.getLends().get(0).equals(usernameToLend)) {
                            if (abilityOfLender.equals("Student")) {
                                System.out.println("Parakalw paralabete to biblio sas");
                                book.setAvailability(false);
                                book.setLendedBy(usernameToLend);
                                book.getLends().remove(0);
                            } else if (abilityOfLender.equals("Professor")) {
                                System.out.println("Parakalw paralabete to biblio sas");
                                book.setAvailability(false);
                                book.setLendedBy(usernameToLend);
                                book.getLends().remove(0);
                            }
                        } else {
                            book.setWaitingLineAndLenders(abilityOfLender, usernameToLend);

                        }
                    } else {
                        book.setWaitingLineAndLenders(abilityOfLender, usernameToLend);
                    }
                }
                break;


            }

        }
        if (foundBook == false) {
            System.out.println("O kodikos bibliou pou pliktrologhsate den uparxei");
        }
    }

    /**
     * Basikh methodos gia thn epistrofh bibliwn
     * @param usernameToLend
     * @param abilityOfLender
     */
    public void returnBook(String usernameToLend, String abilityOfLender) {
        int bookCode;
        boolean foundBook = false;
        System.out.print("Dwse ton kwdiko tou bibliou pros epistrofh: ");
        bookCode = input.nextInt();
        for (Book book : books) {
            if (bookCode == book.getID()) {
                foundBook = true;
                if (book.getAvailability() == false) {
                    if (book.getLendedBy().equals(usernameToLend)) {
                        book.removeWaitingLine(usernameToLend, abilityOfLender);
                    if (book.getLends().size() == 0) {
                        book.setAvailability(true);
                    }
                    }else
                        System.out.println("O xrhsths pou pliktrologsate den exei to biblio");
                    
                } else {
                    System.out.println("To biblio einai hdh diathesimo kai den mporei na epistrafei");
                }
            }
        }
        if (foundBook == false) {
            System.out.println("O kodikos bibliou pou pliktrologhsate den uparxei");
        }

    }

    /**
     * Methodos anazhthshs bibliwn
     */
    public void bookSearch() {
        String keywords;
        int count = 0;
        System.out.print("Dwse tis lekseis kleidia gia anazhthsh xwrismenes me keno: ");
        keywords = input.nextLine();
        String[] tokens = keywords.split(" ");
        System.out.println("Apotelesmata anazhthshs:\n");
        for (Book book : books) {
            boolean foundBook = false;
            String[] tokensTitle = book.getTitle().split(" ");
            String[] tokensSummary = book.getSummary().split(" ");
            for (String token2 : tokensTitle) {

                for (String token : tokens) {
                    if ((token.toLowerCase()).equals(token2.toLowerCase())) {

                        foundBook = true;
                    }
                }
            }
            for (String token2 : tokensSummary) {

                for (String token : tokens) {
                    if ((token.toLowerCase()).equals(token2.toLowerCase())) {
                        foundBook = true;
                    }
                }
            }
            if (foundBook == true) {
                System.out.println(book.SearchView());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Den brethikan biblia pou na tairiazoun me ta krithria anazhthshs");
        }
    }

    /**
     * Methodos gia apothikeush twn bibliwn sto disko
     */
    public void saveBooks() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("books.dat"));
            out.writeObject(books);
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Methodos gia fortwsh twn bibliwn apo to disko
     */
    public void loadBooks() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("books.dat"));
            books = (ArrayList<Book>) in.readObject();
            in.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Methodos gia apothikeush twn bibliwn sto disko se morfh keimenou
     */
    public void saveBooksToTxt() {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("books-keimeno.txt")));
            for (Book book : books) {
                pw.print(book.UserView());
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
