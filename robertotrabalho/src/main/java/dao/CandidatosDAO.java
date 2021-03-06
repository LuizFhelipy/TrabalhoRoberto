package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modal.Candidatos;
import utils.HibernateUtil;

public class CandidatosDAO {

	public void getAllCandidatos() {
		EntityManager em = HibernateUtil.getEntityManager();
		String ql = "select c from candidatos c";
		TypedQuery<Candidatos> query = em.createQuery(ql, Candidatos.class);
		List<Candidatos> candidatos = query.getResultList();
		System.out.println("candidatos: " + candidatos);

	}

	public void getCandidatoById(Integer id) {
		EntityManager em = HibernateUtil.getEntityManager();
		String ql = "select c from candidatos c where c.id_candidatos = :id";
		TypedQuery<Candidatos> query = em.createQuery(ql, Candidatos.class);
		query.setParameter("id", id);
		Candidatos candidato = query.getSingleResult();
		System.out.println("Candidato por id: " + candidato);
	}

	public void deleteCandidato(Integer id) {
		EntityManager em = HibernateUtil.getEntityManager();
		Candidatos candidato = em.find(Candidatos.class, id);
		if (candidato != null) {
			em.getTransaction().begin();
			em.remove(candidato);
			em.getTransaction().commit();
		} else {
			System.out.println("Candidato " + id + " não encontrado.");
		}
	}

	public void insertNewCandidato(Candidatos candidato) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(candidato);
		em.getTransaction().commit();
		System.out.println("Valor gerado pelo insert na tabela Candidato: " + candidato.getId_candidato());

	}

	public void updateCandidato(Candidatos candidato) {
		EntityManager em = HibernateUtil.getEntityManager();

		Candidatos objCargo = em.find(Candidatos.class, candidato.getId_candidato());
		if (objCargo != null) {
			em.getTransaction().begin();
			em.merge(candidato);
			em.getTransaction().commit();
		} else {
			System.out.println("Candidato " + candidato.getId_candidato() + " não encontrado.");
		}
	}

}
