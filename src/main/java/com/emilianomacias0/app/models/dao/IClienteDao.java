package com.emilianomacias0.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.emilianomacias0.app.models.entity.Cliente;


public interface IClienteDao extends CrudRepository<Cliente, Long>{


}
