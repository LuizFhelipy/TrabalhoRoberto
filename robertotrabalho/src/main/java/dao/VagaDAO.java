package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modal.Vaga;
import utils.HibernateUtil;

public class VagaDAO {

	public void getAllVaga() {
		EntityManager em = HibernateUtil.getEntityManager();

		String ql = "select v from vaga v";

		TypedQuery<Vaga> query = em.createQuery(ql, Vaga.class);

		List<Vaga> vaga = query.getResultList();

		System.out.println("Vagas: " + vaga);

	}

	public void getVagaById(Integer id) {
		EntityManager em = HibernateUtil.getEntityManager();
		String ql = "select v from vaga v where v.id_rep = :id";

		TypedQuery<Vaga> query = em.createQuery(ql, Vaga.class);
		query.setParameter("id", id);

		Vaga vaga = query.getSingleResult();

		System.out.println("Vaga por id: " + vaga);
	}

	public void deleteVaga(Integer id) {
		EntityManager em = HibernateUtil.getEntityManager();
		Vaga vaga = em.find(Vaga.class, id);
		if (vaga != null) {
			em.getTransaction().begin();
			em.remove(vaga);
			em.getTransaction().commit();
		} else {
			System.out.println("Vaga " + id + " não encontrado.");
		}
	}

	public void insertNewVaga(Vaga vaga) {
		EntityManager em = HibernateUtil.getEntityManager();

		em.getTransaction().begin();
		em.persist(vaga);
		em.getTransaction().commit();

		System.out.println("Valor gerado pelo insert na tabela vaga: " + vaga.getId_vaga());

	}

	public void updateVaga(Vaga vaga) {
		EntityManager em = HibernateUtil.getEntityManager();

		Vaga objCargo = em.find(Vaga.class, vaga.getId_vaga());
		if (objCargo != null) {
			em.getTransaction().begin();
			em.merge(vaga);
			em.getTransaction().commit();
		} else {
			System.out.println("vaga " + vaga.getId_vaga() + " não encontrado.");
		}
	}

}
