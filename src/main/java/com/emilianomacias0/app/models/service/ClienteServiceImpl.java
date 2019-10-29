package com.emilianomacias0.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emilianomacias0.app.models.dao.IClienteDao;
import com.emilianomacias0.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clientedao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clientedao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clientedao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clientedao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientedao.deleteById(id);
		
	}

}
