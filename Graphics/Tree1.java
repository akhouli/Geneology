package Graphics;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;

public class Tree1
{

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty birthday;
    private final SimpleStringProperty treeName;
    private final SimpleStringProperty biography;

    Tree1(String fName, String lName,String bday, String tName, String bio)
    {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.birthday = new SimpleStringProperty(bday);
        this.treeName = new SimpleStringProperty(tName);
        this.biography = new SimpleStringProperty(bio);
    }
    public String getFirstName()
    {
        return firstName.get();
    }

    public void setFirstName(String fName)
    {
        firstName.set(fName);
    }

    public String getLastName()
    {
        return lastName.get();
    }

    public void setLastName(String fName)
    {
        lastName.set(fName);
    }
    public String getBirthday()
    {
        return birthday.get();
    }

    public void setBirthday(String fName)
    {
    	birthday.set(fName);
    }
    public String getTreeName()
    {
        return treeName.get();
    }

    public void setTree(String fName)
    {
    	treeName.set(fName);
    }
    public String getBio()
    {
        return biography.get();
    }

    public void setBio(String fName)
    {
    	biography.set(fName);
    }
}



