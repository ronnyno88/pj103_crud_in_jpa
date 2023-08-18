package controller;

import connection.ConnectioBD;
import jakarta.persistence.EntityManager;
import model.Person;

public class PersonController {

    ConnectioBD connect = new ConnectioBD();
    public PersonController() {
    }

    public void createPerson(Person person){
        EntityManager em = connect.createConnection();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        connect.closeConnection();
        System.out.println("created successful");
    }

    public void readPerson(Integer id){
        EntityManager em = connect.createConnection();
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        System.out.println("id: "+p.getId()+" - name: "+p.getName() +" - age: "+p.getAge());
        em.getTransaction().commit();
        connect.closeConnection();
        System.out.println("finded successful");
    }

    public void updatePerson(Person person, Integer id){
        EntityManager em = connect.createConnection();
        em.getTransaction().begin();
        Person p = new Person();
        p.setId(id);
        p.setName(person.getName());
        p.setAge(person.getAge());
        em.merge(p);
        em.getTransaction().commit();
        connect.closeConnection();
        System.out.println("updated successful");
    }

    public void deletePerson(int id){
        EntityManager em = connect.createConnection();
        em.getTransaction().begin();
        Person p = em.find(Person.class, id);
        em.remove(p);
        em.getTransaction().commit();
        connect.closeConnection();
        System.out.println("deleted successful");
    }
}
