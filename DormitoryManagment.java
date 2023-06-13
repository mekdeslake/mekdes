/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dormitorymanagment;
import java.util.*;
/**
 *
 * @author hp
 */
public class DormitoryManagment {

private String uniName;
private String BuildingName;
private int BuildingNo;
private String location;
private java.util.Date dateCreated;


public DormitoryManagment(){
    dateCreated=new java.util.Date();
}

public DormitoryManagment( String BuildingName, int BuidingNo, String location ){
    dateCreated=new java.util.Date();
    this.BuildingName=BuildingName;
    this.BuildingNo=BuidingNo;
    this.location=location;   
}

public String getuniName(){
    return uniName;
}
public void setuniName(String uniName){
    this.uniName=uniName;
}

public String getBuildingNmae(){
    return BuildingName;
}
public void setBuildingName(String newBuildingName){
    this.BuildingName=newBuildingName;
}

public int getBuildingNo(){
    return BuildingNo;
}
public void setBuildingNo(int buildingNo){
    this.BuildingNo=buildingNo;
}

public String getlocation(){
    return location;
}

public void setlocation(String Location){
    this.location=Location;
}

public java.util.Date getDateCreated() {
 return dateCreated;
 }
}

class Student extends  Dorm{
   private String stuName;
   private int studID;
   private String Department;
   private String sex;
  
   public Student(){
       
   }
   
   public Student(String newStuName, int newStudID, String newDpartment, String newsex){
       this.stuName=newStuName;
       this.studID=newStudID;
       this.Department=newDpartment;
       this.sex=newsex;
   }
  public String getstuName(){
    return stuName;
}
public void setstuName(String newSex){
    this.sex=newSex;
}
  public String getsex(){
    return sex;
}
public void setsex(String newSex){
    this.stuName=newSex;
}
public double getstudID(){
    return studID;
}
public void setstudID(int newStudID){
    this.studID=newStudID;
}

public String getDepartment(){
    return Department;
}
public void setDepartment(String newDpartment){
    this.Department=newDpartment;
}

         
}



//this a dorm class which extends from the super class
class Dorm extends DormitoryManagment {
   private int DormNo;
   private int numberOfBeds;
   Dorm next;
   public Dorm(){
    super();   
   }
    public Dorm(int newDormNo, int newNumbrOfBeds  ){
        getBuildingNmae();
      this.DormNo= newDormNo;
      this.numberOfBeds=newNumbrOfBeds ;
   }
    
      public int getDormNo(){
    return DormNo;
}
public void setDormNo(int newDormNo){
    this.DormNo=newDormNo;
}

public int getnumberOfBeds(){
    return numberOfBeds;
}
public void setnumberOfBeds(int newnumberOfBeds){
    this.numberOfBeds=newnumberOfBeds;
}
   
}


//claass for the proctor who is responsible for managing and assigning sudents to their dorm
class Proctor extends DormitoryManagment{
//        private static LinkedList<Student> students = new LinkedList<>();
//     private static LinkedList<Dorm> dorms = new LinkedList<>();
//    private static List<DormitoryManagment> maleBuildings = new LinkedList<>();
//  private static List<DormitoryManagment> femaleBuildings = new LinkedList<>();
//  private static List<Proctor> proc = new LinkedList<>();
  
    
public Proctor(){
  
}
public Proctor(String newProName, String newLname, String newQualification){
   
}
//this is assign student method which accepts instances of a class
public void assignStudent(List<Student> students, List<Dorm> dorms,  List<DormitoryManagment>  maleBuildings, List<DormitoryManagment> femaleBuildings){
   List<Student> maleStudents = new ArrayList<>();
  List<Student> femaleStudents = new ArrayList<>();

  for (Student student : students) {
    if (student.getsex().equalsIgnoreCase("male")) {
      maleStudents.add(student);
    } else {
      femaleStudents.add(student);
    }
  }

  assignMaleStudents(maleStudents, dorms, maleBuildings);
  assignFemaleStudents(femaleStudents, dorms, femaleBuildings);
    
}
private void assignMaleStudents(List<Student> students, List<Dorm> dorms, List<DormitoryManagment>  maleBuildings) {
  int dormNo = 0;
  int studentCount = 0;
  for (Student student : students) {
    if (studentCount == 8) {
      dormNo++;
      studentCount = 0;
      if (dormNo >= dorms.size()) {
        break;
      }
    }
    switch (student.getDepartment().toUpperCase()) {
      case "IT":
           if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 1;
        }
        student.setBuildingName(maleBuildings.get(0).getBuildingNmae());
        student.setBuildingNo(maleBuildings.get(0).getBuildingNo());
        student.setlocation(maleBuildings.get(0).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
      case "software":
           if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 9;
        }
        student.setBuildingName(maleBuildings.get(0).getBuildingNmae());
        student.setBuildingNo(maleBuildings.get(0).getBuildingNo());
        student.setlocation(maleBuildings.get(0).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
          case "mechanical":
               if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 18;
        }
        student.setBuildingName(maleBuildings.get(0).getBuildingNmae());
        student.setBuildingNo(maleBuildings.get(0).getBuildingNo());
        student.setlocation(maleBuildings.get(0).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
              case "electrical":
                   if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 1;
        }
        student.setBuildingName(maleBuildings.get(1).getBuildingNmae());
        student.setBuildingNo(maleBuildings.get(1).getBuildingNo());
        student.setlocation(maleBuildings.get(1).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
         case "CS":
         if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 9;
        }
        student.setBuildingName(maleBuildings.get(1).getBuildingNmae());
        student.setBuildingNo(maleBuildings.get(1).getBuildingNo());
        student.setlocation(maleBuildings.get(1).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
                      case "IS":
                           if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 18;
        }
        student.setBuildingName(maleBuildings.get(1).getBuildingNmae());
        student.setBuildingNo(maleBuildings.get(1).getBuildingNo());
        student.setlocation(maleBuildings.get(1).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
      // Add similar cases for other departments
      default:
        // Do nothing
        break;
    }
  }
}

private void assignFemaleStudents(List<Student> students, List<Dorm> dorms, List<DormitoryManagment> femaleBuildings) {
  int dormNo = 1;
  int studentCount = 0;
  for (Student student : students) {
    switch (student.getDepartment().toLowerCase()) {
      case "IT":
        if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 1;
        }
        student.setBuildingName(femaleBuildings.get(0).getBuildingNmae());
        student.setBuildingNo(femaleBuildings.get(0).getBuildingNo());
        student.setlocation(femaleBuildings.get(0).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
      case "software":
        if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 8;
        }
        student.setBuildingName(femaleBuildings.get(0).getBuildingNmae());
        student.setBuildingNo(femaleBuildings.get(0).getBuildingNo());
        student.setlocation(femaleBuildings.get(0).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
           case "IS":
        if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 18;
        }
        student.setBuildingName(femaleBuildings.get(0).getBuildingNmae());
        student.setBuildingNo(femaleBuildings.get(0).getBuildingNo());
        student.setlocation(femaleBuildings.get(0).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
                case "chemical":
        if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 1;
        }
        student.setBuildingName(femaleBuildings.get(1).getBuildingNmae());
        student.setBuildingNo(femaleBuildings.get(1).getBuildingNo());
        student.setlocation(femaleBuildings.get(1).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
          case "electrical":
        if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 9;
        }
        student.setBuildingName(femaleBuildings.get(1).getBuildingNmae());
        student.setBuildingNo(femaleBuildings.get(1).getBuildingNo());
        student.setlocation(femaleBuildings.get(1).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
              
               case "mechanical":
               if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 18;
        }
        student.setBuildingName(femaleBuildings.get(0).getBuildingNmae());
        student.setBuildingNo(femaleBuildings.get(0).getBuildingNo());
        student.setlocation(femaleBuildings.get(0).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
               case "CS":
        if (studentCount == 8) {
          dormNo++;
          studentCount = 0;
        }
        if(dormNo >= dorms.size()) {
          dormNo = 18;
        }
        student.setBuildingName(femaleBuildings.get(1).getBuildingNmae());
        student.setBuildingNo(femaleBuildings.get(1).getBuildingNo());
        student.setlocation(femaleBuildings.get(1).getlocation());
        student.setDormNo(dorms.get(dormNo).getDormNo());
        studentCount++;
        break;
      // Add similar cases for other departments
      default:
        // Do nothing
        break;
    }
  } 
}

   public void editStudent(List<Student> students) {
       Scanner input = new Scanner(System.in);
  System.out.print("Enter the ID number of the student you want to edit: ");
  int studentId;
  try {
    studentId = input.nextInt();
  } catch (InputMismatchException e) {
    System.out.println("Invalid input. Please enter a valid number.");
    input.nextLine();
    return;
  }
  System.out.print("Enter the new block number you want to assign the student: ");
  int newBuildingBlock=input.nextInt();
  System.out.print("Enter the new building that you want to assign the student: ");
  String newBuilding=input.next();
  System.out.print("Enter the new dorm number you want to assign the student: ");
  int newDormNumber=input.nextInt();
  for (Student student : students) {
      if (student.getstudID() == studentId) {
        student.setDormNo(newDormNumber) ;
        student.setBuildingNo(newBuildingBlock);
        student.setBuildingName(newBuilding);
        System.out.println("Student with ID: " + studentId + " has been assigned to Dorm Number: " + newDormNumber +" newe Building:  "+newBuilding +" and Building Block: " + newBuildingBlock);
        return;
      }
    }
    System.out.println("Student with ID: " + studentId + " not found.");
  }
}




    


