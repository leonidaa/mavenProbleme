package com.scenebuilderproba.model;

import javafx.beans.property.*;

import java.sql.Date;

public class Employee {
    private IntegerProperty employeeId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty phoneNumber;
    private SimpleObjectProperty <Date> hireDate;
    private StringProperty jobId;
    private IntegerProperty salary;
    private DoubleProperty commision;
    private IntegerProperty managerId;
    private IntegerProperty departmentId;

    public Employee() {
        this.employeeId=new SimpleIntegerProperty();
        this.firstName=new SimpleStringProperty();
        this.lastName=new SimpleStringProperty();
        this.email=new SimpleStringProperty();
        this.phoneNumber=new SimpleStringProperty();
        this.hireDate=new SimpleObjectProperty<>();
        this.jobId=new SimpleStringProperty();
        this.salary=new SimpleIntegerProperty();
        this.commision=new SimpleDoubleProperty();
        this.managerId=new SimpleIntegerProperty();
        this.departmentId=new SimpleIntegerProperty();
    }

    public int getEmployeeId() {
        return employeeId.get();
    }

    public IntegerProperty employeeIdProperty() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId.set(employeeId);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public Date getHireDate() {
        return hireDate.get();
    }

    public SimpleObjectProperty<Date> hireDateProperty() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate.set(hireDate);
    }

    public String getJobId() {
        return jobId.get();
    }

    public StringProperty jobIdProperty() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId.set(jobId);
    }

    public int getSalary() {
        return salary.get();
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    public double getCommision() {
        return commision.get();
    }

    public DoubleProperty commisionProperty() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision.set(commision);
    }

    public int getManagerId() {
        return managerId.get();
    }

    public IntegerProperty managerIdProperty() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId.set(managerId);
    }

    public int getDepartmentId() {
        return departmentId.get();
    }

    public IntegerProperty departmentIdProperty() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId.set(departmentId);
    }

}