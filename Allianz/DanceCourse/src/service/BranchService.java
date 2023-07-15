package service;

import model.BankAccount;
import model.Branch;
import model.DanceCourse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class BranchService {
    public static DanceCourse createBranch(DanceCourse danceCourse){
        Scanner inp = new Scanner(System.in);
        System.out.print("Branş ismini giriniz: ");
        String branchName = inp.nextLine();
        Branch branch = createBranch(branchName);
        while(!createBranchToBranchPool( danceCourse.getBranchList(), branch)){
            createBranchToBranchPool( danceCourse.getBranchList(), branch);
        };
        DanceCourseService.addBranchToDanceCourse(danceCourse,branch);
        return danceCourse;
    }

    public static Branch createBranch(String name) {
        Branch branch = new Branch();
        branch.setName(name);
        return branch;
    }


    public static boolean createBranchToBranchPool(List<Branch> branchList, Branch branch) {
        boolean isExist = false;
        for (Branch br : branchList) {
            if (br.getName().equalsIgnoreCase(branch.getName())) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            branchList.add(branch);
            return true;
        } else {
            System.err.println("Branş ismi " + branch.getName() + " daha önceden mevcut.");
            return false;
        }
    }
}
