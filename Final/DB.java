package Final;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class DB {
	static int currentPID;
	static int currentTreeID;
	static String currentTree;
	static ArrayList<Logic> siblingTrees;
	
	public static ArrayList<Logic> getSiblingTrees() {
		return siblingTrees;
	}
	public static void setSiblingTrees(ArrayList<Logic> siblingTrees) {
		DB.siblingTrees = siblingTrees;
	}
	public static int getCurrentTreeID() {
		return currentTreeID;
	}
	public static void setCurrentTreeID(int currentTreeID) {
		DB.currentTreeID = currentTreeID;
	}
	public static int getCurrentPID() {
		return currentPID;
	}
	public static int updateCurrentPID(Tree1 treePID) {
		try {
		Class.forName("org.postgresql.Driver");
	
		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);
	
		Statement stmt = con.createStatement();

		String sql = "Select (pid) From \"Java\".Person " + "WHERE firstname = '" + treePID.getFirstName() + "' and lastname = '" + treePID.getLastName() + "' and birthdate = '"
					+ treePID.getBirthday() +"'";

		ResultSet rs = stmt.executeQuery(sql);

		while(rs.next()) {
			DB.currentPID= Integer.parseInt(rs.getString("pid"));
		}
		stmt.close();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
		 return currentPID;

	}
	public static void Create_New_Tree(String TreeField) {
		
		
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);
				
		Statement stmt = con.createStatement();
	
		String sql = "Insert into \"Java\".treeconnect(familyname) " + "VALUES ('"+TreeField+"')";
		currentTree = TreeField;
		currentTree= "Select (tid) from \"Java\".treeconnect " + "WHERE familyname='"+currentTree+"'";
		stmt.executeUpdate(sql);

		ResultSet rs = stmt.executeQuery(currentTree);
		while(rs.next()) {
			setCurrentTreeID(Integer.parseInt(rs.getString("tid")));
		}
		 
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}

}
	public static void familyMemberCreate( String firstname, 
		String lastname, String gender, LocalDate localDate,String birthplace,LocalDate DateofDeath,String deathPlace,String biography) {
		try {
			Class.forName("org.postgresql.Driver");


			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			String sql;
			Statement stmt = con.createStatement();
			if(DateofDeath != null && deathPlace != null) {
					sql ="Insert into \"Java\".Person(treeid, firstname, lastname, gender, Birthdate, birthplace, dateofdeath, deathplace, biography) "
					+ "values (" + currentTreeID + ", '"+ firstname+"', '"+ lastname +"',"
							+ " '"+gender+ "', '"+localDate+"', '"+ birthplace + "', '" +DateofDeath+"', '"+ deathPlace + "', '" + biography +"')";
			}
			else if(DateofDeath == null && deathPlace == null) {
				sql ="Insert into \"Java\".Person(treeid, firstname, lastname, gender, Birthdate, birthplace, biography) "
						+ "values (" + currentTreeID + ", '"+ firstname+"', '"+ lastname +"',"
								+ " '"+gender+ "', '"+localDate+"', '"+ birthplace + "', '" + biography +"')";
			}
			else if(deathPlace == null) {
				sql ="Insert into \"Java\".Person(treeid, firstname, lastname, gender, Birthdate, birthplace, dateofdeath, biography) "
						+ "values (" + currentTreeID + ", '"+ firstname+"', '"+ lastname +"',"
								+ " '"+gender+ "', '"+localDate+"', '"+ birthplace + "', '" +DateofDeath+"', '"+ biography +"')";
			}
			else {
				sql ="Insert into \"Java\".Person(treeid, firstname, lastname, gender, Birthdate, birthplace, deathplace, biography) "
						+ "values (" + currentTreeID + ", '"+ firstname+"', '"+ lastname +"',"
								+ " '"+gender+ "', '"+localDate+"', '"+ birthplace + "', '"+ deathPlace + "', '" + biography +"')";
			}
			stmt.executeUpdate(sql);
			Tree1 currentnew = new Tree1(firstname, lastname, localDate.toString(), "");
			int id = updateCurrentPID(currentnew);
			String family = "Insert into \"Java\".familyconnect(pid) values("+ id + ")";
			stmt.executeUpdate(family);
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<Logic> findFamilyMembersDisplay(int focusedID){
		ArrayList<Logic> family = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);
			Statement stmt = con.createStatement();
			Logic focused = DB_Alter.createLogic(focusedID);
			focused.setTreeLevel(0);
			family.add(focused);
			String spouseIDQuery = "Select spouse from \"Java\".familyconnect where pid = " + focusedID;
			
			ResultSet spouseIDrs = stmt.executeQuery(spouseIDQuery);
			int spouseID = 0;
			while(spouseIDrs.next()) {
				spouseID = spouseIDrs.getInt("spouse");
			}
			if(spouseID > 0) {
				Logic spouse = DB_Alter.createLogic(spouseID);
				focused.setSpouse(spouse);
				spouse.setSpouse(focused);
				spouse.setTreeLevel(0);
	
				family.add(spouse);
			}

			ArrayList<Logic> children = new ArrayList<>();
			String childrenQuery;
			if(focused.getMale()) {
				childrenQuery = "Select pid from \"Java\".familyconnect where father = " + focusedID;
			}
			else {
				childrenQuery = "Select pid from \"Java\".familyconnect where mother = " + focusedID;
			}
			ResultSet childrenIDrs = stmt.executeQuery(childrenQuery);

			int childID;
			Logic l;
			while(childrenIDrs.next()) {
				childID = childrenIDrs.getInt("pid");
				l = DB_Alter.createLogic(childID);
				if(focused.getMale()) {
					l.setFather(focused);
					if(focused.getSpouse() != null) {
						l.setMother(focused.getSpouse());
					}
				}
				else {
					l.setMother(focused);
					if(focused.getSpouse() != null) {
						l.setFather(focused.getSpouse());
					}
				}
				l.setTreeLevel(1);
				children.add(l);
			}
			if(!children.isEmpty()) {
				focused.setChildren(children);
				if(focused.getSpouse() != null) {
					focused.getSpouse().setChildren(children);
				}
				family.addAll(children);
			}

			//children's spouses
			String childSpouseQuery;
			for(Logic kid : children) {
				if(kid.getMale()) {
					childSpouseQuery = "Select pid from \"Java\".familyconnect where spouse = " + kid.getID();
				}
				else {
					childSpouseQuery = "Select pid from \"Java\".familyconnect where spouse = " + kid.getID();
				}
				ResultSet childSpouseIDrs = stmt.executeQuery(childSpouseQuery);

				int childSpouseID = 0;
				while(childSpouseIDrs.next()) {
					childSpouseID = childSpouseIDrs.getInt("pid");
				}
				if(childSpouseID > 0) {
					l = DB_Alter.createLogic(childSpouseID);
					kid.setSpouse(l);
					l.setSpouse(kid);
					l.setTreeLevel(1);
		
					family.add(l);
				}
			}
			
			
			//father
			String fatherIDQuery =  "Select father from \"Java\".familyconnect where pid = " + focusedID;
			ResultSet fatherIDrs = stmt.executeQuery(fatherIDQuery);

			int fatherID = 0;
			while(fatherIDrs.next()) {
				fatherID = fatherIDrs.getInt("father");
			}
			if(fatherID > 0) {
				Logic father = DB_Alter.createLogic(fatherID);
				focused.setFather(father);
				father.setTreeLevel(-1);	
				family.add(father);
			}
			
			//mother
			String motherIDQuery =  "Select mother from \"Java\".familyconnect where pid = " + focusedID;
			ResultSet motherIDrs = stmt.executeQuery(motherIDQuery);

			int motherID = 0;
			while(motherIDrs.next()) {
				motherID = motherIDrs.getInt("mother");
			}
			if(motherID > 0) {
				Logic mother = DB_Alter.createLogic(motherID);
				focused.setMother(mother);
				mother.setTreeLevel(-1);	
				if(focused.getFather() != null) {
					focused.getFather().setSpouse(mother);
					mother.setSpouse(focused.getFather());
				}
				family.add(mother);
			}
			
			//siblings
			ArrayList<Logic> siblings = new ArrayList<>();
			String siblingsQuery;
			if(focused.getFather() != null) {
				siblingsQuery = "Select pid from \"Java\".familyconnect where father = " + fatherID + " and not pid = " + focusedID;
			}
			else if(focused.getMother() != null){
				siblingsQuery = "Select pid from \"Java\".familyconnect where mother = " + motherID + " and not pid = " + focusedID;
			}
			else {
				siblingsQuery = " ";
			}
			ResultSet siblingIDrs = stmt.executeQuery(siblingsQuery);

			int siblingID;
			while(siblingIDrs.next()) {
				siblingID = siblingIDrs.getInt("pid");
				l = DB_Alter.createLogic(siblingID);
				
				if(focused.getFather() != null) {
					l.setFather(focused.getFather());
				}
				else if(focused.getMother() != null){
					l.setMother(focused.getMother());
				}
				l.setTreeLevel(0);
				siblings.add(l);
			}
			if(!siblings.isEmpty()) {
				family.addAll(siblings);
				siblings.add(focused);
				if(focused.getFather() != null) {
					focused.getFather().setChildren(siblings);
				}
				else if(focused.getMother() != null) {
					focused.getMother().setChildren(siblings);
				}
			}

			setSiblingTrees(siblings);
			//sibling's spouses
			String siblingSpouseQuery;
			for(Logic sibling : siblings) {
				if(sibling.getMale()) {
					siblingSpouseQuery = "Select pid from \"Java\".familyconnect where spouse = " + sibling.getID();
				}
				else {
					siblingSpouseQuery = "Select pid from \"Java\".familyconnect where spouse = " + sibling.getID();
				}
				ResultSet siblingSpouseIDrs = stmt.executeQuery(siblingSpouseQuery);

				int siblingSpouseID = 0;
				while(siblingSpouseIDrs.next()) {
					siblingSpouseID = siblingSpouseIDrs.getInt("pid");
				}
				if(siblingSpouseID > 0) {
					l = DB_Alter.createLogic(siblingSpouseID);
					sibling.setSpouse(l);
					l.setSpouse(sibling);
					l.setTreeLevel(0);
		
					family.add(l);
				}
			}
			
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return family;
	}
	public static ObservableList<Tree1> nodeListCreate() {
		ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();

		try {
			Class.forName("org.postgresql.Driver");

			

			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			
			String sql = "Select * from \"Java\".Person where treeid="+currentTreeID;
			String sql2 = "Select familyname from \"Java\".treeconnect where tid="+currentTreeID;

			Statement stmt = con.createStatement();
			
			
			ResultSet rs2 = stmt.executeQuery(sql2);

			Tree1 l;
			String treename = "";
			while(rs2.next()) {
				treename = (rs2.getString("familyname"));
			}
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				l = new Tree1(rs.getString("firstname"), rs.getString("lastname"), rs.getDate("birthdate").toString(), 
						treename);
				newlistdata.add(l);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	
		
		return newlistdata;
	}
	public static ObservableList<Tree1> nodeListSearch(int chosenPID) {
		ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();

		try {
			Class.forName("org.postgresql.Driver");


			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			
			String sql = "Select treeid from \"Java\".Person where "+ "(pid = "+chosenPID+ ")";
			
			Statement stmt = con.createStatement();
			
			
			
			ResultSet rs = stmt.executeQuery(sql);
			Tree1 l;
			int treeid = 0;
			while(rs.next()) {
				treeid = (rs.getInt("treeid"));
			}
			String sql2 = "Select familyname from \"Java\".treeconnect where tid="+treeid;

			ResultSet rs2 = stmt.executeQuery(sql2);

			String treename = "";
			while(rs2.next()) {
				treename = (rs2.getString("familyname"));
			}
			String sql3 = "Select * from \"Java\".Person where "+ "(treeid = "+treeid+ ")";
			ResultSet rs3 = stmt.executeQuery(sql3);
			
			while(rs3.next()) {				
				l = new Tree1(rs3.getString("firstname"), rs3.getString("lastname"), rs3.getDate("birthdate").toString(), 
						treename);
				newlistdata.add(l);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	return newlistdata;
	}
	public static ObservableList<Tree1> FullList() {
		ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();

		try {
			Class.forName("org.postgresql.Driver");


			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			
			String sql = "select p.*, t.familyname from \"Java\".treeconnect t, \"Java\".person p where p.treeid = t.tid";

			Statement stmt = con.createStatement();
			
			Tree1 l;

			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				l = new Tree1(rs.getString("firstname"), rs.getString("lastname"), rs.getDate("birthdate").toString(), 
						rs.getString("familyname"));
						
				newlistdata.add(l);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	
		
		return newlistdata;
	}
	public static ObservableList<Tree1> PostDeleteList(int treeid) {
		ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();

		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);
			
			String sql = "select p.*, t.familyname from \"Java\".treeconnect t, \"Java\".person p where p.treeid = t.tid and p.treeid = " + treeid;

			Statement stmt = con.createStatement();
			
			

			Tree1 l;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {				
				l = new Tree1(rs.getString("firstname"), rs.getString("lastname"), rs.getDate("birthdate").toString(), 
						rs.getString("familyname"));
				newlistdata.add(l);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	
		
		return newlistdata;
	}
	public static ObservableList<Logic> TreeNodeCreate() {
		ObservableList<Logic> newlistdata= FXCollections.observableArrayList();

		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			
			String sql = "Select * from \"Java\".Person where treeid="+currentTreeID;

			Statement stmt = con.createStatement();
			
			Logic l;
			boolean male;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("gender")== "Female") {
					male = false;
				}
				else {
					male = true;
				}
				l = new Logic(rs.getInt("pid"), currentTreeID,rs.getString("firstname"), rs.getString("lastname"),male, rs.getDate("birthdate").toString(),rs.getString("birthplace").toString(),
						rs.getDate("dateofdeath").toString(),rs.getString("deathplace"),rs.getString("biography"));
				newlistdata.add(l);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
		return newlistdata;
	}
	public static int lookupTreeID(int nodeID) {
		int treeid = 0;
	try {
		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

		Statement stmt = con.createStatement();
		String treeidQuery = "Select treeid from \"Java\".Person where "+ "(pid = "+nodeID+ ")";

		ResultSet rs = stmt.executeQuery(treeidQuery);
		
		while(rs.next()) {
			treeid = (rs.getInt("treeid"));
		}
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	setCurrentTreeID(treeid);
	DB_Alter.setCurrentTreeID(treeid);
	return treeid;
	
	}
	static final String USER_Name = "axk1029";
	static final String PASSWORD = "woe+loss118";
}

