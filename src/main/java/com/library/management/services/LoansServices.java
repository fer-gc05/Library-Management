package com.library.management.services;

import com.library.management.models.Loans;
import com.library.management.repositories.ILoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoansServices {
    private final ILoansRepository loansRepository;

    @Autowired
    public LoansServices(ILoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    public Loans addLoans(Loans loans) {
        return loansRepository.save(loans);
    }

    public Loans updateLoans(Loans loans) {
        return loansRepository.save(loans);
    }


    public void deleteLoans(Long id) {
        loansRepository.deleteById(id);
    }

    public List<Loans> getLoans() {
        return loansRepository.findAll();
    }

    public List<Loans> getLoansByMemberId(Long memberId) {
        return loansRepository.findByMemberId(memberId);
    }

    public List<Loans> getLoansByBookId(Long bookId) {
        return loansRepository.findByBookId(bookId);
    }

    public List<Loans> getLoansByReturnDate(String returnDate) {
        return loansRepository.findByReturnDate(returnDate);
    }

    public List<Loans> getLoansByLoanDate(String loanDate) {
        return loansRepository.findByLoanDate(loanDate);
    }

    public List<Loans> getLoansByReturnDateAndLoanDate(String returnDate, String loanDate) {
        return loansRepository.findByReturnDateAndLoanDate(returnDate, loanDate);
    }


}
