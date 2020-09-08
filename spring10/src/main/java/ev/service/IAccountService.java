package ev.service;

import ev.domain.Account;

public interface IAccountService {

    Account findAccountById(Integer id);

    void transfer(String sourceName,String targetName,float money);
}
