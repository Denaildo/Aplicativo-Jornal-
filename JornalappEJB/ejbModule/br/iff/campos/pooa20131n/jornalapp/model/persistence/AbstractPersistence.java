package br.iff.campos.pooa20131n.jornalapp.model.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

@Stateless
@LocalBean
public class AbstractPersistence {

 @PersistenceContext(unitName="JornalappEJB")
 EntityManager entityManager;
	
// @TransactionAttribute(TransactionAttributeType.REQUIRED)

	public Object insert(Object object) {

		entityManager.persist(object);
	
		return object;
	}

	public Object update(Object object) {


		entityManager.merge(object);

		return object;
	}

	public void delete(Class<?> classe, String codigo) {
		Object object = find(classe, codigo);
		entityManager.remove(object);
	
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> classe) {
		return entityManager.createQuery(
				"select e from " + classe.getName() + " e").getResultList();
	}

	public <T> T find(Class<T> classe, String codigo) {
		return entityManager.find(classe, codigo);
	}
}