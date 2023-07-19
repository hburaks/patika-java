package service;

import model.InsuranceCompany;
import model.Proposal;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ProposalService {
    public Proposal createProposal(InsuranceCompany insuranceCompany,
                                   Vehicle vehicle,
                                   BigDecimal offerPrice,
                                   LocalDate startDate,
                                   LocalDate endDate,
                                   LocalDate expireDate,
                                   BigDecimal discountPrice) {
        Proposal proposal = new Proposal();
        proposal.setCompany(insuranceCompany);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(calculateOfferPriceAccordingToAccident(offerPrice, vehicle));
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
        proposal.setDiscountPrice(discountPrice);
        return proposal;
    }

    public BigDecimal calculateDiscountedPrice(Proposal proposal) {
        if (proposal.getDiscountPrice() != null) {
            return proposal.getOfferPrice().subtract(proposal.getDiscountPrice());
        } else {
            return proposal.getOfferPrice();
        }
    }

    public BigDecimal calculateOfferPriceAccordingToAccident(BigDecimal offerPrice, Vehicle vehicle) {
        VehicleService vehicleService = new VehicleService();
        BigDecimal totalOfferPrice = offerPrice;

        BigDecimal totalDamagePrice = vehicleService.getTotalDamageOfTheVehicle(vehicle);
        if (totalDamagePrice.compareTo(BigDecimal.ZERO) == 0) {
            return totalOfferPrice;
        } else if (totalDamagePrice.compareTo(BigDecimal.ZERO) > 0 && totalDamagePrice.compareTo(new BigDecimal(4000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(10)).divide(new BigDecimal(100)));
        } else if (totalDamagePrice.compareTo(new BigDecimal(4000)) > 0 && totalDamagePrice.compareTo(new BigDecimal(8000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(25)).divide(new BigDecimal(100)));
        } else if (totalDamagePrice.compareTo(new BigDecimal(8000)) > 0 && totalDamagePrice.compareTo(new BigDecimal(16000)) <= 0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(40)).divide(new BigDecimal(100)));
        } else {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(80)).divide(new BigDecimal(100)));
        }
        return totalOfferPrice;
    }
}
