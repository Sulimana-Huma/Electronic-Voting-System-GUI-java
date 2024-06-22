/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guievoting1;

/**
 *
 * @author thinkpad
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
    
public class Admin extends Person {
    // private static final String FILE_NAME = "NADRA.txt";
    private static final String ADMIN_FILE_NAME = "admin.txt";
    
     Scanner scanner = new Scanner(System.in);

        
     public static int readCNIC(){
        System.out.println("Input cnic");
        Scanner scan = new Scanner(System.in);
         while (!scan.hasNextInt()) {
         System.out.println("Input is not a CNIC Number. Enter again.");
         scan.nextLine();

          }
        int cnic = scan.nextInt();
        //System.out.println(cnic);
    return cnic;
    }



            

      public void SelectOption(){


        






          System.out.print("Enter Admin Name: ");
          setName(scanner.nextLine());
        System.out.print("Enter Admin Password: ");
          setPassword(scanner.nextLine());

        if (verifyAdmin(getName(), getPassword())) {
            System.out.println("Admin Verified Successfully!");
           // System.out.print("Enter the file name (NADRA.txt or ElectionCommission.txt): ");
           // String fileName = scanner.next();
             
             //List<String> entries = loadEntriesFromFile(fileName);

             List<String> entriesN = loadEntriesFromFile("NADRA.txt");
              List<String> entriesEC = loadEntriesFromFile("ElectionCommission.txt");
                boolean loop=true;
        while (loop==true) {
           
            System.out.println("1. Add Information");
            System.out.println("2. Display Information");
            System.out.println("3. Update Information");
            System.out.println("4. Delete Information");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                 System.out.println("Press 1 for NADRA: ");
                 System.out.println("Press 2 for election commission: ");
                int ch =scanner.nextInt();
                switch (ch) {
                    case 1:
                       
                       // List<String> entriesN = loadEntriesFromFile("NADRA.txt");
                        addInformationNADRA(entriesN);
                        saveEntriesToFile(entriesN, "NADRA.txt");
                        break;
                    case 2:
                     
                     // List<String> entriesEC = loadEntriesFromFile("ElectionCommission.txt");
                        addInformationEC(entriesEC);
                         saveEntriesToFile(entriesEC, "ElectionCommission.txt");
                        break;
                    default:
                    System.out.println("Invalid option");
                        break;
                }
                
                    break;











                case 2:
                 System.out.println("Press 1 for NADRA: ");
                 System.out.println("Press 2 for election commission: ");
                int ch1 =scanner.nextInt();
                switch (ch1) {
                    case 1:
                       
                        
                        displayInformationNADRA(entriesN);
                        
                        break;
                    case 2:
                     
                     // List<String> entriesEC = loadEntriesFromFile("ElectionCommission.txt");
                        displayInformationEC(entriesEC);
                        
                        break;
                    default:
                    System.out.println("Invalid option");
                        break;
                }
                   // displayInformationNADRA(entries);
                    break;








                case 3:
                System.out.println("Press 1 for NADRA: ");
                 System.out.println("Press 2 for election commission: ");
                int ch2 =scanner.nextInt();
                switch (ch2) {
                    case 1:
                       
                        
                        updateInformationNADRA(entriesN);
                        saveEntriesToFile(entriesN, "NADRA.txt");
                        break;
                    case 2:
                     
                     // List<String> entriesEC = loadEntriesFromFile("ElectionCommission.txt");
                        updateInformationEC(entriesEC);
                         saveEntriesToFile(entriesEC, "ElectionCommission.txt");
                        break;
                    default:
                    System.out.println("Invalid option");

                   // updateInformation(entries);
                    break;
                }
                break;











                case 4:
                 System.out.println("Press 1 for NADRA: ");
                 System.out.println("Press 2 for election commission: ");
                int ch3 =scanner.nextInt();
                switch (ch3) {
                    case 1:
                       
                        
                        deleteInformationNADRA(entriesN);
                         saveEntriesToFile(entriesN, "NADRA.txt");
                        break;
                    case 2:
                     
                     // List<String> entriesEC = loadEntriesFromFile("ElectionCommission.txt");
                        deleteInformationEC(entriesEC);
                         saveEntriesToFile(entriesEC, "ElectionCommission.txt");
                        break;
                    default:
                    System.out.println("Invalid option");

                   // updateInformation(entries);
                    break;
                }

                   // deleteInformation(entries);
                    break;
                
                
                
                
                
                
                
                
                
                
                
                
                    case 5:
                 


                    //saveEntriesToFile(entries, fileName);
                    System.out.println(" Goodbye Admin!");
                   // System.exit(0);
                loop=false;
                break;


                
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    
        } 
else {
            System.out.println("Admin Verification Failed. Invalid name or password.");
        }
      }
    




      
    public static boolean verifyAdmin(String name, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ADMIN_FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] adminInfo = line.split(",");
                if (adminInfo.length == 2 && adminInfo[0].equals(name) && adminInfo[1].equals(password)) {
                    return true; // Admin found and verified
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from admin file: " + e.getMessage());
        }
        return false; // Admin not found or error occurred
    }





    public static List<String> loadEntriesFromFile(String fileName) {
        List<String> entries = new ArrayList<>();
        BufferedReader br=null;
        FileReader fr=null;

        try 
        {   fr=new FileReader(fileName);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                entries.add(line);
            }
        fr.close();
        br.close();
        
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } 
        return entries;
    }





    public static void saveEntriesToFile(List<String> entries, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < entries.size(); i++) {
                String entry = entries.get(i); 
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }





    public static void addInformationNADRA(List<String> entries) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter CNIC: ");

        String cnic=Integer.toString(readCNIC());
        
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Province: ");
        String province = scanner.next();
        System.out.print("Enter City: ");
        String city = scanner.next();


        // Adding information to the list
        entries.add(cnic + "," + name + "," + province + "," + city);

        System.out.println("Information added successfully!");
    }


    public static void addInformationEC(List<String> entries) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter CNIC: ");

        String cnic=Integer.toString(readCNIC());
        
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Province: ");
        String province = scanner.next();
        System.out.print("Enter City: ");
        String city = scanner.next();
        System.out.print("Enter Party: ");
        String party = scanner.next();


        // Adding information to the list
        entries.add(cnic + "," + name + "," + province + "," + city + "," +party);

        System.out.println("Information added successfully!");
    }




    public static void displayInformationNADRA(List<String> entries) {
        System.out.println("CNIC\t  \tName\t  \tProvince \tCity");
        System.out.println("---------------------------------");

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            String[] parts = entry.split(",");
            System.out.println(parts[0] + "\t\t" + parts[1] + "\t\t" + parts[2]    + "\t\t" + parts[3]);
        }
    }



  public static void displayInformationEC(List<String> entries) {
        System.out.println("CNIC\t  \tName\t  \tProvince \tCity \tParty");
        System.out.println("---------------------------------");

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            String[] parts = entry.split(",");
            System.out.println(parts[0] + "\t\t" + parts[1] + "\t\t" + parts[2]    + "\t\t" + parts[3]   + "\t\t" + parts[4]);
        }
    }


    

    public static void updateInformationNADRA(List<String> entries) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the CNIC to update: ");
       // String cnicToUpdate = scanner.next();
         String cnicToUpdate=Integer.toString(readCNIC());

        boolean found = false;

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            String[] parts = entry.split(",");

            if (parts[0].equals(cnicToUpdate)) {
                System.out.print("Enter new Name: ");
                String newName = scanner.next();
                System.out.print("Enter new Province: ");
                String newProvince = scanner.next();
                System.out.print("Enter new city: ");
                String newCity = scanner.next();

                // Update information in the list
                entries.set(i, cnicToUpdate + "," + newName + "," + newProvince +  "," + newCity);

                System.out.println("Information updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("CNIC not found. No information updated.");
        }
    }


     public static void updateInformationEC(List<String> entries) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the CNIC to update: ");
       // String cnicToUpdate = scanner.next();
          String cnicToUpdate=Integer.toString(readCNIC());
        boolean found = false;

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            String[] parts = entry.split(",");

            if (parts[0].equals(cnicToUpdate)) {
                System.out.print("Enter new Name: ");
                String newName = scanner.next();
                System.out.print("Enter new Province: ");
                String newProvince = scanner.next();
                 System.out.print("Enter new city: ");
                String newCity = scanner.next();

                // Update information in the list
                entries.set(i, cnicToUpdate + "," + newName + "," + newProvince +"," + newCity);

                System.out.println("Information updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("CNIC not found. No information updated.");
        }
    }




    public static void deleteInformationNADRA(List<String> entries) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the CNIC to delete: ");
        //String cnicToDelete = scanner.next();
          String cnicToDelete=Integer.toString(readCNIC());

        boolean found = false;

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            String[] parts = entry.split(",");

            if (parts[0].equals(cnicToDelete)) {
                // Remove information from the list
                entries.remove(i);

                System.out.println("Information deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("CNIC not found. No information deleted.");
        }
    }


public static void deleteInformationEC(List<String> entries) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the CNIC to delete: ");
        //String cnicToDelete = scanner.next();
          String cnicToDelete=Integer.toString(readCNIC());

        boolean found = false;

        for (int i = 0; i < entries.size(); i++) {
            String entry = entries.get(i);
            String[] parts = entry.split(",");

            if (parts[0].equals(cnicToDelete)) {
                // Remove information from the list
                entries.remove(i);

                System.out.println("Information deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("CNIC not found. No information deleted.");
        }
    }




}

