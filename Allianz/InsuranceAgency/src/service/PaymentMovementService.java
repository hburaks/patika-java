package service;

import model.BankAccount;
import model.InsuranceRequest;
import model.MovementTypeEnum;
import model.PaymentMovement;

import java.math.BigDecimal;

public class PaymentMovementService {
    public PaymentMovement createPaymentMovement(BankAccount bankAccount,
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
    public  String createDescription(InsuranceRequest insuranceRequest){
        return insuranceRequest.getVehicle().getPlate() + " " + insuranceRequest.getInsuranceTypeEnum().toString() + " payment";
    }
}
