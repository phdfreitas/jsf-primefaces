package com.jsf.primefaces.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jsf.primefaces.erp.enums.TipoEmpresa;
import com.jsf.primefaces.erp.model.Atividade;
import com.jsf.primefaces.erp.model.Empresa;

public class PersistenceLayer {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPrimefacesPU");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando os repositórios
		AtividadeRepository ramoAtividades = new AtividadeRepository(em);
		EmpresaRepository empresas = new EmpresaRepository(em);
		
		//Buscando as informações do banco
		List<Atividade> listaDeRamoAtividades = ramoAtividades.search("");
		List<Empresa> listaDeEmpresas = empresas.search("");
		System.out.println(listaDeEmpresas);
		
		//Criando uma empresa
		Empresa empresa = new Empresa();		
		empresa.setNomeFantasia("João da Silva");
		empresa.setCnpj("41.952.519/0001-57");
		empresa.setRazaoSocial("João da Silva 41952519000157");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setAtividade(listaDeRamoAtividades.get(0));
		
		//Salvando a empresa
		empresas.saveOrUpdate(empresa);
		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Empresa> listaDeEmpresas2 = empresas.search("");
		System.out.println(listaDeEmpresas2);
		
		em.close();
		emf.close();
	}
	
}
