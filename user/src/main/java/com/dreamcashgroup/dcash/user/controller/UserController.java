package com.dreamcashgroup.dcash.user.controller;

import com.dreamcashgroup.dcash.common.annotation.CurrentUser;
import com.dreamcashgroup.dcash.common.common.ResponseCode;
import com.dreamcashgroup.dcash.common.common.ResponseStatus;
import com.dreamcashgroup.dcash.common.common.RestResponse;
import com.dreamcashgroup.dcash.common.exception.DCashDBItemAlreadyExistException;
import com.dreamcashgroup.dcash.common.exception.DCashDBItemNotFoundException;
import com.dreamcashgroup.dcash.common.security.CustomUserDetails;
import com.dreamcashgroup.dcash.model.entity.Users;
import com.dreamcashgroup.dcash.user.dto.CustomerDto;
import com.dreamcashgroup.dcash.user.service.CustomerService;
import com.dreamcashgroup.dcash.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;


    // GESTION DES CLIENTS
    /**
     * Création d'un client
     * @param customerDto
     * @return
     */
    @PostMapping
    @ApiOperation(value = "Créer un client")
    public RestResponse createCustomer(@Valid @RequestBody CustomerDto customerDto) throws DCashDBItemAlreadyExistException {
        return new RestResponse(customerService.create(customerDto), "Client crée avec succès", ResponseStatus.SUCCESS, ResponseCode.CREATED.getValue());
    }

    /**
     * Récupérer un client à partir de son identifiant
     * @param customerId
     * @return
     * @throws DCashDBItemNotFoundException
     */
    @GetMapping("/{customerId}")
    @ApiOperation(value = "Récupérer un client à partir de son identifiant")
    public RestResponse getCustomerById(@PathVariable String customerId) throws DCashDBItemNotFoundException {
        return new RestResponse(customerService.findById(customerId), "Client avec pour id " + customerId, ResponseStatus.SUCCESS, ResponseCode.OK.getValue());
    }

    /**
     * Récupérer tous le clients
     * @return
     * @throws DCashDBItemNotFoundException
     */
    @GetMapping
    @ApiOperation(value = "Récupérer tous les clients")
    public RestResponse getAllCustomers() throws DCashDBItemNotFoundException {
        return new RestResponse(customerService.getAllCustomers(), "Liste de tous les clients", ResponseStatus.SUCCESS, ResponseCode.OK.getValue());
    }

    /**
     * Récupérer tous le clients
     * @return
     * @throws DCashDBItemNotFoundException
     */
    @GetMapping("/me")
    @ApiOperation(value = "Récupérer les informations sur l'utilisateur connecté")
    public RestResponse getCurrentUser(@CurrentUser CustomUserDetails customUserDetails) throws DCashDBItemNotFoundException {
        Users user = userService.findById(customUserDetails.getId());
        if(user.isAdmin()){
            return new RestResponse(user, "Administrateur connecté", ResponseStatus.SUCCESS, ResponseCode.OK.getValue());
        }else{
            return new RestResponse(customerService.getCurrentCustomer(customUserDetails.getId()), "Client courant", ResponseStatus.SUCCESS, ResponseCode.OK.getValue());
        }
    }



}
