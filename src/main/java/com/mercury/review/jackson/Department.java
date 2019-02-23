package com.mercury.review.jackson;

public class Department {

    private String name;
    private Integer employeeCount;

    public Department() {

    }

    public Department(String name, Integer employeeCount) {
        this.name = name;
        this.employeeCount = employeeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", employeeCount=" + employeeCount +
                '}';
    }
}
