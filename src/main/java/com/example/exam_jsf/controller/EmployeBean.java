package com.example.exam_jsf.controller;
import com.example.exam_jsf.model.Employe;
import com.example.exam_jsf.Service.EmployeService;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.List;
@ManagedBean(name="empBean")
@SessionScoped
public class EmployeBean {
    private List<Employe> empList = new ArrayList<Employe>();
    private EmployeService userService = new EmployeService();
    private String message;
    private String message1;
    private boolean showAddUserForm;
    private Employe newUser;


    public Employe getNewUser() {
        return newUser;
    }

    public void setNewUser(Employe newUser) {
        this.newUser = newUser;
    }

    public EmployeBean() {
        newUser = new Employe();
        init();

    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {
        empList.clear();
        empList.addAll(userService.selectUser());
    }

    public EmployeService getUserService() {
        return userService;
    }

    public void setUserService(EmployeService userService) {
        this.userService = userService;
    }

    public List<Employe> getUserList() {
        return empList;
    }



    public void setUserList(List<Employe> userList) {
        this.empList = userList;
    }

    public void deleteuser(String email) {
        message = userService.deleteUser(email);
        init();
    }

    public void adduser(Employe emp) {
        message1 = userService.addUser(emp);
        init();

    }
}

