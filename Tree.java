import java.util.ArrayList;
import java.util.HashSet;

public class Tree {
	
	private String firstname;
	private String lastname;
	private boolean male;
	private String birthdate;
	private String birthplace;
	private String deathdate;
	private String deathplace;
	private String biography;
	private Tree father;
	private Tree mother;
	private Tree spouse;
	private ArrayList<Tree> children;
	private int familyID;
	
	public Tree(int familyID) {
		this.familyID = familyID;
	}
	public Tree(String firstname, String lastname, boolean male, String birthdate, String birthplace, int familyID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.male = male;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.familyID = familyID;
	}
	
	public Tree(String firstname, String lastname, boolean male, String birthdate, String birthplace, int familyID, String deathdate, String deathplace) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.male = male;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.familyID = familyID;
		this.deathdate = deathdate;
		this.deathplace = deathplace;
	}
	
	/**
	 * setters
	 * @param newName
	 */
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
	
	public void setFather(Tree father) {
		this.father = father;
	}
	
	public void setMother(Tree mother) {
		this.mother = mother;
	}
	
	public void setSpouse(Tree spouse) {
		this.spouse = spouse;
	}
	
	public void setChildren(ArrayList<Tree> children) {
		this.children = children;
	}
	
	public void setFamilyID(int familyid) {
		familyID = familyid;
	}
	
	/**
	 * Getters
	 * @return
	 */
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
	
	public Tree getFather() {
		return father;
	}
	
	public Tree getMother() {
		return mother;
	}
	
	public Tree getSpouse() {
		return spouse;
	}
	
	public ArrayList<Tree> getChildren() {
		return children;
	}
	
	public int getFamilyID() {
		return familyID;
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
	public void addSpouse(Tree spouse) {
		setSpouse(spouse);
		getSpouse().setSpouse(this);
		if(children != null) {
			getSpouse().setChildren(getChildren());
			if(getSpouse().male) {
				for(Tree t: children) {
					t.setFather(getSpouse());
				}
			}
			else {
				for(Tree t: children) {
					t.setMother(getSpouse());
				}
			}
		}
	}
	
	/**
	 * addChild() adds a child node. Also updates the child pointer to the current node and checks if there is a spouse to be updated.
	 * @param child
	 */
	public void addChild(Tree child) {
		ArrayList<Tree> childlist = new ArrayList<>();
		if(getChildren() != null) {
		childlist.addAll(getChildren());
		}
		childlist.add(child);
		setChildren(childlist);
		System.out.println("addChild " + getChildren());
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
	public void addParent(Tree parent) {
		if(parent.getMale()) {
			if(getFather() != null) {
				if(getFather().getFirstName() == null && getFather().getChildren() != null) {
					ArrayList<Tree> childrenlist = new ArrayList<>();
					for(Tree t: getFather().getChildren()) {
						childrenlist.add(t);
					}
					childrenlist.add(this);
					HashSet<Tree> uniques = new HashSet<>(childrenlist);
					for(Tree t : uniques) {
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
			if(getFather() != null) {
				getFather().setSpouse(parent);
				parent.setSpouse(getFather());
				HashSet<Tree> uniques = new HashSet<>(parent.getSpouse().getChildren());
				for(Tree t : uniques) {
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
	public void addSibling(Tree sibling) {
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
			Tree dummyparent = new Tree(getFamilyID());
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
	
	public static void main(String[] args) {
		Tree Lilly = new Tree("Lilly", "Schwarzenbach", false, "19-11-1995", "Riggisberg", 1);
		Tree Felix = new Tree("Felix", "Schwarzenbach", true, "17-02-1959", "Wädenswil", 1);
		Tree Susanna = new Tree("Susanna", "Schwarzenbach", false, "30-06-1963", "Bern", 1);
		Tree Fanny = new Tree("Fanny", "Schwarzenbach", false, "04-05-1995", "Jegenstorf", 1);
		Tree Fritz = new Tree("Fritz", "Schwarzenbach", true, "21-10-1925", "Zürich", 1, "09-06-2018", "Bern");
		Tree Hedi = new Tree("Hedi", "Schwarzenbach", false, "21-11-1925", "Wädenswil", 1, "12-04-1973", "Davos");
		Tree Hans = new Tree("Hans", "Moser", true, "16-03-1931", "Krauchthal", 1, "14-08-2015", "Bäriswil");
		Tree Käthi = new Tree("Käthi", "Moser", false, "21-03-1936", "Hindelbank", 1);
		Tree Hasi = new Tree("Hasi", "Schwarzenbach", true, "31-07-1953", "Wädenswil", 1);
		Tree Heidi = new Tree("Heidi", "Stähli", false, "31-07-1955", "Wädenswil", 1);
		
		System.out.println(Felix);
		System.out.println("\n------------------Adding Child: Lilly-------------------");

		Felix.addChild(Lilly);
		
		System.out.println(Felix);
		System.out.println();
		System.out.println(Lilly);
		
		System.out.println("\n------------------Adding Spouse: Susanna-------------------");
		Felix.addSpouse(Susanna);
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		

		System.out.println("\n------------------Adding Child: Fanny-------------------");
		Susanna.addChild(Fanny);
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		
		System.out.println("\n------------------Adding Sister: Heidi-------------------");
		Felix.addSibling(Heidi);
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		System.out.println("\n" + Heidi);
		

		System.out.println("\n------------------Adding Father: Fritz-------------------");
		Felix.addParent(Fritz);
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		System.out.println("\n" + Heidi);
		System.out.println("\n" + Fritz);
		
		
		System.out.println("\n------------------Adding Mother: Hedi-------------------");
		Felix.addParent(Hedi);
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		System.out.println("\n" + Heidi);
		System.out.println("\n" + Fritz);
		System.out.println("\n" + Hedi);
		
		System.out.println("\n------------------Adding Brother: Hasi-------------------");
		Felix.addSibling(Hasi);
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		System.out.println("\n" + Fritz);
		System.out.println("\n" + Hedi);
		System.out.println("\n" + Hasi);

		System.out.println("\n------------------Adding Father: Hans-------------------");
		Susanna.addParent(Hans);
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		System.out.println("\n" + Heidi);
		System.out.println("\n" + Fritz);
		System.out.println("\n" + Hedi);
		System.out.println("\n" + Hasi);
		System.out.println("\n" + Hans);

		System.out.println("\n------------------Adding Mother: Käthi-------------------");
		Susanna.addParent(Käthi);
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		System.out.println("\n" + Heidi);
		System.out.println("\n" + Fritz);
		System.out.println("\n" + Hedi);
		System.out.println("\n" + Hasi);
		System.out.println("\n" + Hans);
		System.out.println("\n" + Käthi);
		
		System.out.println("\n------------------Deleting Child: Hasi-------------------");
		Hasi.delete();
		System.out.println(Felix);
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		System.out.println("\n" + Heidi);
		System.out.println("\n" + Fritz);
		System.out.println("\n" + Hedi);
		System.out.println("\n" + Hasi);
		System.out.println("\n" + Hans);
		System.out.println("\n" + Käthi);
		
		System.out.println("\n------------------Deleting Parent: Felix-------------------");
		Felix.deleteParent();
		System.out.println("\n" + Lilly);
		System.out.println("\n" + Susanna);
		System.out.println("\n" + Fanny);
		System.out.println("\n" + Heidi);
		System.out.println("\n" + Fritz);
		System.out.println("\n" + Hedi);
		System.out.println("\n" + Hasi);
		System.out.println("\n" + Hans);
		System.out.println("\n" + Käthi);
		
		
		
	}

}
