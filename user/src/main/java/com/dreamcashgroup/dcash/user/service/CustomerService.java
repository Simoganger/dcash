package com.dreamcashgroup.dcash.user.service;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemAlreadyExistException;
import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.model.entity.Customer;
import com.dreamcashgroup.dcash.user.dto.CustomerDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    /**
     * Créer un client sur le système
     * @param customerDto
     * @return
     */
    Customer create(CustomerDto customerDto) throws DCashDBItemAlreadyExistException;

    /**
     * Enregistrer un client
     * @param customer
     * @return
     */
    Customer save(Customer customer);

    /**
     * Retrouver un client à partir de son identifiant
     * @param id
     * @return
     * @throws DCashDBItemNotFoundException
     */
    Customer findById(String id) throws DCashDBItemNotFoundException;

    /**
     * Rechercher un client à partir de son adresse mail
     * @param email
     * @return
     */
    Optional<Customer> findByEmail(String email);

    /**
     * Vérifier si un client existe avec un email donné
     * @param email
     * @return
     */
    boolean existsByEmail(String email);

    /**
     * Mettre à jour un client
     * @param id
     * @param customerDto
     * @return
     * @throws DCashDBItemNotFoundException
     */
    Customer update(String id, CustomerDto customerDto) throws DCashDBItemNotFoundException;

    /**
     * Supprimer un client
     * @param id
     * @throws DCashDBItemNotFoundException
     */
    void delete(String id) throws DCashDBItemNotFoundException;

    /**
     * Récupérer une page d'utilisateurs
     * @return
     */
    Page<Customer> getCustomerPerPage(int pageNo, int pageSize);

    /**
     * Récupérer la liste de tous les clients
     * @return
     */
    List<Customer> getAllCustomers();
}
