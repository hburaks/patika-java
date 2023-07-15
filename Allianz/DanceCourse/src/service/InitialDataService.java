package service;

import model.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

public class InitialDataService {
    public static DanceCourse loadInitialData(DanceCourse danceCourse){

        BankAccount isBank = BankAccountService.createBankAccount("İş Bank",
                "HBS Ltd Şti",
                "TR123456789012345678901234",
                new BigDecimal(100000));
        BankAccount ziraat =BankAccountService.createBankAccount("Ziraat Bank",
                "HBS Ltd Şti",
                "TR111111111111111111111111",
                new BigDecimal(200000));
        BankAccount yapikredi = BankAccountService.createBankAccount("Yapı Kredi Bank",
                "HBS Ltd Şti",
                "TR999999999999999999999999",
                new BigDecimal(300000));
        DanceCourseService.createBankAccountToDanceCourse(danceCourse,isBank);
        DanceCourseService.createBankAccountToDanceCourse(danceCourse,ziraat);
        DanceCourseService.createBankAccountToDanceCourse(danceCourse,yapikredi);

        Branch salsa = BranchService.createBranch("Salsa");
        Branch zumba = BranchService.createBranch("Zumba");
        Branch ballet = BranchService.createBranch("Bale");

        DanceCourseService.addBranchToDanceCourse(danceCourse,salsa);
        DanceCourseService.addBranchToDanceCourse(danceCourse,zumba);
        DanceCourseService.addBranchToDanceCourse(danceCourse,ballet);

        Instructor instructor = InstructorService.createInstructor("Tan Sağtürk",
                53,
                Sex.MALE,
                BigDecimal.valueOf(65000));
        DanceCourseService.addInstructorToDanceCourse(danceCourse,instructor);
        InstructorService.addBranchToInstructor(instructor,salsa);


        Student student1 = StudentService.createStudent("Ahmet", 23,Sex.MALE, BigDecimal.valueOf(20000));
        Date startDate = null;
        try {
            startDate = StudentService.dateCreator("2022/05/04");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date endDate = null;
        try {
            endDate = StudentService.dateCreator("2023/05/04");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        student1.setStartDate(startDate);
        student1.setEndDate(endDate);
        DanceCourseService.addStudentToDanceCourse(danceCourse,student1);

        return danceCourse;
    }
}
