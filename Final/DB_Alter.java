package Final;
import java.sql.*;
import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class DB_Alter {
	static int currentPID;
	static int currentTreeID;
	static String currentTree;
	static int parentID;
	static int NewSpouseID;
	static int SpouseExistingID;
	static int newParentID;
	public static int getAlterCurrentID() {
		return AlterCurrentID;
	}
	public static void setAlterCurrentID(int alterCurrentID) {
		AlterCurrentID = alterCurrentID;
	}
	static int AlterCurrentID;
	public static int getNewParentID() {
		return newParentID;
	}
	public static void setNewParentID(int newParentID) {
		DB_Alter.newParentID = newParentID;
	}
	public static int getExistingChildID() {
		return ExistingChildID;
	}
	public static void setExistingChildID(int existingChildID) {
		ExistingChildID = existingChildID;
	}
	static int ExistingChildID;
	
	public static int getNewSpouseID() {
		return NewSpouseID;
	}
	public static void setNewSpouseID(int newSpouseID) {
		NewSpouseID = newSpouseID;
	}
	public static int getSpouseExistingID() {
		return SpouseExistingID;
	}
	public static void setSpouseExistingID(int spouseExistingID) {
		SpouseExistingID = spouseExistingID;
	}
	public static int getParentID() {
		return parentID;
	}
	public static void setParentID(int parentID) {
		DB_Alter.parentID = parentID;
	}
	public static int getChildID() {
		return childID;
	}
	public static void setChildID(int childID) {
		DB_Alter.childID = childID;
	}
	static int childID;

	public static int getCurrentTreeID() {
		return currentTreeID;
	}
	public static void setCurrentTreeID(int currentTreeID) {
		DB_Alter.currentTreeID = currentTreeID;
	}
	
	
	public static void addChild() {
		
	try {
		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);
		
		Statement stmt = con.createStatement();
		
		String findSpouse = "Select spouse from \"Java\".familyconnect where pid = "+getParentID();
		ResultSet rs = stmt.executeQuery(findSpouse);
		int spouseid = -1;
		while(rs.next()) {

			spouseid = (rs.getInt("spouse"));
		}
		Logic parentTree = createLogic(getParentID());
		parentTree.setSpouse(null);
		if(spouseid != 0) {

			Logic spouseTree = createLogic(spouseid);
			parentTree.setSpouse(spouseTree);
		}

		String sql;
		String sql0 = "";
		if(parentTree.getMale() && parentTree.getSpouse() != null) {

			sql0 = "Update \"Java\".familyconnect set mother = " + spouseid + " where pid = " + getChildID() ; 

			sql = "Update \"Java\".familyconnect set father = " + getParentID() + " where mother = " + spouseid ; 
		}
		else if(parentTree.getMale() && parentTree.getSpouse() == null) {

			sql = "Update \"Java\".familyconnect set father = " + getParentID() + " where pid = " +getChildID(); 
		}
		else if(!parentTree.getMale() && parentTree.getSpouse() != null) {
			sql0 = "Update \"Java\".familyconnect set father = " + spouseid + " where pid = " + getChildID() ; 

			sql = "Update \"Java\".familyconnect set mother = " + getParentID() + " where father = " + spouseid ; 
		}
		else if(!parentTree.getMale() && parentTree.getSpouse() == null){

			sql = "Update \"Java\".familyconnect set mother = " + getParentID() + " where pid = " +getChildID(); 
		}
		else {
			sql = "";
		}

		stmt.executeUpdate(sql0);

		stmt.executeUpdate(sql);
		 
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}
	public static void addParent() {
		
		
		try {
			Class.forName("org.postgresql.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			Statement stmt = con.createStatement();

			Logic parentTree = createLogic(getNewParentID());

			Logic childTree = createLogic(getExistingChildID());
			childTree.setMother(null);
			childTree.setFather(null);
			int motherid = -1;
			int fatherid = -1;
			if(parentTree.getMale()) {
				String findMother = "Select mother from \"Java\".familyconnect where (pid = "+getExistingChildID()+ ")";

				ResultSet rs = stmt.executeQuery(findMother);

				while(rs.next()) {
					motherid = (rs.getInt("mother"));
				}

				if(motherid > 0) {

					Logic motherTree = createLogic(motherid);
					childTree.setMother(motherTree);

				}
			}
			else {
				String findFather = "Select father from \"Java\".familyconnect where pid = "+getExistingChildID();
				ResultSet rs = stmt.executeQuery(findFather);
				while(rs.next()) {
					fatherid = (rs.getInt("father"));
				}
				if(fatherid > 0) {
					Logic fatherTree = createLogic(fatherid);
					childTree.setFather(fatherTree);
				}
			}

			String addspouse = "empty";
			String addspousetonewparent = "empty";
			String addparenttochildren = "empty";
			String addnewparent = "empty";

			if(parentTree.getMale() && childTree.getMother() != null) {

				addspouse = "Update \"Java\".familyconnect set spouse = " + getNewParentID() + " where (pid = " + motherid + ")";
				addspousetonewparent = "Update \"Java\".familyconnect set spouse = " + motherid + " where (pid = " + getNewParentID() + ")";
				addparenttochildren = "Update \"Java\".familyconnect set father = " + getNewParentID() + " where mother = " + motherid;
			}
			
			else if(!parentTree.getMale() && childTree.getFather() != null) {
				addspouse = "Update \"Java\".familyconnect set spouse = " + getNewParentID() + " where pid = " + fatherid;
				addspousetonewparent = "Update \"Java\".familyconnect set spouse = " + fatherid + " where (pid = " + getNewParentID() + ")";
				addparenttochildren = "Update \"Java\".familyconnect set mother = " + getNewParentID() + " where father = " + fatherid;
			}
			
			else if(parentTree.getMale() && childTree.getMother() == null) {

				addparenttochildren = "Update \"Java\".familyconnect set father = " + getNewParentID() + " where pid = " + getExistingChildID();
			}

			else  {
				addparenttochildren = "Update \"Java\".familyconnect set mother = " + getNewParentID() + " where pid = " + getExistingChildID();
			}
			
			if(!addspouse.equals("empty")) {
				stmt.executeUpdate(addspouse);
			}
			if(!addspousetonewparent.equals("empty")) {
				stmt.executeUpdate(addspousetonewparent);
			}
			if(!addparenttochildren.equals("empty")) {

				stmt.executeUpdate(addparenttochildren);
			}
		 
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
public static void addSpouse() {
		
		
		try {
			Class.forName("org.postgresql.Driver");


			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			Statement stmt = con.createStatement();

			Logic existingSpouseTree = createLogic(getSpouseExistingID());

			Logic newSpouseTree = createLogic(getNewSpouseID());
			
			
			String addspousetoExisting = "Update \"Java\".familyconnect set spouse = " + getNewSpouseID()+ " where (pid = " + getSpouseExistingID() + ")";
			String addspousetoNew ="Update \"Java\".familyconnect set spouse = " + getSpouseExistingID() + " where (pid = " + getNewSpouseID() + ")";
			
			String addparenttochildren;

			if(existingSpouseTree.getMale()) {
				addparenttochildren = "Update \"Java\".familyconnect set mother = " + getNewSpouseID() + " where father = " + getSpouseExistingID();
			}
			else {
				addparenttochildren = "Update \"Java\".familyconnect set father = " + getNewSpouseID() + " where mother = " + getSpouseExistingID();
			}
			
			stmt.executeUpdate(addspousetoExisting);
			stmt.executeUpdate(addspousetoNew);
			stmt.executeUpdate(addparenttochildren);

			;
			// STEP 6: Clean-up environment			 
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
public static void AlterPerson(String firstname, String lastname, LocalDate birthdate, String birthcountry, String gender, 
		LocalDate deathDate, String deathcountry, String bio) {
	try {
		Class.forName("org.postgresql.Driver");

		
		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);
		
		Statement stmt = con.createStatement();

		String alterFirstName = "Update \"Java\".person set firstname = '" + firstname + "' where pid = " + getAlterCurrentID();
		stmt.executeUpdate(alterFirstName);
		String alterLastName = "Update \"Java\".person set lastname = '" + lastname + "' where pid = " + getAlterCurrentID();
		stmt.executeUpdate(alterLastName);
		String alterGender = "Update \"Java\".person set gender = '" + gender + "' where pid = " + getAlterCurrentID();
		stmt.executeUpdate(alterGender);
		String alterBirthdate = "Update \"Java\".person set birthdate = '" + birthdate + "' where pid = " + getAlterCurrentID(); 
		stmt.executeUpdate(alterBirthdate);
		String alterBirthplace = "Update \"Java\".person set birthplace = '" + birthcountry + "' where pid = " + getAlterCurrentID();
		stmt.executeUpdate(alterBirthplace);
		if(!deathDate.equals(null)) {
		String alterDOD = "Update \"Java\".person set dateofdeath = '" + deathDate + "' where pid = " + getAlterCurrentID();
		stmt.executeUpdate(alterDOD);
		}
		if(!deathcountry.equals(null)) {
		String alterDeathplace = "Update \"Java\".person set deathplace = '" + deathcountry + "' where pid = " + getAlterCurrentID();
		stmt.executeUpdate(alterDeathplace);
		}
		if(!bio.equals(null)) {
		String alterBio = "Update \"Java\".person set biography = '" + bio + "' where pid = " + getAlterCurrentID();
		stmt.executeUpdate(alterBio);
		}
		
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}

}
	public static Logic createLogic(int thatid) {
		Logic tree = new Logic();
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			Statement stmt = con.createStatement();
		
		String sql = "Select * from \"Java\".Person where pid = "+ thatid;
		boolean male;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			if(rs.getString("gender").equals("Female")) {
				male = false;
			}
			else {

				male = true;
			}

			if(rs.getDate("dateofdeath") != null && rs.getString("deathplace") != null) {
				tree = new Logic(rs.getInt("pid"), rs.getInt("treeid"),rs.getString("firstname"), rs.getString("lastname"),male, rs.getDate("birthdate").toString(),rs.getString("birthplace").toString(),
						rs.getDate("dateofdeath").toString(),rs.getString("deathplace"),rs.getString("biography"));
		}
		else if(rs.getDate("dateofdeath") == null && rs.getString("deathplace") == null) {
			tree = new Logic(rs.getInt("pid"), rs.getInt("treeid"),rs.getString("firstname"), rs.getString("lastname"),male, rs.getDate("birthdate").toString(),rs.getString("birthplace").toString(),
					rs.getString("biography"));
		}
		else if(rs.getString("deathplace") == null) {
			tree = new Logic(rs.getInt("pid"), rs.getInt("treeid"),rs.getString("firstname"), rs.getString("lastname"),male, rs.getDate("birthdate").toString(),rs.getString("birthplace").toString(),
					rs.getDate("dateofdeath").toString(),rs.getString("biography"));
		}
		else {
			tree = new Logic(rs.getInt("pid"), rs.getInt("treeid"),rs.getString("firstname"), rs.getString("lastname"),male, rs.getDate("birthdate").toString(),rs.getString("birthplace").toString(),
					rs.getString("deathplace"),rs.getString("biography"));
		}
		}
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		return tree;

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
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
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
	public static int deletePerson(int deleteID) {
		int treeid = 0;
	try {
		Class.forName("org.postgresql.Driver");

		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

		Statement stmt = con.createStatement();

		String treeidQuery = "Select treeid from \"Java\".Person where "+ "(pid = "+deleteID+ ")";

		ResultSet rs = stmt.executeQuery(treeidQuery);
		Tree1 l;
		
		while(rs.next()) {
			treeid = (rs.getInt("treeid"));
		}
		String spouseQuery = "Update \"Java\".familyconnect set spouse = null where spouse =" + deleteID;
		String fatherQuery = "Update \"Java\".familyconnect set father = null where father = "+ deleteID;
		String motherQuery = "Update \"Java\".familyconnect set mother = null where mother = " + deleteID;
		String deleteFamilyConnect = "Delete from \"Java\".familyconnect where pid = " + deleteID;
		String deletePerson = "delete from \"Java\".person where pid = " + deleteID;
		
		
		stmt.executeUpdate(spouseQuery);
		stmt.executeUpdate(fatherQuery);
		stmt.executeUpdate(motherQuery);
		stmt.executeUpdate(deleteFamilyConnect);
		stmt.executeUpdate(deletePerson);
		 
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	return treeid;
	}
	

	static final String USER_Name = "axk1029";
	static final String PASSWORD = "woe+loss118";
}

