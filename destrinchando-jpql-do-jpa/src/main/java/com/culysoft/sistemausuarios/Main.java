package com.culysoft.sistemausuarios;

import com.culysoft.sistemausuarios.model.Dominio;
import com.culysoft.sistemausuarios.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Usuario-PU");
        EntityManager entityManager = factory.createEntityManager();

//        primeiraConsulta(entityManager);
//        fazerProjecoes(entityManager);
        consultaComParametro(entityManager);

        entityManager.close();
        factory.close();
    }

    private static void consultaComParametro(EntityManager entityManager) {
        String jpql = "SELECT u FROM Usuario u WHERE u.id = :idUsuario";

        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class)
                .setParameter("idUsuario", 1);
        Usuario usuario = query.getSingleResult();

        System.out.println(usuario);
    }

    private static void fazerProjecoes(EntityManager entityManager) {
        String jpql = "SELECT new com.culysoft.sistemausuarios.UsuarioDto(u.id, u.login, u.nome) FROM Usuario u";
        TypedQuery<UsuarioDto> usuarioTypedQuery = entityManager.createQuery(jpql, UsuarioDto.class);

        usuarioTypedQuery.getResultList().forEach(System.out::println);
//        System.out.println(usuarioTypedQuery.getSingleResult());
    }

    private static void primeiraConsulta(EntityManager entityManager) {
//        String jpql = "SELECT u FROM Usuario u";
        String jpql = "SELECT u FROM Usuario u WHERE u.id = 1";
        TypedQuery<Usuario> usuarioTypedQuery = entityManager.createQuery(jpql, Usuario.class);

//        usuarioTypedQuery.getResultList().forEach(System.out::println);
        System.out.println(usuarioTypedQuery.getSingleResult());
    }
}
