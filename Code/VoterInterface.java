/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.guievoting1;

/**
 *
 * @author thinkpad
 */
public interface VoterInterface {

    void VoterSide();

    void InputVoter();

    void Login();

    void DisplayCandidates(String cnic, String city);

    void StoreVote(String CandidateName);

    boolean CastedValidCandidate(String CandidateName);

    boolean alreadyCasted(String cnic);

    void DisplayVote(String cnic);
boolean isAbove18(String dateOfBirth);
}
