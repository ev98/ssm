package factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * 一个创建Bean对象的工厂
 * <p>
 * Bean：在计算机英语中，有可重用组件的含义。
 * JavaBean：用java语言编写的可重用组件。
 * javabean >  实体类
 * <p>
 * 它就是创建service和dao对象的。
 * <p>
 * 第一个：需要一个配置文件来配置service和dao
 * 配置的内容：唯一标识=全限定类名（key=value)
 * 第二个：通过读取配置文件中配置的内容，反射创建对象
 * <p>
 * 配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    private static Properties props;

    //定义一个Map，用于存放我们要创建的对象，我们把它称之为容器
    private static Map<String, Object> beans;

    static {
        try {
            props = new Properties();
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(is);

            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration<Object> keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanpath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanpath).getDeclaredConstructor().newInstance();
                //把key和value存入容器
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败...");
        }
    }

    //根据bean的名称获取bean对象
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }


    /*//根据bean的名称获取bean对象
    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).getDeclaredConstructor().newInstance();//每次都会调用默认构造函数创建对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
