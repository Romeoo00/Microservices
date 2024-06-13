package com.journey.loans.mapper;

import com.journey.loans.dto.LoanDto;
import com.journey.loans.entity.Loans;

public class LoansMapper {

    public static LoanDto mapToLoanDto(Loans loans, LoanDto loanDto){
        loanDto.setLoanNumber(loans.getLoanNumber());
        loanDto.setLoanType(loans.getLoanType());
        loanDto.setMobileNumber(loans.getMobileNumber());
        loanDto.setTotalLoan(loans.getTotalLoan());
        loanDto.setAmountPaid(loans.getAmountPaid());
        loanDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loanDto;
    }

    public static Loans mapToLoans(LoanDto loanDto, Loans loans){
        loans.setLoanNumber(loanDto.getLoanNumber());
        loans.setLoanType(loanDto.getLoanType());
        loans.setMobileNumber(loanDto.getMobileNumber());
        loans.setTotalLoan(loanDto.getTotalLoan());
        loans.setAmountPaid(loanDto.getAmountPaid());
        loans.setOutstandingAmount(loanDto.getOutstandingAmount());
        return loans;

    }
}
