package service;

import model.Currency;
import model.CurrencyTypeEnum;

import java.math.BigDecimal;
import java.util.Scanner;

public class CurrencyService {
    public static BigDecimal convertCurrencyToUSD(BigDecimal moneyAmount, CurrencyTypeEnum currencyType) {
        boolean running = true;
        BigDecimal conversionMultiplier = BigDecimal.valueOf(1);
                switch (currencyType){
                    case TL :
                        conversionMultiplier =  Currency.getTLtoUSD();
                        break;
                    case EURO :
                        conversionMultiplier = Currency.getEUROtoUSD();
                        break;
                }
            return moneyAmount.multiply(conversionMultiplier);
    }
}
