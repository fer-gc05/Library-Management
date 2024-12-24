package com.library.management.repositories;

import com.library.management.models.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILoansRepository extends JpaRepository<Loans, Long> {

    public List<Loans> findByMemberId(Long memberId);

    public List<Loans> findByBookId(Long bookId);

    public List<Loans> findByReturnDate(String returnDate);

    public List<Loans> findByLoanDate(String loanDate);

    public List<Loans> findByReturnDateAndLoanDate(String returnDate, String loanDate);


}
