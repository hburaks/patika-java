import java.util.Random;
import java.util.Scanner;

public class ToolStore extends NormalLoc{
        public ToolStore(Player player) {
            super( player, "Store");
        }

        @Override
        public boolean onLocation() {
            System.out.println("**** Welcome to the store ****");
            boolean showMenu = true;
            while (showMenu) {
                System.out.println("1 - Weaponry");
                System.out.println("2 - Armors");
                System.out.println("3 - Go back");
                System.out.print("Which category would you like to choose? :");
                int selectCase = Location.scanner.nextInt();
                while (selectCase < 1 || selectCase > 3) {
                    System.out.print("You entered an invalid value. Re-enter value ");
                    selectCase = scanner.nextInt();
                }
                switch (selectCase) {
                    case 1:
                        printWeapon();
                        buyWeapon();
                        showMenu = false;
                        break;
                    case 2:
                        printArmor();
                        buyArmor();
                        showMenu = false;
                        break;
                    case 3:
                        System.out.println("We look forward to seeing you again");
                        showMenu = false;
                        break;
                    default:
                        System.out.println("Weapons selected");
                        printWeapon();
                        showMenu = false;
                        break;
                }
            }
            return true;

        }

        private void printWeapon() {
            System.out.println("**** Weapons ****");
            for (Weapon weapon : Weapon.weapons()) {
                System.out.println(weapon.getId() + " - " + weapon.getName() + " : "
                        + " Price: " + weapon.getPrice()
                        + " Damage: " + weapon.getDamage());
            }
            System.out.println("0 - Go back");
        }

        private void buyWeapon() {
            System.out.print("Choose a weapon: ");
            int selectWeapon = scanner.nextInt();
            while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
                System.out.print("Invalid value. Re-enter: ");
                selectWeapon = scanner.nextInt();
            }

            if (selectWeapon != 0) {
                Weapon selectedWeaponId = Weapon.getWeaponById(selectWeapon);

                if (selectedWeaponId != null) {
                    if (selectedWeaponId.getPrice() > this.getPlayer().getCharacter().getMoney()) {
                        System.out.println("You don't have enough money!");
                    } else {
                        System.out.println("You bought " + selectedWeaponId.getName());
                        int balance = this.getPlayer().getCharacter().getMoney() - selectedWeaponId.getPrice();
                        System.out.println("Your remaining money: " + balance);
                        System.out.println("Your previous weapon: "
                                + this.getPlayer().getCharacter().getInventory().getWeapon().getName());
                        this.getPlayer().getCharacter().getInventory().setWeapon(selectedWeaponId);
                        System.out.println("Your new weapon: "
                                + this.getPlayer().getCharacter().getInventory().getWeapon().getName());
                        this.getPlayer().getCharacter().setMoney(balance);
                    }
                }
            }
        }

        private void printArmor() {
            System.out.println("**** Armors ****");
            for (Armor armor : Armor.armors()) {
                System.out.println(armor.getId() + " - " + armor.getName() + " : "
                        + " Price: " + armor.getPrice()
                        + " Block: " + armor.getBlock());
            }
            System.out.println("0 - Go back");
        }
    private void buyArmor() {
        System.out.print("Choose an armor: ");
        int selectArmor = scanner.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.print("Invalid value. Re-enter: ");
            selectArmor = scanner.nextInt();
        }

        if (selectArmor != 0) {
            Armor selectedArmorId = Armor.getArmorById(selectArmor);

            if (selectedArmorId != null) {
                if (selectedArmorId.getPrice() > this.getPlayer().getCharacter().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You bought " + selectedArmorId.getName());
                    int balance = this.getPlayer().getCharacter().getMoney() - selectedArmorId.getPrice();
                    System.out.println("Your remaining money: " + balance);
                    System.out.println("Your previous weapon: "
                            + this.getPlayer().getCharacter().getInventory().getArmor().getName());
                    this.getPlayer().getCharacter().getInventory().setArmor(selectedArmorId);
                    System.out.println("Your new weapon: "
                            + this.getPlayer().getCharacter().getInventory().getArmor().getName());
                    this.getPlayer().getCharacter().setMoney(balance);
                }
            }
        }
    }
}