package com.journey.accounts.service;

import com.journey.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);


    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return account number base on given number
     */
    CustomerDto fetAccount(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return boolean indicating if the update of account details is successful
     */
    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);

    /**
     *
     * @param accountNumber
     * @return
     */
    boolean updateCommunicationStatus(Long accountNumber);

}
