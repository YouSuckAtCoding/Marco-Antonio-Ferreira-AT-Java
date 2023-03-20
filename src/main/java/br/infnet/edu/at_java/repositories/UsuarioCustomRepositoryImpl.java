package br.infnet.edu.at_java.repositories;



import br.infnet.edu.at_java.Classes.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

public class UsuarioCustomRepositoryImpl implements UsuarioCustomRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Usuario Login(String Email, String Password) {
		try {
		
			StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("Login").setParameter("EmailParam", Email).setParameter("PasswordParam", Password);
			return (Usuario) sp.getResultList().get(0);
		}
		catch(Exception ex){
			return new Usuario();
		}
		
		
		
		
	}
	

}
