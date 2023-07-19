package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceRequestService {
    public InsuranceRequest createInsuranceRequest(Vehicle vehicle, InsuranceTypeEnum insuranceTypeEnum, Agency agency) {
        InsuranceRequest insuranceRequest = new InsuranceRequest();
        insuranceRequest.setVehicle(vehicle);
        insuranceRequest.setInsuranceTypeEnum(insuranceTypeEnum);
        insuranceRequest.setAgency(agency);
        return insuranceRequest;
    }

    public void addProposalToInsuranceRequest(InsuranceRequest insuranceRequest, Proposal proposal) {
        if (insuranceRequest.getProposalList() != null) {
            insuranceRequest.getProposalList().add(proposal);
        } else {
            ArrayList<Proposal> proposalList = new ArrayList<>();
            proposalList.add(proposal);
            insuranceRequest.setProposalList(proposalList);
        }
    }

    public void setPolicyToInsuranceRequest(InsuranceRequest insuranceRequest, Policy policy) {
        insuranceRequest.setPolicy(policy);
    }
}
