/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.guievoting1;

/**
 *
 * @author thinkpad
 */
public interface CandidateInterface {
    
    void InputCandidate() ;
    boolean alreadyRegistered(String cnic);
    void StoreLoginInfo();
    void TOTALvotes(String cnic);
    void LOGIN();
    boolean VerifyCandidate(String cnic, String name, String province, String city, String party);
    
}
