package Final;
import java.sql.*;
import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class DB {
	static int currentPID;
	static int currentTreeID;
	static String currentTree;
	
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

		System.out.println("Connecting to database...");

		
		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

		System.out.println("Connected...");
		
		
		Statement stmt = con.createStatement();

		String sql = "Select (pid) From \"Java\".Person " + "WHERE firstname = '" + treePID.getFirstName() + "' and lastname = '" + treePID.getLastName() + "' and birthdate = '"
					+ treePID.getBirthday() +"'";

		System.out.println("Record added...");

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
		// STEP 2: initialize JDBC driver
		Class.forName("org.postgresql.Driver");

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");

		
		Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

		System.out.println("Connected...");
		
		// STEP 4: Execute a query
		
		Statement stmt = con.createStatement();
//		
//		Insert into familyconnect values(5,null,null,null)
		String sql = "Insert into \"Java\".treeconnect(familyname) " + "VALUES ('"+TreeField+"')";
//		=TreeField;
		currentTree = TreeField;
		currentTree= "Select (tid) from \"Java\".treeconnect " + "WHERE familyname='"+currentTree+"'";
		stmt.executeUpdate(sql);
		System.out.println("Record added...");

		ResultSet rs = stmt.executeQuery(currentTree);
//		System.out.println(rs.next());
		while(rs.next()) {
			setCurrentTreeID(Integer.parseInt(rs.getString("tid")));
		}
		System.out.println(currentTreeID);
//		currentTree = String.valueOf(stmt.executeUpdate(sql2));
		// STEP 6: Clean-up environment			 
		stmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	System.out.println("Goodbye!");

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
			Tree1 currentnew = new Tree1(firstname, lastname, localDate.toString(), "");
			int id = updateCurrentPID(currentnew);
			String family = "Insert into \"Java\".familyconnect(pid) values("+ id + ")";
			stmt.executeUpdate(family);
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
				System.out.println("outer while");
				
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
	public static ObservableList<Tree1> FullList() {
		ObservableList<Tree1> newlistdata= FXCollections.observableArrayList();

		try {
			// STEP 2: initialize JDBC driver
			Class.forName("org.postgresql.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			System.out.println("Connected...");
			
			// STEP 4: Execute a query
			String sql = "select p.*, t.familyname from \"Java\".treeconnect t, \"Java\".person p where p.treeid = t.tid";
//			String sql = "Select * from \"Java\".Person";
//			String sql2 = "Select familyname from \"Java\".treeconnect where tid="+currentTreeID;

			Statement stmt = con.createStatement();
			
			
//			ResultSet rs2 = stmt.executeQuery(sql2);

//			System.out.println(rs.next());
			Tree1 l;
//			String treename = "";
//			while(rs2.next()) {
//				treename = (rs2.getString("familyname"));
//				System.out.println("inner while");
//			}
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("outer while");
				
				l = new Tree1(rs.getString("firstname"), rs.getString("lastname"), rs.getDate("birthdate").toString(), 
						rs.getString("familyname"));
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
	public static ObservableList<Logic> TreeNodeCreate() {
		ObservableList<Logic> newlistdata= FXCollections.observableArrayList();

		try {
			// STEP 2: initialize JDBC driver
			Class.forName("org.postgresql.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			
			Connection con = DriverManager.getConnection("jdbc:postgresql://mod-databases-dubai.cs.bham.ac.uk:5432/axk1029", USER_Name, PASSWORD);

			System.out.println("Connected...");
			
			// STEP 4: Execute a query
			String sql = "Select * from \"Java\".Person where treeid="+currentTreeID;
//			String sql2 = "Select familyname from \"Java\".treeconnect where tid="+currentTreeID;

			Statement stmt = con.createStatement();
			
			
//			ResultSet rs2 = stmt.executeQuery(sql2);

//			System.out.println(rs.next());
			Logic l;
			boolean male;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println("outer while");
				if(rs.getString("gender")== "Female") {
					male = false;
				}
				else {
					male = true;
				}
				l = new Logic(rs.getInt("pid"), currentTreeID,rs.getString("firstname"), rs.getString("lastname"),male, rs.getDate("birthdate").toString(),rs.getString("birthplace").toString(),
						rs.getDate("dateofdeath").toString(),rs.getString("deathplace"),rs.getString("biography"));
				System.out.println(l);
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
	static final String USER_Name = "axk1029";
	static final String PASSWORD = "woe+loss118";
}

