/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Account;

/**
 *
 * @author Cam Nhung
 */
public class AccountServicesImp implements AccountServicesInterface{

    @Override
    public Account authenAccount(String username, String password) {
        if(username.equals("admin") && password.equals("root")){
            System.out.println("tag");
            return new Account();
        }
        return null;
    }

    @Override
    public void addNew(String username, String password, String fullname) {
        
    }
    
}
