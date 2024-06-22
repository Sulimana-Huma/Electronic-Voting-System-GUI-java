/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.guievoting1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;
//import javax.swing.border.Border;
//import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
//import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
//import javax.swing.JRadioButtonMenuItem;
//import javax.swing.JRootPane;
import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//import javax.swing.UIDefaults;
//import javax.swing.UIManager;
//import javax.swing.border.LineBorder;
//import javax.swing.plaf.FontUIResource;

/**
 *
 * @author thinkpad
 */
public class GUIevoting1 {

    public void MainMenu() {
        Font labF = new Font("Helvetica", Font.BOLD, 30);
        VOTER V = new VOTER();
        GUIevoting1 G = new GUIevoting1();
        JLabel logo;
        CandidateSide C = new CandidateSide();
        JFrame frame = new JFrame();
        Color softGreen = new Color(204, 229, 204);
        Color DarkSlateGray = new Color(47, 79, 79);
        JLabel background;
        JLabel ecof = new JLabel("ELECTION COMISSION OF PAKISTAN");
        ecof.setBounds(500, 50, 600, 30);
        ecof.setForeground(Color.WHITE);
        //  ecof.setFont("PMingLiU-ExtB",Font.BOLD, 0b1100);
        ecof.setFont(new Font("Helvetica", Font.BOLD, 30));
        frame.add(ecof);
        frame.setTitle("WELCOME TO EVOTING SYSTEM");

        frame.setSize(1540, 820);

        frame.setLayout(null);
        JLabel backg;

        JLabel voter;

        JLabel candidate;
        JLabel exit;
        Color BlueSaphire = new Color(18, 97, 128);

        JLabel ec;
        ImageIcon ce = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\ElectionComission Logo.jpg");
        ec = new JLabel(ce);
        ec.setBounds(390, 10, 100, 110);
        frame.add(ec);
        //v1.setF
        voter = new JLabel("VOTER");
        voter.setBounds(100, 330, 500, 70);
        voter.setForeground(Color.WHITE);
        voter.setFont(new Font("Helvetica", Font.BOLD, 30));
        frame.add(voter);
        frame.setVisible(true);
        candidate = new JLabel("CANDIDATE");
        candidate.setBounds(260, 315, 500, 100);
        candidate.setForeground(Color.WHITE);
        candidate.setFont(new Font("Helvetica", Font.BOLD, 30));
        frame.add(candidate);

        JLabel parties = new JLabel("PARTIES");
        parties.setBounds(490, 350, 400, 30);
        parties.setForeground(Color.WHITE);
        parties.setFont(new Font("Helvetica", Font.BOLD, 30));
        frame.add(parties);

        exit = new JLabel("EXIT");
        exit.setBounds(710, 350, 250, 30);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Helvetica", Font.BOLD, 30));
        frame.add(exit);

        JButton vot;
        ImageIcon vo = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Caste Vote.png");
        vot = new JButton(vo);
        vot.setBounds(100, 230, 110, 110);
        frame.add(vot);
        JLabel v = new JLabel("VOTE");
        v.setBounds(510, 570, 200, 30);
        v.setForeground(Color.white);
        v.setFont(labF);

        frame.add(v);
        JButton can;
        ImageIcon ca = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Candidate.jpg");
        can = new JButton(ca);
        can.setBounds(300, 230, 110, 110);
        frame.add(can);

        JButton ex;
        ImageIcon xx = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\exit.jpg");
        ex = new JButton(xx);
        ex.setBounds(690, 230, 110, 110);
        frame.add(ex);

        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == ex) {
                    System.exit(0);
                }

            }

        });

        can.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == can) {
                    C.SelectOption();
                }

            }

        });

        JButton par;
        ImageIcon cp = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Parties.jpg");
        par = new JButton(cp);
        par.setBounds(500, 230, 110, 110);
        frame.add(par);
        par.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == par) {
                    G.DisplayParties();
                }

            }

        });

        JLabel quote = new JLabel("\"Your Voice, Your Vote, Your Future! \"");
        quote.setBounds(520, 750, 500, 30);
        quote.setForeground(Color.WHITE);
        quote.setFont(new Font("Pristina", Font.BOLD, 35));
        frame.add(quote);

        //  Font labF=new Font("Helvetica", Font.BOLD, 30);
        Display d = new Display();

        ImageIcon i = new ImageIcon("C:\\Users\\thinkpad\\OneDrive\\Documents\\NetBeansProjects\\GUIevoting1\\images\\winner.png");
        JLabel w = new JLabel("WINNER");
        // w1.setFont(labF);
        w.setBounds(100, 570, 200, 30);
        w.setForeground(Color.white);
        w.setFont(labF);
        frame.add(w);
        JButton winnerButton = new JButton(i);
        winnerButton.setBounds(100, 450, 110, 110);

        ImageIcon ci = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\voteCand.png");
        JLabel c = new JLabel("CAN VOTE");
        //c1.setForegrounf(Color.WHITE);
        c.setBounds(280, 570, 300, 30);
        c.setForeground(Color.white);
        c.setFont(labF);
        frame.add(c);
        JButton candidateVotesButton = new JButton(ci);
        candidateVotesButton.setBounds(300, 450, 110, 110);

        GUIAdmin A=new GUIAdmin();
        ImageIcon ad = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Admin.png");
        JButton admin=new JButton(ad);
        admin.setBounds(700, 450, 110, 110);
        frame.add(admin);
        admin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                A.GUIAdminVerifyCheck();
                
            }
            
        });
        
        JLabel ADMIN=new JLabel("ADMIN");
        ADMIN.setBounds(700, 570, 300, 30);
        ADMIN.setFont(labF);
        ADMIN.setForeground(Color.WHITE);
        frame.add(ADMIN);
        ImageIcon vi = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\vote.png");

        JButton voterVoteButton = new JButton(vi);
        voterVoteButton.setBounds(500, 450, 110, 110);
        //  JButton provinceVotesButton = new JButton("See Province Wise Votes");
        //  JButton candidatePositionsButton = new JButton("See Positions of Candidates");
        // JButton exitButton = new JButton("Exit");
        //  exitButton.setBounds(100, 320, 160, 50);

        winnerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JFrame f = new JFrame();
                JPanel p = new JPanel(null);
                JLabel l = new JLabel("Winner is: " + d.displayWinner());
                l.setFont(new Font("Helvetica", Font.BOLD, 50));
                l.setForeground(Color.WHITE);

                l.setBounds(200, 100, 1000, 50);

                f.setSize(1540, 820);
                ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Main Background.jpg");
                JLabel backg = new JLabel(back);
                backg.setBounds(0, 0, f.getWidth(), back.getIconHeight());
                p.add(l);

                p.add(backg);

                f.add(p);
                f.setSize(1540, 820);
                f.setVisible(true);
            }
        });

        candidateVotesButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter the name of the candidate:");
                int votes = d.displayVotesOfCandidate(name);
                String s = Integer.toString(votes);
                JFrame f = new JFrame();
                JPanel p = new JPanel(null);
                JLabel l = new JLabel("Votes of " + name + " : " + s);
                l.setFont(new Font("Helvetica", Font.BOLD, 50));
                l.setForeground(Color.WHITE);
p.add(l);
                l.setBounds(200, 100, 1000, 50);

                f.setSize(1540, 820);
                ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Main Background.jpg");
                JLabel backg = new JLabel(back);
                backg.setBounds(0, 0, f.getWidth(), back.getIconHeight());
                
                p.add(backg);
                f.add(p);

                f.setSize(1540, 820);
                f.setVisible(true);
                //JOptionPane.showMessageDialog(panel,e, d. displayVotesOfCandidate(name));

            }
        });

        voterVoteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String voterCNIC = JOptionPane.showInputDialog("Enter the CNIC of the voter:");
                String votes = d.displayVote(voterCNIC);

                JFrame f = new JFrame();
                JPanel p = new JPanel(null);
                JLabel l = new JLabel("Vote of " + voterCNIC + " : " + votes);
                l.setFont(new Font("Helvetica", Font.BOLD, 40));
                l.setForeground(Color.WHITE);

                l.setBounds(10, 100, 1540, 50);

                f.setSize(1540, 820);
                ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Main Background.jpg");
                JLabel backg = new JLabel(back);
                backg.setBounds(0, 0, f.getWidth(), back.getIconHeight());
                p.add(l);
                p.add(backg);

                f.add(p);
                f.setVisible(true);

            }
        });
        /* 
        provinceVotesButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
               d. sortProvince();
            }
        });

        candidatePositionsButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
               d. sortCandidates();
            }
        });

        exitButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });*/

        frame.add(winnerButton);
//        frame.add(wl);
        frame.add(candidateVotesButton);
//           frame.add(cl);
        frame.add(voterVoteButton);
//           frame.add(vl);
        // panel.add(provinceVotesButton);
        // panel.add(candidatePositionsButton);
        // panel.add(exitButton);

        //frame.add(panel);
        frame.setVisible(true);

        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
       // frame.revalidate();
        //frame.repaint();

        ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\Main Background.jpg");
        backg = new JLabel(back);
        backg.setBounds(0, 0, frame.getWidth(), back.getIconHeight());
        frame.add(backg);

        vot.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == vot) {

                    V.VoterSide();
                }
            }
        });
frame.revalidate();
        frame.repaint();

    }

    public void DisplayParties() {
        Font labF = new Font("Monotype Corsiva", Font.BOLD, 25);
        JFrame frame = new JFrame("Parties");
        JPanel panel = new JPanel(null);
        frame.setVisible(true);
        frame.setSize(1540, 820);

        JButton goback = new JButton("Go Back");
        goback.setBounds(680, 670, 140, 40);
        goback.setFont(labF);
        panel.add(goback);
        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu();
            }

        });

        JLabel backg;
        ImageIcon back = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\parties (3).jpg");
        backg = new JLabel(back);
        backg.setBounds(110, 50, 1300, 200);
        panel.add(backg);

        JLabel ppp = new JLabel("Pakistan Peoples Party");
        ppp.setBounds(190, 250, 400, 30);
        ppp.setFont(labF);
        ppp.setForeground(Color.WHITE);
        panel.add(ppp);

        JLabel pti = new JLabel("Pakistan Tehreek-e-Insaaf");
        pti.setBounds(480, 250, 400, 30);
        pti.setFont(labF);
        pti.setForeground(Color.WHITE);
        panel.add(pti);

        JLabel pmln = new JLabel("Pakistan Muslim League");
        pmln.setBounds(780, 250, 400, 30);
        pmln.setFont(labF);
        pmln.setForeground(Color.WHITE);
        panel.add(pmln);

        JLabel mqm = new JLabel("Mutahida Qaumi Movement");
        mqm.setBounds(1080, 250, 400, 30);
        mqm.setFont(labF);
        mqm.setForeground(Color.WHITE);
        panel.add(mqm);

        JLabel nw;
        ImageIcon w = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\200s.jpg");
        nw = new JLabel(w);
        nw.setBounds(170, 400, 1200, 190);
        panel.add(nw);

        JLabel jip = new JLabel("Jamat Islami Pakistan");
        jip.setBounds(190, 590, 400, 30);
        jip.setFont(labF);
        jip.setForeground(Color.WHITE);
        panel.add(jip);

        JLabel pml = new JLabel("Pakistan Muslim League");
        pml.setBounds(490, 590, 400, 30);
        pml.setFont(labF);
        pml.setForeground(Color.WHITE);
        panel.add(pml);

        JLabel anp = new JLabel("Awami National Party");
        anp.setBounds(800, 590, 400, 30);
        anp.setFont(labF);
        anp.setForeground(Color.WHITE);
        panel.add(anp);

        JLabel psp = new JLabel("Pak Sarzameen Party");
        psp.setBounds(1100, 590, 400, 30);
        psp.setFont(labF);
        psp.setForeground(Color.WHITE);
        panel.add(psp);

        JLabel bf;
        ImageIcon b = new ImageIcon("C:\\Users\\thinkpad\\Downloads\\fp.jpg");
        bf = new JLabel(b);
        bf.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.add(bf);

        frame.add(panel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        GUIevoting1 GUI = new GUIevoting1();
        GUI.MainMenu();

    }
}
