/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dormitorymanagment;
import java.util.LinkedList;
import java.util.*;
/**
 *
 * @author hp
 */
public class TestDormManagment {
    private static Scanner input = new Scanner(System.in);
    private static LinkedList<Student> students = new LinkedList<>();
     private static LinkedList<Dorm> dorms = new LinkedList<>();
    private static List<DormitoryManagment> maleBuildings = new LinkedList<>();
  private static List<DormitoryManagment> femaleBuildings = new LinkedList<>();
  private static List<Proctor> proc = new LinkedList<>();
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int checker=0;
         int studchecker=0;
          while (true) {
      showMenu();
      int choice;
      try {
        choice = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        input.nextLine();
        continue;
      }
      if (choice == 1) {
        addBuilding();
        checker++;
      }
        if (choice == 2) {
        viewBuilding();
      }
      
      if (choice == 3) {
        addStudent();
        studchecker++;
      }
       else if (choice == 4) {
        AddDorm();
      }else if (choice == 5) {
          if(checker==0){
              System.out.println("Oops!....There is no student informtion recorded add data and come back later");  
               System.out.println("Press Enter to continue");
             try{System.in.read();}
             catch(Exception e){}
             
          }
          else{
          viewStudents();
          }
        
      }
      else if (choice == 6) {
          if(checker==0){
              System.out.println("Oops!....There is no building information to assign students. create building and come back later");  
               System.out.println("Press Enter to continue");
             try{System.in.read();}
             catch(Exception e){}
             
          }
          else{
          Proctor proctor = new Proctor();
          proctor.assignStudent(students, dorms, maleBuildings, femaleBuildings);
              System.out.println("Done! the students have assigned automatically");
          }
         
      }
      else if (choice == 7) {
          if(studchecker==0){
           System.out.println("Oops!....There is no student to be updated. Add student information and come back later");  
               System.out.println("Press Enter to continue");
             try{System.in.read();}
             catch(Exception e){}
          
          }
          else{
          Proctor proctor = new Proctor();
          proctor.editStudent(students);
          }
           
        
      } else if (choice == 8) {
        break;
      } 
    
      System.out.println();
    }
   
}
             private static void showMenu() {
    System.out.println("\t\t\t\tDormitory Management System");
    System.out.println("\t\t\t\t1. Add Buildings");
    System.out.println("\t\t\t\t2. View Buildings");
    System.out.println("\t\t\t\t3. Add Student");
    System.out.println("\t\t\t\t4. Add Dorms");
    System.out.println("\t\t\t\t5. View Students");
    System.out.println("\t\t\t\t6. assign Students");
    System.out.println("\t\t\t\t7. Edit Student");
    System.out.println("\t\t\t\t8. Exit");
    System.out.print("\t\t\t\tEnter your choice: ");
  }
          

     
      private static void addStudent() {
           int studNumber;
       Student[] stud;
        String stuName;
         int studID;
         String Department = null;
         String gender=null;
         int depList;
         int genderlist;
     System.out.println("How many students do you want to add?");
          try {
    studNumber = input.nextInt();
  } catch (InputMismatchException e) {
    System.out.println("Invalid input. Please enter a valid number.");
    input.nextLine();
    return;
  }
  
         for(int i=0; i<studNumber; i++){
          System.out.println("Name of the student?"); 
          stuName=input.next();
          System.out.println("ID of the student?"); 
           try {
       studID=input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        input.nextLine();
        continue;
      }
           System.out.println("Sex of the student?(male/female)"); 
               System.out.println("\t\t\t\t1. male");
               System.out.println("\t\t\t\t2. female");
              System.out.print("\t\t\t\tEnter your choice: ");
           genderlist=input.nextInt();
           if(genderlist==1){
           gender="Male";
           }
           else if(genderlist==2){
           gender="Female";
           }
            System.out.println("which one is the department of the student?");
    System.out.println("\t\t\t\t1. Computer science");
    System.out.println("\t\t\t\t2. Electrical engineering");
    System.out.println("\t\t\t\t3. IT");
    System.out.println("\t\t\t\t4. IS");
    System.out.println("\t\t\t\t5. Mechanical engineering");
    System.out.println("\t\t\t\t6. Software engineering");
    System.out.println("\t\t\t\t7. Water engineering");
    System.out.println("\t\t\t\t8. Chemical engineering");
    System.out.println("\t\t\t\t9. Food engineering");
    System.out.println("\t\t\t\t10. industrial engineering");
     System.out.print("\t\t\t\tEnter your choice: ");
            depList=input.nextInt();
            if(depList==1){
            Department="CS";
            }
            else if(depList==2){
            Department="Electrical";
            }
              else if(depList==3){
            Department="IT";
            }
             else if(depList==4){
            Department="IS";
            }
             else if(depList==5){
            Department="mechanical";
            }
             else if(depList==6){
            Department="software";
            }
             else if(depList==7){
            Department="water";
            }
             else if(depList==8){
            Department="chemical";
            }
             else if(depList==9){
            Department="food";
            }
             else if(depList==10){
            Department="industrial";
            }
             else{
             System.out.println("Invalid input. Please enter a valid number.");
             }
            Student student =new Student(stuName,studID, Department, gender);
            students.add(student);
          System.out.println("Student added successfully.");
     }
  }
       private static void addBuilding() {
           int num;
           int fmaleBuildingNum;
           String BuildingName;
         int BuildingNo;
         String BuildingLocation;
       System.out.println("how many building blocks are there for male students?");
        num=input.nextInt();
     for(int i=0; i<num; i++){  
      System.out.println("Enter the name of the building");
       BuildingName=input.next();
       System.out.println("Enter the block number of the building");
       BuildingNo=input.nextInt();
       System.out.println("Enter the location of the building");
       BuildingLocation=input.next();
       DormitoryManagment building=new DormitoryManagment(BuildingName,BuildingNo,BuildingLocation); 
        maleBuildings.add(building);
     }
     
     System.out.println("how many building blocks are there for fmale students?");
     fmaleBuildingNum=input.nextInt();
             for(int i=0; i<fmaleBuildingNum; i++){  
      System.out.println("Enter the name of the building");
       BuildingName=input.next();
       System.out.println("Enter the block number of the building");
       BuildingNo=input.nextInt();
       System.out.println("Enter the location of the building");
       BuildingLocation=input.next();
        DormitoryManagment building=new DormitoryManagment(BuildingName,BuildingNo,BuildingLocation); 
        femaleBuildings.add(building);
     }
       
       }
  
        private static void AddDorm(){
        System.out.println("How many available dorms are there in each block?");
        int num=input.nextInt();
        System.out.println("How many available Beds are there in each dorm?");
        int num1=input.nextInt();
        for(int i=0; i<num; i++){
        Dorm dorm=new Dorm(i,num1);
        dorms.add(dorm);
        }
        }
        
     public static void viewStudents() {
    System.out.println("List of Students:");
    for (int i = 0; i < students.size(); i++) {
      System.out.println((i + 1) + " Name. " + students.get(i).getstuName());
       System.out.println("ID. " + students.get(i).getstudID());
       System.out.println("Department. " + students.get(i).getDepartment());
      System.out.println("Building name. " + students.get(i).getBuildingNmae());
      System.out.println("Building number. " + students.get(i).getBuildingNo());
      System.out.println("Dorm number. " + students.get(i).getDormNo());
    }
  }
     private static void viewBuilding() {
     System.out.println("List of Male buildings:");
       for (int i = 0; i < maleBuildings.size(); i++) {
         System.out.println((i + 1 ) + ". Building Name: " + maleBuildings.get(i).getBuildingNmae());
       System.out.println("Block Number: " + maleBuildings.get(i).getBuildingNo());
       System.out.println("Building location: " + maleBuildings.get(i).getlocation());
       System.out.println("Building Crated: " + maleBuildings.get(i).getDateCreated());
       System.out.println();
       
       }
        System.out.println();
        System.out.println("*****************************************************************");
      
       
       System.out.println("List of Fmale buildings:");
      for (int i = 0; i < femaleBuildings.size(); i++) {
         System.out.println((i + 1 ) + ". Building Name: " +femaleBuildings.get(i).getBuildingNmae());
       System.out.println("Block Number: " + femaleBuildings.get(i).getBuildingNo());
       System.out.println("Building location: " + femaleBuildings.get(i).getlocation());
       System.out.println("Building Crated: " + femaleBuildings.get(i).getDateCreated());
        System.out.println();
       }
     
     }
  
    
        
        
    }
     
  
     
    

