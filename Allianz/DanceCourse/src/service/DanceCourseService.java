package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanceCourseService {

    public static DanceCourse createDanceCourse(String name, String address, String founder, String taxNumber, String taxOffice) {
        DanceCourse danceCourse = new DanceCourse();
        danceCourse.setName(name);
        danceCourse.setAddress(address);
        danceCourse.setFounder(founder);
        danceCourse.setTaxNumber(taxNumber);
        danceCourse.setTaxOffice(taxOffice);
        return danceCourse;
    }

    public static void createBankAccountToDanceCourse(DanceCourse danceCourse, BankAccount bankAccount) {
        if (danceCourse.getBankAccountList() != null) {
            if (isExistBankAccount(danceCourse, bankAccount)) {
                addAmountToExistBankAccount(danceCourse, bankAccount);
            } else {
                danceCourse.getBankAccountList().add(bankAccount);
            }
        } else {
            danceCourse.setBankAccountList(new ArrayList<>());
            danceCourse.getBankAccountList().add(bankAccount);
        }
        if(danceCourse.getTotalAmount() == null ){
            danceCourse.setTotalAmount(BigDecimal.valueOf(0));
        }
        danceCourse.setTotalAmount(danceCourse.getTotalAmount().add(bankAccount.getAmount()));
    }
    public static List<BankAccount> getBankAccountList(DanceCourse danceCourse){
        if (danceCourse.getBankAccountList() != null) {
            return danceCourse.getBankAccountList();
        } else {
            danceCourse.setBankAccountList(new ArrayList<>());
            return danceCourse.getBankAccountList();
        }
    }


    public static boolean isExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {

        boolean isExist = false;

        for (BankAccount bankAccount1 : danceCourse.getBankAccountList()) {
            if (bankAccount1.getIbanNo().equals(bankAccount.getIbanNo())) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public static void addAmountToExistBankAccount(DanceCourse danceCourse, BankAccount bankAccount) {
        for (BankAccount bankAccount1 : danceCourse.getBankAccountList()) {
            if (bankAccount1.getIbanNo().equals(bankAccount.getIbanNo())) {
                bankAccount1.setAmount(bankAccount1.getAmount().add(bankAccount.getAmount()));
                break;
            }
        }
    }


    public static void addInstructorToDanceCourse(DanceCourse danceCourse, Instructor instructor) {

        BankAccountService bankAccountService = new BankAccountService();
        PaymentMovementService paymentMovementService = new PaymentMovementService();

        if (danceCourse.getBankAccountList() != null) {
            BankAccount bankAccount = bankAccountService.
                    getBankAccountWithEnoughMoney(danceCourse, instructor.getSalary());

            if (bankAccount != null) {
                PaymentMovement paymentMovement = paymentMovementService.
                        createPaymentMovement(bankAccount,
                                instructor.getName() + " salary payment",
                                MovementType.OUTCOME, instructor.getSalary());

                addPaymentMovementToDanceCourse(danceCourse, paymentMovement);

                if (danceCourse.getInstructorList() != null) {
                    danceCourse.getInstructorList().add(instructor);
                } else {
                    danceCourse.setInstructorList(List.of(instructor));
                }
            } else {
                System.err.println("Trainer cannot be recruited because there is no bank account with sufficient balance.");
            }
        } else {
            System.err.println("Trainers cannot be recruited because there is no bank account yet.");
        }
    }

    public static void addPaymentMovementToDanceCourse(DanceCourse danceCourse, PaymentMovement paymentMovement) {
        BigDecimal totalAmount = BankAccountService.getTotalBankAccountAmount(danceCourse);
        String paymentBankName = paymentMovement.getBankAccount().getBankName();
        BankAccount bankAccount = null;
        for(BankAccount bankAccount1 : getBankAccountList(danceCourse)){
            if(bankAccount1.getBankName() == paymentBankName){
                bankAccount = bankAccount1;
            }
        }

        if(paymentMovement.getMovementType() == MovementType.INCOME){
            totalAmount = totalAmount.add(paymentMovement.getAmount());
            bankAccount.setAmount(bankAccount.getAmount().add(paymentMovement.getAmount()));
        }else if (paymentMovement.getMovementType() == MovementType.OUTCOME){
            totalAmount = totalAmount.subtract(paymentMovement.getAmount());
            bankAccount.setAmount(bankAccount.getAmount().subtract(paymentMovement.getAmount()));
        };
        danceCourse.setTotalAmount(totalAmount);

        if (danceCourse.getPaymentMovementList() != null) {
            danceCourse.getPaymentMovementList().add(paymentMovement);
        } else {
            List<PaymentMovement> paymentMovementList = new ArrayList<>();
            paymentMovementList.add(paymentMovement);
            danceCourse.setPaymentMovementList(paymentMovementList);
        }
    }

    public static void addLectureToDanceCourse(DanceCourse danceCourse, Lecture lecture) {

        if (danceCourse.getLectureList() != null) {
            danceCourse.getLectureList().add(lecture);
        } else {
            danceCourse.setLectureList(new ArrayList<>());
            danceCourse.getLectureList().add(lecture);
        }
    }

    public static void addBranchToDanceCourse(DanceCourse danceCourse, Branch branch) {

        if (danceCourse.getBranchList() != null) {
            danceCourse.getBranchList().add(branch);
        } else {
            danceCourse.setBranchList(new ArrayList<>());
            danceCourse.getBranchList().add(branch);
        }
    }

    public static void addStudentToDanceCourse(DanceCourse danceCourse, Student student) {

        if (danceCourse.getStudentList() != null) {
            danceCourse.getStudentList().add(student);
        } else {
            danceCourse.setStudentList(new ArrayList<>());
            danceCourse.getStudentList().add(student);
        }
    }
    public static Branch getBranchFromDanceCourse(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        boolean running2 = true;
        Branch branch = null;
        while(running2){
            System.out.println("Options:");
            for(int i = 0; i < danceCourse.getBranchList().size(); i++){
                System.out.println(i + 1 + " - " + danceCourse.getBranchList().get(i));
            }
            System.out.print("Please specify the branch: ");
            int choice = inp.nextInt() -1;
            if (choice < danceCourse.getBranchList().size() && choice >= 0) {
                branch = danceCourse.getBranchList().get(choice);
                running2 = false;
            } else {
                System.out.println("----------------- Please select from the options -----------------");
            }
        }
        return branch;
    }

}
