package librarymanagement;


import java.util.ArrayList;
import java.io.Serializable;

/**
 * Klash gia ta periexomena tou kathe bibliou
 * @author Paraskevas Paraskevas 1828
 * @author Xristos Badogias 1817
 */
public class Book implements Serializable{

    private String title, author, oikos, summary,lendedBy;
    private int id, pages;
    private boolean availability;
    private int waitingLine;
    /**
     * 
     */
    protected ArrayList<String> lends = new ArrayList<String>();

    /**
     * 
     * @param id
     * @param title
     * @param author
     * @param oikos
     * @param pages
     * @param summary
     * @param availability
     * @param waitingLine
     * @param lends
     */
    public Book(int id, String title, String author, String oikos, int pages, String summary,
            boolean availability, int waitingLine, ArrayList waitingToLend, String lendedBy) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.oikos = oikos;
        this.summary = summary;
        this.pages = pages;
        this.availability = availability;

    }


    /**
     * Methodos ektupwshs bibliwn mesw anazhthshs
     * @return
     */
    public String SearchView() {
        String details = "Kodikos:" + id + "\nTitlos: " + title + "\nPerilhpsh: " + summary + "\n";
        return details;
    }


    /**
     * Methodos ektupwshs gia upallhlous, foithtes kai kathightes
     * @return
     */
    public String UserView() {
        String details = "\nKodikos:" + id + "\nTitlos: " + title + "\nSuggrafeas: "
                + author + "\nSelides: " + pages + "\nDiathesimothta: " + availability
                + "\nMeres anamonhs: " + waitingLine+ showLenderOfBook();
        return details;
    }
    public String showLenderOfBook(){
        String s;
        if (lendedBy==null){
            s="\nTo biblio einai eleuthero";
            return s;
        }else{
            s="\nTo biblio to exei o: " + lendedBy;
            return s;
        }     
    }
        

    /**
     * 
     * @return
     */
    public int getID() {
        return id;
    }

    /**
     * 
     * @return
     */
    public boolean getAvailability() {
        return availability;
    }

    /**
     * 
     * @return
     */
    public ArrayList<String> getLends() {
        return lends;
    }

    /**
     * 
     * @return
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param availability
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * 
     * @param username
     */
    public void addToLendList(String username) {
        lends.add(username);
    }

    /**
     * 
     * @param daysOfLend
     */
    public void addWaitingLine(int daysOfLend) {
        this.waitingLine = waitingLine + daysOfLend;
    }

    /**
     * 
     * @param daysOfLend
     */
    public void decreaseWaitingLine(int daysOfLend) {
        this.waitingLine = waitingLine - daysOfLend;
    }

    /**
     * Methodos gia prosthesh sth listas anamonhs
     * @param abilityOfLender
     * @param usernameToLend
     */
    public void setWaitingLineAndLenders(String abilityOfLender, String usernameToLend) {
        if (abilityOfLender.equals("Student")) {
            System.out.println("O xrhsths mpike stin oura anamonhs1");
            addWaitingLine(15);
            addToLendList(usernameToLend);
        } else if (abilityOfLender.equals("Professor")) {
            System.out.println("O xrhsths mpike stin oura anamonhs2");
            addWaitingLine(30);
            addToLendList(usernameToLend);
        }
    }

    /**
     * Methodos gia afairesh apo tin lista anamonhs
     * @param usernameToLend
     * @param abilityOfLender
     */
    public void removeWaitingLine(String usernameToLend, String abilityOfLender) {
        if (abilityOfLender.equals("Student")) {
            System.out.println("To biblio epistrafhke");
            decreaseWaitingLine(15);
        } else if (abilityOfLender.equals("Professor")) {
            System.out.println("To biblio epistrafhke");
            decreaseWaitingLine(30);
        }
    }

    public String getLendedBy() {
        return lendedBy;
    }

    public void setLendedBy(String lendedBy) {
        this.lendedBy = lendedBy;
    }
}
