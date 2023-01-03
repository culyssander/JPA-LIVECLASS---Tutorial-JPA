package com.culysoft.sistemausuarios;

import com.culysoft.sistemausuarios.model.Configuracao;
import com.culysoft.sistemausuarios.model.Dominio;
import com.culysoft.sistemausuarios.model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Usuario-PU");
        EntityManager entityManager = factory.createEntityManager();

//        primeiraConsulta(entityManager);
//        fazerProjecoes(entityManager);
//        consultaComParametro(entityManager);
//        fazerJoins(entityManager);

//        fazerLeftJoin(entityManager);

//        carregamentoComJoinFetch(entityManager);
        filtrandoRegistros(entityManager);

        entityManager.close();
        factory.close();
    }

    private static void filtrandoRegistros(EntityManager entityManager) {
        // LIKE, IS NULL, IS EMPTY, >, <, >=, <=, =, <>
//        String jpql = "SELECT u FROM Usuario u WHERE u.nome like :nomeUsuario";
        String jpql = "SELECT u FROM Usuario u WHERE u.nome like concat(:nomeUsuario, '%')";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class)
                .setParameter("nomeUsuario", "%cal%");
        typedQuery.getResultList().forEach(System.out::println);
    }

    public static void carregamentoComJoinFetch(EntityManager entityManager) {
        String jpql = "SELECT u FROM Usuario u JOIN FETCH u.configuracao JOIN FETCH u.dominio d";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        typedQuery.getResultList().forEach(System.out::println);
    }

    private static void fazerLeftJoin(EntityManager entityManager) {
        String jpql = "SELECT u, c FROM Usuario u left join u.configuracao c";
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        typedQuery.getResultList().forEach(arr -> {
            String out = ((Usuario) arr[0]).getNome();

            if(arr[1] == null)
                out += ", NULL";
            else
                out += ", " + ((Configuracao) arr[1]).getId();

            System.out.println(out);
        });
    }

    private static void fazerJoins(EntityManager entityManager) {
        String jpql = "SELECT u FROM Usuario u JOIN u.dominio d WHERE d.id = 2";
        TypedQuery<Usuario> typedQuery = entityManager.createQuery(jpql, Usuario.class);
        typedQuery.getResultList()
                .forEach(System.out::println);
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
