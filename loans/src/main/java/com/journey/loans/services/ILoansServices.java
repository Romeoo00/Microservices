package com.journey.loans.services;


import com.journey.loans.dto.LoanDto;

public interface ILoansServices {

    void createLoan(String mobileNumber);

    LoanDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoanDto loanDto);

    boolean deleteLoans(String mobileNumber);
}
