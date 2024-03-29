package com.jsf.primefaces.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jsf.primefaces.erp.model.Empresa;
import com.jsf.primefaces.erp.repository.EmpresaRepository;
import com.jsf.primefaces.erp.util.Transacional;

public class EmpresaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EmpresaRepository empresaRepository;
	
	@Transacional
	public void save(Empresa empresa) {
		empresaRepository.saveOrUpdate(empresa);
	}
	
	@Transacional
	public void remove(Empresa empresa) {
		empresaRepository.remove(empresa);
	}
}
