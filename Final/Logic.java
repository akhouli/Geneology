package Final;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Logic {
	
	private int id;
	private String firstname;
	private String lastname;
	private boolean male;
	private String birthdate;
	private String birthplace;
	private String deathdate;
	private String deathplace;
	private String biography;
	private Logic father;
	private Logic mother;
	private Logic spouse;
	private ArrayList<Logic> children;
	private int familyID;
	private int treeLevel;
	private double xpos = 0;
	private int noNo;
	private double ypos;
	
	
	public Logic() {
		
	}
	public Logic(int familyID) {
		this.familyID = familyID;
	}
	
	public Logic(String firstname, String lastname, int familyID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.familyID = familyID;
	}
	
	public Logic(int id, int familyID, String firstname, String lastname, boolean male, String birthdate, String birthplace) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.male = male;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.familyID = familyID;
	}
	
	public Logic(String firstname, String lastname, boolean male, String birthdate, String birthplace, int familyID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.male = male;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.familyID = familyID;
	}
	
	public Logic(int pid, int familyID, String firstname, String lastname, boolean male, String birthdate, String birthplace, String deathdate, String deathplace, String bio) {
		this.id = pid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.male = male;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.familyID = familyID;
		this.deathdate = deathdate;
		this.deathplace = deathplace;
		this.biography = bio;
	}
	public Logic(int pid, int familyID, String firstname, String lastname, boolean male, String birthdate, String birthplace, String bio) {
		this.id = pid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.male = male;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.familyID = familyID;
		this.biography = bio;
	}
	public Logic(int pid, int familyID, String firstname, String lastname, boolean male, String birthdate, String birthplace, Date deathdate, String bio) {
		this.id = pid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.male = male;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.familyID = familyID;
		this.deathdate = deathdate.toString();
		this.biography = bio;
	}
	public Logic(int pid, int familyID, String firstname, String lastname, boolean male, String birthdate, String birthplace, String deathplace, String bio) {
		this.id = pid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.male = male;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.familyID = familyID;
		this.deathplace = deathplace;
		this.biography = bio;
	}
	
	/**
	 * setters
	 * @param newName
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	public void setFirstname(String newName) {
		firstname = newName;
	}
	
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	
	public void setMale(boolean male) {
		this.male = male;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public void setBirthPlace(String birthplace) {
		this.birthplace = birthplace;
	}
	
	public void setDeathDate(String deathdate) {
		this.deathdate = deathdate;
	}
	
	public void setDeathPlace(String deathplace) {
		this.deathplace = deathplace;
	}
	
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public void setFather(Logic father) {
		this.father = father;
	}
	
	public void setMother(Logic mother) {
		this.mother = mother;
	}
	
	public void setSpouse(Logic spouse) {
		this.spouse = spouse;
	}
	
	public void setChildren(ArrayList<Logic> children) {
		this.children = children;
	}
	
	public void setFamilyID(int familyid) {
		familyID = familyid;
	}
	
	public void setTreeLevel(int treeLevel) {
		this.treeLevel = treeLevel;
	}
	
	public void setXPos(double xpos) {
		this.xpos = xpos;
	}
	
	public void setNoNo(int noNo) {
		this.noNo = noNo;
	}
	
	public void setYPos(double ypos) {
		this.ypos = ypos;
	}
	
	/**
	 * Getters
	 * @return
	 */
	public int getID() {
		return id;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public boolean getMale() {
		return male;
	}
	
	public String getBirthDate() {
		return birthdate;
	}
	
	public String getBirthPlace() {
		return birthplace;
	}
	
	public String getDeathDate() {
		return deathdate;
	}
	
	public String getDeathPlace() {
		return deathplace;
	}
	
	public String getBiography() {
		return biography;
	}
	
	public Logic getFather() {
		return father;
	}
	
	public Logic getMother() {
		return mother;
	}
	
	public Logic getSpouse() {
		return spouse;
	}
	
	public ArrayList<Logic> getChildren() {
		return children;
	}
	
	public int getFamilyID() {
		return familyID;
	}
	
	public int getTreeLevel() {
		return treeLevel;
	}
	
	public double getXPos() {
		return xpos;
	}
	
	public int getNoNo() {
		return noNo;
	}
	
	public double getYPos() {
		return ypos;
	}
	
	/**
	 * deleteParent() should be called for nodes which have children so that they remain dummy nodes
	 */
	public void deleteParent() {
		setFirstname(null);
		setLastname(null);
		setBirthdate(null);
		setBirthPlace(null);
		setBiography(null);
		setDeathDate(null);
		setDeathPlace(null);
	}
	
	/**
	 * delete() should be used for any nodes without children
	 */
	public void delete() {
		if(father != null) {
			father.getChildren().remove(this);
		}
		if(mother != null) {
			mother.getChildren().remove(this);
		}
		if(spouse != null) {
			spouse.setSpouse(null);
		}
	}
	
	/**
	 * Adds a spouse to an existing node. Also copies the children to the spouse
	 * @param spouse
	 */
	public void addSpouse(Logic spouse) {
		setSpouse(spouse);
		getSpouse().setSpouse(this);
		getSpouse().setTreeLevel(getTreeLevel());
		if(children != null) {
			getSpouse().setChildren(getChildren());
			if(getSpouse().male) {
				for(Logic t: children) {
					t.setFather(getSpouse());
				}
			}
			else {
				for(Logic t: children) {
					t.setMother(getSpouse());
				}
			}
		}
	}
	
	/**
	 * addChild() adds a child node. Also updates the child pointer to the current node and checks if there is a spouse to be updated.
	 * @param child
	 */
	public void addChild(Logic child) {
		child.setTreeLevel(getTreeLevel()+1);
		ArrayList<Logic> childlist = new ArrayList<>();
		if(getChildren() != null) {
		childlist.addAll(getChildren());
		}
		childlist.add(child);
		setChildren(childlist);
		if(getSpouse()!= null) {
			getSpouse().setChildren(childlist);
			if(getSpouse().getMale()) {
				child.setFather(getSpouse());
			}
			else {
				child.setMother(getSpouse());
			}
		}
		if(this.male) {
			child.setFather(this);
		}
		else {
			child.setMother(this);
		}
		
	}
	
	/**
	 * addParent() adds a parent node to an existing node. Also checks if there is another parent which is set as spouse and if there are other children of the potential spouse.
	 * @param parent
	 */
	public void addParent(Logic parent) {
		parent.setTreeLevel(getTreeLevel()-1);
		if(parent.getMale()) {
			if(getFather() != null) {
				if(getFather().getFirstName() == null && getFather().getChildren() != null) {
					ArrayList<Logic> childrenlist = new ArrayList<>();
					for(Logic t: getFather().getChildren()) {
						childrenlist.add(t);
					}
					childrenlist.add(this);
					HashSet<Logic> uniques = new HashSet<>(childrenlist);
					for(Logic t : uniques) {
						parent.addChild(t);
					}
				}
			}
			else {
				parent.addChild(this);
			}
			setFather(parent);
			if(getMother() != null) {
				getMother().setSpouse(parent);
				parent.setSpouse(getMother());
			}
		}
		else {
			setMother(parent);
			parent.addChild(this);
			if(getFather() != null) {
				getFather().setSpouse(parent);
				parent.setSpouse(getFather());
				HashSet<Logic> uniques = new HashSet<>(parent.getSpouse().getChildren());
				for(Logic t : uniques) {
					parent.addChild(t);
				}
			}			
		}
	}
	
	/**
	 * addSibling() adds a sibling to an existing node. If the node has one or more parents, the sibling is added to their children lists and the pointers
	 * are updated. If there is no known parent, a dummy node is introduced in the place of the father.
	 * @param sibling
	 */
	public void addSibling(Logic sibling) {
		if(getFather() != null) {
			if(getFather().getChildren() != null) {
				getFather().addChild(sibling);
			}
		}
		else if(getMother() != null) {
			if(getMother().getChildren() != null) {
				getMother().addChild(sibling);
			}
		}
		if(getFather() == null && getMother() == null) {
			Logic dummyparent = new Logic(getFamilyID());
			setFather(dummyparent);
			sibling.setFather(dummyparent);
			dummyparent.addChild(this);
			dummyparent.addChild(sibling);
		}
	}
	
	/**
	 * toString() defines what the printout should look like
	 */
	public String toString() {
		String out = getFirstName() + " " + getLastName() + ", born " + getBirthDate() + ", " + getBirthPlace();
		if(getDeathDate() != null && getDeathPlace() != null) {
			out += "\nDied on " + getDeathDate() + " in " + getDeathPlace();
		}
		if(getFather() != null && getMother() != null) {
			if(getFather().getFirstName() == null) {
					out += "\nChild of " + getMother().getFirstName();
				}
			if(getMother().getFirstName() == null) {
				out += "\nChild of " + getFather().getFirstName();
			}
			else{
				out += "\nChild of " + getMother().getFirstName() + " and " + getFather().getFirstName();
			}
		}
		else if(getFather() == null && getMother() != null) {
			out += "\nChild of " + getMother().getFirstName();
		}
		else if(getFather() != null && getMother() == null) {
			if(getFather().getFirstName() != null) {
				out += "\nChild of " + getFather().getFirstName();
			}
		}
		if(getSpouse() != null) {
			if(getSpouse().getFirstName() != null) {
				out += "\nSpouse of " + spouse.getFirstName();
			}
		}
		if(getChildren() != null && getMale()) {
			out += "\nFather of ";
			for(int i = 0; i<getChildren().size()-1; i++) {
				if(getChildren().get(i).getFirstName() != null) {
					out += getChildren().get(i).getFirstName() + ", ";
				}
			}
			out += getChildren().get(getChildren().size()-1).getFirstName();
		}
		else if (getChildren() != null) {
			out += "\nMother of ";
			for(int i = 0; i<getChildren().size()-1; i++) {
				if(getChildren().get(i).getFirstName() != null) {
					out += getChildren().get(i).getFirstName() + ", ";
				}
			}
			out += getChildren().get(getChildren().size()-1).getFirstName();
		}
		if(getBiography() != null) {
			out += "\nBiography: " + getBiography();
		}
		return out;
	}
	
//	public static void main(String[] args) {
//		Logic Lilly = new Logic("Lilly", "Schwarzenbach", false, "19-11-1995", "Riggisberg", 1);
//		Logic Felix = new Logic("Felix", "Schwarzenbach", true, "17-02-1959", "W�denswil", 1);
//		Logic Susanna = new Logic("Susanna", "Schwarzenbach", false, "30-06-1963", "Bern", 1);
//		Logic Fanny = new Logic("Fanny", "Schwarzenbach", false, "04-05-1995", "Jegenstorf", 1);
//		Logic Fritz = new Logic("Fritz", "Schwarzenbach", true, "21-10-1925", "Z�rich", 1, "09-06-2018", "Bern");
//		Logic Hedi = new Logic("Hedi", "Schwarzenbach", false, "21-11-1925", "W�denswil", 1, "12-04-1973", "Davos");
//		Logic Hans = new Logic("Hans", "Moser", true, "16-03-1931", "Krauchthal", 1, "14-08-2015", "B�riswil");
//		Logic K�thi = new Logic("K�thi", "Moser", false, "21-03-1936", "Hindelbank", 1);
//		Logic Hasi = new Logic("Hasi", "Schwarzenbach", true, "31-07-1953", "W�denswil", 1);
//		Logic Heidi = new Logic("Heidi", "St�hli", false, "31-07-1955", "W�denswil", 1);
//		
//		System.out.println(Felix);
//		System.out.println("\n------------------Adding Child: Lilly-------------------");
//
//		Felix.addChild(Lilly);
//		
//		System.out.println(Felix);
//		System.out.println();
//		System.out.println(Lilly);
//		
//		System.out.println("\n------------------Adding Spouse: Susanna-------------------");
//		Felix.addSpouse(Susanna);
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		
//
//		System.out.println("\n------------------Adding Child: Fanny-------------------");
//		Susanna.addChild(Fanny);
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		
//		System.out.println("\n------------------Adding Sister: Heidi-------------------");
//		Felix.addSibling(Heidi);
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		System.out.println("\n" + Heidi);
//		
//
//		System.out.println("\n------------------Adding Father: Fritz-------------------");
//		Felix.addParent(Fritz);
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		System.out.println("\n" + Heidi);
//		System.out.println("\n" + Fritz);
//		
//		
//		System.out.println("\n------------------Adding Mother: Hedi-------------------");
//		Felix.addParent(Hedi);
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		System.out.println("\n" + Heidi);
//		System.out.println("\n" + Fritz);
//		System.out.println("\n" + Hedi);
//		
//		System.out.println("\n------------------Adding Brother: Hasi-------------------");
//		Felix.addSibling(Hasi);
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		System.out.println("\n" + Fritz);
//		System.out.println("\n" + Hedi);
//		System.out.println("\n" + Hasi);
//
//		System.out.println("\n------------------Adding Father: Hans-------------------");
//		Susanna.addParent(Hans);
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		System.out.println("\n" + Heidi);
//		System.out.println("\n" + Fritz);
//		System.out.println("\n" + Hedi);
//		System.out.println("\n" + Hasi);
//		System.out.println("\n" + Hans);
//
//		System.out.println("\n------------------Adding Mother: K�thi-------------------");
//		Susanna.addParent(K�thi);
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		System.out.println("\n" + Heidi);
//		System.out.println("\n" + Fritz);
//		System.out.println("\n" + Hedi);
//		System.out.println("\n" + Hasi);
//		System.out.println("\n" + Hans);
//		System.out.println("\n" + K�thi);
//		
//		System.out.println("\n------------------Deleting Child: Hasi-------------------");
//		Hasi.delete();
//		System.out.println(Felix);
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		System.out.println("\n" + Heidi);
//		System.out.println("\n" + Fritz);
//		System.out.println("\n" + Hedi);
//		System.out.println("\n" + Hasi);
//		System.out.println("\n" + Hans);
//		System.out.println("\n" + K�thi);
//		
//		System.out.println("\n------------------Deleting Parent: Felix-------------------");
//		Felix.deleteParent();
//		System.out.println("\n" + Lilly);
//		System.out.println("\n" + Susanna);
//		System.out.println("\n" + Fanny);
//		System.out.println("\n" + Heidi);
//		System.out.println("\n" + Fritz);
//		System.out.println("\n" + Hedi);
//		System.out.println("\n" + Hasi);
//		System.out.println("\n" + Hans);
//		System.out.println("\n" + K�thi);
//		
//		
////		System.out.println("\n" + Hedi.getChildren());
//		
//	}
//
}
