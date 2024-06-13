package com.journey.cards.service;

import com.journey.cards.dto.CardsDto;

public interface ICardsService {

    void createCards(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);

    boolean updateCard(CardsDto cardsDto);

    boolean deleteCards(String mobileNumber);


}
