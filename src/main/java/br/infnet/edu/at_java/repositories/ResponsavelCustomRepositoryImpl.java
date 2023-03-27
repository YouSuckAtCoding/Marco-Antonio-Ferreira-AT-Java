package br.infnet.edu.at_java.repositories;

import java.util.List;

import br.infnet.edu.at_java.Classes.Responsavel;
import br.infnet.edu.at_java.Classes.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

public class ResponsavelCustomRepositoryImpl implements ResponsavelCustomRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Responsavel> GetByUsuario(long UsuarioId) {
		try {
			StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("GetResponsavelByUsuarioId").setParameter("UsuarioIdParam", UsuarioId);
			return (List<Responsavel>) sp.getResultList();
		}
		catch(Exception ex) {
			return null;	
		}
		
	}

}
