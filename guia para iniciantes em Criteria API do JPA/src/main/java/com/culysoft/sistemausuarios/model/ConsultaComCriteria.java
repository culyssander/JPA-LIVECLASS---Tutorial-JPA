package com.culysoft.sistemausuarios.model;

import com.culysoft.sistemausuarios.UsuarioDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;


public class ConsultaComCriteria {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Usuario-PU");
        EntityManager entityManager = factory.createEntityManager();

//        primeiraConsulta(entityManager);
//        escolhendoORetorno(entityManager);
//        fazendoProjecoes(entityManager);
//        fazendoProjecoes(entityManager);
//        consultaComParametro(entityManager);
//        order(entityManager);
        paginacao(entityManager);
    }

    private static void paginacao(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = criteriaQuery.from(Usuario.class);
        criteriaQuery.select(root);

        TypedQuery<Usuario> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(2);

        typedQuery.getResultList().forEach(System.out::println);
    }

    private static void order(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = criteriaQuery.from(Usuario.class);
        criteriaQuery.select(root);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("nome")));

        TypedQuery<Usuario> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(System.out::println);
    }

    private static void consultaComParametro(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);

        Root<Usuario> root = criteriaQuery.from(Usuario.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), 1));

        TypedQuery<Usuario> typedQuery = entityManager.createQuery(criteriaQuery);
        System.out.println(typedQuery.getResultList());
    }

    private static void fazendoProjecoes(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
//
//        Root<Usuario> root = criteriaQuery.from(Usuario.class);
//
//        criteriaQuery.multiselect(root.get("id"), root.get("login"), root.get("nome"));
//
//        TypedQuery<Object[]> typedQuery = entityManager.createQuery(criteriaQuery);
//        typedQuery.getResultList().forEach(arr -> System.out.println(Arrays.toString(arr)));

//        criteriaQuery.select(new UsuarioDto(Integer.parseInt(root.get("id").toString()),
//                root.get("login").toString(),
//                root.get("nome").toString()));

        CriteriaQuery<UsuarioDto> criteriaQuery = criteriaBuilder.createQuery(UsuarioDto.class);

        Root<Usuario> root = criteriaQuery.from(Usuario.class);
//        System.out.println("SEPARADO: " + root.get("nome"));

//        criteriaQuery.multiselect(root.get("id"), root.get("login"), root.get("nome"));
        criteriaQuery.select(criteriaBuilder.construct(
                UsuarioDto.class, root.get("id"), root.get("login"), root.get("nome")
        ));

        TypedQuery<UsuarioDto> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(System.out::println);
    }

    private static void escolhendoORetorno(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<Usuario> root = criteriaQuery.from(Usuario.class);

        criteriaQuery.select(root.get("nome"));

        TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);

        typedQuery.getResultList().forEach(System.out::println);

//        CriteriaQuery<Dominio> criteriaQuery = criteriaBuilder.createQuery(Dominio.class);
//        Root<Usuario> root = criteriaQuery.from(Usuario.class);
//
//        criteriaQuery.select(root.get("dominio"));
//
//        TypedQuery<Dominio> typedQuery = entityManager.createQuery(criteriaQuery);
//
//        typedQuery.getResultList().forEach(System.out::println);
    }

    private static void primeiraConsulta(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = criteriaQuery.from(Usuario.class);
        criteriaQuery.select(root);

        TypedQuery<Usuario> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.getResultList().forEach(System.out::println);
    }
}
