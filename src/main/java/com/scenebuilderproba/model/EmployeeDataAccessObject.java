package com.scenebuilderproba.model;

import com.scenebuilderproba.util.DbUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeDataAccessObject {
    public static Employee searchEmployee(String employeeId) throws SQLException, ClassNotFoundException {
        String selectStatement = "SELECT * FROM employees WHERE employee_id=" +
                employeeId;
        try {
            ResultSet resultSet = DbUtil.dbExecuteQuery(selectStatement);
            Employee employee = getEmployeeFromResultSet(resultSet);
            return employee;
        } catch (SQLException e) {
            System.out.println("while searching" + employeeId + "id,error occur:" + e);
            throw e;
        }
    }

    private static Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException {
        Employee employee = null;
        if (rs.next()) {
            employee = new Employee();
            employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));

            employee.setFirstName(rs.getString("FIRST_NAME"));
            employee.setLastName(rs.getString("LAST_NAME"));
            employee.setEmail(rs.getString("EMAIL"));
            employee.setPhoneNumber(rs.getString("PHONE_NUMBER"));
            employee.setHireDate(rs.getDate("HIRE_DATE"));
            employee.setJobId(rs.getString("JOB_ID"));
            employee.setSalary(rs.getInt("SALARY"));
            employee.setCommision(rs.getDouble("COMMISSION_PCT"));
            employee.setManagerId(rs.getInt("MANAGER_ID"));
            employee.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
        }

        return employee;
    }

    public static ObservableList<Employee> searchEmployeesAll() throws SQLException, ClassNotFoundException {
        String selectStatement = "SELECT * FROM employees";
        try {
            ResultSet resultSet = DbUtil.dbExecuteQuery(selectStatement);
            ObservableList<Employee> employeeList = getEmployeeList(resultSet);

            return employeeList;
        } catch (SQLException e) {
            System.out.println("SQL select operation failed " + e);
            throw e;
        }
    }

    public static ObservableList<Employee> getEmployeeList(ResultSet resultSet) throws SQLException, ClassNotFoundException {
        ObservableList<Employee> employeeObservableList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
            employee.setFirstName(resultSet.getString("FIRST_NAME"));
            employee.setLastName(resultSet.getString("LAST_NAME"));
            employee.setEmail(resultSet.getString("EMAIL"));
            employee.setPhoneNumber(resultSet.getString("PHONE_NUMBER"));
            employee.setHireDate(resultSet.getDate("HIRE_DATE"));
            employee.setJobId(resultSet.getString("JOB_ID"));
            employee.setSalary(resultSet.getInt("SALARY"));
            employee.setCommision(resultSet.getDouble("COMMISSION_PCT"));
            employee.setManagerId(resultSet.getInt("MANAGER_ID"));
            employee.setDepartmentId(resultSet.getInt("DEPARTMENT_ID"));
            employeeObservableList.add(employee);
        }
        return employeeObservableList;
    }
}