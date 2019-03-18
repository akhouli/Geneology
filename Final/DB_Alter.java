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
		System.out.println("INTO ADD CHILD ____________________________________________________HELLO)");
		
	try {
		// STEP 2: initialize JDBC driver
		Class.forName("org.postgresql.Driver");

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");

		
		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

		System.out.println("Connected...");
		
		// STEP 4: Execute a query
//		parentID = DB.updateCurrentPID(parent);
		Statement stmt = con.createStatement();
		System.out.println("Post ..........Connected...");
//		familyMemberCreate.
//		Insert into familyconnect values(5,null,null,null)
		
		String findSpouse = "Select spouse from \"Java\".familyconnect where pid = "+getParentID();
		ResultSet rs = stmt.executeQuery(findSpouse);
//		System.out.println(rs.next());
		int spouseid = -1;
		System.out.println("Before while...");
		while(rs.next()) {
			System.out.println("in while...");

			spouseid = (rs.getInt("spouse"));
		}
		System.out.println("while Done...");

		System.out.println("parent id = " + getParentID());
		Logic parentTree = createLogic(getParentID());
		parentTree.setSpouse(null);
		if(spouseid != 0) {
			System.out.println("into If spouse !0...");

			System.out.println("spouse = " + spouseid);

			Logic spouseTree = createLogic(spouseid);
			System.out.println("Spouse tree name !!!!!!!!!!!!!!!!!! " + spouseTree.getFirstName());
			parentTree.setSpouse(spouseTree);
		}
//		String gender = "Male";
//		if(parentTree.getMale()==false) {
//			gender = "Female";
//		}
		String sql;
		String sql0 = "";
		if(parentTree.getMale() && parentTree.getSpouse() != null) {
			System.out.println("1st if --------------------------------------");

			sql0 = "Update \"Java\".familyconnect set mother = " + spouseid + " where pid = " + getChildID() ; 

			sql = "Update \"Java\".familyconnect set father = " + getParentID() + " where mother = " + spouseid ; 
		}
		else if(parentTree.getMale() && parentTree.getSpouse() == null) {
			System.out.println("2 if --------------------------------------");

			sql = "Update \"Java\".familyconnect set father = " + getParentID() + " where pid = " +getChildID(); 
		}
		else if(!parentTree.getMale() && parentTree.getSpouse() != null) {
			System.out.println("3 if --------------------------------------");
			sql0 = "Update \"Java\".familyconnect set father = " + spouseid + " where pid = " + getChildID() ; 

			sql = "Update \"Java\".familyconnect set mother = " + getParentID() + " where father = " + spouseid ; 
		}
		else if(!parentTree.getMale() && parentTree.getSpouse() == null){
			System.out.println("4 if --------------------------------------");

			sql = "Update \"Java\".familyconnect set mother = " + getParentID() + " where pid = " +getChildID(); 
		}
		else {
			System.out.println("5 if --------------------------------------");

			System.out.println("confused");
			sql = "";
		}
		
//		String sql = "Insert into \"Java\".treeconnect(familyname) " + "VALUES ('"+TreeField+"')";
//		=TreeField;
		stmt.executeUpdate(sql0);

		stmt.executeUpdate(sql);
		System.out.println("Record added...");

		
//		currentTree = String.valueOf(stmt.executeUpdate(sql2));
		// STEP 6: Clean-up environment			 
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	System.out.println("Goodbye!");

}
	public static void addParent() {
		
		
		try {
			// STEP 2: initialize JDBC driver
			Class.forName("org.postgresql.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			System.out.println("Connected...");
			
			// STEP 4: Execute a query
//			parentID = DB.updateCurrentPID(parent);
			Statement stmt = con.createStatement();
//			familyMemberCreate.
//			Insert into familyconnect values(5,null,null,null)
			Logic parentTree = createLogic(getParentID());

			Logic childTree = createLogic(getChildID());
			childTree.setMother(null);
			childTree.setFather(null);
			int motherid = -1;
			int fatherid = -1;
			if(parentTree.getMale()) {
				System.out.println("if parent Tree Line enter1");
				String findMother = "Select mother from \"Java\".familyconnect where (pid = "+getChildID()+ ")";
				System.out.println("if parent Tree lINE ENTER 2");

				ResultSet rs = stmt.executeQuery(findMother);
				System.out.println("if parent Tree lINE ENTER 3");

//				System.out.println(rs.next());
//				String a = rs.getString(1);
				while(rs.next()) {
					System.out.println("INTO WHILE 1");
					System.out.println(rs.getString(1));
					motherid = (rs.getInt("mother"));
				}
//				
				//CHECK IF THERE IS A MOM - WE'RE ADDING A DAD
//				System.out.println("parent id = " + getParentID());
				if(motherid != 0) {
					System.out.println("MOTHER NOT -1");
//					motherid = Integer.parseInt(a);
					System.out.println("mom = " + motherid);

					Logic motherTree = createLogic(motherid);
					childTree.setMother(motherTree);
					System.out.println("END");

				}
			}
			//THIS IS ENTERED IF THE NEW PARENT IS A MOM
			else {
				System.out.println("111111111Else statemant !!!!");

				String findFather = "Select father from \"Java\".familyconnect where pid = "+getChildID();
				ResultSet rs = stmt.executeQuery(findFather);
//				System.out.println(rs.next());
				while(rs.next()) {
					fatherid = (rs.getInt("father"));
				}
////				System.out.println("parent id = " + getParentID());
				//CHECK IF THERE IS A DAD - WE'RE ADDING A MOM
				System.out.println("fatherid " + fatherid);
				if(fatherid != 0) {
//					System.out.println("dad = " + fatherid);
//
					Logic fatherTree = createLogic(fatherid);
					System.out.println(fatherTree);
					childTree.setFather(fatherTree);
				}
			}
//			
			System.out.println("Out of while and if 1 -----------------");

			String addspouse = "empty";
			String addspousetonewparent = "empty";
			String addparenttochildren = "empty";
			String addnewparent = "empty";
			System.out.println("Making emptez -----------------");

			if(parentTree.getMale() && childTree.getMother() != null) {
				System.out.println("1st If statement !!!!");

				addspouse = "Update \"Java\".familyconnect set spouse = " + getParentID() + " where (pid = " + motherid + ")";
				System.out.println("add spouse--------------------------------------------- "+ addspouse);
				addspousetonewparent = "Update \"Java\".familyconnect set spouse = " + motherid + " where (pid = " + getParentID() + ")";
				addparenttochildren = "Update \"Java\".familyconnect set father = " + getParentID() + " where mother = " + motherid;
			}
			
			else if(!parentTree.getMale() && childTree.getFather() != null) {
				System.out.println("2nd If statement !!!!");
				addspouse = "Update \"Java\".familyconnect set spouse = " + getParentID() + " where pid = " + fatherid;
				addspousetonewparent = "Update \"Java\".familyconnect set spouse = " + fatherid + " where (pid = " + getParentID() + ")";
				addparenttochildren = "Update \"Java\".familyconnect set mother = " + getParentID() + " where father = " + fatherid;
			}
			
			else if(parentTree.getMale() && childTree.getMother() == null) {
				System.out.println("3rd If statement !!!!");

				addparenttochildren = "Update \"Java\".familyconnect set father = " + getParentID() + " where pid = " + getChildID();
			}
//			else if(!parentTree.getMale() && childTree.getFather() == null) {
//				System.out.println("4th If statement !!!!");
//
//				addparenttochildren = "Update \"Java\".familyconnect set mother = " + getParentID() + " where pid = " + getChildID();
//			}
			else  {
				System.out.println("4th If statement !!!!");

				addparenttochildren = "Update \"Java\".familyconnect set mother = " + getParentID() + " where pid = " + getChildID();
			}
			
			if(!addspouse.equals("empty")) {
				System.out.println("5th If statement !!!!");

				stmt.executeUpdate(addspouse);
			}
			if(!addspousetonewparent.equals("empty")) {
				System.out.println("6th If statement !!!!");

				stmt.executeUpdate(addspousetonewparent);
			}
			if(!addparenttochildren.equals("empty")) {
				System.out.println("7th If statement !!!!");

				stmt.executeUpdate(addparenttochildren);
			}
			
//			String sql = "Insert into \"Java\".treeconnect(familyname) " + "VALUES ('"+TreeField+"')";
//			=TreeField;
			
//			stmt.executeUpdate(sql);
			System.out.println("Record added...");

			
//			currentTree = String.valueOf(stmt.executeUpdate(sql2));
			// STEP 6: Clean-up environment			 
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Goodbye!");

	}
public static void addSpouse() {
		
		
		try {
			// STEP 2: initialize JDBC driver
			Class.forName("org.postgresql.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			System.out.println("Connected...");
			
			// STEP 4: Execute a query
//			parentID = DB.updateCurrentPID(parent);
			Statement stmt = con.createStatement();
//			familyMemberCreate.
//			Insert into familyconnect values(5,null,null,null)
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
		System.out.println("Goodbye!");

	}
public static void AlterPerson(String firstname, String lastname, LocalDate birthdate, String birthcountry, String gender, 
		LocalDate deathDate, String deathcountry, String bio) {
	try {
		// STEP 2: initialize JDBC driver
		Class.forName("org.postgresql.Driver");

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");

		
		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

		System.out.println("Connected...");
		
		Statement stmt = con.createStatement();

		String alterFirstName = "Update \"Java\".person set firstname = '" + firstname + "' where pid = " + currentTreeID;
		stmt.executeUpdate(alterFirstName);
		String alterLastName = "Update \"Java\".person set lastname = '" + lastname + "' where pid = " + currentTreeID;
		stmt.executeUpdate(alterLastName);
		String alterGender = "Update \"Java\".person set gender = '" + gender + "' where pid = " + currentTreeID;
		stmt.executeUpdate(alterGender);
		String alterBirthdate = "Update \"Java\".person set birthdate = '" + birthdate + "' where pid = " + currentTreeID; 
		stmt.executeUpdate(alterBirthdate);
		String alterBirthplace = "Update \"Java\".person set birthplace = '" + birthcountry + "' where pid = " + currentTreeID;
		stmt.executeUpdate(alterBirthplace);
		if(!deathDate.equals(null)) {
		String alterDOD = "Update \"Java\".person set dateofdeath = '" + deathDate + "' where pid = " + currentTreeID;
		stmt.executeUpdate(alterDOD);
		}
		if(!deathcountry.equals(null)) {
		String alterDeathplace = "Update \"Java\".person set deathplace = '" + deathcountry + "' where pid = " + currentTreeID;
		stmt.executeUpdate(alterDeathplace);
		}
		if(!bio.equals(null)) {
		String alterBio = "Update \"Java\".person set biography = '" + bio + "' where pid = " + currentTreeID;
		stmt.executeUpdate(alterBio);
		}
		
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	System.out.println("Goodbye!");

}
	public static Logic createLogic(int thatid) {
		Logic tree = new Logic();
		try {
			// STEP 2: initialize JDBC driver
			Class.forName("org.postgresql.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			System.out.println("Connected...");
			
			// STEP 4: Execute a query
//			parentID = DB.updateCurrentPID(parent);
			Statement stmt = con.createStatement();
		
		String sql = "Select * from \"Java\".Person where pid = "+ thatid;
		boolean male;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println("!!outer!! !!while!!");
			if(rs.getString("gender").equals("Female")) {
				male = false;
			}
			else {

				male = true;
			}
			System.out.println("!!Create Tree Object!!");
//			System.out.println("DOD = "+ rs.getDate("dateofdeath").toString());
//			System.out.println("DeathPlace = "+ rs.getString("deathplace"));
//			tree = new Logic(rs.getInt("pid"), rs.getInt("treeid"),rs.getString("firstname"), rs.getString("lastname"),male, rs.getDate("birthdate").toString(),rs.getString("birthplace").toString(),
//					rs.getDate("dateofdeath").toString(),rs.getString("deathplace"),rs.getString("biography"));
//			System.out.println("!!Created Tree DONE!!!!!");
//			System.out.println("logic creation " + tree.getFirstName() + " " + tree.getMale());
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
		System.out.println("!!Before closing!!");
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
		System.out.println("return tree");

		return tree;

	}
	public static void familyMemberCreate( String firstname, 
		String lastname, String gender, LocalDate localDate,String birthplace,LocalDate DateofDeath,String deathPlace,String biography) {
		try {
			// STEP 2: initialize JDBC driver
			Class.forName("org.postgresql.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			System.out.println("Connected...");
			
			// STEP 4: Execute a query
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
		System.out.println("Goodbye!");
	}
	
	public static ObservableList<Tree1> nodeListCreate() {
		ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();

		try {
			// STEP 2: initialize JDBC driver
			Class.forName("org.postgresql.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			System.out.println("Connected...");
			
			// STEP 4: Execute a query
			String sql = "Select * from \"Java\".Person where treeid="+currentTreeID;
			String sql2 = "Select familyname from \"Java\".treeconnect where tid="+currentTreeID;

			Statement stmt = con.createStatement();
			
			
			ResultSet rs2 = stmt.executeQuery(sql2);

//			System.out.println(rs.next());
			Tree1 l;
			String treename = "";
			while(rs2.next()) {
				treename = (rs2.getString("familyname"));
				System.out.println("inner while");
			}
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("2!!outer2!! while");
				
				l = new Tree1(rs.getString("firstname"), rs.getString("lastname"), rs.getDate("birthdate").toString(), 
						treename);
				newlistdata.add(l);
			}
			System.out.println(currentTreeID);		 
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Goodbye!");

	
		
		return newlistdata;
	}
	
	public static void deletePerson() {
		System.out.println("INTO DELETE ____________________________________________________HELLO)");
		
	try {
		// STEP 2: initialize JDBC driver
		Class.forName("org.postgresql.Driver");

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");

		
		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

		System.out.println("Connected...");
		Statement stmt = con.createStatement();

		String spouseQuery = "Update \"Java\".familyconnect set spouse = null where spouse =" + getCurrentTreeID();
		String fatherQuery = "Update \"Java\".familyconnect set father = null where father = "+ getCurrentTreeID();
		String motherQuery = "Update \"Java\".familyconnect set mother = null where mother = " + getCurrentTreeID();
		String deleteFamilyConnect = "Delete from \"Java\".familyconnect where pid = " + getCurrentTreeID();
		String deletePerson = "delete from \"Java\".person where pid = " + getCurrentTreeID();
		
		stmt.executeUpdate(spouseQuery);
		stmt.executeUpdate(fatherQuery);
		stmt.executeUpdate(motherQuery);
		stmt.executeUpdate(deleteFamilyConnect);
		stmt.executeUpdate(deletePerson);
		System.out.println("Record deleted...");

		
//		currentTree = String.valueOf(stmt.executeUpdate(sql2));
		// STEP 6: Clean-up environment			 
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	System.out.println("Goodbye!");
	}
	static final String USER_Name = "axk1029";
	static final String PASSWORD = "woe+loss118";
}

