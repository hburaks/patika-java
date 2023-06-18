import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.print("Lütfen adınızı giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Oyuncu " + player.getName() + ". Lütfen karakter seç." );
        player.selectChar();
        player.printCharInfo();
        Location location = null;
        while(true){
            System.out.println("Bölgeler:");
            System.out.println("1 - Güvenli Ev --> Burasi sizin için güvenlidir, düşman yok!");
            System.out.println("2 - Mağaza     --> Silah veya zırh satın alabilirsiniz.");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
            }
            System.out.println(location.getName());
        }


    }

}