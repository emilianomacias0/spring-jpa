package com.emilianomacias0.app.models.dao;

import java.util.List;

import com.emilianomacias0.app.models.entity.Cliente;

public interface IClienteDao {

	public List<Cliente> findAll();
}