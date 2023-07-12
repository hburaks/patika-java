package service;

import model.BankAccount;
import model.Branch;
import model.DanceCourse;

import java.math.BigDecimal;
import java.util.Scanner;

public class BranchService {
    public static DanceCourse createBranch(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        System.out.print("Branş ismini giriniz: ");
        String branchName = inp.nextLine();
        Branch branch = new Branch(branchName);
        danceCourse.addBranchtToList(branch);
        return danceCourse;
    }
}
