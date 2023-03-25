package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //belli id li student getirelim
        Student04 student1 = session.get(Student04.class,1001);

        //diary getirelim
        Diary04 diary1 = session.get(Diary04.class,101);
        System.out.println(student1);
        System.out.println("*****************************");
        System.out.println(diary1);
        System.out.println("*****************************");
        System.out.println("Diary uzerinden student objesine ulasalim: "+diary1.getStudent());
        System.out.println("*****************************");
        System.out.println("Student uzerinden diary objesine ulasalim: "+student1.getDiary());

        // !!! Task: Kesisim kumesini bana getirin (INNER JOIN)
        String hqlQuery= "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id=d.student";
        List<Object[]> resultList = session.createQuery(hqlQuery).getResultList();
        for (Object[] w:resultList){
            System.out.println(Arrays.toString(w));
        }


        // !!! task 2 : HQL LEFT JOIN ***********
        String hqlQuery2= "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id=d.student";
        List<Object[]> resultList2 = session.createQuery(hqlQuery2).getResultList();
        resultList2.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });

        tx.commit();
        session.close();
        sf.close();


    }

}
