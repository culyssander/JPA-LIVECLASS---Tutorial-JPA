package com.culysoft.sistemausuarios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Usuario-PU");
        EntityManager entityManager = factory.createEntityManager();

        primeiraConsulta(entityManager);

        entityManager.close();
        factory.close();
    }

    private static void primeiraConsulta(EntityManager entityManager) {

    }
}
