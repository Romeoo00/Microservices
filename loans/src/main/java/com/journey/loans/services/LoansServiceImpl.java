package com.journey.loans.services;

import com.journey.loans.constants.LoansConstants;
import com.journey.loans.dto.LoanDto;
import com.journey.loans.entity.Loans;
import com.journey.loans.exception.LoanAlreadyExistsException;
import com.journey.loans.exception.ResourcesNotFoundException;
import com.journey.loans.mapper.LoansMapper;
import com.journey.loans.repository.LoansRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansServices{

    @Autowired
    private LoansRepository loansRepository;
    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if (optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already exist with given mobileNumber" + mobileNumber);
        }
        loansRepository.save(createNewloan(mobileNumber));

    }

    @Override
    public LoanDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourcesNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoansMapper.mapToLoanDto(loans, new LoanDto());
    }

    @Override
    public boolean updateLoan(LoanDto loanDto) {
        Loans loans = loansRepository.findByLoanNumber(loanDto.getLoanNumber()).orElseThrow(
                () ->  new ResourcesNotFoundException("Loan", "loanNumber", loanDto.getLoanNumber())
        );
        LoansMapper.mapToLoans(loanDto, loans);
        loansRepository.save(loans);
        return true;
    }

    @Override
    public boolean deleteLoans(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourcesNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }

    private Loans createNewloan(String mobileNumber) {
        Loans newLoans = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(90000000);

        newLoans.setLoanNumber(Long.toString(randomLoanNumber));
        newLoans.setMobileNumber(mobileNumber);
        newLoans.setLoanType(LoansConstants.HOME_LOAN);
        newLoans.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoans.setAmountPaid(0);
        newLoans.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoans;

    }
}
