package assignment201;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class A1_Model { //object class
	private static ArrayList<A1_Input> presidents = new ArrayList<>();
	private String name;
	private String surname;
	private int dob;
	private int lengthpresidency;
	private String picture;

	
	
	
    @Override
	public String toString() {
		return "A1_Model [name=" + name + ", surname=" + surname + ", dob=" + dob
				+ ", lengthpresidency=" + lengthpresidency + ", picture=" + picture + "]";
	}

	public A1_Model (String name, String surname, int dob, int lengthpresidency,
			String picture) {
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.lengthpresidency = lengthpresidency;
		this.picture = picture;
		//presidents.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public int getLengthpresidency() {
		return lengthpresidency;
	}

	public void setLengthpresidency(int lengthpresidency) {
		this.lengthpresidency = lengthpresidency;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	
	
	public static void loadObjectsFromCSV() {
        // Implement CSV loading logic here
    try {
		Scanner scan = new Scanner(new File ("C:\\Users\\dombt\\eclipse-workspace\\Programming1\\src\\objects.csv"));
		scan.nextLine();
	while (scan.hasNext()) {
		String lineString = scan.nextLine();
		String [] words = lineString.split(";");
		
		A1_Model a = new A1_Model (words[0], words[1], Integer.parseInt(words[2]), Integer.parseInt(words[3]), words[4]);
		
		//System.out.println(scan.nextLine());
		System.out.println(a);
	}
	
		
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    public void saveObjectsToCSV(String filename) {
        // Implement CSV saving logic here
    }

   /* public ArrayList<A1_Input> getObjects() {
        return objects;
    }
*/
    public void updateObject(A1_Input updatedObject) {
        // Implement object update logic here
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
loadObjectsFromCSV();
}
}
