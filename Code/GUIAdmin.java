/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guievoting1;

/**
 *
 * @author thinkpad
 */
import java.awt.BorderLayout;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIAdmin extends Admin{
    



    List<String> entriesN = loadEntriesFromFile("NADRA.txt");
    List<String> entriesEC = loadEntriesFromFile("ElectionCommission.txt");
    
    public void GUIAdminVerifyCheck(){
        JFrame verifyFrame = new JFrame("Admin Verification");
        verifyFrame.setSize(300, 200);
        
        
        //verifyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JTextField passwordField = new JTextField();
        JButton verifyButton = new JButton("Verify");

       

        verifyButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                setName(usernameField.getText());
                setPassword(passwordField.getText());

                if (verifyAdmin(getName(), getPassword())) {
                   
                    NADRAorEC();
                  
                    verifyFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(verifyFrame, "Invalid credentials. Try again.");
                    
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });

        JPanel verifyPanel = new JPanel();
        verifyPanel.setLayout(new BoxLayout(verifyPanel, BoxLayout.Y_AXIS));
        verifyPanel.add(usernameLabel);
        verifyPanel.add(usernameField);
        verifyPanel.add(passwordLabel);
        verifyPanel.add(passwordField);
        verifyPanel.add(verifyButton);

      
        verifyFrame.add(verifyPanel);

      
        verifyFrame.setVisible(true);
    }



    public void NADRAorEC(){
        JFrame addframe = new JFrame("Admin Console");
        addframe.setSize(300, 200);
       // addframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JButton nadraButton = new JButton("NADRA");
        JButton electionCommissionButton = new JButton("Election Commission");

       
        nadraButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
               
                JOptionPane.showMessageDialog(addframe, "NADRA button clicked!");
                NADRAGUISelectOption();
                addframe.dispose();
            }
        });

        electionCommissionButton.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
               
                JOptionPane.showMessageDialog(addframe, "Election Commission button clicked!");
                ECGUISelectOption();
                addframe.dispose();
            }
        });

      
        JPanel panel = new JPanel();
        panel.add(nadraButton);
        panel.add(electionCommissionButton);

        // Add the panel to the addframe
        addframe.add(panel);

        // Set the addframe visibility to true
        addframe.setVisible(true);

    }
    
    private void displayRequestsAndAccept() {
            JFrame frame = new JFrame("Display Requests and Accept");
            frame.setSize(400, 200);
            //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BorderLayout());
    
            JTextArea requestsArea = new JTextArea();
            JButton acceptButton = new JButton("Accept Request");
    
            frame.add(new JLabel("Requests:"), BorderLayout.NORTH);
            frame.add(new JScrollPane(requestsArea), BorderLayout.CENTER);
            frame.add(acceptButton, BorderLayout.SOUTH);
    
            displayRequests(requestsArea);
    
            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedRequest = requestsArea.getSelectedText();
                    if (selectedRequest != null) {
                        acceptRequest(selectedRequest);
                        displayRequests(requestsArea); // Refresh the displayed requests
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please select a request to accept.");
                    }
                }
            });
    
            frame.setVisible(true);
        }
    
        private void displayRequests(JTextArea requestsArea) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Requests.txt"))) {
                StringBuilder requests = new StringBuilder();
    
                String line;
                while ((line = reader.readLine()) != null) {
                    requests.append(line).append("\n");
                }
    
                requestsArea.setText(requests.toString());
    
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    
        private void acceptRequest(String selectedRequest) {
            try (FileWriter writer = new FileWriter("ElectionCommission.txt", true)) {
                writer.write(selectedRequest + "\n");
               // JOptionPane.showMessageDialog(frame, "Request accepted and added to Election Commission.");
            } catch (IOException ex) {
                ex.printStackTrace();
              //  JOptionPane.showMessageDialog(this, "Error accepting request. Please try again.");
            }
        }
    
    
    
    public void NADRAGUISelectOption(){
    JFrame optionFrame = new JFrame("Admin Console");
        optionFrame.setSize(400, 300);
      //  optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons for each action
        JButton addButton = new JButton("Add Information");
       // JButton displayButton = new JButton("Display Information");
       // JButton updateButton = new JButton("Update Information");
       // JButton deleteButton = new JButton("Delete Information");

        
        addButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(optionFrame, "Add Information button clicked!");
                //addInfoNadra();
                JFrame f=new JFrame("Add Information in NADRA");
                f.setSize(400, 400);
                JPanel p=new JPanel(null);

                JLabel l1=new JLabel("Enter cnic: ");
                l1.setBounds(10,10,100,50);

                JLabel l2=new JLabel("Enter name: ");
                l2.setBounds(10,40,100,50);

                JLabel l3=new JLabel("Enter province: ");
                l3.setBounds(10,70,100,50);

                JLabel l4=new JLabel("Enter city: ");
                l4.setBounds(10,100,100,50);

                JLabel l5=new JLabel("Enter DOB: ");
                l5.setBounds(10,130,100,50);
                
                JTextField t1=new JTextField();
                t1.setBounds(100, 25, 150, 20);

                 JTextField t2=new JTextField();
                t2.setBounds(100, 55, 150, 20);

                
                 JTextField t3=new JTextField();
                t3.setBounds(100, 85, 150, 20);
                
                 JTextField t4=new JTextField();
                t4.setBounds(100, 115, 150, 20);
                
                JTextField t5=new JTextField();
                t5.setBounds(100, 145, 150, 20);


                JButton b=new JButton("Submit");
                b.setBounds(200, 250, 100, 40);


                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String cnic = t1.getText();
                        String name = t2.getText();
                        String province = t3.getText();
                        String city = t4.getText();
                        String DOB=t5.getText();
        
                        if (!cnic.isEmpty() && !name.isEmpty() && !province.isEmpty() && !city.isEmpty()) {
                            addEntryToFile(cnic, name, province, city, DOB);
                            JOptionPane.showMessageDialog(f, "Entry added successfully!");
                            f.dispose();
                        } else {
                            JOptionPane.showMessageDialog(f, "Please fill in all fields.");
                        }
                    }
                });

                p.add(l1);
                p.add(l2);
                p.add(l3);
                p.add(l4);
                p.add(l5);
                p.add(t1);
                p.add(t2);
                p.add(t3);
                p.add(t4);
                p.add(t5);
                p.add(b);
                f.add(p);

                f.setVisible(true);
                //optionFrame.dispose();

            }
        });
        /*displayButton.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(optionFrame, "Display Information button clicked!");
               
            }
        });*/

   /*     updateButton.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(optionFrame, "Update Information button clicked!");
              //  UpdateInformationNADRAGUI(entriesN);
                saveEntriesToFile(entriesN, "NADRA.txt");
            
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(optionFrame, "Delete Information button clicked!");
            //   deleteInfoNADRAGUI(entriesN);
                saveEntriesToFile(entriesN, "NADRA.txt");
            }
        });
*/
        // Create a panel to organize components
        JPanel panel = new JPanel();
        panel.add(addButton);
       // panel.add(displayButton);
        //panel.add(updateButton);
       // panel.add(deleteButton);

        // Add components to the addframe
        optionFrame.add(panel);

        // Set the addframe visibility to true
        optionFrame.setVisible(true);

}








private void addEntryToFile(String cnic, String name, String province, String city, String DOB) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("NADRA.txt", true))) {
        String entry = cnic + "," + name + "," + province + "," + city+","+DOB;
        writer.write(entry);
        writer.newLine();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}




private void addEntryToFileEC(String cnic, String name, String province, String city, String party) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Election Commission.txt", true))) {
        String entry = cnic + "," + name + "," + province + "," + city+ ","+party;
        writer.write(entry);
        writer.newLine();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}





public void ECGUISelectOption(){
    JFrame optionFrame = new JFrame("Admin Console");
        optionFrame.setSize(400, 300);
    //    optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons for each action
       // JButton addButton = new JButton("Add Information");
        JButton displayButton = new JButton("Display Requests");
     //   JButton updateButton = new JButton("Update Information");
     //   JButton deleteButton = new JButton("Delete Information");

        
       /* addButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(optionFrame, "Add Information button clicked!");
                // Add your logic for adding information here
                JFrame f=new JFrame("Add Information in Election Commission");
                f.setSize(400, 400);
                JPanel p=new JPanel(null);

                JLabel l1=new JLabel("Enter cnic: ");
                l1.setBounds(10,10,100,50);

                JLabel l2=new JLabel("Enter name: ");
                l2.setBounds(10,40,100,50);

                JLabel l3=new JLabel("Enter province: ");
                l3.setBounds(10,70,100,50);

                JLabel l4=new JLabel("Enter city: ");
                l4.setBounds(10,100,100,50);

                JLabel l5=new JLabel("Enter party: ");
                l5.setBounds(10,130,100,50);

                JTextField t1=new JTextField();
                t1.setBounds(100, 25, 150, 20);

                 JTextField t2=new JTextField();
                t2.setBounds(100, 55, 150, 20);

                
                 JTextField t3=new JTextField();
                t3.setBounds(100, 85, 150, 20);
                
                 JTextField t4=new JTextField();
                t4.setBounds(100, 115, 150, 20);

                 
                 JTextField t5=new JTextField();
                t5.setBounds(100, 145, 150, 20);

                JButton b=new JButton("Submit");
                b.setBounds(200, 250, 100, 40);


                 b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String cnic = t1.getText();
                        String name = t2.getText();
                        String province = t3.getText();
                        String city = t4.getText();
                        String party=t5.getText();
        
                        if (!cnic.isEmpty() && !name.isEmpty() && !province.isEmpty() && !city.isEmpty()  && !party.isEmpty()) {
                            addEntryToFileEC(cnic, name, province, city, party);
                            JOptionPane.showMessageDialog(f, "Entry added successfully!");
                            f.dispose();
                        } else {
                            JOptionPane.showMessageDialog(f, "Please fill in all fields.");
                        }
                    }
                });

                p.add(l1);
                p.add(l2);
                p.add(l3);
                p.add(l4);
                p.add(l5);
                p.add(t1);
                p.add(t2);
                p.add(t3);
                p.add(t4);
                p.add(t5);
                p.add(b);
                f.add(p);

                f.setVisible(true);
            }
        });*/

        displayButton.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(optionFrame, "Display Information button clicked!");
             displayRequestsAndAccept();
            }
        });

      /*  updateButton.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(optionFrame, "Update Information button clicked!");
                 // UpdateInformationECGUI(entriesEC);
                saveEntriesToFile(entriesEC, "ElectionCommission.txt");
                
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(optionFrame, "Delete Information button clicked!");
               //  deleteInfoECGUI(entriesEC);
                saveEntriesToFile(entriesEC, "Election Commission.txt");
                
            }
        });*/

        // Create a panel to organize components
        JPanel panel = new JPanel();
      //  panel.add(addButton);
        panel.add(displayButton);
       // panel.add(updateButton);
       // panel.add(deleteButton);

        // Add components to the addframe
        optionFrame.add(panel);

        // Set the addframe visibility to true
        optionFrame.setVisible(true);
}
}