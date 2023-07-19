package service;

import model.*;

import java.util.ArrayList;

public class InsuranceService {
    public Insurance createInsurance(String name, InsuranceTypeEnum insuranceTypeEnum) {
        Insurance insurance = new Insurance();
        insurance.setName(name);
        insurance.setInsuranceTypeEnum(insuranceTypeEnum);
        return insurance;
    }
}
