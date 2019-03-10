package Graphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import Logic.Tree;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class TreeScreenModel {

	public Group root;
	public static ArrayList<Tree> getNodes(){
		ArrayList<Tree> trees = new ArrayList<Tree>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\lschw\\Documents\\Bham\\Term2\\TeamProject\\FamilyTree\\src\\Graphics\\DatabaseMockUp"));
			Tree t;
			String line;
			while((line = br.readLine()) != null) {
				String[] lineA = line.split(",");
				int id = Integer.parseInt(lineA[0]);
				String firstname = lineA[1];
				String lastname = lineA[2];
				boolean male = false;
				if(lineA[3].equals("male")) {
					male = true;
				}
				String birthdate = lineA[4];
				String birthplace = lineA[5];
				int familyID = Integer.parseInt(lineA[6]);
				if(lineA.length>7) {
					String deathdate = lineA[7];
					String deathplace = lineA[8];
					t = new Tree(firstname, lastname, male, birthdate, birthplace, familyID, deathdate, deathplace);
				}
				else {
					t = new Tree(id, firstname, lastname, male, birthdate, birthplace, familyID);
				}
				trees.add(t);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trees;
	}
	
	public static int findLevelWithMaxNodes(ArrayList<Tree> trees, int minLevel, int maxlevel, Tree focused) {
		int numberOfLevels = maxlevel - minLevel;
		int max = 0;
		double levelWithMaxNodes = 0;
		int level = minLevel;
		if(focused != null) {
			levelWithMaxNodes = focused.getTreeLevel();
		}
		else {
			for(int i = 1; i<numberOfLevels; i++) {
				int no = 0;
				for(int j = 0; j<trees.size(); j++) {
					if(trees.get(j).getTreeLevel()==level) {
						no++;
					}
				}
				if(no>max) {
					max = no;
					levelWithMaxNodes = level;
				}
				level++;
			}
		}
		return (int) levelWithMaxNodes;
	}
	
	public static int findNumberOfNodesInLevel(ArrayList<Tree> trees, int level) {
		int max = 1;
		for(Tree t : trees) {
			if(t.getTreeLevel() == level) {
				max++;
			}
		}
		return max;
	}
	
	public static int findMaxLevel(ArrayList<Tree> trees) {
		int maxLevel = trees.get(0).getTreeLevel();
		for(Tree t1 : trees) {
			if(t1.getTreeLevel()>maxLevel) {
				maxLevel = t1.getTreeLevel();
			}
		}
		return maxLevel;
	}
	
	public static int findMinLevel(ArrayList<Tree> trees) {
		int minLevel = trees.get(0).getTreeLevel();
		for(Tree t1 : trees) {
//			System.out.println(t1.getFirstName() + " min: " +minLevel);
			if(t1.getTreeLevel()<minLevel) {
				minLevel = t1.getTreeLevel();
			}
		}
//		System.out.println("final min: "+ minLevel);
		return minLevel;
	}
	public static ArrayList<Tree> sortTrees(ArrayList<Tree> trees, Tree focused) {
		int maxLevel = findMaxLevel(trees);
		int minLevel = findMinLevel(trees);
		int levelWithMaxNodes = TreeScreenModel.findLevelWithMaxNodes(trees, minLevel, maxLevel, focused);
		ArrayList<Tree> sortedTrees = new ArrayList<Tree>();
		ArrayList<Tree> higherTrees = new ArrayList<Tree>();
		ArrayList<Tree> copyTrees = new ArrayList<>();
		copyTrees.addAll(trees);
		for(Tree t : trees) {
			if(t.getTreeLevel() == levelWithMaxNodes) {
				sortedTrees.add(t);
				copyTrees.remove(t);
			}
			if(t.getTreeLevel() < levelWithMaxNodes) {
				higherTrees.add(t);
				copyTrees.remove(t);
			}
		}
		
//		System.out.println("Sorted trees:  "+ sortedTrees);
		ArrayList<Tree> sortedWithoutSpouses = new ArrayList<>();
		ArrayList<Tree> siblingTrees = new ArrayList<>();
		
		if(focused != null) {
			siblingTrees.add(focused);
		}
		for(Tree t1 : sortedTrees) {
			if(!t1.equals(focused)) {
				if(t1.getSpouse() != null) {
					if(!siblingTrees.contains(t1.getSpouse())) {
						siblingTrees.add(t1);
					}
					else {
//						System.out.println(t1.getFirstName());
						sortedWithoutSpouses.add(t1);
					}
				}
				else {
					siblingTrees.add(t1);
				}
			}
			
		}

//		System.out.println("Sibling trees here:  "+ siblingTrees);

		double max = siblingTrees.size();
		
		Comparator<Tree> LevelComp = new Comparator<Tree>() {
			public int compare(Tree t1, Tree t2) {
				return t1.getTreeLevel()-t2.getTreeLevel();
			}
		};
		Collections.sort(higherTrees, LevelComp.reversed());
		Collections.sort(copyTrees, LevelComp);
		sortedTrees.addAll(higherTrees);
		sortedTrees.addAll(copyTrees);
		return sortedTrees;
	}
	
	public static ArrayList<Tree> getSiblingTrees(ArrayList<Tree> sortedTrees, Tree focused){
		ArrayList<Tree> siblingTrees = new ArrayList<>();
		int levelWithMaxNodes = findLevelWithMaxNodes(sortedTrees, findMinLevel(sortedTrees), findMaxLevel(sortedTrees), focused);
		
		if(focused != null) {
			siblingTrees.add(focused);
		}
		for(Tree t1 : sortedTrees) {
			if(t1.getTreeLevel() == levelWithMaxNodes) {
				if(!t1.equals(focused)) {
					if(t1.getSpouse() != null) {
						if(!siblingTrees.contains(t1.getSpouse())) {
							siblingTrees.add(t1);
						}
					}
					else {
						siblingTrees.add(t1);
					}
				}
			}
			
		}
		return siblingTrees;
	}
	
	public static double getYPosition(ArrayList<Tree> trees, Tree t, double treeLevel, Tree focused, double scale, double y1, double y2) {
		int min =  findMinLevel(trees);
		int max = findMaxLevel(trees);

		int numberOfLevels = max-min+1;
		int levelWithMaxNodes = findLevelWithMaxNodes(trees, min, max, focused);
		levelWithMaxNodes  = (int) numberOfLevels - (findMaxLevel(trees) -levelWithMaxNodes);
		double ypos = (y1+  scale*(((y2-y1)/2)*((1+2*(treeLevel-levelWithMaxNodes))/numberOfLevels)));
		return ypos;
	}
	
	
	public static double getFocusedXPosition(ArrayList<Tree> trees, Tree t, double treeLevel, Tree focused, double scale, double x1, double x2, int nodeIndex) {
		Comparator<Tree> PosComp = new Comparator<Tree>() {
			public int compare(Tree t1, Tree t2) {
				return (int) t1.getXPos()- (int)t2.getXPos();
			}
		};
		double xpos;
		ArrayList<Tree> siblingTrees = getSiblingTrees(sortTrees(trees, focused), focused);
//		System.out.println("Sibling trees" + siblingTrees + "");
//		System.out.println(siblingTrees.size());
		int middle=(int) siblingTrees.size()/2;
//		System.out.println("middle : " + middle);
		int levelWithMaxNodes = findLevelWithMaxNodes(trees, findMinLevel(trees), findMaxLevel(trees), focused);
		int numberOfLevels = findMaxLevel(trees)-findMinLevel(trees)+1;
		levelWithMaxNodes  = (int) numberOfLevels - (findMaxLevel(trees) -levelWithMaxNodes);
		int max = TreeScreenModel.findNumberOfNodesInLevel(trees, levelWithMaxNodes);

//		System.out.println(focused.getFirstName());
//		System.out.println("treeLevel model: " + treeLevel);
//		System.out.println("treeLevel max: " + levelWithMaxNodes);
		if(treeLevel==levelWithMaxNodes) {
//			System.out.println("same level: "+ t.getFirstName());
			if(t.equals(focused)) {
				xpos = x1+((x2-x1)/2.0);
//				System.out.println("xpos "+ xpos);
			}
			else {
				if(siblingTrees.contains(t)) {
					if(siblingTrees.indexOf(t)<middle) {
						System.out.println("< " + t.getFirstName());
						xpos = x1- 60*scale + scale*((((x2-x1)/2.0) -30*((1+3.0*nodeIndex)/max)));
					}
					else {
						if(middle >=3) {
							System.out.println("> " + t.getFirstName());

							xpos = (x2-x1)/2.0 +60*scale +scale*(( 30 *((1+3.0*nodeIndex)/max)));
						}
						else {
							xpos = scale*((x1+((x2-x1)/2.0-x1)*3 *((1+2.0*nodeIndex)/max)));
						}
					}
				}
				else if(t.getMale()){
					xpos = t.getSpouse().getXPos() - scale*0.7*60;
				}
				else {
					xpos= t.getSpouse().getXPos() + scale*0.7*60;
				}
			}
		}
		else if(treeLevel < levelWithMaxNodes) {
//			System.out.println("< "+t.getFirstName());
			double numberOfChildren=0;
			if(t.getChildren() != null) {
				numberOfChildren = t.getChildren().size();
			}
			if(numberOfChildren == 0) {
				int numberOfNodesInLevel = findNumberOfNodesInLevel(trees, t.getTreeLevel());
				System.out.println("nono level "+numberOfNodesInLevel);
//				double randomnum = rand.nextInt(numberOfNodesInLevel);
				double randomnum = Math.random()%numberOfNodesInLevel;
				System.out.println("random " +t.getFirstName() +", x: "+ randomnum);
				xpos = scale*((((x2-x1)/2.0) *((1+2.0*randomnum)/max)));
			}
			
			else if(numberOfChildren == 1) {
				if(t.getChildren().get(0).getSpouse() == null || (t.getChildren().get(0).getSpouse().getFather() == null && t.getChildren().get(0).getSpouse().getFather() == null)) {
					if(t.getSpouse() != null && t.getMale() == false) {
						xpos = t.getChildren().get(0).getXPos() + scale*0.8*60;
					}
					else {
						xpos = t.getChildren().get(0).getXPos();
					}
				}
				else {
					if(t.getSpouse() != null && t.getMale() == false) {
						xpos = t.getChildren().get(0).getXPos() + scale*260;
					}
					else {
						xpos = t.getChildren().get(0).getXPos() + scale*200;
					}
				}
			}
			else {
				double offset = 0;
				double potentialOffset = scale*100;
				for(Tree child : t.getChildren()) {
					if(child.getMale() == false && child.getSpouse() != null && (child.getSpouse().getFather() != null || child.getSpouse().getFather() != null)){
						offset = potentialOffset;
						if(child.getSpouse().getFather() != null) {
							offset += Collections.max(child.getSpouse().getFather().getChildren(), PosComp).getXPos();
						}
						else {
							offset += Collections.max(child.getSpouse().getMother().getChildren(), PosComp).getXPos();
						}
					}
					
				}
				
				if(offset == 0) {
					if(t.getSpouse() != null && t.getMale() == false) {
						xpos = ((Collections.min(t.getChildren(), PosComp)).getXPos() +Collections.max(t.getChildren(), PosComp).getXPos())/2.0+scale*0.8*60;
					}
					else {
						xpos = ((Collections.min(t.getChildren(), PosComp)).getXPos() +Collections.max(t.getChildren(), PosComp).getXPos())/2.0;
					}
				}
				else {
					if(t.getMale()) {
						xpos = offset;
					}
					else {
						xpos = offset+scale*0.8*60;
					}
				}
			}
		}
		else {
			if(t.getSpouse() != null && t.getSpouse().getXPos() != 0.0) {
				if(t.getMale()) {
					xpos = t.getSpouse().getXPos() - scale*0.7*60;
				}
				else {
					xpos = t.getSpouse().getXPos() + scale*0.7*60;
				}
			}
			else {
				int numberOfSiblings;
				if(t.getFather() != null) {
					numberOfSiblings = t.getFather().getChildren().size()-1;
					allocateChildPositions(t.getFather(), numberOfSiblings);

				}
				else if(t.getMother() != null){
					numberOfSiblings = t.getMother().getChildren().size()-1;
					allocateChildPositions(t.getMother(), numberOfSiblings);
				}
				else {
					numberOfSiblings = 0;
				}
				if(numberOfSiblings > 0) {
					if(t.getMother() == null) {
						double minBorder = t.getFather().getXPos() - scale*164;
						double maxBorder = t.getFather().getXPos() + scale*164;
	
						xpos = t.getFather().getXPos()+(maxBorder-minBorder)/2.0 * ((2.0*t.getNoNo())/(numberOfSiblings+2));
					}
					else {
						double minBorder = t.getFather().getXPos() - scale*(164.0/(treeLevel+0.5));
						double maxBorder = t.getFather().getXPos() + scale*(164.0/(treeLevel+0.5));

						xpos = t.getFather().getXPos()- scale*1.1 * (maxBorder-minBorder)/2.0 * ((2.0*t.getNoNo())/(numberOfSiblings+1));
					}
				}
				else {
					if(t.getMother() == null && t.getFather() != null) {
						xpos = t.getFather().getXPos();
					}
					else if(t.getMother() != null){
						if(t.getFather()==null) {
							xpos =t.getMother().getXPos();
						}
						else {
							xpos = t.getFather().getXPos()+scale*30;
						}
						
					}
					else {
						xpos = 300;
					}

				}
			}
		}
		
		return xpos;
	}
	
	public static double getXPosition(ArrayList<Tree> trees, Tree t, double treeLevel, double scale, double x1, double x2, double nodeIndex) {
		ArrayList<Tree> siblingTrees = sortTrees(trees, null);
		int levelWithMaxNodes = findLevelWithMaxNodes(trees, findMinLevel(siblingTrees), findMaxLevel(siblingTrees), null);
		int numberOfLevels = findMaxLevel(siblingTrees)-findMinLevel(siblingTrees)+1;
		int max = TreeScreenModel.findNumberOfNodesInLevel(trees, levelWithMaxNodes);
		levelWithMaxNodes  = (int) numberOfLevels - (findMaxLevel(trees) -levelWithMaxNodes);

		System.out.println("max: " + max);
//		System.out.println(t.getFirstName() + " treelevel model " + treeLevel);
//		System.out.println("maxlevel " + levelWithMaxNodes);


		double xpos;

		Comparator<Tree> PosComp = new Comparator<Tree>() {
			public int compare(Tree t1, Tree t2) {
				return (int) t1.getXPos()- (int)t2.getXPos();
			}
		};
		
		if(treeLevel==levelWithMaxNodes) {
			if(siblingTrees.contains(t) || t.getSpouse() == null) {
				xpos = x1+scale*(((x2-x1)/2.0 *((1+2.0*nodeIndex)/max)));
//				System.out.println("FIRST "+ t.getFirstName() + ", nodeindex: " +nodeIndex + ", xpos: "+ xpos);
			}
			else if(t.getMale()){
				xpos = t.getSpouse().getXPos() - scale*0.7*60;
			}
			else {
				xpos = t.getSpouse().getXPos() + scale*0.7*60;
			}
		}
		
		else if(treeLevel < levelWithMaxNodes) {
//			System.out.println("< "+t.getFirstName());
			double numberOfChildren=0;
			if(t.getChildren() != null) {
				numberOfChildren = t.getChildren().size();
			}
			if(numberOfChildren == 0) {
				xpos = 300;
			}
			
			else if(numberOfChildren == 1) {
				if(t.getChildren().get(0).getSpouse() == null || (t.getChildren().get(0).getSpouse().getFather() == null && t.getChildren().get(0).getSpouse().getFather() == null)) {
					if(t.getSpouse() != null && t.getMale() == false) {
						xpos = t.getChildren().get(0).getXPos() + scale*0.8*60;
					}
					else {
						xpos = t.getChildren().get(0).getXPos();
					}
				}
				else {
					if(t.getSpouse() != null && t.getMale() == false) {
						xpos = t.getChildren().get(0).getXPos() + scale*260;
					}
					else {
						xpos = t.getChildren().get(0).getXPos() + scale*200;
					}
				}
			}
			else {
				double offset = 0;
				double potentialOffset = scale*100;
				for(Tree child : t.getChildren()) {
					if(child.getMale() == false && child.getSpouse() != null && (child.getSpouse().getFather() != null || child.getSpouse().getFather() != null)){
						offset = potentialOffset;
						if(child.getSpouse().getFather() != null) {
							offset += Collections.max(child.getSpouse().getFather().getChildren(), PosComp).getXPos();
						}
						else {
							offset += Collections.max(child.getSpouse().getMother().getChildren(), PosComp).getXPos();
						}
					}
					
				}
				
				if(offset == 0) {
					if(t.getSpouse() != null && t.getMale() == false) {
						xpos = ((Collections.min(t.getChildren(), PosComp)).getXPos() +Collections.max(t.getChildren(), PosComp).getXPos())/2.0+scale*0.8*60;
					}
					else {
						xpos = ((Collections.min(t.getChildren(), PosComp)).getXPos() +Collections.max(t.getChildren(), PosComp).getXPos())/2.0;
					}
				}
				else {
					if(t.getMale()) {
						xpos = offset;
					}
					else {
						xpos = offset+scale*0.8*60;
					}
				}
			}
		}
		else {
			if(t.getSpouse() != null && t.getSpouse().getXPos() != 0.0) {
				if(t.getMale()) {
					xpos = t.getSpouse().getXPos() - scale*0.7*60;
				}
				else {
					xpos = t.getSpouse().getXPos() + scale*0.7*60;
				}
			}
			else {
				int numberOfSiblings;
				if(t.getFather() != null) {
					numberOfSiblings = t.getFather().getChildren().size()-1;
					allocateChildPositions(t.getFather(), numberOfSiblings);

				}
				else if(t.getMother() != null){
					numberOfSiblings = t.getMother().getChildren().size()-1;
					allocateChildPositions(t.getMother(), numberOfSiblings);
				}
				else {
					numberOfSiblings = 0;
				}
				if(numberOfSiblings > 0) {
					if(t.getMother() == null) {
						double minBorder = t.getFather().getXPos() - scale*164;
						double maxBorder = t.getFather().getXPos() + scale*164;
	
						xpos = t.getFather().getXPos()+(maxBorder-minBorder)/2.0 * ((2.0*t.getNoNo())/(numberOfSiblings+2));
					}
					else {
						double minBorder = t.getFather().getXPos() - scale*(164.0/(treeLevel+0.5));
						double maxBorder = t.getFather().getXPos() + scale*(164.0/(treeLevel+0.5));

						xpos = t.getFather().getXPos()+ scale*30 + (maxBorder-minBorder)/2.0 * ((2.0*t.getNoNo())/(numberOfSiblings+1));
					}
				}
				else {
					if(t.getMother() == null && t.getFather() != null) {
						xpos = t.getFather().getXPos();
					}
					else if(t.getMother() != null){
						if(t.getFather()==null) {
							xpos =t.getMother().getXPos();
						}
						else {
							xpos = t.getFather().getXPos()+scale*30;
						}
						
					}
					else {
						xpos = 300;
					}

				}
			}
		}
		return xpos;
		
	}
	
	public static void allocateChildPositions(Tree parent, int numberOfSiblings) {
		if(numberOfSiblings == 1) {
			parent.getChildren().get(0).setNoNo(-1);
			parent.getChildren().get(1).setNoNo(1);

		}
		else {
		double middle = numberOfSiblings/2.0;
		
		int counter = 1;
		for(int i = 0; i<parent.getChildren().size(); i++) {
			if(numberOfSiblings-i > middle) {
				parent.getChildren().get(i).setNoNo(-counter);
				counter--;
			}
			else {
				parent.getChildren().get(i).setNoNo(counter);
				counter++;
			}
		}
		}
		
	}
	
	public static Group generateNodes(Group root, ArrayList<Tree> trees, Stage stage, Tree focused) {
		/**
		 * for every node, a Button is created
		 */
//		ArrayList<Tree> trees = TreeScreenModel.getNodes();

		ToggleGroup tg = new ToggleGroup();
		double scale = 1.0;
		int y2 = 800;
		int y1 = 350;
		int x2 = 1000;
		int x1 = 250;

		int maxLevel = TreeScreenModel.findMaxLevel(trees);
		System.out.println("maxLevel main " + maxLevel);
		int minLevel = TreeScreenModel.findMinLevel(trees);
		System.out.println("minLevel main " + minLevel);


		double numberOfLevels = maxLevel-minLevel + 1;
//		System.out.println("number of levels: " +numberOfLevels);

		
		double maxNodesInOneLevel = 0;
		
		
//		ArrayList<Tree> temp = trees;
//		Collections.sort(temp, LevelComp);
		
//		Tree focused = null;
		int levelWithMaxNodes = TreeScreenModel.findLevelWithMaxNodes(trees, minLevel, maxLevel, focused);
		int max = TreeScreenModel.findNumberOfNodesInLevel(trees, levelWithMaxNodes);
		int nodeIndex = 0;


		ArrayList<Tree> sortedTrees = TreeScreenModel.sortTrees(trees, focused);
		ArrayList<Tree> siblingTrees = TreeScreenModel.getSiblingTrees(sortedTrees, focused);


		ToggleButton[] tbA = new ToggleButton[trees.size()];
		int i = 0;
//		System.out.println("sibling trees " + siblingTrees);
		for(Tree t : sortedTrees) {
			double treeLevel = numberOfLevels - (maxLevel -t.getTreeLevel());
//			System.out.println(t.getFirstName() + " treelevel main " + treeLevel);
			ToggleButton treebutton = new ToggleButton(t.getFirstName());
			treebutton.setShape(new Circle(10));
			
			if(t.getMale()) {
				treebutton.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 2px;-fx-border-color: #006400");
			}
			else {
				treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 2px;-fx-border-color: #006400");
			}
			treebutton.setMinSize(scale*0.8*50, scale*0.8*50);
			treebutton.setMaxSize(scale*0.8*50, scale*0.8*50);
			t.setYPos(TreeScreenModel.getYPosition(trees, t, treeLevel, focused, scale, y1, y2));
			treebutton.setLayoutY(t.getYPos());
			if(t.equals(focused)) {
				if(focused.getMale()) {
					treebutton.setStyle("-fx-background-color: #87CEFA; -fx-border-width: 3px;-fx-border-color: #FF0000");
				}
				else {
					treebutton.setStyle("-fx-background-color: #FFB6C1; -fx-border-width: 3px;-fx-border-color: #FF0000");
				}

			}
			if(focused != null) {
//				System.out.println("HERE");
//				System.out.println("treeLevel main: " + treeLevel);

				t.setXPos(TreeScreenModel.getFocusedXPosition(sortedTrees, t, treeLevel, focused, scale, x1, x2, nodeIndex));
			}
			else {
				t.setXPos(TreeScreenModel.getXPosition(sortedTrees, t, treeLevel, scale, x1, x2, nodeIndex));
//				System.out.println(t.pos);
			}
			treebutton.setLayoutX(t.getXPos());

			
			treebutton.setToggleGroup(tg);
			NodeEventHandler neh = new NodeEventHandler(t, stage, root, tg);
			treebutton.addEventFilter(MouseEvent.MOUSE_MOVED, neh);
//			treebutton.setOnAction(evt -> {if(treebutton.isSelected()) {treebutton.setStyle("-fx-background-color: #EEE8AA");} else{treebutton.setStyle("-fx-background-color: #006400");}});
			
			System.out.println(t.getFirstName() + ", x: "+ t.getXPos()+ ", y: "+t.getYPos());
//			t.setXPos(treebutton.getLayoutX());
//			System.out.println("firstname: " + t.getFirstName() + ", x pos: " + treebutton.getLayoutX());
			root.getChildren().add(treebutton);
			tbA[i] = treebutton;
			if(t.getTreeLevel() == levelWithMaxNodes && siblingTrees.contains(t)) {
			nodeIndex++;
			}
			i++;
		}

		for(Tree t : trees) {
			if(t.getMother() != null) {
//				System.out.println("mother: " +t.getMother().getFirstName());
//				System.out.println(t.getMother().pos);
				Line m = new Line(t.getXPos()+scale*0.8*25, t.getYPos(), t.getMother().getXPos()+scale*0.8*25, t.getMother().getYPos()+scale*0.8*50);
				m.setStyle("-fx-stroke: #FFFFFF");
//				System.out.println("firstname: "+ t.getFirstName());
				root.getChildren().add(m);
			}
			if(t.getFather() != null) {
//				System.out.println("mother: " +t.getMother().getFirstName());
//				System.out.println(t.getMother().pos);
				Line m = new Line(t.getXPos()+scale*0.8*25, t.getYPos(), t.getFather().getXPos()+scale*0.8*25, t.getFather().getYPos()+scale*0.8*50);
				m.setStyle("-fx-stroke: #000000");
//				System.out.println("firstname: "+ t.getFirstName());
				root.getChildren().add(m);
			}
			if(t.getSpouse() != null && t.getMale()) {
				Circle ring1 = new Circle(2.5*scale, Color.MEDIUMSEAGREEN);
				ring1.setStroke(Color.GOLD);
				ring1.setCenterX(t.getXPos() +scale*0.75*54);
				ring1.setCenterY(t.getYPos() + scale*25);
				root.getChildren().add(ring1);
				Circle ring2 = new Circle(2.5*scale, Color.MEDIUMSEAGREEN);
				ring2.setStroke(Color.GOLD);
				ring2.setCenterX(t.getXPos() +scale*0.75*57);
				ring2.setCenterY(t.getYPos() + scale*25);
				root.getChildren().add(ring2);
				Shape s = Shape.intersect(ring1, ring2);
				s.setFill(Color.TRANSPARENT);
				s.setStroke(Color.WHITESMOKE);
				root.getChildren().add(s);
			}
			
			
			
		}
		return root;
	}
	
	public static void main(String[] args) {
		getNodes();
	}
}
