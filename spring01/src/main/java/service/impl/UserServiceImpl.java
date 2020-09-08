package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import factory.BeanFactory;
import service.UserService;

public class UserServiceImpl implements UserService {
    //private UserDao dao = (UserDao) BeanFactory.getBean("userDao");
    private UserDao dao = new UserDaoImpl();
    public void saveUser() {
        dao.saveUser();
    }
}
