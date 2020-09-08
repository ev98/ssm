package ev.jdbctemplate;

import ev.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
        /*jt.update("insert into account(name,money)values (?,?)","eee",3333);*/

        /*jt.update("update account set name=?,money=? where id=?","test",1234,6);*/

        /*jt.update("delete from account where id = ?",6);*/

        /*List<Account> accounts = jt.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts) {
            System.out.println(account);
        }*/

        /*List<Account> accounts = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
        System.out.println(accounts.isEmpty()?"无":accounts.get(0));*/

        Long count = jt.queryForObject("select count(*) from account where money > ?", Long.class, 1000);
        System.out.println(count);
    }
}
