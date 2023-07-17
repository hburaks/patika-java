package service;

import model.BankAccount;
import model.MovementTypeEnum;
import model.PaymentMovement;

import java.math.BigDecimal;

public class PaymentMovementService {
    public static PaymentMovement createPaymentMovement(BankAccount bankAccount,
                                                        String description,
                                                        MovementTypeEnum movementType,
                                                        BigDecimal amount) {
        PaymentMovement paymentMovement = new PaymentMovement();
        paymentMovement.setBankAccount(bankAccount);
        paymentMovement.setDescription(description);
        paymentMovement.setMovementType(movementType);
        paymentMovement.setAmount(amount);
        return paymentMovement;
    }

}
