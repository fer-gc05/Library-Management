package com.library.management.controllers;

import com.library.management.models.Loans;
import com.library.management.services.LoansServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
public class LoansRestController {
    private final LoansServices loansServices;

    @Autowired

    public LoansRestController(LoansServices loansServices) {
        this.loansServices = loansServices;
    }

    @GetMapping(value = "/all", headers = "Accept=application/json")
    public List<Loans> getLoans() {
        return loansServices.getLoans();
    }

    @GetMapping(value = "/byMemberId/{memberId}", headers = "Accept=application/json")
    public List<Loans> getLoansByMemberId(@PathVariable Long memberId) {
        return loansServices.getLoansByMemberId(memberId);
    }

    @GetMapping(value = "/byBookId/{bookId}", headers = "Accept=application/json")
    public List<Loans> getLoansByBookId(@PathVariable Long bookId) {
        return loansServices.getLoansByBookId(bookId);
    }

    @GetMapping(value = "/byReturnDate/{returnDate}", headers = "Accept=application/json")
    public List<Loans> getLoansByReturnDate(@PathVariable String returnDate) {
        return loansServices.getLoansByReturnDate(returnDate);
    }

    @GetMapping(value = "/byLoanDate/{loanDate}", headers = "Accept=application/json")
    public List<Loans> getLoansByLoanDate(@PathVariable String loanDate) {
        return loansServices.getLoansByLoanDate(loanDate);
    }

    @GetMapping(value = "/byReturnDateAndLoanDate/{returnDate}/{loanDate}", headers = "Accept=application/json")
    public List<Loans> getLoansByReturnDateAndLoanDate(@PathVariable String returnDate, @PathVariable String loanDate) {
        return loansServices.getLoansByReturnDateAndLoanDate(returnDate, loanDate);
    }

    @PostMapping(value = "/add", headers = "Accept=application/json")
    public Loans addLoans(@RequestBody Loans loans) {
        return loansServices.addLoans(loans);
    }

    @PutMapping(value = "/update", headers = "Accept=application/json")
    public Loans updateLoans(@RequestBody Loans loans) {
        return loansServices.updateLoans(loans);
    }

    @DeleteMapping(value = "/delete/{id}", headers = "Accept=application/json")
    public void deleteLoans(@PathVariable Long id) {
        loansServices.deleteLoans(id);
    }
}
