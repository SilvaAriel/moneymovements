package br.com.moneymovements.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.moneymovements.domain.Account;

@Repository
public class GetAccountImpl implements GetAccount {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Account findAccount(int account) {
		Query query = entityManager.createNativeQuery(String.format("select * from account where account_id = %s", account), Account.class);
		return (Account) query.getSingleResult();
	}


}
