import model.*;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        AgencyService agencyService = new AgencyService();
        BankAccountService bankAccountService = new BankAccountService();
        PaymentMovementService paymentMovementService = new PaymentMovementService();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        InsuranceService insuranceService = new InsuranceService();
        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
        ProposalService proposalService = new ProposalService();


        Agency agency = agencyService.createAgency("MAN");

        BankAccount bankAccountAgency = bankAccountService.createBankAccount("İş Bankası",
                "TR111111111111111111111111",
                BigDecimal.valueOf(100000));
        BankAccount bankAccountInsuranceCompany = bankAccountService.createBankAccount("Yapı Kredi",
                "TR123446541111111111",
                BigDecimal.valueOf(3000000));

        agencyService.addBankAccountToAgency(agency, bankAccountAgency);

        InsuranceCompany insuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz",
                "Mesir", "123123131", "Gaziemir - İzmir", BigDecimal.valueOf(0.08)
        );
        agencyService.addInsuranceCompanyToAgency(agency, insuranceCompany);
        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompany ,bankAccountInsuranceCompany);


        Insurance insurance = insuranceService.createInsurance("Compulsory Traffic Insurance",
                InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE);

        insuranceCompanyService.addInsuranceToInsuranceCompany(insuranceCompany, insurance);
        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompany, bankAccountInsuranceCompany);

        Customer customer = customerService.createCustomer("Hasan Burak", CustomerTypeEnum.CORPORATE);
        BankAccount bankAccountCustomer = bankAccountService.createBankAccount("Ziraat",
                "TR12234453543534",
                BigDecimal.valueOf(10000));
        customerService.addBankAccountToCustomer(customer, bankAccountCustomer);
        agencyService.addCustomerToAgency(agency,customer);

        Vehicle vehicle = vehicleService.createVehicle("Opel",
                "Astra",
                1998,
                "45ALV301",
                "S4FG235Y6767",
                ColorTypeEnum.BLUE);
        customerService.addVehicleToCustomer(customer,vehicle);

        InsuranceRequest insuranceRequest = insuranceRequestService.createInsuranceRequest(vehicle, InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE, agency);
        customerService.addInsuranceRequestToCustomer(customer,insuranceRequest);

        LocalDate startDate = LocalDate.of(2010, Month.APRIL, 15);
        LocalDate endDate = LocalDate.of(2011,Month.APRIL,15);
        LocalDate expireDate = startDate.plusDays(3);

        customerService.addInsuranceRequestToCustomer(customer,insuranceRequest);
        Proposal proposal = proposalService.createProposal(insuranceCompany,vehicle,BigDecimal.valueOf(1500),
                startDate,endDate,expireDate, BigDecimal.valueOf(100));

        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest,proposal);

        customerService.acceptProposal(customer,proposal, insuranceRequest);

        System.out.println(customer);
        System.out.println(bankAccountInsuranceCompany);
        System.out.println( bankAccountAgency);

        // insurance type added to insurance request
        // agency added to insurance request
        // agency > customer > insuranceRequest > agency infinite loop?
    }
}