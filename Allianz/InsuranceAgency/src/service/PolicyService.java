package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class PolicyService {
    public Policy createPolicy(InsuranceCompany insuranceCompany,
                                         Vehicle vehicle,
                                         BigDecimal price,
                                         Date startDate,
                                         Date endDate){
        Policy policy = new Policy();
        policy.setInsuranceCompany(insuranceCompany);
        policy.setVehicle(vehicle);
        policy.setPrice(price);
        policy.setStartDate(startDate);
        policy.setEndDate(endDate);
        return policy;
    }
}
