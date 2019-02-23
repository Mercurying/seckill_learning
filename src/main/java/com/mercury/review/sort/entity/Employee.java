package com.mercury.review.sort.entity;

public class Employee implements Comparable {
    private String name;
    private Integer age;

    public Employee() {
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee employee = (Employee) o;
            // 按照姓名升序排序
            return this.name.compareTo(employee.getName());
            // 按照年龄升序排序
            // return this.age.compareTo(employee.getAge());
        }
        // throw new ClassNotFoundException("不能转换成Employee类型对象");
        return -1;
    }
}
