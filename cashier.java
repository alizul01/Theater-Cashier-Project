
// import date
import java.util.*;
import java.time.*;

public class cashier {
    public static void main(String[] args) {
        int menu = 0;
        boolean confirmUser = true;
        /**
         * 1. Kegunaan fungsi randomPilihKursi untuk melakukan pengacakan pemilihan
         * kursi seakan-akan sudah ada yang menempati kursi tersebut.
         * 2. Total duduk ada 9 dengan menggunakan ekspresi boolean 0 dan 1 untuk
         * melakukan pemilihan dengan peluang 0.5 tiap kursi terisi otomatis
         */
        todayFilm();
        randomPilihKursi(studio[0]);
        randomPilihKursi(studio[1]);
        randomPilihKursi(studio[2]);
        while (confirmUser) {
            menuUtama();
            System.out.print("Pilih menu : ");
            try {
                menu = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Inputan salah");
                sc.nextLine();
                continue;
            }

            if (menu == 1) {
                pembelianTiket();
            } else if (menu == 2) {
                pencarianFilm();
            } else if (menu == 3) {
                cafeBioskop();
            } else if (menu == 4) {
                strukDanBayar();
            } else if (menu == 5) {
                confirmUser = false;
                System.out.println("Terima kasih sudah menggunakan program ini");
            } else {
                System.out.println("Menu tidak tersedia, masukkan angka 1 - 5");
            }

        }
    }

    // Deklarasi global variable dan library
    public static LocalDate dateNow = LocalDate.now();
    public static Scanner sc = new Scanner(System.in);
    public static double totalPembelian = 0;
    public static Random rand = new Random();
    public static String[] cafetaria = { "Popcorn", "Kentang", "Sosis", "Kopi", "Teh", "Jus" };
    public static int[][] dataCafetaria = {
            { 0, 0, 7500, 0 }, { 0, 0, 9500, 0 }, { 0, 0, 5500, 0 },
            { 0, 0, 4000, 0 }, { 0, 0, 6000, 0 }, { 0, 0, 6500, 0 }
    };
    /**
     * dataCafetaria[n][0] = jumlah makanan / minuman yang dibeli,
     * dataCafetaria[n][1] = total makanan / minuman yang dibeli,
     * dataCafetaria[n][2] = harga makanan / minuman, dataCafetaria[n][3] = total
     * harga makanan / minuman
     */
    public static String pesananFilmFix[][] = {
            { "", "" },
            { "", "" },
            { "", "" }
    };
    public static int totalPembelianCafe = 0;
    public static String[][][] studio = {
            {
                    { "A1", "A2", "A3", "A4" },
                    { "B1", "B2", "B3", "B4" },
                    { "C1", "C2", "C3", "C4" },
                    { "D1", "D2", "D3", "D4" }
            },
            {
                    { "A1", "A2", "A3", "A4" },
                    { "B1", "B2", "B3", "B4" },
                    { "C1", "C2", "C3", "C4" },
                    { "D1", "D2", "D3", "D4" }
            },
            {
                    { "A1", "A2", "A3", "A4" },
                    { "B1", "B2", "B3", "B4" },
                    { "C1", "C2", "C3", "C4" },
                    { "D1", "D2", "D3", "D4" }
            }
    };

    public static String tanggal = dateNow.getDayOfMonth() + "-" + dateNow.getMonthValue()
            + "-" + dateNow.getYear();
    public static String makananTerbeli[][] = new String[2][3];
    public static String filmHariIni[] = new String[3];
    public static int hargaFilm[] = new int[3];

    public static void todayFilm() {
        int i = 0, choose = rand.nextInt(filmData.length - 1);
        int j[] = { 0, 0, 0 };
        while (i < 3) {
            if (j[0] == choose || j[1] == choose || j[2] == choose) {
                choose = rand.nextInt(filmData.length - 1);
            } else {
                filmHariIni[i] = filmData[choose][0] + " - " + filmData[choose][3];
                hargaFilm[i] = Integer.parseInt(filmData[choose][4]);
                j[i] = choose;
                i++;
            }
        }
    }

    public static String filmData[][] = {
            { "The Matrix", "Action", "December", "14:00", "25000", "16+" },
            { "Spiderman No Way Home", "Action", "December", "15:00", "34000", "13+" },
            { "Spiderman Far From Home", "Action", "March", "17:35", "35000", "16+" },
            { "Five Feets Apart", "Romance", "December", "18:00", "25000", "16+" },
            { "Ironman", "Action", "January", "23:00", "30000", "13+" },
            { "Up", "Adventure", "January", "13:30", "23000", "7+" },
            { "Mission Impossible", "Action", "February", "19:25", "30000", "17+" },
            { "The Dark Knight", "Action", "February", "20:15", "30000", "17+" },
            { "The Avengers", "Action", "February", "12:30", "23000", "17+" },
            { "The Dark Knight Rises", "Action", "February", "11:10", "35000", "17+" },
            { "Avengers End Game", "Superhero", "March", "13:00", "25000", "16+" },
            { "Avengers Infinity War", "Superhero", "May", "19:00", "27000", "13+" },
            { "Dilan 1990", "Romance", "April", "19:30", "35000", "16+" },
            { "John Wick : 3", "Action", "February", "12:10", "30000", "16+" },
            { "Friendzone", "Comedy", "August", "17:00", "25000", "16+" },
            { "Stand By Me : 2", "Comedy", "July", "13:25", "40000", "13+" },
            { "One day", "Romance", "June", "14:00", "40000", "17+" },
            { "Start Up", "Romance", "November", "12:55", "28000", "16+" },
            { "Oxygen", "Intense", "October", "19:45", "23000", "16+" },
            { "Habibie dan Ainun", "Romance", "January", "15:30", "30000", "17+" },
            { "The Last Airbender", "Adventure", "February", "18:00", "25000", "16+" },
            { "The Last Airbender : 2", "Adventure", "February", "18:00", "25000", "16+" }
    };

    // Fitur 1 - Menu Utama Kasir Bioskop
    public static void menuUtama() {
        garis();
        System.out.println(
                "| Selamat Datang di Mini Cineplex \t\t\t" + tanggal + " |");
        garis();

        System.out.println("\nMenu Utama : ");
        System.out.println("1. Pembelian Tiket");
        System.out.println("2. Pencarian Film");
        System.out.println("3. Pemesanan Makanan dan Minuman");
        System.out.println("4. Pembayaran dan Cetak Struk");
        System.out.println("5. Keluar");
        System.out.println("\t\t\t\t\tTotal pembelian Tiket\t: Rp" + totalPembelian);
        System.out.println("\t\t\t\t\tTotal Pembelian Cafe\t: Rp" + totalPembelianCafe);
    }

    // Fitur 2 - Pembelian Tiket
    public static void pembelianTiket() {
        int pilihFilm = 0;
        String pilihKursi = "";
        while (true) {
            garis();
            System.out.println("| Pembelian Tiket \t\t\t\t\t" + tanggal + " |");
            garis();
            System.out.println("\nFilm yang tersedia : ");
            for (int i = 0; i < filmHariIni.length; i++) {
                System.out.println((i + 1) + ". " + filmHariIni[i] + " - Rp" + hargaFilm[i]);
            }

            System.out.print("\nPilih film : ");

            try {
                pilihFilm = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\nInput salah, silahkan ulangi lagi");
                sc.nextLine();
                continue;
            }
            break;
        }
        pesananFilmFix[pilihFilm - 1][0] = filmHariIni[pilihFilm - 1];

        while (true) {
            printKursi(studio[pilihFilm - 1]);
            System.out.println("Ketik 0 untuk kembali ke menu utama");
            System.out.print("Pilih kursi (A1-D4) : ");
            pilihKursi = sc.nextLine();
            if (pilihKursi.equals("0")) {
                break;
            } else if (chairValidation(pilihKursi.toUpperCase())) {
                pesananFilmFix[pilihFilm - 1][1] += cariKursi(studio[pilihFilm - 1], pilihKursi,
                        hargaFilm[pilihFilm - 1]) + " ";
                System.out.println("\nKursi " + pilihKursi.toUpperCase() + " berhasil dipesan");
                System.out.println();
            } else {
                System.out.println("\nInput salah, silahkan ulangi lagi");
            }
        }

    }

    // Fitur 2.1 - Random isi kursi
    public static void randomPilihKursi(String[][] studio) {
        for (int i = 0; i < studio.length; i++) {
            for (int j = 0; j < studio[0].length; j++) {
                if (rand.nextInt(2) == 1) {
                    studio[i][j] = "X";
                }
            }
        }
    }

    // Fitur 2.2 - Print Kursi
    public static void printKursi(String[][] kursiStudio) {
        for (int i = 0; i < kursiStudio.length; i++) {
            for (int j = 0; j < kursiStudio[0].length; j++) {
                System.out.print(kursiStudio[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Fitur 2.3 - cariKursi
    public static String cariKursi(String[][] namaStudio, String kursi, int harga) {
        String kursiDipilih = "";
        for (int i = 0; i < namaStudio.length; i++) {
            for (int j = 0; j < namaStudio[0].length; j++) {
                if (namaStudio[i][j].equalsIgnoreCase(kursi)) {
                    kursiDipilih += kursi + "";
                    namaStudio[i][j] = "O";
                    totalPembelian += harga;

                }
            }

        }
        return kursiDipilih;
    }

    // Fitur 2.4 - Validasi Kursi
    public static boolean chairValidation(String input) {

        if ((input.contains("A") || input.contains("B") || input.contains("C") || input.contains("D"))
                && (input.contains("1") || input.contains("2") || input.contains("3") || input.contains("4"))
                && input.length() == 2) {
            return true;
        } else {
            return false;
        }
    }

    // Fitur 3 - Pencarian Film
    public static void pencarianFilm() {
        String cariDataFilm = "";
        while (true) {
            garis();
            System.out.println("Pencarian Film");
            garis();

            System.out.println("Film yang tersedia : ");
            System.out.println("Hari ini : ");
            for (int i = 0; i < filmHariIni.length; i++) {
                System.out.println((i + 1) + ". " + filmHariIni[i] + " - Rp" + hargaFilm[i]);
            }

            System.out.println("Cari Film : ");
            System.out.println("Berdasarkan : ");
            System.out.println("1. Judul Film");
            System.out.println("2. Genre Film");
            System.out.println("3. Bulan Tayang");
            System.out.println("4. Jam Tayang");
            System.out.println("5. Harga");
            System.out.println("6. Rating Film");
            System.out.println("7. Kembali");
            System.out.print("Pilih : ");
            String cariFilm = sc.nextLine();
            if (cariFilm.equals("1")) {
                System.out.print("Masukkan Judul Film : ");
            } else if (cariFilm.equals("2")) {
                System.out.print("Masukkan Genre Film : ");
            } else if (cariFilm.equals("3")) {
                System.out.print("Masukkan Bulan Tayang : ");
            } else if (cariFilm.equals("4")) {
                System.out.print("Masukkan Jam Tayang : ");
            } else if (cariFilm.equals("5")) {
                System.out.print("Masukkan Harga : ");
            } else if (cariFilm.equals("6")) {
                System.out.print("Masukkan Rating Film : ");
            } else if (cariFilm.equals("7")) {
                break;
            } else {
                System.out.println("Input salah, silahkan ulangi lagi");
                continue;
            }

            cariDataFilm = sc.nextLine();
            System.out.println(databaseFilm(cariFilm, cariDataFilm));
            System.out.println("\nKetik 0 untuk kembali, atau ketik lainnya untuk melanjutkan");
            System.out.print("Pilih : ");
            int pilih;
            try {
                pilih = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\nInput salah, silahkan ulangi lagi");
                sc.nextLine();
                continue;
            }

            if (pilih == 0) {
                break;
            } else {
                continue;
            }
        }
    }

    // Fitur 3.1 - Database Film
    public static String databaseFilm(String cariFilm, String cariDataFilm) {
        String hasil = "";
        int counter = 0;
        for (int i = 0; i < filmData.length; i++) {
            if (filmData[i][Integer.parseInt(cariFilm) - 1].equalsIgnoreCase(cariDataFilm)) {
                hasil += "Judul Film\t: " + filmData[i][0] + "\n"
                        + "Genre Film\t: " + filmData[i][1] + "\n"
                        + "Bulan Tayang\t: " + filmData[i][2] + "\n"
                        + "Pukul\t: " + filmData[i][3] + "\n"
                        + "Harga\t: " + filmData[i][4] + "\n"
                        + "Rating Film\t: " + filmData[i][5] + "\n\n";
                counter++;
            }
        }

        if (counter == 0) {
            hasil = "Film tidak ditemukan";
        }
        return hasil;
    }

    // Fitur 4 - Print Struk
    public static void strukDanBayar() {
        int sistemBayar = 0;
        double diskon = 0, totalBayar = totalPembelian + totalPembelianCafe;
        double bayar = 0;
        garis();
        System.out.println("Cetak Struk dan Pembayaran Bioskop");
        garis();

        System.out.println("Pilih sistem pembayaran : \n1. Left-Pay\n2. Vovo\n3. Tunai");
        System.out.print("Masukkan sistem bayar : ");
        do {
            sistemBayar = sc.nextInt();
            sc.nextLine();
        } while (sistemBayar < 1 || sistemBayar > 3);
        if (sistemBayar == 1) {
            System.out.println("Pelanggan mendapatkan diskon sebesar 5%");
            diskon = totalPembelian * 0.05;
            totalBayar -= diskon;
        } else if (sistemBayar == 2) {
            System.out.println("Pelanggan mendapatkan diskon sebesar 3%");
            diskon = totalPembelian * 0.03;
            totalBayar -= diskon;
        } else if (sistemBayar == 3) {
            System.out.println("Pelanggan tidak mendapatkan diskon");
        } else {
            System.out.println("Input salah, silahkan ulangi lagi");
        }

        if (coupon()) {
            System.out.println("Pelanggan mendapatkan kupon potongan sebesar Rp10000!");
            totalBayar -= 10000;
        } else {
            System.out.println("Pelanggan tidak mendapatkan kupon!");
        }

        System.out.println("Total Pembayaran\t: " + totalBayar);
        if (sistemBayar == 1 || sistemBayar == 2) {
            bayar = totalBayar;
        } else {
            do {
                try {
                    System.out.print("Masukkan jumlah uang yang dibayarkan : ");
                    bayar = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid");
                    sc.nextLine();
                }
            } while (bayar < totalBayar);
        }

        System.out.println();
        garis();
        System.out.println("Struk");
        garis();

        // Tampilkan film yang dipesan dan kursi yang dipilih
        for (int i = 0; i < pesananFilmFix.length; i++) {
            if (pesananFilmFix[i][0] != "") {
                System.out.println(pesananFilmFix[i][0]);
                System.out.println(">> Kursi\t: " + pesananFilmFix[i][1].toUpperCase());
                System.out.println(">> Harga\t: " + hargaFilm[i]);
                System.out.println(">> Total\t: " + pesananFilmFix[i][1].split(" ").length * hargaFilm[i]);
                System.out.println();
            }
        }

        // Tampilkan Makanan atau Minuman yang dibeli
        for (int i = 0; i < cafetaria.length; i++) {
            if (dataCafetaria[i][1] != 0) {
                System.out.println(cafetaria[i]);
                System.out.println(">> Jumlah\t: " + dataCafetaria[i][1]);
                System.out.println(">> Harga\t: " + dataCafetaria[i][2]);
                System.out.println(">> Total\t: " + dataCafetaria[i][1] * dataCafetaria[i][2]);
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("Total Pembelian Tiket\t\t: " + totalPembelian);
        System.out.println("Total Pembelian Cafe\t\t: " + totalPembelianCafe);
        System.out.println("Diskon / Bonus\t\t: " + diskon);
        System.out.println("Total Pembayaran\t: " + totalBayar);
        System.out.println("Uang yang dibayarkan\t: " + bayar);
        System.out.println("Kembalian\t\t: " + (bayar - totalBayar));
        System.out.println();
        System.exit(0);

    }

    /**
     * Additonal Features :
     * 1. Garis pembatas - Untuk merapikan kode dan memudahkan penulisan
     * 2. Coupon and Promo - Untuk menambahkan kode promo dan coupon
     * 3. Makanan dan Minuman - Untuk menambahkan menu makanan dan minuman
     */

    public static boolean coupon() {
        int jawaban = 0, pilihKupon = 0, kupon = rand.nextInt(11);
        while (true) {
            System.out.println("Ingin mencoba ambil kupon? (0 = Tidak, 1 = Ya) ");
            System.out.print("Jawab : ");
            try {
                jawaban = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input salah, silahkan ulangi lagi");
                sc.nextLine();
                continue;
            }
            if (jawaban == 0) {
                return false;
            } else if (jawaban == 1) {
                System.out.println("Ketik angka 0 - 10");
                try {
                    pilihKupon = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Input salah, silahkan ulangi lagi");
                    continue;
                }
                if (pilihKupon == kupon) {
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("Not valid answer");
                continue;
            }
        }
    }

    public static void garis() {
        System.out.println("==================================================================");
    }

    public static void cafeBioskop() {
        int choose, pilihMenu, total = 0;

        while (true) {

            garis();
            System.out.println("Menu Makanan dan Minuman");
            garis();
            System.out.println("1. Makanan");
            System.out.println("2. Minuman");
            System.out.println("3. Kembali ke menu utama");
            System.out.print("Pilih menu : ");

            try {
                pilihMenu = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Input tidak valid");
                continue;
            }

            if (pilihMenu == 1) {
                garis();
                System.out.println("Menu Makanan");
                garis();
                // Output data makanan dari cafetaria 0 - 2
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + ". " + cafetaria[i] + " - Rp" + dataCafetaria[i][2]);
                }
                // Pilih makanan
                System.out.print("Pilih Makanan : ");

                try {
                    choose = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid");
                    continue;
                }

                if (choose > 0 && choose <= 3) {
                    System.out.print("Masukkan Jumlah : ");
                    try {
                        dataCafetaria[choose - 1][0] = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid");
                        continue;
                    }
                    dataCafetaria[choose - 1][1] += dataCafetaria[choose - 1][0];
                    System.out.println(">> " + cafetaria[choose - 1] + " telah ditambahkan ke keranjang");
                } else {
                    System.out.println("Input tidak valid");
                    continue;
                }
            } else if (pilihMenu == 2) {
                garis();
                System.out.println("Menu Minuman");
                garis();
                // Output data minuman dari cafetaria 3 - 5
                for (int i = 3; i < 6; i++) {
                    System.out.println((i - 2) + ". " + cafetaria[i] + " - Rp" + dataCafetaria[i][2]);
                }
                // Pilih minuman
                System.out.print("Pilih Minuman : ");

                try {
                    choose = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid");
                    continue;
                }

                if (choose >= 1 && choose <= 3) {
                    System.out.print("Masukkan Jumlah : ");
                    try {
                        dataCafetaria[choose + 2][0] = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak valid");
                        sc.nextLine();
                        continue;
                    }
                    dataCafetaria[choose + 2][1] += dataCafetaria[choose + 2][0];
                    System.out.println(">> " + cafetaria[choose + 2] + " telah ditambahkan ke keranjang");
                } else {
                    System.out.println("Input tidak valid");
                    continue;
                }
            } else if (pilihMenu == 3) {
                break;
            } else {
                System.out.println("Input tidak valid");
                continue;
            }

        }
        for (int i = 0; i < dataCafetaria.length; i++) {
            dataCafetaria[i][3] = dataCafetaria[i][1] * dataCafetaria[i][2];
        }
        total = 0;
        for (int i = 0; i < dataCafetaria.length; i++) {
            total += dataCafetaria[i][3];
        }
        totalPembelianCafe = total;
        System.out.println("Total Pembelian Cafe\t\t: " + totalPembelianCafe);
    }
}