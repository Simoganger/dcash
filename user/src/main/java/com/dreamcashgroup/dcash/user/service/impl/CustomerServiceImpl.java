package com.dreamcashgroup.dcash.user.service.impl;

import com.dreamcashgroup.dcash.common.exception.DCashDBItemAlreadyExistException;
import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.common.exception.EnumErrorCode;
import com.dreamcashgroup.dcash.model.entity.Customer;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.user.dto.CustomerDto;
import com.dreamcashgroup.dcash.user.repository.CustomerRepository;
import com.dreamcashgroup.dcash.user.service.CustomerService;
import com.dreamcashgroup.dcash.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Créer un client sur le système
     *
     * @param customerDto
     * @return
     */
    @Override
    @Transactional
    public Customer create(CustomerDto customerDto) throws DCashDBItemAlreadyExistException {
        // Créer un compte de connexion pour ce client
        Users user = userService.create(customerDto.getEmail(), customerDto.getPassword());

        // Créer le client lui même
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setUser(user);
        return save(customer);
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
        // TODO
        return null;
    }

    /**
     * Récupérer la liste de tous les clients
     *
     * @return
     */
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
