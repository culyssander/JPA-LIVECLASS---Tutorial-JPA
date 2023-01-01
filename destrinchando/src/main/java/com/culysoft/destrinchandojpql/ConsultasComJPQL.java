package com.culysoft.destrinchandojpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultasComJPQL {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Usuario-PU");
        EntityManager entityManager = factory.createEntityManager();




        entityManager.close();
        factory.close();
    }

    private static void primeiraConsulta(EntityManager entityManager) {
        String jpql = "select from U";
    }
}
