package com.ty.atm.repository;

import com.ty.atm.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumberAndPin(Long accountNumber, String pin);
}
