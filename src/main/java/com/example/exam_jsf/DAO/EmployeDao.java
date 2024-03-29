package com.example.exam_jsf.DAO;
import com.example.exam_jsf.model.Employe;
import java.util.List;

public interface EmployeDao {
        boolean ajouter(Employe emp);
        List<Employe>lister();
        boolean delete( String email);
        boolean existEmail(Employe emp);
        boolean edit(Employe emp);
    }
