package com.sushe.entity;

/**
 * Created by jiangbin on 15/4/23.
 */
public class School_DepartMent {
    private School school;
    private Department department;
    private String status;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
