package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    private AccountDAO accountDAO;
    
    public AccountService(){
        accountDAO = new AccountDAO();
    }
    
    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    /*
    - The registration will be successful if and only if the username is not blank, 
    - the password is at least 4 characters long, 
    - and an Account with that username does not already exist. (username is set as a unique field in account, so there's no need to check for this)
    If all these conditions are met, the response body should contain a JSON of the Account, 
    including its account_id. 
    */
    public Account addAccount(Account account) {
        if(account.getUsername().length() <= 0){
            return null;
        }
        if(account.getPassword().length() < 4){
            return null;
        }
        return accountDAO.registerUser(account);
    }

    /*
    The login will be successful if and only if the username and password provided in the request body JSON match a real account existing on the database. 
    If successful, the response body should contain a JSON of the account in the response body, 
    including its account_id. 
    */
    public Account loginAccount(Account account) {
        return accountDAO.loginDAO(account);
    }
}
