package com.mercury.review.sort;

import com.mercury.review.sort.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.CollationKey;
import java.text.Collator;
import java.util.*;

/**
 * 集合进行排序的两种方式：
 * 1.自然排序 参与排序的对象需要实现comparable接口，重写compareTo()方法,方法体中实现对象的大小比较
 * 规则
 * 2.定制排序或自定义排序 需编写匿名内部类 先new一个comparator接口的比较器对象c
 * 同时实现compare()其方法
 * 然后将比较器对象c传给Collections.sort()方法的参数列表中 实现排序功能
 * 说明：
 * 第一种方式不够灵活 实体类继承实现了Comparable接口 会增加耦合性
 * 第二种方式 需要的时候创建匿名内部类重写其比较方法即可
 */

public class CompareMain {

    private static final Logger logger = LoggerFactory.getLogger(CompareMain.class);

    public static void main(String[] args) {
         sortByMethodOne();
        // sortNameByComparator();
        // sortAgeByComparator();
    }

    private static void sortByMethodOne() {

        List<Employee> employees = initData();
        Collections.sort(employees);
        for (Employee e : employees) {
            logger.info("Employee sort:{}", e.toString());
        }
    }

    /**
     * 方式二的实现方式 比较name
     */
    private static void sortNameByComparator() {
        List<Employee> list = initData();
        Collections.sort(list, new Comparator<Employee>() {
            // 实现按照中文名首字母顺序进行比较
            Collator collator = Collator.getInstance(Locale.CHINA);

            @Override
            public int compare(Employee o1, Employee o2) {
                CollationKey key1 = collator.getCollationKey(o1.getName());
                CollationKey key2 = collator.getCollationKey(o2.getName());
                return key1.compareTo(key2);
            }
        });
        logger.info("实现Comparator接口实现对name的排序:");
        for (Employee e : list) {
            logger.info("Employee sort:{}", e.toString());
        }

    }

    /**
     * 方式二实现方式 比较age
     */
    private static void sortAgeByComparator() {
        List<Employee> list = initData();
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                Employee employee1 = (Employee) o1;
                Employee employee2 = (Employee) o2;
                /*按照年龄升序排序*/
                /*倒序可以使用employee2-employee1*/
                return employee1.getAge() - employee2.getAge();
            }
        });

        logger.info("实现Comparator接口实现对age的排序:");
        for (Employee e : list) {
            logger.info("Employee sort:{}", e.toString());
        }
    }


    private static List<Employee> initData() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee1 = new Employee("上海", 55);
        Employee employee2 = new Employee("成都", 43);
        Employee employee3 = new Employee("北京", 32);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        return employeeList;
    }


}
