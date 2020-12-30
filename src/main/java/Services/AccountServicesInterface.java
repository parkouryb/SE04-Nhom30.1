package Services;


import Entity.Account;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cam Nhung
 */
public interface AccountServicesInterface {
    Account authenAccount(String username, String password);
    void addNew(String username, String password, String fullname);
    
}
