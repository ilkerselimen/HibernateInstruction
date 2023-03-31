package com.hb11.criteriaapi;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Random;

public class RunnerFetch11 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student11 student1 = session.get(Student11.class,1L);
//        student1.setName("Guncellenmis "+student1.getName());
//        session.update(student1);

        // !!! Degisken tanimla
        //     mathGrade puani 22 den kucuk olan ogrencilerin puanlarini 80 yapalim

//        int sMathGrade = 80;
//        int lMathGrade = 22;
//
//        String hqlQuery = "UPDATE Student11 s SET s.mathGrade=:sMath WHERE s.mathGrade<:lMath";
//        Query query = session.createQuery(hqlQuery);
//
//        query.setParameter("sMath", sMathGrade);
//        query.setParameter("lMath", lMathGrade);
//
//        int numberOfRecords = query.executeUpdate();
//        System.out.println("Etkilenen veri sayisi : " + numberOfRecords);

        // !!! CriteriaAPI **************************
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);

        // !!! 1.Ornek: butun Student11 objelerini ekrana basalim.
//        criteriaQuery.select(root); // SELECT * FROM Student11
//
//        Query<Student11> query1 = session.createQuery(criteriaQuery);
//        List<Student11> resultList = query1.getResultList();
//        resultList.forEach(System.out::println);

        // !!! 2.Ornek , Student ismi "Student Name 6" olan ogrenci bilgilerini getirelim.
        criteriaQuery.select(root). // SELECT * FROM Student11 s
                where(cb.equal(root.get("name"), "Student Name 6")); // WHERE s.name=""

        Query<Student11> query2 = session.createQuery(criteriaQuery);
        List<Student11> resultList2 = query2.getResultList();
        resultList2.forEach(System.out::println);


        tx.commit();
        session.close();
        sf.close();

    }

}
