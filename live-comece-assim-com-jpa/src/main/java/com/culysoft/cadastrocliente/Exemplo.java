package com.culysoft.cadastrocliente;

import com.culysoft.cadastrocliente.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Exemplo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Clientes-PU");

        EntityManager entityManager = factory.createEntityManager();

//        Cliente cliente = entityManager.find(Cliente.class, 1);
//        System.out.println(cliente);

//        Cliente cliente = new Cliente();
//        cliente.setNome("Laura Bernardo");
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(cliente);
//        entityManager.getTransaction().commit();

//        Cliente cliente = entityManager.find(Cliente.class, 2);
//
//        entityManager.getTransaction().begin();
//        entityManager.remove(cliente);
//        entityManager.getTransaction().commit();

        Cliente cliente = entityManager.find(Cliente.class, 1);
        Cliente cliente2 = entityManager.find(Cliente.class, 1);

        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNome("Culysoft");

        entityManager.getTransaction().begin();
        entityManager.merge(cliente1);
        entityManager.getTransaction().commit();

        List<Cliente> clientes = entityManager.createQuery("select c from Cliente c").getResultList();

        clientes.stream().forEach(System.out::println);
        entityManager.close();
        factory.close();
    }
}
