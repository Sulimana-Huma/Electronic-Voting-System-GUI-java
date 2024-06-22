/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guievoting1;

//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.table.DefaultTableCellRenderer;
//import java.awt.FlowLayout;
import java.awt.Font;
//import java.awt.GridBagLayout;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.ListSelectionModel;
//import javax.swing.UIManager;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author thinkpad
 */
public class VOTER extends Person implements VoterInterface {

    Scanner enter = new Scanner(System.in);
    private boolean ValidCandidate;
    private String nameCandidate;
    private int validPassword;
    private boolean CastedVote;
    private int alreadyRegistered;
    private int VerifiedVoter;

    public int getAlreadyRegistered() {
        return alreadyRegistered;
    }

    public void setAlreadyRegistered(int alreadyRegistered) {
        this.alreadyRegistered = alreadyRegistered;
    }

    public int getvalidPassword() {
        return validPassword;
    }

    public void setvalidPassword(int validPassword) {
        this.validPassword = validPassword;
    }

    public boolean isCastedVote() {
        return CastedVote;
    }

    public void setCastedVote(boolean CastedVote) {
        this.CastedVote = CastedVote;
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

    public void VoterSide() {
        GUIevoting1 GUI=new GUIevoting1();
        Font labF=new Font("Monotype Corsiva",Font.BOLD,25);
        Color  ForestGreen=new Color(34, 139, 34);
        Color BlueSaphire = new Color(18, 97, 128);
        Color BabyBlue = new Color(137, 207, 240);
        Color CarolinaBlue = new Color(75, 156, 211);
        JFrame frame = new JFrame("WELCOME TO VOTER SIDE");
        frame.setSize(1540, 820);
        ButtonGroup BG = new ButtonGroup();
        JPanel panel = new JPanel(null);
        panel.setLayout(null);
         JButton submit1 = new JButton("Submit");
        submit1.setBounds(200, 410, 130, 40);
        submit1.setFont(labF);
        panel.add(submit1);
        JLabel quote = new JLabel("\"Your Voice, Your Vote, Your Future! \"");
        quote.setBounds(520, 60, 500, 30);
        quote.setForeground(Color.white);
        quote.setFont(new Font("Pristina", Font.BOLD, 35));
        panel.add(quote);
        JLabel inst = new JLabel("HOW TO CAST VOTE?");
        inst.setBounds(620, 590, 300, 30);
        inst.setForeground(Color.white);
      
        inst.setFont(new Font("MV Boli", Font.BOLD, 20));
        panel.add(inst);

        JButton goback=new JButton("Go Back");
        goback.setBounds(470, 410, 130, 40);
        goback.setFont(labF);
         panel.add(goback);
        goback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.MainMenu();
            }
            
        });
        
        JLabel way1 = new JLabel("1- If you're a new user, register to create account.");
        way1.setBounds(550, 640, 400, 30);
        way1.setForeground(Color.WHITE);
       
        way1.setFont(new Font("Helvetica", Font.BOLD, 15));
        panel.add(way1);

        JLabel way3 = new JLabel("3- Choose your preferred candidate.");
        way3.setBounds(550, 700, 350, 30);
        way3.setForeground(Color.white);
        way3.setFont(new Font("Helvetica", Font.BOLD, 15));
        panel.add(way3);

        JLabel way2 = new JLabel("2- Already registered? Log in to account.");
        way2.setBounds(550, 670, 350, 30);
        way2.setForeground(Color.white);
        way2.setFont(new Font("Helvetica", Font.BOLD, 15));
        panel.add(way2);

        JLabel way4 = new JLabel("4- You can vote for only one candidate.");
        way4.setBounds(550, 730, 350, 30);
        way4.setForeground(Color.white);
        way4.setFont(new Font("Helvetica", Font.BOLD, 15));
        panel.add(way4);

        JLabel way5 = new JLabel("5- If registered but not voted, can vote after login");
        way5.setBounds(550, 750, 400, 40);
        way5.setForeground(Color.white);
        way5.setFont(new Font("Helvetica", Font.BOLD, 15));
        panel.add(way5);

        JLabel REG = new JLabel("Click here for voter registeration");
        REG.setBounds(130, 180, 550, 30);
        REG.setForeground(Color.WHITE);
        REG.setFont(new Font("Helvetica", Font.BOLD, 30));
        panel.add(REG);

        JLabel loog = new JLabel("Click here for voter Login");
        loog.setBounds(130, 240, 400, 30);
        loog.setForeground(Color.WHITE);
        loog.setFont(new Font("Helvetica", Font.BOLD, 30));
        panel.add(loog);

        JLabel back1 = new JLabel("Click here to Exit.");
        back1.setBounds(130, 300, 400, 30);
        back1.setForeground(Color.WHITE);
        back1.setFont(new Font("Helvetica", Font.BOLD, 30));
        panel.add(back1);
        Color DarkSaphire = new Color(8, 37, 103);
        JRadioButton voterReg = new JRadioButton();
        voterReg.setBounds(110, 180, 20, 30);
        voterReg.setBackground(ForestGreen);
       
        panel.add(voterReg);
        BG.add(voterReg);

        JRadioButton voterLogin = new JRadioButton();
        voterLogin.setBounds(110, 240, 20, 30);
         voterLogin.setBackground(ForestGreen);
        
        panel.add(voterLogin);
        BG.add(voterLogin);

        JRadioButton exit = new JRadioButton();
        exit.setBounds(110, 300, 20, 30);
         exit.setBackground(ForestGreen);
       
        panel.add(exit);
        BG.add(exit);

        BG.add(voterLogin);
        BG.add(voterReg);
       
        submit1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == submit1) {
                    if (voterReg.isSelected()) {
                        InputVoter();
                    } else if (voterLogin.isSelected()) {
                        Login();
                    } else if (exit.isSelected()) {
                        System.exit(0);

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
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

    public void InputVoter() {
        JFrame frame1 = new JFrame("VOTER REGISTERATION");
        Color AquaBlue = new Color(107, 202, 226);
        Font textf = new Font("Arial", Font.BOLD, 16);
        Font labF = new Font("Helvetica", Font.BOLD, 30);
        JPanel jpanel = new JPanel(null);
        frame1.setSize(1540, 820);
        JLabel Lcnic = new JLabel("Enter your CNIC: ");
        Lcnic.setBounds(360, 70, 400, 30);
        Lcnic.setForeground(Color.WHITE);
        Lcnic.setFont(labF);
        JTextField cnic = new JTextField();
        cnic.setBounds(680, 70, 350, 40);
        cnic.setFont(textf);
        cnic.setBackground(Color.white);
        JLabel Lname = new JLabel("Enter your NAME: ");
        Lname.setBounds(360, 140, 400, 30);
        Lname.setForeground(Color.WHITE);
        Lname.setFont(labF);
        JTextField name = new JTextField();
        name.setBounds(680, 140, 350, 40);
        name.setBackground(Color.white);
        name.setFont(textf);
        JLabel Lprovince = new JLabel("Enter your PROVINCE: ");
        Lprovince.setBounds(360, 210, 400, 30);
        Lprovince.setFont(labF);
        Lprovince.setForeground(Color.WHITE);
        JTextField province = new JTextField();
        province.setBounds(680, 210, 350, 40);
        province.setBackground(Color.white);
        province.setFont(textf);
        JLabel Lcity = new JLabel("Enter your CITY: ");
        Lcity.setBounds(360, 280, 400, 30);
        Lcity.setForeground(Color.WHITE);
        Lcity.setFont(labF);
        JTextField city = new JTextField();
        city.setBounds(680, 280, 350, 40);
        city.setFont(textf);
        city.setBackground(Color.white);
        JLabel Lpassword = new JLabel("Set your Password");
        Lpassword.setBounds(360, 350, 400, 30);
        Lpassword.setForeground(Color.WHITE);
        Lpassword.setFont(labF);
        JPasswordField password = new JPasswordField();
        password.setBounds(680, 350, 350, 40);
        password.setFont(textf);
        password.setBackground(Color.white);
        JButton submit2 = new JButton("Submit");
        submit2.setBounds(480, 520, 140, 40);
        submit2.setFont(new Font("Helvetica", Font.BOLD, 20));
        jpanel.add(Lcnic);
        jpanel.add(cnic);
        jpanel.add(Lname);
        jpanel.add(name);
        jpanel.add(Lprovince);
        jpanel.add(province);
        jpanel.add(Lcity);
        jpanel.add(city);
        jpanel.add(Lpassword);
        jpanel.add(password);
        jpanel.add(submit2);
        frame1.add(jpanel);
        frame1.setVisible(true);

        JButton goback = new JButton("Go Back");
        goback.setBounds(700, 520, 140, 40);
        goback.setFont(new Font("Helvetica", Font.BOLD, 20));
        frame1.add(goback);
        goback.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent g) {
                if (g.getSource() == goback) {
                    VoterSide();
                }
            }
        });

        submit2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent w) {
                boolean validcountcnic = isThreeDigitInteger(cnic.getText());
                boolean validname = isValidAlphabetic(name.getText());
                boolean validprovince = isValidAlphabetic(province.getText());
                boolean validcity = isValidAlphabetic(city.getText());
                boolean verified = false;
                if (!validcountcnic) {
                    JOptionPane.showMessageDialog(frame1, "Invalid input! Please enter 3 digits integer only", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                if (!validname) {
                    JOptionPane.showMessageDialog(frame1, "Invalid input! Please enter only alphabets in name", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                if (!validprovince) {
                    JOptionPane.showMessageDialog(frame1, "Invalid input! Please enter only alphabets in province", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                if (!validcity) {
                    JOptionPane.showMessageDialog(frame1, "Invalid input! Please enter only alphabets in city.", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                try {
                    BufferedReader BR = new BufferedReader(new FileReader("Registeration.txt"));
                    String line;
                    while ((line = BR.readLine()) != null) {
                        String[] parts = line.split(",");
                        String cnc = parts[0].trim();
                        if (cnc.equals(cnic.getText())) {
                            JOptionPane.showMessageDialog(frame1, "you are already registered please login to proceed further");
                            setAlreadyRegistered(0);
                            break;
                        } else {
                            setAlreadyRegistered(1);
                        }
                    }
                    if (getAlreadyRegistered() == 1) {
                        FileWriter FW = null;
                        BufferedWriter BW = null;
                        FileReader FR = null;
                        BufferedReader BRR = null;
                        try {
                            FR = new FileReader("NADRA.txt");
                            BRR = new BufferedReader(FR);
                            String line1;
                            while ((line1 = BRR.readLine()) != null) {
                                String[] parts = line1.split(",");
                                if (parts.length >= 4) {
                                    String fileCnic = parts[0].trim();
                                    String fileName = parts[1].trim();
                                    String fileProvince = parts[2].trim();
                                    String fileCity = parts[3].trim();
                                    String filedob = parts[4].trim();
                                    if (fileCnic.equals(cnic.getText()) && fileName.equals(name.getText()) && fileProvince.equals(province.getText()) && fileCity.equals(city.getText())) {
                                        verified = true;

                                        boolean above18 = isAbove18(filedob);

                                        if (above18 == true) {

                                            FW = new FileWriter("Registeration.txt", true);
                                            BW = new BufferedWriter(FW);
                                            BW.write(cnic.getText());
                                            BW.write(",");
                                            BW.write(name.getText());
                                            BW.write(",");
                                            BW.write(province.getText());
                                            BW.write(",");
                                            BW.write(city.getText());
                                            BW.newLine();
                                            BW.close();
                                            JOptionPane.showMessageDialog(frame1, "you are a verified voter. ");
                                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Password.txt", true))) {
                                                writer.write(password.getText());
                                                writer.write(",");
                                                writer.write(cnic.getText());
                                                writer.newLine(); // Add a new line for each password
                                                JOptionPane.showMessageDialog(frame1, "Password saved successfully");
                                                writer.close();
                                                setCnic(cnic.getText());
                                                System.out.println(getCnic());
                                                fetchCITY();
                                                System.out.println(getCity());
                                                DisplayCandidates(getCnic(), getCity());
                                                DisplayVote(getCnic());
                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            } catch (IOException ff) {
                                                ff.printStackTrace();
                                            } catch (ArrayIndexOutOfBoundsException ss) {
                                                ss.printStackTrace();
                                            } catch (Exception gg) {
                                                gg.printStackTrace();
                                            }
                                            // DisplayCandidates(cnic.getText(), city.getText());

                                            // break;
                                        } else {
                                            JOptionPane.showMessageDialog(frame1, "you are under 18 so you can't cast vote. ");
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!verified) {
                                JOptionPane.showMessageDialog(frame1, "you are not a verified voter. ");
                            }

                        } catch (Exception we) {
                        } finally {
                            try {
                                if (BW != null) {
                                    BW.close();
                                }
                                if (BR != null) {
                                    BR.close();
                                }
                                if (BRR != null) {
                                    BRR.close();
                                }
                                if (FW != null) {
                                    FW.close();
                                }
                                if (FR != null) {
                                    FR.close();
                                }
                            } catch (Exception gh) {
                                gh.printStackTrace();
                            }
                        }
                    }
                } catch (Exception ff) {
                    ff.printStackTrace();
                }
            }
        });
        JLabel backg;
        ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\fp.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame1.getWidth(), back.getIconHeight());
        jpanel.add(backg);
        frame1.add(jpanel);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
    }

    public boolean isAbove18(String dateOfBirth) {
        boolean ABOVE18 = false;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = dateFormat.parse(dateOfBirth);

            long currentTime = System.currentTimeMillis();
            long ageInMillis = currentTime - dob.getTime();
            long ageInYears = ageInMillis / (365L * 24 * 60 * 60 * 1000);

            // Check if the person is 18 or older
            if (ageInYears >= 18) {
                ABOVE18 = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            ABOVE18 = false;
        }
        return ABOVE18;
    }

    public void fetchCITY() {
        FileReader FR = null;
        BufferedReader BR = null;
        try {
            FR = new FileReader("Registeration.txt");
            BR = new BufferedReader(FR);
            String line;
            while ((line = BR.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String voterCNIC = parts[0].trim();
                    //     System.out.println(voterCNIC);
                    String voterNAME = parts[1].trim();
                    String voterPROVINCE = parts[2].trim();
                    String voterCITY = parts[3].trim();
                    System.out.println("read");
                    if (voterCNIC.equals(getCnic())) {
                        // System.out.println(voterCNIC);
                        setCity(voterCITY);
                        setProvince(voterPROVINCE);
                    } else {
                        System.out.println("cnic not found in registeration file");
                    }
                }
            }
        } catch (Exception ff) {
            ff.printStackTrace();
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

    public void Login() {
        JFrame frame2 = new JFrame("VOTER LOGIN");
        frame2.setSize(1540, 820);
        Color AquaBlue = new Color(107, 202, 226);
        Font textf = new Font("Arial", Font.BOLD, 16);
        Font labF = new Font("Helvetica", Font.BOLD, 30);
        JPanel panel = new JPanel(null);
         JButton submit = new JButton("Submit");
        submit.setBounds(450, 380, 140, 40);
        submit.setFont(new Font("Helvetica", Font.BOLD, 20));
         panel.add(submit);
          JButton goback = new JButton("Go Back");
        goback.setBounds(680, 380, 140, 40);
        goback.setFont(new Font("Helvetica", Font.BOLD, 20));
        panel.add(goback);
        JLabel Lcnic = new JLabel("Enter your Cnic");
        Lcnic.setBounds(360, 50, 400, 50);
        Lcnic.setForeground(Color.WHITE);
        Lcnic.setFont(labF);
        JTextField cnic = new JTextField();
        cnic.setFont(textf);
        cnic.setBackground(Color.white);
        cnic.setBounds(680, 60, 300, 30);
        JLabel Lpassword = new JLabel("Enter your Password");
        Lpassword.setBounds(360, 130, 400, 50);
        Lpassword.setFont(labF);
        Lpassword.setForeground(Color.WHITE);
        JPasswordField password = new JPasswordField();
        password.setBounds(680, 140, 300, 30);
        password.setFont(textf);
        password.setBackground(Color.white);
       
        panel.add(Lcnic);
        panel.add(cnic);
        panel.add(Lpassword);
        panel.add(password);
       

        JLabel backg;
        ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\fp.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame2.getWidth(), back.getIconHeight());
        panel.add(backg);
        frame2.add(panel);
       

        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == goback) {
                    VoterSide();
                }

            }

        });

        frame2.add(panel);
        frame2.setVisible(true);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean validLogin = false;
                try {
                    boolean validcnic = isThreeDigitInteger(cnic.getText());
                    if (!validcnic) {
                        JOptionPane.showMessageDialog(frame2, "please enter 3 digits integers in cnic");
                        Login();
                    }
                    BufferedReader reader = new BufferedReader(new FileReader("Password.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length >= 2) {
                            String pass = parts[0].trim();
                            String votcnic = parts[1].trim();
                            if (pass.equals(new String(password.getPassword())) && votcnic.equals(cnic.getText())) {
                                setvalidPassword(1);
                                setCnic(cnic.getText());
                                validLogin = true;

                                break;
                            } else {
                                validLogin = false;
                            }
                        }
                    }
                    reader.close();
                } catch (FileNotFoundException we) {
                    we.printStackTrace();
                } catch (IOException nn) {
                    nn.printStackTrace();
                } catch (ArrayIndexOutOfBoundsException gg) {
                    gg.printStackTrace();
                } catch (Exception aa) {
                    aa.printStackTrace();
                }
                if (validLogin) {
                    boolean already = alreadyCasted(cnic.getText());
                    fetchCITY();
                    if (already == true) {

                        DisplayCandidates(getCnic(), getCity());
                        DisplayVote(getCnic());

                    } else {
                        JOptionPane.showMessageDialog(frame2, "Already Casted Vote. ");
                        DisplayVote(getCnic());

                    }
                }
                if (!validLogin) {
                    JOptionPane.showMessageDialog(frame2, "Invalid Login Info");
                }
            }

        });
        frame2.setDefaultCloseOperation(frame2.EXIT_ON_CLOSE);

    }

    public void DisplayCandidates(String cnic, String city) {
        JFrame frame = new JFrame("CANDIDATES LIST");
        frame.setSize(1540, 820);
        JPanel panel = new JPanel();
        JLabel list = new JLabel("YOU CAN CAST VOTE TO FOLLOWING CANDIDATES");
        list.setBounds(10, 10, 100, 30);
        list.setFont(new Font("Arial", Font.BOLD, 15));
        list.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(list, BorderLayout.NORTH);
        panel.add(list);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.setVisible(true);
        boolean FoundCandidates = false;
        BufferedReader reader = null;
        FileReader FRR = null;
        JLabel backg;

        try {
            FRR = new FileReader("Candidate File.txt");
            reader = new BufferedReader(FRR);
            String line;
            JTable table = new JTable();
            DefaultTableModel tableModel = new DefaultTableModel();
            Dimension preferredSize = new Dimension(1400, 760);
            table.setPreferredScrollableViewportSize(preferredSize);
            tableModel.addColumn("CANDIDATE");
            tableModel.addColumn("CITY");
            tableModel.addColumn("PARTY");
            table = new JTable(tableModel);
            table.setRowHeight(30);
            this.setBoldFontForColumnHeaders(table);
            this.setBoldAndBigFontForRowData(table);
            //  table.setEnabled(false);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setMaximumSize(new Dimension(1000, 600));
            panel.add(scrollPane);
            while ((line = reader.readLine()) != null) {
                String[] CanInfo = line.split(",");
                if (CanInfo.length >= 5) {
                    String cancnc = CanInfo[0].trim();
                    String canname = CanInfo[1].trim();
                    String canprovnce = CanInfo[2].trim();
                    String cancity = CanInfo[3].trim();
                    String canParty = CanInfo[4].trim();
                    if (cancity.equals(city)) {
                        FoundCandidates = true;
                        Object[] rowData = {canname, cancity, canParty};
                        tableModel.addRow(rowData);
                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException uu) {
            uu.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (FRR != null) {
                    FRR.close();
                }
            } catch (FileNotFoundException gg) {
                gg.printStackTrace();
            } catch (IOException gg) {
                gg.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException v) {
                v.printStackTrace();
            } catch (Exception yy) {
                yy.printStackTrace();
            }
        }

        JLabel nam = new JLabel("Enter name of Candidate: ");
        nam.setAlignmentX(Component.LEFT_ALIGNMENT);
        //  nam.setFont("Arial",Font.BOLD,16);
        panel.add(nam);
        JTextField Tnam = new JTextField();
        Tnam.setAlignmentX(Component.LEFT_ALIGNMENT);
        Tnam.setSize(250, 40);
        Tnam.setBounds(10, 10, 250, 40);
        Tnam.setMaximumSize(new Dimension(100, 30));
        panel.add(Tnam);
        JButton caste = new JButton("Caste Vote");
        //caste.setAlignmentX(Component.CENTER_ALIGNMENT);
        caste.setBounds(500, 700, 140, 40);
        caste.setMaximumSize(new Dimension(140, 40));
        caste.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(caste);
        caste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == caste) {

                    boolean validCandidate = CastedValidCandidate(Tnam.getText());
                    if (validCandidate == true) {
                        StoreVote(Tnam.getText());
                        JOptionPane.showMessageDialog(frame, "Your vote has been stored successfully");
                        DisplayVote(getCnic());
                    }
                }

            }

        });
        JButton goback=new JButton("Go Back");
       goback.setFont(new Font("Arial",Font.BOLD,20));
       goback.setBounds(350, 440, 140, 40);
       panel.add(goback);
       goback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==goback)
                {
                    VoterSide();
                }
            }
           
       });
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

    public void StoreVote(String CandidateName) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        BufferedReader BR = null;
        FileReader FR = null;
        try {
            FR = new FileReader("Candidate File.txt");
            BR = new BufferedReader(FR);

            String line;
            while ((line = BR.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String CanCNIC = parts[0].trim();
                    String CanNAME = parts[1].trim();
                    String CanPROVNCE = parts[2].trim();
                    String CanCity = parts[3].trim();
                    String CanParty = parts[4].trim();
                    if (CanCity.equals(getCity())) {
                        if (CanNAME.equals(CandidateName)) {
                            fw = new FileWriter("Vote Stored.txt", true);
                            bw = new BufferedWriter(fw);
                            bw.write(getCnic());
                            bw.write(",");
                            bw.write(CandidateName);
                            bw.write(",");
                            bw.write(getProvince());
                            bw.write(",");
                            bw.write(getCity());
                            bw.write(",");
                            bw.write(CanParty);
                            bw.newLine();
                            break;
                        }
                    }
                }
            }
            System.out.println("your vote has been saved successfully");
        } catch (FileNotFoundException yy) {
            yy.printStackTrace();
        } catch (IOException hh) {
            hh.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException jj) {
            jj.printStackTrace();
        } catch (Exception bb) {
            bb.printStackTrace();
        } finally {
            try {
                if (BR != null) {
                    BR.close();
                }
                if (FR != null) {
                    FR.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (FileNotFoundException yy) {
                yy.printStackTrace();
            } catch (IOException HH) {
                HH.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException hh) {
                hh.printStackTrace();
            } catch (Exception nn) {
                nn.printStackTrace();
            }
        }
    }

    public boolean CastedValidCandidate(String CandidateName) {
        FileReader FR = null;
        BufferedReader BR = null;
        try {
            FR = new FileReader("Candidate File.txt");
            BR = new BufferedReader(FR);
            String line;
            while ((line = BR.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String CanCNIC = parts[0].trim();
                    String CanNAME = parts[1].trim();
                    String CanPROVNCE = parts[2].trim();
                    String CanCity = parts[3].trim();
                    String CanParty = parts[4].trim();
                    if (CanCity.equals(getCity())) {
                        if (CanNAME.equals(CandidateName)) {
                            this.ValidCandidate = true;
                            break;
                        } else {
                            this.ValidCandidate = false;
                        }
                    }
                }
            }
        } catch (FileNotFoundException gh) {
            gh.printStackTrace();
        } catch (IOException bb) {
            bb.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ff) {
            ff.printStackTrace();
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
            } catch (Exception jj) {
                jj.printStackTrace();
            }
        }

        return ValidCandidate;

    }

    private void setColumnWidths(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < columnModel.getColumnCount(); column++) {
            int width = 50; // Set your preferred width here
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void setBoldFontForColumnHeaders(JTable table) {
        JTableHeader header = table.getTableHeader();
        Font headerFont = header.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(headerFont.getAttributes());
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        Font boldHeaderFont = new Font(attributes);
        header.setFont(new Font("Arial", Font.BOLD, 18));
    }

    private void setBoldAndBigFontForRowData(JTable table) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Set font to bold and bigger for row data
                Font currentFont = c.getFont();
                Map<TextAttribute, Object> attributes = new HashMap<>(currentFont.getAttributes());
                attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
                attributes.put(TextAttribute.SIZE, 18); // Set the size to 14 (you can adjust as needed)
                c.setFont(new Font(attributes));

                return c;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    public boolean alreadyCasted(String cnic) {//used CastedVote
        BufferedReader br = null;
        FileReader fr = null;
        BufferedReader Br = null;
        FileReader Fr = null;
        try {
            fr = new FileReader("Vote Stored.txt");
            br = new BufferedReader(fr);
            String line;
            this.CastedVote = true;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String votcnc = parts[0].trim();
                    String votcan = parts[1].trim();
                    String votprovince = parts[2].trim();
                    String votCity = parts[3].trim();
                    String canPARTY = parts[4].trim();
                    if (votcnc.equals(cnic)) {
                        System.out.println("vote already casted to: " + votcan);
                        System.out.println("candidate party is: " + canPARTY);
                        this.CastedVote = false;
                        break;
                    }
                    break;

                }
            }
        } catch (FileNotFoundException ee) {
            ee.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ff) {
            ff.printStackTrace();
        } catch (IOException jj) {
            jj.printStackTrace();
        } catch (Exception jj) {
            jj.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception yy) {
                yy.printStackTrace();
            }
        }
        return this.CastedVote;
    }

    public void DisplayVote(String cnic) {
 Font labF=new Font("Helvetica", Font.BOLD, 30);
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader("Vote Stored.txt");
            br = new BufferedReader(fr);
            String line;
            setCastedVote(true);
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String votcnc = parts[0].trim();
                    String votcan = parts[1].trim();
                    String votprovince = parts[2].trim();
                    String votCity = parts[3].trim();
                    String canPARTY = parts[4].trim();
                    if (votcnc.equals(cnic)) {
                        JFrame frame = new JFrame("LOGIN WINDOW");
                        JPanel panel = new JPanel(null);
                        frame.setSize(1540, 820);

                        JLabel yourCNIC = new JLabel("YOUR CNIC:");
                        yourCNIC.setBounds(360, 50, 300, 30);
                        yourCNIC.setFont(labF);
                        yourCNIC.setForeground(Color.WHITE);
                        JLabel CNIC = new JLabel(cnic);
                        CNIC.setFont(labF);
                        CNIC.setForeground(Color.WHITE);
                        CNIC.setBounds(600, 50, 100, 30);
                        JLabel castedTO = new JLabel("Your have already casted vote to: ");
                        castedTO.setFont(labF);
                        castedTO.setForeground(Color.WHITE);
                        castedTO.setBounds(360, 110, 500, 30);
                        JLabel CANDIDATE = new JLabel("CANDIDATE: ");
                        CANDIDATE.setBounds(360, 200, 300, 30);
                        CANDIDATE.setFont(labF);
                        CANDIDATE.setForeground(Color.WHITE);
                        JLabel candidate = new JLabel(votcan);
                        candidate.setFont(labF);
                        candidate.setForeground(Color.WHITE);
                        JLabel PARTY = new JLabel("PARTY: ");
                        PARTY.setFont(labF);
                        PARTY.setForeground(Color.WHITE);
                        PARTY.setBounds(360, 250, 500, 30);
                        JLabel party = new JLabel(canPARTY);
                        party.setFont(labF);
                        party.setForeground(Color.WHITE);
                        JLabel province = new JLabel(votprovince);
                        province.setFont(labF);
                        province.setForeground(Color.WHITE);
                        province.setBounds(700, 300, 300, 30);
                        candidate.setBounds(700, 200, 400, 30);
                        party.setBounds(700, 250, 500, 30);
                        JLabel PROVINCE = new JLabel("PROVINCE:");
                        PROVINCE.setFont(labF);
                        PROVINCE.setForeground(Color.WHITE);
                        PROVINCE.setBounds(360, 300, 300, 30);
                        JLabel city = new JLabel(votCity);
                        city.setFont(labF);
                        city.setForeground(Color.WHITE);
                        city.setBounds(700, 340, 200, 30);
                        JLabel CITY = new JLabel("CITY:");
                        CITY.setFont(labF);
                        CITY.setForeground(Color.WHITE);
                        CITY.setBounds(360, 340, 300, 30);
                        JButton goback = new JButton("Go Back");
                        goback.setBounds(600, 500, 140, 40);
                        goback.setFont(new Font("Arial",Font.BOLD,20));
                        panel.add(goback);

                        goback.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Login();

                            }

                        });
                        panel.add(candidate);
                        panel.add(party);
                        panel.add(yourCNIC);
                        panel.add(CNIC);
                        panel.add(castedTO);
                        panel.add(CANDIDATE);
                        panel.add(PARTY);
                        panel.add(province);
                        panel.add(PROVINCE);
                        panel.add(city);
                        panel.add(CITY);
                        JLabel backg;
ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\fp.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame.getWidth(), back.getIconHeight());
        panel.add(backg);
                        frame.add(panel);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
                        this.CastedVote = false;
                        break;
                    }
                } else {
                    // System.out.println("not casted");
                    this.CastedVote = true;
                }

            }
        } catch (FileNotFoundException ee) {
            ee.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ff) {
            ff.printStackTrace();
        } catch (IOException jj) {
            jj.printStackTrace();
        } catch (Exception jj) {
            jj.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception yy) {
                yy.printStackTrace();
            }

        }
    }

}
