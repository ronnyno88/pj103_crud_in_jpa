package connection;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectioBD {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public EntityManager createConnection(){
        try {
            emf = Persistence.createEntityManagerFactory("person");
            em = emf.createEntityManager();
            System.out.println("Connected");
        } catch (Exception e){
            e.printStackTrace();
        }
        return em;
    }

    public void closeConnection(){
        emf.close();
        em.close();
        System.out.println("Finished");
    }

}
