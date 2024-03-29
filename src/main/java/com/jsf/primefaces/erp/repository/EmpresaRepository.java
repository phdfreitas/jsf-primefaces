package com.jsf.primefaces.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.jsf.primefaces.erp.model.Empresa;

public class EmpresaRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	public EmpresaRepository() {
		
	}

	public EmpresaRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public Empresa findById(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public List<Empresa> search(String name){
		TypedQuery<Empresa> query = manager
				.createQuery("from Empresa where nomeFantasia like :nomeFantasia", Empresa.class);
		query.setParameter("nomeFantasia", name + "%");
		return query.getResultList();
	}
	
	public Empresa saveOrUpdate(Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public void remove(Empresa empresa) {
		empresa = findById(empresa.getId());
		manager.remove(empresa);
	}
}
