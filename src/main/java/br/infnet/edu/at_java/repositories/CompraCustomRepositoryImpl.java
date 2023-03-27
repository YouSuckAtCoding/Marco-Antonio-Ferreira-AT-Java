package br.infnet.edu.at_java.repositories;

import java.util.List;

import br.infnet.edu.at_java.Classes.Compra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

public class CompraCustomRepositoryImpl implements CompraCustomRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Compra> GetCompraByUsuario(long UsuarioId) {
		try {
			StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("GetCompraByUsuarioId").setParameter("UsuarioIdParam", UsuarioId);
			return (List<Compra>) sp.getResultList();
		}
		catch(Exception ex) {
			return null;	
		}
		
	}

}
