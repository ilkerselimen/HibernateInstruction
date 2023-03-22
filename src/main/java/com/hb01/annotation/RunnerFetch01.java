package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        /*
                DB den bilgi almak istiyorsam
                    1) get()
                    2) SQL
                    3) HQL
         */

        // !!! 1.Yol: get() ****************************************************
//        Student01 student1 = session.get(Student01.class,1001);
//        Student01 student2 = session.get(Student01.class,1002);
//        Student01 student3 = session.get(Student01.class,1003);
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);

        // !!! 2.Yol: SQL ****************************************************

//        String sqlQuery ="select * from t_student01";
//        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] object: resultList){
//            System.out.println(Arrays.toString(object));
//        }

        // !!! 3.Yol: HQL ****************************************************
        //    Trick : HQL sorgusunda From dan sonra sinif ismi kullanilmali
//        String hqlQuery = "FROM Student01";
//        List<Student01> resultList2 = session.createQuery(hqlQuery, Student01.class).getResultList();
//        for (Student01 w:resultList2){
//            System.out.println(w);
//        }

        // Not: yukardaki 3 methodu kiyaslayalim...
        //      1. hazir method 2. hql 3. sql
        // !!! Donecek kaydin unique (tek bir tane) oldugundan emin isem uniqueResult() ...

        // SQL ile
        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name ilike 'cemil bey'";
        Object[] uniqueResult01 =(Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println(Arrays.toString(uniqueResult01));

        // HQL ile
        String hqlQuery2 ="FROM Student01 WHERE name='Cemil Bey' ";
        Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println(uniqueResult2);


        tx.commit();

        session.close();
        sf.close();

    }

}
