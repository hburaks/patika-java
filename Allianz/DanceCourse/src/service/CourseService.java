package service;

import model.BankAccount;
import model.DanceCourse;

import java.math.BigDecimal;

public class CourseService {
    public static DanceCourse defaultParameters(DanceCourse danceCourse){
        danceCourse.setFounder("Hasan Burak Songur");
        danceCourse.setName("HBS Akademi");
        danceCourse.setAddress("Bostanlı - Karşıyaka - İzmir - Türkiye");
        danceCourse.setTaxNumber("2222222222");
        danceCourse.setTaxOffice("Mesir");

        BankAccount isBank = new BankAccount("İş Bankası",
                "TR123456789012345678901234",
                "HBS Ltd Şti",
                new BigDecimal(5000000));

        BankAccount ziraat = new BankAccount("Ziraat Bankası",
                "TR111111111111111111111111",
                "HBS Ltd Şti",
                new BigDecimal(2000000));

        BankAccount yapikredi = new BankAccount("Yapı Kredi Bankası",
                "TR999999999999999999999999",
                "HBS Ltd Şti",
                new BigDecimal(1000000));

        danceCourse.addBankAccountToList(isBank);
        danceCourse.addBankAccountToList(ziraat);
        danceCourse.addBankAccountToList(yapikredi);

        return danceCourse;
    }
}
