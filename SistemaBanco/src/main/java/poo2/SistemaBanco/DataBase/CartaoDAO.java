package poo2.SistemaBanco.DataBase;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import poo2.SistemaBanco.Classes.Cartao;

public class CartaoDAO implements InterfaceDAO<Cartao> {
	
	@Override
	public void persist(Cartao t) {
		EntityManager em = ConnectionDB.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} catch (EntityExistsException e) {
			em.getTransaction().rollback();
			Cartao original = get(t.getNumCartao());
			em.getTransaction().begin();
			original.setDatavenc(t.getDatavenc());
			original.setCvv(t.getCvv());
			original.setSaldo(t.getSaldo());
			original.setLimite(t.getLimite());
			em.getTransaction().commit();
		}
	}

	@Override
	public List<Cartao> getAll() {
		return ConnectionDB.getEntityManager().createQuery("SELECT g FROM Cartao g", Cartao.class).getResultList();
	}

	@Override
	public void remove(Cartao t) {
		EntityManager em = ConnectionDB.getEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public Cartao get(Object pk) {
		return ConnectionDB.getEntityManager().find(Cartao.class, pk);
	}

}
