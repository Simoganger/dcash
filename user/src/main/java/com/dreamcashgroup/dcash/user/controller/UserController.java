package com.dreamcashgroup.dcash.user.controller;

import com.dreamcashgroup.dcash.common.common.ResponseCode;
import com.dreamcashgroup.dcash.common.common.ResponseStatus;
import com.dreamcashgroup.dcash.common.common.RestResponse;
import com.dreamcashgroup.dcash.user.dto.CustomerDto;
import com.dreamcashgroup.dcash.user.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerService customerService;

    /**
     * Création d'un client
     * @param customerDto
     * @return
     */
    @PostMapping
    @ApiOperation(value = "Créer un utilisateur")
    public RestResponse createUser(@Valid @RequestBody CustomerDto customerDto){
        return new RestResponse(customerService.create(customerDto), "Client crée avec succès", ResponseStatus.SUCCESS, ResponseCode.CREATED.getValue());
    }
}
