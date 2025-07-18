package com.example.finance.infratructure.persistance.repository;

import com.example.finance.infratructure.persistance.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllBySourceCard_Id(Long sourceCardId);

    @Query("select t from  Transaction  t where t.sourceCard.user.id = ?1")
    List<Transaction> findAllByUserId(Long cardId);

    List<Transaction> findAllByCreatedDateBetweenAndSourceCard_User_Id(Date createdDateAfter, Date createdDateBefore, Long sourceCardUserId);
}
