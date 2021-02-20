package com.dreamcashgroup.dcash.user.service.impl;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.common.exception.EnumErrorCode;
import com.dreamcashgroup.dcash.model.entity.Customer;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.user.dto.CustomerDto;
import com.dreamcashgroup.dcash.user.repository.CustomerRepository;
import com.dreamcashgroup.dcash.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder encoder;

    /**
     * Créer un client sur le système
     *
     * @param customerDto
     * @return
     */
    @Override
    public Customer create(CustomerDto customerDto) {
        // Créer un compte utilisateur pour ce client
        Users user = new Users();
        user.setUsername(customerDto.getEmail());
        user.setPassword(encoder.encode(customerDto.getPassword()));
        user.setActive(true);

        // TODO
        return null;
    }

    /**
     * Enregistrer un client
     *
     * @param customer
     * @return
     */
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Retrouver un client à partir de son identifiant
     *
     * @param id
     * @return
     * @throws DCashDBItemNotFoundException
     */
    @Override
    public Customer findById(String id) throws DCashDBItemNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(()-> new DCashDBItemNotFoundException(EnumErrorCode.ERROR_DB_ITEM_NOTFOUND, Customer.class.getSimpleName(), "id", id));
    }

    /**
     * Rechercher un client à partir de son adresse mail
     *
     * @param email
     * @return
     */
    @Override
    public Optional<Customer> findByEmail(String email) {
        // TODO
        return Optional.empty();
    }

    /**
     * Vérifier si un client existe avec un email donné
     *
     * @param email
     * @return
     */
    @Override
    public boolean existsByEmail(String email) {
        // TODO
        return false;
    }

    /**
     * Mettre à jour un client
     *
     * @param id
     * @param customerDto
     * @return
     * @throws DCashDBItemNotFoundException
     */
    @Override
    public Customer update(String id, CustomerDto customerDto) throws DCashDBItemNotFoundException {
        // TODO
        return null;
    }

    /**
     * Supprimer un client
     *
     * @param id
     * @throws DCashDBItemNotFoundException
     */
    @Override
    public void delete(String id) throws DCashDBItemNotFoundException {
        // TODO
    }

    /**
     * Récupérer une page d'utilisateurs
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Page<Customer> getCustomerPerPage(int pageNo, int pageSize) {
        return null;
    }
}
