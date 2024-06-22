/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guievoting1;

/**
 *
 * @author thinkpad
 */
import java.awt.Color;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.PasswordView;
//import javax.swing.text.PasswordView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class CandidateSide extends Person implements CandidateInterface{

    //Scanner enter = new Scanner(System.in);
    private int VerifiedCandidate;
    private boolean alreadyRegistered = true;
   // private String loginCNIC;
    

    public void SelectOption() {
        Color BlueSaphire=new Color(18, 97, 128);
        Font labF=new Font("Helvetica", Font.BOLD, 30);
        JFrame frame = new JFrame("CANDIDATE WINDOW");
        frame.setSize(1540, 820);
        JPanel panel = new JPanel(null);
        Color  ForestGreen=new Color(34, 139, 34);
       // frame.setLayout(null);
        ButtonGroup BG=new ButtonGroup();
         JLabel quote = new JLabel("\"Your Voice, Your Vote, Your Future! \"");
        quote.setBounds(520, 60, 500, 30);
        quote.setForeground(Color.white);
        quote.setFont(new Font("Pristina", Font.BOLD, 35));
        panel.add(quote);
        
        JLabel REG=new JLabel("Click here for Registeration. ");
        REG.setBounds(130, 180, 500, 30);
        REG.setFont(labF);
        REG.setForeground(Color.WHITE);
        panel.add(REG);
        
        JLabel LOG=new JLabel("Click here for Login. ");
        LOG.setBounds(130, 240, 500, 30);
        LOG.setFont(labF);
        LOG.setForeground(Color.WHITE);
        panel.add(LOG);
        
         JLabel req=new JLabel("Click here to request EC.");
        req.setBounds(130, 300, 700, 30);
        req.setFont(labF);
        req.setForeground(Color.WHITE);
        panel.add(req);
        
        JRadioButton rec=new JRadioButton();
         rec.setBounds(100, 300, 20, 30);
         rec.setBackground(ForestGreen);
         panel.add(rec);
        
        JLabel EXI=new JLabel("Click here for Exiting. ");
        EXI.setBounds(130, 360, 500, 30);
        EXI.setFont(labF);
        EXI.setForeground(Color.WHITE);
        panel.add(EXI);
        
        
        
        JRadioButton candReg=new JRadioButton();
         candReg.setBounds(100, 180, 20, 30);
         candReg.setBackground(ForestGreen);
         panel.add(candReg);
         
         JRadioButton canLogin=new JRadioButton();
         canLogin.setBounds(100, 240, 20, 30);
         canLogin.setBackground(ForestGreen);
         panel.add(canLogin);
         
         JRadioButton canExit=new JRadioButton();
         canExit.setBounds(100, 360, 20, 30);
         canExit.setBackground(ForestGreen);
         panel.add(canExit);
         BG.add(candReg);
         BG.add(canLogin);
         BG.add(canExit);
        JButton submit = new JButton("Submit");
        submit.setBounds(300, 500, 140, 40);
        submit.setFont(new Font("Arial",Font.BOLD,18));
        panel.add(submit);
        
        JButton backbutt = new JButton("Go Back");
        backbutt.setBounds(500, 500, 140, 40);
        backbutt.setFont(new Font("Arial",Font.BOLD,18));
        panel.add(backbutt);
        
        backbutt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        
        
    });
        
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {
                    if (candReg.isSelected()) {
                        InputCandidate();
                    } else if (canLogin.isSelected()) {
                        LOGIN();
                    }
                    else if(canExit.isSelected())
                    {
                        System.exit(0);
                    }
                    else if(rec.isSelected())
                    {
                        RequestEC();
                    }
                    else
                    {
                                            JOptionPane.showMessageDialog(frame, "Please Select Some Option. ", "Warning", JOptionPane.WARNING_MESSAGE);

                    }
                }
            }
        });
        JLabel backg;
ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Main Background.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame.getWidth(), back.getIconHeight());
        panel.add(backg);
        frame.add(panel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private boolean isThreeDigitInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return input.length() == 3;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidAlphabetic(String input) {
        return input.matches("^[a-zA-Z\\s]+$");
    }

    public void InputCandidate() {
        Color AquaBlue = new Color(107, 202, 226);
        Font labF=new Font("Helvetica", Font.BOLD, 30);
         Color BlueSaphire=new Color(18, 97, 128);
        
        Font TextF=new Font("Helvetica", Font.BOLD, 20);
        JFrame frame = new JFrame("CANDIDATE REGISTERATION");
        frame.setSize(1540, 820);
        JPanel panel = new JPanel(null);
        JLabel Lcnic = new JLabel("Enter your cnic: ");
        Lcnic.setBounds(360, 50, 500, 30);
        Lcnic.setForeground(Color.WHITE);
        Lcnic.setFont(labF);
        panel.add(Lcnic);
        JTextField cnic = new JTextField();
        cnic.setBounds(680, 50, 300, 40);
        cnic.setFont(TextF);
        cnic.setBackground(Color.white);
        panel.add(cnic);

        JLabel Lname = new JLabel("Enter your name: ");
        Lname.setBounds(360, 100, 500, 30);
         Lname.setForeground(Color.WHITE);
        Lname.setFont(labF);
        panel.add(Lname);
        JTextField name = new JTextField();
        name.setBounds(680, 100, 300, 40);
        name.setFont(TextF);
        name.setBackground(Color.white);
        panel.add(name);

        JLabel Lprovince = new JLabel("Enter your province: ");
        Lprovince.setBounds(360, 150, 500, 30);
         Lprovince.setForeground(Color.WHITE);
        Lprovince.setFont(labF);
        panel.add(Lprovince);
        JTextField province = new JTextField();
        province.setBounds(680, 150, 300, 40);
        province.setFont(TextF);
        province.setBackground(Color.white);
        panel.add(province);

        JLabel Lcity = new JLabel("Enter your city: ");
        Lcity.setBounds(360, 200, 300, 40);
         Lcity.setForeground(Color.WHITE);
        Lcity.setFont(labF);
        panel.add(Lcity);
        JTextField city = new JTextField();
        city.setBounds(680, 200, 300, 40);
        city.setFont(TextF);
        city.setBackground(Color.white);
        panel.add(city);
       JButton goback=new JButton("Go Back");
       goback.setFont(new Font("Arial",Font.BOLD,20));
       goback.setBounds(800, 440, 140, 40);
       panel.add(goback);
       goback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==goback)
                {
                    SelectOption();
                }
            }
           
       });
        JLabel Lparty = new JLabel("Enter your party: ");
        Lparty.setBounds(360, 250, 500, 30);
         Lparty.setForeground(Color.WHITE);
        Lparty.setFont(labF);
        panel.add(Lparty);
        JTextField party = new JTextField();
        party.setBounds(680, 250, 300, 40);
        party.setFont(TextF);
        party.setBackground(Color.white);
        panel.add(party);
        
        
        
        JLabel Lpass = new JLabel("Set your Password: ");
        Lpass.setBounds(360, 300, 500, 30);
         Lpass.setForeground(Color.WHITE);
        Lpass.setFont(labF);
        panel.add(Lpass);
        JPasswordField password = new JPasswordField();
        password.setBounds(680, 300, 300, 40);
        password.setFont(TextF);
        password.setBackground(Color.white);
        setPassword(new String(password.getPassword()));
        System.out.println(getPassword());
        panel.add(password);
        
        JButton submit = new JButton("Submit");
        submit.setBounds(500, 440, 140, 40);
        submit.setFont(new Font("Arial",Font.BOLD,18));
        panel.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                boolean validcnic = isThreeDigitInteger(cnic.getText());
                boolean validname = isValidAlphabetic(name.getText());
                boolean validprovince = isValidAlphabetic(province.getText());
                boolean validcity = isValidAlphabetic(city.getText());
                boolean validparty = isValidAlphabetic(party.getText());

                if (!validcnic) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter 3 digits cnic in integers", "Warning", JOptionPane.WARNING_MESSAGE);

                }
                if (!validname) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter name in alphabets", "Warning", JOptionPane.WARNING_MESSAGE);

                }
                if (!validprovince) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter province in alphabets", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                if (!validcity) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter city in alphabets", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                if (!validparty) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter party in alphabets", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                boolean ar = alreadyRegistered(cnic.getText());
                if (ar == true) {
                    boolean vc = VerifyCandidate(cnic.getText(), name.getText(), province.getText(), city.getText(), party.getText());
                    if (vc == true) {
                        setPassword(new String(password.getText()));
                        setCnic(cnic.getText());
                        System.out.println(getPassword());
                        StoreLoginInfo();
                        JOptionPane.showMessageDialog(frame, "verified candidate", "Warning", JOptionPane.WARNING_MESSAGE);
                        TOTALvotes(cnic.getText());
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid Info!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "You are already registered please login to proceed further", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }

        });
        JLabel backg;
ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\fp.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame.getWidth(), back.getIconHeight());
        panel.add(backg);
        frame.setVisible(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
     public void RequestEC() {
        Color AquaBlue = new Color(107, 202, 226);
        Font labF=new Font("Helvetica", Font.BOLD, 30);
         Color BlueSaphire=new Color(18, 97, 128);
        
        Font TextF=new Font("Helvetica", Font.BOLD, 20);
        JFrame frame = new JFrame("CANDIDATE REGISTERATION");
        frame.setSize(1540, 820);
        JPanel panel = new JPanel(null);
        JLabel Lcnic = new JLabel("Enter your cnic: ");
        Lcnic.setBounds(360, 50, 500, 30);
        Lcnic.setForeground(Color.WHITE);
        Lcnic.setFont(labF);
        panel.add(Lcnic);
        JTextField cnic = new JTextField();
        cnic.setBounds(680, 50, 300, 40);
        cnic.setFont(TextF);
        cnic.setBackground(Color.white);
         setCnic(cnic.getText());
        panel.add(cnic);

        JLabel Lname = new JLabel("Enter your name: ");
        Lname.setBounds(360, 100, 500, 30);
         Lname.setForeground(Color.WHITE);
        Lname.setFont(labF);
        panel.add(Lname);
        JTextField name = new JTextField();
        name.setBounds(680, 100, 300, 40);
        name.setFont(TextF);
         setName(name.getText());
        name.setBackground(Color.white);
        panel.add(name);

        JLabel Lprovince = new JLabel("Enter your province: ");
        Lprovince.setBounds(360, 150, 500, 30);
         Lprovince.setForeground(Color.WHITE);
        Lprovince.setFont(labF);
        
        panel.add(Lprovince);
        JTextField province = new JTextField();
        province.setBounds(680, 150, 300, 40);
        province.setFont(TextF);
         setProvince(province.getText());
        province.setBackground(Color.white);
        panel.add(province);

        JLabel Lcity = new JLabel("Enter your city: ");
        Lcity.setBounds(360, 200, 300, 40);
         Lcity.setForeground(Color.WHITE);
        Lcity.setFont(labF);
        panel.add(Lcity);
        JTextField city = new JTextField();
        city.setBounds(680, 200, 300, 40);
        city.setFont(TextF);
         setCity(city.getText());
        city.setBackground(Color.white);
        panel.add(city);
       JButton goback=new JButton("Go Back");
       goback.setFont(new Font("Arial",Font.BOLD,20));
       goback.setBounds(600, 440, 140, 40);
       panel.add(goback);
       goback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==goback)
                {
                    SelectOption();
                }
            }
           
       });
        JLabel Lparty = new JLabel("Enter your party: ");
        Lparty.setBounds(360, 250, 500, 30);
         Lparty.setForeground(Color.WHITE);
        Lparty.setFont(labF);
        panel.add(Lparty);
        JTextField party = new JTextField();
        party.setBounds(680, 250, 300, 40);
        party.setFont(TextF);
        party.setBackground(Color.white);
         setParty(party.getText());
        panel.add(party);
        
        
        
        JLabel Lpass = new JLabel("Set your Password: ");
        Lpass.setBounds(360, 300, 500, 30);
         Lpass.setForeground(Color.WHITE);
        Lpass.setFont(labF);
        panel.add(Lpass);
        JPasswordField password = new JPasswordField();
        password.setBounds(680, 300, 300, 40);
        password.setFont(TextF);
        password.setBackground(Color.white);
        setPassword(new String(password.getPassword()));
        panel.add(password);
        
        JButton submit = new JButton("Submit");
        submit.setBounds(400, 440, 140, 40);
        submit.setFont(new Font("Arial",Font.BOLD,18));
        panel.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                boolean validcnic = isThreeDigitInteger(cnic.getText());
                boolean validname = isValidAlphabetic(name.getText());
                boolean validprovince = isValidAlphabetic(province.getText());
                boolean validcity = isValidAlphabetic(city.getText());
                boolean validparty = isValidAlphabetic(party.getText());

                if (!validcnic) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter 3 digits cnic in integers", "Warning", JOptionPane.WARNING_MESSAGE);

                }
                if (!validname) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter name in alphabets", "Warning", JOptionPane.WARNING_MESSAGE);

                }
                if (!validprovince) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter province in alphabets", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                if (!validcity) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter city in alphabets", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                if (!validparty) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter party in alphabets", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                setCnic(cnic.getText());
                setName(name.getText());
                setProvince(province.getText());
                setCity(city.getText());
                setParty(party.getText());
                setPassword(new String(password.getText()));
                setParty(party.getText());
                //System.out.println(getParty());
                boolean ar = alreadyRegistered(cnic.getText());
                if (ar == true) {
                  /*  boolean vc = VerifyCandidate(cnic.getText(), name.getText(), province.getText(), city.getText(), party.getText());
                    if (vc == true) {*/
                        
                        setCnic(cnic.getText());
                       // System.out.println(getPassword());
                        setParty(party.getText());
                        //System.out.println(getParty());
                        StoreLoginInfo();
                         System.out.println(getCnic());
                     System.out.println(getName());
                      System.out.println(getProvince());
                       System.out.println(getCity());
                        System.out.println(getParty());
                        boolean sr=AddRequest();
                        if(sr==true){
                        JOptionPane.showMessageDialog(frame, "Your Request Submitted to EC. ", "Warning", JOptionPane.WARNING_MESSAGE);
                        }//  JOptionPane.showMessageDialog(frame, "verified candidate", "Warning", JOptionPane.WARNING_MESSAGE);
                        else if(sr==false){ 
                         JOptionPane.showMessageDialog(frame, "Your can't be Submitted to EC you are not registered in NADRA ", "Warning", JOptionPane.WARNING_MESSAGE);   
                        }// TOTALvotes(cnic.getText());
                  //  } 
                  /*  else {
                        JOptionPane.showMessageDialog(frame, "Invalid Info!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }*/
                } else {
                    JOptionPane.showMessageDialog(frame, "You are already registered please login to proceed further", "Warning", JOptionPane.WARNING_MESSAGE);
                }

            }

        });
        JLabel backg;
ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Main Background.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame.getWidth(), back.getIconHeight());
        panel.add(backg);
        frame.setVisible(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    
    
    
    
    
    
    
    
    public boolean AddRequest(){
        
       boolean submitted=false;
         boolean NadraValidity = false;
        FileReader FR = null;
        BufferedReader BR = null;
        FileWriter FW = null;
        BufferedWriter BW = null;
        try {
            FR = new FileReader("C:\\Users\\thinkpad\\OneDrive\\Documents\\NetBeansProjects\\GUIevoting1\\NADRA.txt");
            BR = new BufferedReader(FR);
            String line;
            while ((line = BR.readLine()) != null) {
                String[] parts = line.split(",");
               // System.out.println("set");
                if (parts.length >= 5) {
                      //System.out.println("res");
                    String CanCnic = parts[0].trim();
                    String CanName = parts[1].trim();
                    String CanProvnce = parts[2].trim();
                    String CanCity = parts[3].trim();
                    String CanParty = parts[4].trim();
                  /*  System.out.println(getCnic());
                     System.out.println(getName());
                      System.out.println(getProvince());
                       System.out.println(getCity());
                        System.out.println(getParty());*/
                    if (CanCnic.equals(getCnic()) && CanName.equals(getName()) && CanProvnce.equals(getProvince()) && CanCity.equals(getCity()) && CanParty.equals(getParty())) {
                       // System.out.println("ggh");
                        NadraValidity = true;
                        break;
                    } else {
                        NadraValidity = false;
                    }
                }
            }
        } catch (Exception gg) {
            gg.printStackTrace();
        } finally {
            try {
                if (BR != null) {
                    BR.close();
                }
                if (FR != null) {
                    FR.close();
                }
            } catch (Exception tt) {
                tt.printStackTrace();
            }
        }
        
        
        if(NadraValidity==true){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try
        {
            fw=new FileWriter("Requests.txt");
            bw=new BufferedWriter(fw);
            submitted=true;
            bw.write(getCnic());
            bw.write(",");
            
            bw.write(getName());
            bw.write(",");
            
            bw.write(getProvince());
            bw.write(",");
            
            bw.write(getCity());
            bw.write(",");
            
            bw.write(getParty());
            bw.newLine();
            submitted=true;
        }catch(Exception gg)
        {
            gg.printStackTrace();
        }
        finally{
            try
            {
                if(bw!=null)
                {
                    bw.close();
                }
                if(fw!=null)
                {
                    fw.close();
                }
            }catch(Exception ss)
            {
                ss.printStackTrace();
            }
        }
        }
        else
        {
            NadraValidity=false;
        }
        return NadraValidity;
    }
    
    

    public boolean alreadyRegistered(String cnic) {
        FileReader FR = null;
        BufferedReader BR = null;
        try {
            FR = new FileReader("Candidate File.txt");
            BR = new BufferedReader(FR);
            String line;
            while ((line = BR.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String canCNIC = parts[0].trim();
                    String canNAME = parts[1].trim();
                    String canPROVINCE = parts[2].trim();
                    String canCITY = parts[3].trim();
                    String canPARY = parts[4].trim();
                    if (canCNIC.equals(cnic)) {
                        System.out.println("please login to proceed further");
                        this.alreadyRegistered = false;
                        break;
                    } else {
                        this.alreadyRegistered = true;
                    }
                }
            }
        } catch (FileNotFoundException dd) {
            dd.printStackTrace();
        } catch (IndexOutOfBoundsException ss) {
            ss.printStackTrace();
        } catch (Exception xc) {
            xc.printStackTrace();
        } finally {
            try {
                if (BR != null) {
                    BR.close();
                }
                if (FR != null) {
                    FR.close();
                }
            } catch (FileNotFoundException qq) {
                qq.printStackTrace();
            } catch (IOException ww) {
                ww.printStackTrace();
            }
        }
        if (this.alreadyRegistered == false) {
            return false;
        } else {
            return true;
        }
    }

    public void StoreLoginInfo() {
        FileWriter FW = null;
        BufferedWriter BW = null;
        try {
            FW = new FileWriter("CandidateLogin.txt", true);
            BW = new BufferedWriter(FW);
            BW.write(getCnic());
            BW.write(",");
            BW.write(getPassword());
            BW.newLine();
        } catch (Exception hj) {
            hj.printStackTrace();
        } finally {
            try {
                if (BW != null) {
                    BW.close();
                }
                if (FW != null) {
                    FW.close();
                }
            } catch (FileNotFoundException ff) {
                ff.printStackTrace();
            } catch (IOException DD) {
                DD.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException gg) {
                gg.printStackTrace();
            } catch (Exception ff) {
                ff.printStackTrace();
            }
        }
    }

    public void TOTALvotes(String cnic) {
        Font labF=new Font("Helvetica", Font.BOLD, 30);
        JFrame frame = new JFrame("Candidate Account");
        JPanel panel = new JPanel(null);
        frame.setSize(1540, 820);
        int total = 0;
        FileReader FR = null;
        BufferedReader BR = null;
        FileReader FRR = null;
        BufferedReader BRR = null;
        
        JLabel label = new JLabel("CNIC: ");
                                    label.setBounds(50, 50, 100, 30);
                                    label.setFont(labF);
                                    label.setForeground(Color.WHITE);
                                    panel.add(label);
                                    
        JLabel Lname = new JLabel("Name: ");
                                    Lname.setBounds(50, 90, 190, 30);
                                    Lname.setFont(labF);
                                    Lname.setForeground(Color.WHITE);
                                    panel.add(Lname);
                                    
        JLabel Lparty = new JLabel("Party: ");
                                    Lparty.setBounds(50, 130, 100, 30);
                                    Lparty.setFont(labF);
                                    Lparty.setForeground(Color.WHITE);
                                    panel.add(Lparty);
                                    
        JLabel Lvotes = new JLabel("Your Total votes are: ");
                                    Lvotes.setBounds(50, 200, 390, 30);
                                    Lvotes.setFont(labF);
                                    Lvotes.setForeground(Color.WHITE);
                                    panel.add(Lvotes);
                                    
                                    
        try {
            FRR = new FileReader("Vote Stored.txt");
            BRR = new BufferedReader(FRR);
            String lane;
            FR = new FileReader("Candidate File.txt");
            BR = new BufferedReader(FR);
            String line;
            while ((line = BR.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String FileCNIC = parts[0].trim();
                    String FileNAME = parts[1].trim();
                    String FilePROVNCE = parts[2].trim();
                    String Filecity = parts[3].trim();
                    String Fileparty = parts[4].trim();
                    if (FileCNIC.equals(cnic)) {
                        System.out.println("candidate file read");
                        //System.out.println("candidate file name "+FileNAME);
                     JLabel canname = new JLabel(FileNAME);
                                    canname.setBounds(210, 90, 200, 30);
                                    canname.setFont(labF);
                                    canname.setForeground(Color.WHITE);
                                    panel.add(canname);
                                JLabel PARTY = new JLabel(Fileparty);
                                    PARTY.setBounds(210, 130, 400, 30);
                                    PARTY.setFont(labF);
                                    PARTY.setForeground(Color.WHITE);
                                    panel.add(PARTY); 
                                    JLabel Lcnic = new JLabel(FileCNIC);
                                    Lcnic.setBounds(210, 50, 200, 30);
                                    Lcnic.setFont(labF);
                                    Lcnic.setForeground(Color.WHITE);
                                    panel.add(Lcnic);
                        while ((lane = BRR.readLine()) != null) {
                            String[] part = lane.split(",");
                            if (part.length >= 5) {
                                String votCNIC = part[0].trim();
                                String canNAME = part[1].trim();
                                String votPROV = part[2].trim();
                                String votCITY = part[3].trim();
                                String canPARTY = part[4].trim();
                                
                                    JLabel votes = new JLabel();
                                if (canNAME.equals(FileNAME)) {
                                    System.out.println("vote file read");
                                    //System.out.println("vote file name "+canNAME);
                                    ++total;
                                    System.out.println("came");

                                    
                                    votes.setText(String.valueOf(total));
                                    votes.setBounds(400, 200, 100, 30);
                                    votes.setFont(labF);
                                    votes.setForeground(Color.WHITE);
                                panel.add(votes);
                                    frame.add(panel);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                                    //  break;
                                }
                                else{
                                votes.setText(String.valueOf(total));
                                votes.setBounds(400, 200, 100, 30);
                                votes.setFont(labF);
                                    votes.setForeground(Color.WHITE);
                                panel.add(votes);}
                            }
                        }
                    }
                }
            }
            System.out.println("you have got " + total + " votes");
            frame.add(panel);
                                    frame.setVisible(true);
                                    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        } catch (Exception gg) {
            gg.printStackTrace();
        } finally {
            frame.add(panel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
            try {
                if (BRR != null) {
                    BRR.close();
                }
                if (FRR != null) {
                    FRR.close();
                }
                if (BR != null) {
                    BR.close();
                }
                if (FR != null) {
                    FR.close();
                }
            } catch (FileNotFoundException gg) {
                gg.printStackTrace();
            } catch (IOException ss) {
                ss.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException ss) {
                ss.printStackTrace();
            } catch (Exception ff) {
                ff.printStackTrace();
            }
        }
        JButton goback=new JButton("Go Back");
       goback.setFont(new Font("Arial",Font.BOLD,20));
       goback.setBounds(350, 490, 140, 40);
       panel.add(goback);
       goback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==goback)
                {
                    LOGIN();
                }
            }
           
       });
        JLabel backg;
        ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Main Background.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame.getWidth(), back.getIconHeight());
        panel.add(backg);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public void LOGIN() {

        JFrame frame = new JFrame("CANDIDATE LOGIN");
        frame.setSize(1540, 820);
        JPanel panel = new JPanel(null);
Color AquaBlue = new Color(107, 202, 226);
        Font labF=new Font("Helvetica", Font.BOLD, 30);
        Font TextF=new Font("Helvetica", Font.BOLD, 20);
        JLabel Lcnic = new JLabel("Enter your cnic: ");
        Lcnic.setBounds(360, 50, 400, 30);
        Lcnic.setFont(labF);
        Lcnic.setForeground(Color.white);
        panel.add(Lcnic);
        JTextField cnic = new JTextField();
        cnic.setBounds(680, 50, 300, 40);
        cnic.setFont(TextF);
        cnic.setBackground(Color.white);
        panel.add(cnic);

        JLabel Lpassword = new JLabel("Enter your password: ");
        Lpassword.setBounds(360, 110, 400, 30);
         Lpassword.setFont(labF);
        Lpassword.setForeground(Color.white);
        panel.add(Lpassword);
        JPasswordField password = new JPasswordField();
        password.setBounds(680, 110, 300, 40);
        password.setFont(TextF);
        password.setBackground(Color.white);
        panel.add(password);

        JButton submit = new JButton("Submit");
        submit.setBounds(410, 300, 140, 40);
        submit.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(submit);
JButton goback=new JButton("Go Back");
       goback.setFont(new Font("Arial",Font.BOLD,20));
       goback.setBounds(600, 300, 140, 40);
       panel.add(goback);
       goback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==goback)
                {
                    SelectOption();
                }
            }
           
       });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit) {
                    boolean validcnic = isThreeDigitInteger(cnic.getText());
                    if (!validcnic) {
                        JOptionPane.showMessageDialog(frame, "Invalid input! Please enter 3 digits cnic in integers", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    boolean ValidLogin = false;
                    FileReader FR = null;
                    BufferedReader BR = null;
                    try {
                        FR = new FileReader("CandidateLogin.txt");
                        BR = new BufferedReader(FR);
                        String line;
                        while ((line = BR.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts.length == 2) {
                                String SeeCNIC = parts[0].trim();
                                String SeePass = parts[1].trim();
                               if (SeeCNIC.equals(cnic.getText()) && SeePass.equals(new String(password.getPassword())))
 {
                                    System.out.println("verified");
                                    JOptionPane.showMessageDialog(frame, "Verified Candidate. ", "Warning", JOptionPane.WARNING_MESSAGE);
                                    TOTALvotes(cnic.getText());
                                    // ValidLogin = true;
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Invalid Login Info! ", "Warning", JOptionPane.WARNING_MESSAGE);

                                }
                            }
                        }
                    } catch (FileNotFoundException hh) {
                        hh.printStackTrace();
                    } catch (IOException aa) {
                        aa.printStackTrace();
                    } catch (ArrayIndexOutOfBoundsException qq) {
                        qq.printStackTrace();
                    } catch (Exception ss) {
                        ss.printStackTrace();
                    } finally {
                        try {
                            if (BR != null) {
                                BR.close();
                            }
                            if (FR != null) {
                                FR.close();
                            }
                        } catch (Exception gg) {
                            gg.printStackTrace();
                        }
                    }

                }
            }

        });
JLabel backg;
        ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\fp.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame.getWidth(), back.getIconHeight());
        panel.add(backg);
        frame.add(panel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public boolean VerifyCandidate(String cnic, String name, String province, String city, String party) {
        boolean NadraValidity = false;
        FileReader FR = null;
        BufferedReader BR = null;
        FileWriter FW = null;
        BufferedWriter BW = null;
        try {
            FR = new FileReader("NADRA.txt");
            BR = new BufferedReader(FR);
            String line;
            while ((line = BR.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String CanCnic = parts[0].trim();
                    String CanName = parts[1].trim();
                    String CanProvnce = parts[2].trim();
                    String CanCity = parts[3].trim();
                    String CanDOB = parts[4].trim();

                    if (CanCnic.equals(cnic) && CanName.equals(name) && CanProvnce.equals(province) && CanCity.equals(city) ){
                        NadraValidity = true;
                        break;
                    } else {
                        NadraValidity = false;
                    }
                }
            }
        } catch (Exception gg) {
            gg.printStackTrace();
        } finally {
            try {
                if (BR != null) {
                    BR.close();
                }
                if (FR != null) {
                    FR.close();
                }
            } catch (Exception tt) {
                tt.printStackTrace();
            }
        }
        if (NadraValidity == true) {
            try {
                FR = new FileReader("ElectionCommission.txt");
                BR = new BufferedReader(FR);
                String line;
                while ((line = BR.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 5) {
                        String CanCnic = parts[0].trim();
                        String CanName = parts[1].trim();
                        String CanProvnce = parts[2].trim();
                        String CanCity = parts[3].trim();
                        String CanParty = parts[4].trim();
                       
                        if (CanCnic.equals(cnic) && CanName.equals(name) && CanProvnce.equals(province) && CanCity.equals(city) && CanParty.equals(party)) {
                            this.setVerifiedCandidate(1);
                           
                            
                            FW = new FileWriter("Candidate File.txt", true);
                            BW = new BufferedWriter(FW);
                            BW.write(cnic);
                            BW.write(",");
                            BW.write(name);
                            BW.write(",");
                            BW.write(province);
                            BW.write(",");
                            BW.write(city);
                            BW.write(",");
                            BW.write(party);
                            BW.newLine();
                            
                       

                            System.out.println("you are valid candidate and you are now registered");
                            break;
                        
                    }
                        else {
                            this.setVerifiedCandidate(0);
                        }
                       
                    }
                }
            } catch (Exception hj) {
                hj.printStackTrace();
            } finally {
                try {
                    if (BR != null) {
                        BR.close();
                    }
                    if (BW != null) {
                        BW.close();
                    }

                    if (FW != null) {
                        FW.close();
                    }

                    if (FR != null) {
                        FR.close();
                    }

                } catch (Exception tt) {
                    tt.printStackTrace();
                }
            }
        } else {
            return false;
        }
        if (this.getVerifiedCandidate() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int getVerifiedCandidate() {
        return VerifiedCandidate;
    }

    public void setVerifiedCandidate(int VerifiedCandidate) {
        this.VerifiedCandidate = VerifiedCandidate;
    }

    /**
     * @return the alreadyRegistered
     */
    public boolean isAlreadyRegistered() {
        return alreadyRegistered;
    }

    /**
     * @param alreadyRegistered the alreadyRegistered to set
     */
    public void setAlreadyRegistered(boolean alreadyRegistered) {
        this.alreadyRegistered = alreadyRegistered;
    }
}
