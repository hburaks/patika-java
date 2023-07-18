package model;

import java.util.ArrayList;

public class InsuranceRequest {
    private ArrayList<Proposal> proposalList;
    private Vehicle vehicle;
    private Policy policy;
    private InsuranceTypeEnum insuranceTypeEnum;
    private Agency agency;

    public InsuranceRequest() {
    }

    public InsuranceRequest(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ArrayList<Proposal> getProposalList() {
        return proposalList;
    }

    public void setProposalList(ArrayList<Proposal> proposalList) {
        this.proposalList = proposalList;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public InsuranceTypeEnum getInsuranceTypeEnum() {
        return insuranceTypeEnum;
    }

    public void setInsuranceTypeEnum(InsuranceTypeEnum insuranceTypeEnum) {
        this.insuranceTypeEnum = insuranceTypeEnum;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return "InsuranceRequest{" +
                "proposalList=" + proposalList +
                ", vehicle=" + vehicle +
                ", policy=" + policy +
                ", insuranceTypeEnum=" + insuranceTypeEnum +
                '}' + "\n";
    }
}
