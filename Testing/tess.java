import java.util.Scanner;

public class tess {
    static double limit = 0;
    static int dataNasabah [] = {100000};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean dataVerifikasi [] = new boolean[10];
        System.out.println("Apakah anda ingin verifikasi?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        System.out.print("Masukkan pilihan anda: ");
        int pilihan = sc.nextInt(); sc.nextLine();

        if (pilihan == 1) {
            dataVerifikasi[0] = true;
        }

        if (dataVerifikasi[0] == true) {
            limit = 10000000;
        } else {
            limit = 2500000;
        }

        System.out.println("Apakah anda ingin melakukan transaksi?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        System.out.print("Masukkan pilihan anda: ");
        int pilihan2 = sc.nextInt(); sc.nextLine();
        // Buat transaksi dengan limit
        if (pilihan2 == 1) {
            System.out.println("Masukkan jumlah uang yang ingin anda transaksikan: ");
            int uang = sc.nextInt();
            if (uang <= limit) {
                System.out.println("Transaksi berhasil");
                dataNasabah[0] = dataNasabah[0] - uang;
                System.out.println("Sisa saldo anda: " + dataNasabah[0]);
            } else {
                System.out.println("Transaksi gagal");
            }
        } else {
            System.out.println("Transaksi dibatalkan");
        }
        
    }
}
