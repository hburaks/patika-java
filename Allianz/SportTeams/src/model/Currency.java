package model;

import java.math.BigDecimal;

public class Currency {
    private static BigDecimal TLtoUSD = BigDecimal.valueOf(26.08);
    private static BigDecimal EUROtoUSD = BigDecimal.valueOf(1.10);

    public static BigDecimal getTLtoUSD() {
        return TLtoUSD;
    }

    public static BigDecimal getEUROtoUSD() {
        return EUROtoUSD;
    }

}
