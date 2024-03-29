package com.jsf.primefaces.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jsf.primefaces.erp.model.Atividade;

public class AtividadeRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	public AtividadeRepository() {
	}

	public AtividadeRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Atividade> search(String descricao){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Atividade> criteriaQuery = criteriaBuilder.createQuery(Atividade.class);
		
		Root<Atividade> root = criteriaQuery.from(Atividade.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
		
		TypedQuery<Atividade> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
	
	
	
	

}
