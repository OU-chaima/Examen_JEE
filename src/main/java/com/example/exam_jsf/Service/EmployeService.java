package com.example.exam_jsf.Service;
import com.example.exam_jsf.DAO.EmployeDaoImp;
import com.example.exam_jsf.model.Employe;
import com.example.exam_jsf.DAO.EmployeDao;
import java.util.List;

public class EmployeService {

    private EmployeDao employeDao;

    public EmployeService(){
         employeDao=new EmployeDaoImp();
    }
    public String addUser(Employe emp) {
        try {
            boolean emailExist = employeDao.existEmail(emp);
            if (!emailExist) {
                boolean added = employeDao.ajouter(emp);
                if (added) {
                    return emp.getName() + " is added";
                } else {
                    return emp.getName() + " is not added";
                }
            } else {
                return emp.getEmail() + " is already exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error adding user";
        }
    }

    public List<Employe> selectUser() {
        return employeDao.lister();
    }

    public boolean editUser(Employe emp) {
        try {
            return employeDao.edit(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String deleteUser(String email) {
        boolean isDeleted = employeDao.delete(email);
        return isDeleted ? email + " is deleted" : email + " is not deleted";
    }

    public boolean isExistEmail(Employe emp) {
        return employeDao.existEmail(emp);
    }
}
