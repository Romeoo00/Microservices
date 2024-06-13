package com.journey.accounts.service.impl;

import com.journey.accounts.dto.*;
import com.journey.accounts.entity.Accounts;
import com.journey.accounts.entity.Customer;
import com.journey.accounts.exception.ResourcesNotFoundException;
import com.journey.accounts.mapper.AccountsMapper;
import com.journey.accounts.mapper.CustomerMapper;
import com.journey.accounts.repository.AccountsRepository;
import com.journey.accounts.repository.CustomerRepository;
import com.journey.accounts.service.ICustomersService;
import com.journey.accounts.service.client.CardsFeignClient;
import com.journey.accounts.service.client.LoansFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomersServiceImpl implements ICustomersService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardsFeignClient cardsFeignClient;

    @Autowired
    LoansFeignClient loansFeignClient;
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourcesNotFoundException("Customer", "MobileNumber", mobileNumber)
        );

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourcesNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        if (null != loansDtoResponseEntity){
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        }
        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        if (null != cardsDtoResponseEntity){
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        }
        return customerDetailsDto;
    }
}
