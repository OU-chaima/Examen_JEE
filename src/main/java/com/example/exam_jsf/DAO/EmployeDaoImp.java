package com.example.exam_jsf.DAO;

import com.example.exam_jsf.model.Employe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class EmployeDaoImp implements EmployeDao {
        private EntityManagerFactory emf;

        public EmployeDaoImp() {
            // Initialize EntityManagerFactory
            this.emf = Persistence.createEntityManagerFactory("Eclipselink");
        }
@Override
        @Transactional

        public boolean ajouter(Employe emp) {

            try {
                EntityManager em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                em.persist(emp);
                tx.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }finally {
                emf.close();
            }
        }

        @Override
        public List<Employe> lister() {
            EntityManager em = emf.createEntityManager();
            return em.createQuery("select u from Employe u", Employe.class).getResultList();
        }
        @Override
        @Transactional
        public boolean edit(Employe emp) {
            try {
                EntityManager em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                em.merge(emp);
                tx.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }finally {
                emf.close();
            }

        }

        @Override
        @Transactional

        public boolean delete(String email1) {
            try {
                EntityManager em = emf.createEntityManager();
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                Employe emp = em.createQuery("select u from Employe u WHERE u.email= :email", Employe.class).setParameter("email", email1).getSingleResult();
                em.remove(emp);
                tx.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }finally {
                emf.close();
            }
        }
        @Override
        public boolean existEmail(Employe emp) {
            EntityManager em = emf.createEntityManager();

            Long count = em.createQuery("select count(u) from Employe u where u.email= :email", Long.class).setParameter("email", emp.getEmail())
                    .getSingleResult();
            return count > 0;
        }
    }


