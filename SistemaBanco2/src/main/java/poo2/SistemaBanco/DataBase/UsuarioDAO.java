package poo2.SistemaBanco.DataBase;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import poo2.SistemaBanco.Classes.Convenios;
import poo2.SistemaBanco.Classes.Usuario;

public class UsuarioDAO implements InterfaceDAO<Usuario> {

	@Override
	public void persist(Usuario t) {
		EntityManager em = ConnectionDB.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			Usuario original = get(t.getCpf());
			em.getTransaction().begin();
			original.setSenha(t.getSenha());
			original.setNome(t.getNome());
			original.setSobrenome(t.getSobrenome());
			original.setDataNasc(t.getDataNasc());
			original.setEndereco(t.getEndereco());
			original.setCidade(t.getCidade());
			original.setEmail(t.getEmail());
			original.setCartao(t.getCartao());
			for (Convenios g : t.getConvenio())
				original.getConvenio().add(g);
			em.getTransaction().commit();
		}		
	}

	@Override
	public void remove(Usuario t) {
		EntityManager em = ConnectionDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public List<Usuario> getAll() {
		return ConnectionDB.getEntityManager().createQuery("SELECT g FROM Usuario g", Usuario.class).getResultList();
	}
	
	@Override
	public Usuario get(Object pk) {
		return ConnectionDB.getEntityManager().find(Usuario.class, pk);
	}

}
