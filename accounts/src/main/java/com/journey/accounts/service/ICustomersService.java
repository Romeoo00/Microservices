package com.journey.accounts.service;

import com.journey.accounts.dto.CustomerDetailsDto;

public interface ICustomersService {

    /**
     * @param mobileNumber  - Input mobile number
     * @param correlationId
     * @return Customer details based on a given mobilenumber
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
