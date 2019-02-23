package com.mercury.review.jackson;

import java.util.List;

public class Company {
    private String name;
    private String address;
    private Integer employeeCount;
    private List<Department> departmentList;

    public Company() {
    }

    public Company(String name, String address, Integer employeeCount, List<Department> departmentList) {
        this.name = name;
        this.address = address;
        this.employeeCount = employeeCount;
        this.departmentList = departmentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employeeCount=" + employeeCount +
                ", departmentList=" + departmentList +
                '}';
    }
}
