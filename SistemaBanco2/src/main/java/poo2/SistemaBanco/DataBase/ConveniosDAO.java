package poo2.SistemaBanco.DataBase;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import poo2.SistemaBanco.Classes.Convenios;

public class ConveniosDAO implements InterfaceDAO<Convenios> {
	
	@Override
	public void persist(Convenios t) {
		EntityManager em = ConnectionDB.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			@SuppressWarnings("unused")
			Convenios original = get(t.getConvenio());
			em.getTransaction().commit();
		}
	}

	@Override
	public List<Convenios> getAll() {
		return ConnectionDB.getEntityManager().createQuery("SELECT g FROM Convenios g", Convenios.class).getResultList();
	}

	@Override
	public void remove(Convenios t) {
		EntityManager em = ConnectionDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public Convenios get(Object pk) {
		return ConnectionDB.getEntityManager().find(Convenios.class, pk);
	}

}
