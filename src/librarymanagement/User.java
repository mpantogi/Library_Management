

package librarymanagement;

/**
 * Klash pou periexei ta stoixeia twn xrhstwn
 * @@author Paraskevas Paraskevas 1828
 * @author Xristos Badogias 1817
 */
public class User {
    protected String name,surname,username,password,ability;
   

    /**
     * 
     * @param name
     * @param surname
     * @param username
     * @param password
     * @param ability
     */
    public User(String name,String surname,String username,String password,String ability){
        this.name=name;
        this.surname=surname;
        this.username=username;
        this.password=password;
        this.ability=ability;

    }

    /**
     * 
     * @return
     */
    public String getAbility() {
        return ability;
    }

    /**
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @return
     */
    public String getUsername() {
        return username;
    }
   

    
    /**
     * Methodos ektupwshs olwn twn xthstwn gia ton Admin
     * @return
     */
    public String AdminView()
    {
        String details = "Onoma: "+name+"\nEpwnumo: "+surname+"\nUsername: "
                +username+"\nPassword: "+password+"\nAbility: "+ability+"\n";
        return details;
    }
}