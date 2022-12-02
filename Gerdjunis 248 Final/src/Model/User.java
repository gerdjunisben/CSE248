package Model;

public class User {
    private String username;
    private int saveID;

    

    public User(String username,  int saveID)
    {
        this.username = username;
        this.saveID = saveID;
    }

    public String getUsername()
    {
        return username;
    }

    public int getSaveID()
    {
        return saveID;
    }

    public String toString()
    {
        return username;
    }
}
