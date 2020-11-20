package org.practice.junior.book01.chap05;

import org.practice.junior.book01.chap04.bok.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @Desc 《Java核心技术·卷1》第五章、继承
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/2/1 11:50
 * <p>
 * @Version 1.0
 */

public class AppInherit {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            initOrder();
            inherit();
            equals0502();
            hashCode0502();
            new AppInherit().hashCode();
            toString0502();
            genericArray0503();
            reflect0507();
            reflect050705();
            invokeMethod050706();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void initOrder() {
        //父执行类 greetMsg=greet() 时，会调用 Executive.greet()方法
        Executive executive = new Executive();
    }

    public static void inherit() {
        Employee employee = new Employee();
        System.out.println(employee);

        Manager manager = new Manager();
        System.out.println();

        manager.setId(10l);
        manager.setName("001-name");
        manager.setSalary(100d);
        manager.setBonus(50d);

        String greet = manager.greet();
        System.out.println(greet);

        Double allSalary = manager.getSalary();
        System.out.println(allSalary);

        Employee manager01 = new Manager();
        //manager01.setBonus(100d);//编译不通过

        Executive executive = new Executive();
        System.out.println(executive);
    }

    public static void equals0502() {
        boolean equals = Objects.equals(new Executive(), new Executive());
        System.out.println(equals);//false, 之前调试时是true？？？

        boolean equals02 = Objects.equals(new Executive(), new Executive());
        System.out.println("equals02: " + equals02);//false

        Executive executive01 = new Executive();
        Executive executive02 = new Executive();
        boolean equals01 = Objects.equals(executive01, executive02);
        System.out.println("equals01: " + equals01);//false
    }

    /**
     * String的比较，“==”比较，equals()比较
     * PS：“==”判断的是地址值，equals()方法判断的是内容
     * 注意：需要用括号括起来
     * https://blog.csdn.net/jakezhang1990/article/details/80827015
     * https://www.cnblogs.com/gc65/p/java.html
     * https://blog.csdn.net/qq_37476266/article/details/89344302
     */
    public static void hashCode0502() {
        String s01 = "OK";
        String s02 = new String("OK");
        String s03 = "OK";
        String s04 = s01;
        System.out.println("s01==s02 " + (s01 == s02));//false
        System.out.println("s01==s03 " + (s01 == s03));//true
        System.out.println("s01==s04 " + (s01 == s04));//true

        StringBuilder sb01 = new StringBuilder(s01);
        StringBuilder sb02 = new StringBuilder(s02);
        System.out.println(s01.hashCode() + ", " + sb01.hashCode());//2524, 1151020327
        System.out.println(s02.hashCode() + ", " + sb02.hashCode());//2524, 88579647
    }

    public int hashCode() {
        int hashCode = Objects.hashCode(getClass());
        System.out.println(hashCode);
        return hashCode;
    }

    public static void toString0502() {
        //Class clazz = getClass();//不能在静态方法中调用getClass()方法，编译报错
        Employee employee = new Employee();
        System.out.println(employee.toString());//@Data注解重新toString()方法：Employee(Id=null, name=null, salary=null, hireDate=null, greetMsg=Employee.greet())
    }

    public static void genericArray0503() {
        Employee[] employeeArray = new Employee[10];    //数组
        ArrayList<Employee> staff01 = new ArrayList<Employee>();    //数组列表
        ArrayList<Employee> staff02 = new ArrayList<>();    //数组列表，Java7中的新声明方式

        staff02.ensureCapacity(100);
        staff02.trimToSize();

        Employee employee02 = staff02.get(0);//staff02[0] 编译报错
        staff02.toArray(employeeArray);//数组列表转换为数组，方便访问
    }

    public static void reflect0507() throws Exception {
        //5.7.1、Class类
        Class clazz01 = new Employee().getClass();
        Class clazz02 = Class.forName("org.practice.junior.book01.chap04.bok.Employee");
        Class clazz03 = Employee.class;

        System.out.println(clazz01.getName());//org.practice.primary.book01.chap04.bok.Employee
        System.out.println(clazz01.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2

        System.out.println(clazz01 == clazz02);//true
        Object instance = clazz01.newInstance();//调用无参构造函数，若没有该构造函数则抛异常
        if (instance instanceof Employee) {
            Employee tmp = (Employee) instance;
            System.out.println(tmp.getName());
        }

        //5.7.3、利用反射分析类的能力
        Field[] fields01 = clazz01.getFields();//返回类提供的public域，包括超类的公有成员
        Field[] fields02 = clazz01.getDeclaredFields();//返回类提供的全部域，包括私有的、受保护的，但不包括超类的成员
        Constructor[] constructors01 = clazz01.getConstructors();
        Constructor[] constructors02 = clazz01.getDeclaredConstructors();
        Method[] methods01 = clazz01.getMethods();
        Method[] methods02 = clazz01.getDeclaredMethods();

        //fields01[0].getName();
        //fields01[0].getType();

        //constructors01[0].getName();
        //constructors01[0].getParameters();
        //constructors01[0].getAnnotation(null);
        //constructors01[0].getModifiers();
        //Modifier.isPublic(0);

        //methods01[0].getName();
        //methods01[0].getParameters();
        //methods01[0].getAnnotation(null);
        //methods01[0].getModifiers();
        //methods01[0].getReturnType();

        //5.7.4、在运行时使用反射分析对象
        Employee employee01 = new Employee("employee01", 111, new Date());
        Field nameField = Employee.class.getDeclaredField("name");
        nameField.setAccessible(true);
        String name = (String) nameField.get(employee01);//会抛出异常，因为name是私有域。java.lang.IllegalAccessException: Class org.practice.primary.book01.chap05.AppInherit can not access a member of class org.practice.primary.book01.chap04.bok.Employee with modifiers "private"
        System.out.println(name);
        nameField.set(employee01, "employee02");
        String name02 = (String) nameField.get(employee01);//会抛出异常，因为name是私有域。java.lang.IllegalAccessException: Class org.practice.primary.book01.chap05.AppInherit can not access a member of class org.practice.primary.book01.chap04.bok.Employee with modifiers "private"
        System.out.println(name02);

        Field salaryField = Employee.class.getDeclaredField("salary");
        salaryField.setAccessible(true);
        //double salary = (Double) salaryField.get(employee01);//java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Double
        Double salary = salaryField.getDouble(employee01);//salary为Double类型会报错：java.lang.IllegalArgumentException: Attempt to get java.lang.Double field "org.practice.primary.book01.chap04.bok.Employee.salary" with illegal data type conversion to double
        System.out.println(salary);
    }

    public static void reflect050705() {
        Employee[] employees = new Employee[100];
        employees[0] = new Employee("employee01", 111, new Date());
        employees = Arrays.copyOf(employees, 2 * employees.length);//用于扩展已经填满的数组
        System.out.println(employees.length);
        Employee employee = employees[0];
        System.out.println(employee.getName());

        Object[] oldObjects = new Object[10];
        Object[] newObjects = new Object[100];
        System.arraycopy(oldObjects, 0, newObjects, 0, Math.min(oldObjects.length, newObjects.length));
    }

    public static void invokeMethod050706() throws Exception {
        Class clazz = Employee.class;

        Method greetMethod = clazz.getMethod("greet");
        Object greetResult = greetMethod.invoke(clazz.newInstance());
        System.out.println(greetResult);

        Object newInstance = clazz.newInstance();
        Field salaryField = clazz.getDeclaredField("salary");
        salaryField.setAccessible(true);
        salaryField.set(newInstance, 100);
        Method salaryMethod = clazz.getMethod("raiseSalary", double.class);
        Object salaryResult = salaryMethod.invoke(newInstance, 10);
        System.out.println(salaryResult);

        Method sqrtMethod = Math.class.getMethod("sqrt", double.class);
        Object sqrtResult = sqrtMethod.invoke(null, 144);
        System.out.println(sqrtResult.getClass());
        System.out.println(sqrtResult);
    }
}
