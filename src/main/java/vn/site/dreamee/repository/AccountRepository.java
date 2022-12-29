package vn.site.dreamee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.site.dreamee.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
