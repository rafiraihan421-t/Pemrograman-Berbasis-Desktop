import java.util.Scanner;
import java.io.*;

public class Main {

    static final String FILE_MENU = "menu.txt";
    static Menu    menu    = new Menu();
    static Pesanan pesanan = new Pesanan();

    // ==================== MAIN ====================

    public static void main(String[] args) {
        // Muat menu dari file saat startup
        try {
            menu.muatDariFile(FILE_MENU);
            System.out.println("✔ Menu dimuat dari " + FILE_MENU);
        } catch (IOException e) {
            System.out.println("⚠ File menu tidak ditemukan, menggunakan data default.");
            isiMenuDefault();
        }

        Scanner sc = new Scanner(System.in);
        menuUtama(sc);
        sc.close();
    }

    static void isiMenuDefault() {
        menu.tambah(new Makanan("Nasi Padang",  25000, "nasi"));
        menu.tambah(new Makanan("Ayam Bakar",   30000, "lauk"));
        menu.tambah(new Makanan("Mie Goreng",   20000, "mie"));
        menu.tambah(new Makanan("Soto Ayam",    18000, "sup"));
        menu.tambah(new Makanan("Nasi Goreng",  22000, "nasi"));
        menu.tambah(new Minuman("Es Teh Manis",  5000, "teh"));
        menu.tambah(new Minuman("Jus Alpukat",  15000, "jus"));
        menu.tambah(new Minuman("Es Jeruk",      7000, "jus"));
        menu.tambah(new Minuman("Air Mineral",   4000, "air"));
        menu.tambah(new Minuman("Kopi Susu",    12000, "kopi"));
        simpanMenu();
    }

    static void simpanMenu() {
        try {
            menu.simpanKeFile(FILE_MENU);
        } catch (IOException e) {
            System.out.println("⚠ Gagal menyimpan menu: " + e.getMessage());
        }
    }

    // ==================== MENU UTAMA ====================

    static void menuUtama(Scanner sc) {
        boolean jalan = true;
        while (jalan) {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║              RESTORAN MUNI — MENU UTAMA         ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Pesan Makanan / Minuman (Pelanggan)         ║");
            System.out.println("║  2. Kelola Menu (Pemilik Restoran)              ║");
            System.out.println("║  0. Keluar                                      ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("Pilih menu: ");
            String pilihan = sc.nextLine().trim();

            if (pilihan.equals("1")) {
                menuPelanggan(sc);
            } else if (pilihan.equals("2")) {
                menuPengelolaan(sc);
            } else if (pilihan.equals("0")) {
                System.out.println("Terima kasih, sampai jumpa!");
                jalan = false;
            } else {
                System.out.println("⚠ Pilihan tidak valid.\n");
            }
        }
    }

    // ==================== MENU PELANGGAN ====================

    static void menuPelanggan(Scanner sc) {
        pesanan.reset();
        tampilkanMenu();
        inputPesanan(sc);

        if (pesanan.size() == 0) {
            System.out.println("Tidak ada pesanan. Kembali ke menu utama.\n");
            return;
        }
        cetakStruk();

        // Simpan struk ke file
        try {
            simpanStrukKeFile();
            System.out.println("✔ Struk disimpan ke struk.txt");
        } catch (IOException e) {
            System.out.println("⚠ Gagal menyimpan struk: " + e.getMessage());
        }

        System.out.println("\nTekan Enter untuk kembali ke menu utama...");
        sc.nextLine();
    }

    // ==================== MENU PENGELOLAAN ====================

    static void menuPengelolaan(Scanner sc) {
        boolean jalan = true;
        while (jalan) {
            System.out.println("╔══════════════════════════════════════════════════╗");
            System.out.println("║          PENGELOLAAN MENU — PEMILIK             ║");
            System.out.println("╠══════════════════════════════════════════════════╣");
            System.out.println("║  1. Lihat Daftar Menu                           ║");
            System.out.println("║  2. Tambah Menu Baru                            ║");
            System.out.println("║  3. Ubah Harga Menu                             ║");
            System.out.println("║  4. Hapus Menu                                  ║");
            System.out.println("║  0. Kembali ke Menu Utama                       ║");
            System.out.println("╚══════════════════════════════════════════════════╝");
            System.out.print("Pilih menu: ");
            String pilihan = sc.nextLine().trim();

            if (pilihan.equals("1")) {
                System.out.println();
                tampilkanDaftarMenu();
                System.out.println("Tekan Enter untuk kembali...");
                sc.nextLine();
            } else if (pilihan.equals("2")) {
                tambahMenuBaru(sc);
            } else if (pilihan.equals("3")) {
                ubahHargaMenu(sc);
            } else if (pilihan.equals("4")) {
                hapusMenu(sc);
            } else if (pilihan.equals("0")) {
                jalan = false;
            } else {
                System.out.println("⚠ Pilihan tidak valid.\n");
            }
        }
    }

    // ==================== TAMPILKAN MENU ====================

    static void tampilkanMenu() {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║         SELAMAT DATANG DI RESTORAN MUNI         ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println();
        tampilkanDaftarMenu();
    }

    static void tampilkanDaftarMenu() {
        // Makanan
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│                  MENU MAKANAN                    │");
        System.out.println("├────┬────────────────────────────┬────────────────┤");
        System.out.println("│ No │ Nama Menu                  │ Harga          │");
        System.out.println("├────┼────────────────────────────┼────────────────┤");
        int no = 1;
        boolean ada = false;
        for (MenuItem item : menu.getDaftar()) {
            if (item.getKategori().equals("makanan")) {
                System.out.printf("│ %-2d │ %-26s │ Rp %,-10.0f │%n", no++, item.getNama(), item.getHarga());
                ada = true;
            }
        }
        if (!ada) System.out.println("│ (Belum ada menu makanan)                         │");
        System.out.println("└────┴────────────────────────────┴────────────────┘");

        // Minuman
        System.out.println();
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│                  MENU MINUMAN                    │");
        System.out.println("├────┬────────────────────────────┬────────────────┤");
        System.out.println("│ No │ Nama Menu                  │ Harga          │");
        System.out.println("├────┼────────────────────────────┼────────────────┤");
        no = 1; ada = false;
        for (MenuItem item : menu.getDaftar()) {
            if (item.getKategori().equals("minuman")) {
                System.out.printf("│ %-2d │ %-26s │ Rp %,-10.0f │%n", no++, item.getNama(), item.getHarga());
                ada = true;
            }
        }
        if (!ada) System.out.println("│ (Belum ada menu minuman)                         │");
        System.out.println("└────┴────────────────────────────┴────────────────┘");

        // Diskon (tampil jika ada)
        boolean adaDiskon = false;
        for (MenuItem item : menu.getDaftar()) {
            if (item instanceof Diskon) { adaDiskon = true; break; }
        }
        if (adaDiskon) {
            System.out.println();
            System.out.println("┌──────────────────────────────────────────────────┐");
            System.out.println("│                  MENU DISKON                     │");
            System.out.println("├────┬────────────────────────────┬────────────────┤");
            System.out.println("│ No │ Nama                       │ Diskon         │");
            System.out.println("├────┼────────────────────────────┼────────────────┤");
            no = 1;
            for (MenuItem item : menu.getDaftar()) {
                if (item instanceof Diskon) {
                    System.out.printf("│ %-2d │ %-26s │ %.0f%%%n", no++, item.getNama(), ((Diskon) item).getDiskon() * 100);
                }
            }
            System.out.println("└────┴────────────────────────────┴────────────────┘");
        }
        System.out.println();
    }

    static void tampilkanMenuBernomor() {
        System.out.println("┌────┬────────────────────────────┬────────────────┬──────────┐");
        System.out.println("│ No │ Nama Menu                  │ Harga          │ Kategori │");
        System.out.println("├────┼────────────────────────────┼────────────────┼──────────┤");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.printf("│ %-2d │ %-26s │ Rp %,-10.0f │ %-8s │%n",
                (i + 1), item.getNama(), item.getHarga(), item.getKategori());
        }
        System.out.println("└────┴────────────────────────────┴────────────────┴──────────┘");
        System.out.println();
    }

    // ==================== TAMBAH MENU BARU ====================

    static void tambahMenuBaru(Scanner sc) {
        System.out.println("\n── TAMBAH MENU BARU ──");

        System.out.print("Nama menu baru: ");
        String nama = sc.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("⚠ Nama tidak boleh kosong. Dibatalkan.\n");
            return;
        }

        double harga = 0;
        boolean hargaValid = false;
        while (!hargaValid) {
            System.out.print("Harga (Rp): ");
            try {
                harga = Double.parseDouble(sc.nextLine().trim());
                if (harga <= 0) System.out.println("⚠ Harga harus lebih dari 0.");
                else hargaValid = true;
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input harga tidak valid.");
            }
        }

        // Pilih tipe: makanan, minuman, atau diskon
        String tipe = "";
        while (tipe.isEmpty()) {
            System.out.print("Tipe (makanan/minuman/diskon): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("makanan") || input.equals("minuman") || input.equals("diskon"))
                tipe = input;
            else System.out.println("⚠ Tipe harus 'makanan', 'minuman', atau 'diskon'.");
        }

        MenuItem itemBaru;
        if (tipe.equals("makanan")) {
            System.out.print("Jenis makanan (nasi/lauk/mie/sup/dll): ");
            String jenis = sc.nextLine().trim();
            itemBaru = new Makanan(nama, harga, jenis.isEmpty() ? "makanan" : jenis);
        } else if (tipe.equals("minuman")) {
            System.out.print("Jenis minuman (teh/jus/kopi/air/dll): ");
            String jenis = sc.nextLine().trim();
            itemBaru = new Minuman(nama, harga, jenis.isEmpty() ? "minuman" : jenis);
        } else {
            double persen = 0;
            boolean ok = false;
            while (!ok) {
                System.out.print("Persentase diskon (contoh: 10 untuk 10%): ");
                try {
                    persen = Double.parseDouble(sc.nextLine().trim()) / 100.0;
                    if (persen <= 0 || persen >= 1) System.out.println("⚠ Diskon harus antara 1-99%.");
                    else ok = true;
                } catch (NumberFormatException e) {
                    System.out.println("⚠ Input tidak valid.");
                }
            }
            itemBaru = new Diskon(nama, harga, persen);
        }

        // Konfirmasi & polymorphic tampilMenu()
        System.out.println("\nKonfirmasi penambahan:");
        System.out.print("  ");
        itemBaru.tampilMenu(); // ← polymorphism

        boolean konfirmValid = false;
        while (!konfirmValid) {
            System.out.print("Yakin ingin menambahkan menu ini? (Ya/Tidak): ");
            String konfirm = sc.nextLine().trim();
            if (konfirm.equalsIgnoreCase("Ya")) {
                menu.tambah(itemBaru);
                simpanMenu();
                System.out.println("✔ Menu '" + nama + "' berhasil ditambahkan.\n");
                konfirmValid = true;
            } else if (konfirm.equalsIgnoreCase("Tidak")) {
                System.out.println("✘ Penambahan dibatalkan.\n");
                konfirmValid = true;
            } else {
                System.out.println("⚠ Ketik 'Ya' atau 'Tidak'.");
            }
        }
    }

    // ==================== UBAH HARGA MENU ====================

    static void ubahHargaMenu(Scanner sc) {
        System.out.println("\n── UBAH HARGA MENU ──");
        if (menu.size() == 0) { System.out.println("⚠ Tidak ada menu.\n"); return; }
        tampilkanMenuBernomor();

        int nomorMenu = pilihNomor(sc, "diubah harganya");
        if (nomorMenu == 0) return;

        MenuItem dipilih = menu.get(nomorMenu - 1);
        System.out.printf("Menu dipilih: %s (Harga saat ini: Rp %,.0f)%n", dipilih.getNama(), dipilih.getHarga());

        double hargaBaru = 0;
        boolean ok = false;
        while (!ok) {
            System.out.print("Harga baru (Rp): ");
            try {
                hargaBaru = Double.parseDouble(sc.nextLine().trim());
                if (hargaBaru <= 0) System.out.println("⚠ Harga harus lebih dari 0.");
                else ok = true;
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input tidak valid.");
            }
        }

        System.out.printf("%nKonfirmasi: %s  Rp %,.0f → Rp %,.0f%n", dipilih.getNama(), dipilih.getHarga(), hargaBaru);
        if (konfirmasi(sc)) {
            dipilih.setHarga(hargaBaru);
            simpanMenu();
            System.out.println("✔ Harga berhasil diubah.\n");
        } else {
            System.out.println("✘ Perubahan dibatalkan.\n");
        }
    }

    // ==================== HAPUS MENU ====================

    static void hapusMenu(Scanner sc) {
        System.out.println("\n── HAPUS MENU ──");
        if (menu.size() == 0) { System.out.println("⚠ Tidak ada menu untuk dihapus.\n"); return; }
        tampilkanMenuBernomor();

        int nomorMenu = pilihNomor(sc, "dihapus");
        if (nomorMenu == 0) return;

        MenuItem dipilih = menu.get(nomorMenu - 1);
        System.out.printf("%nMenu yang akan dihapus: %s (Rp %,.0f — %s)%n",
            dipilih.getNama(), dipilih.getHarga(), dipilih.getKategori());

        if (konfirmasi(sc)) {
            String namaHapus = dipilih.getNama();
            menu.hapus(nomorMenu - 1);
            simpanMenu();
            System.out.println("✔ Menu '" + namaHapus + "' berhasil dihapus.\n");
        } else {
            System.out.println("✘ Penghapusan dibatalkan.\n");
        }
    }

    // ==================== INPUT PESANAN ====================

    static void inputPesanan(Scanner sc) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║                   INPUT PESANAN                 ║");
        System.out.println("║  Format: Nama Menu = Jumlah  (maks. 4 menu)     ║");
        System.out.println("║  Ketik 'selesai' untuk mengakhiri pemesanan      ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println();

        for (int slot = 0; slot < 4; slot++) {
            System.out.print("Pesanan " + (slot + 1) + ": ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("selesai") || input.isEmpty()) break;

            String[] parts = input.split("=");
            if (parts.length != 2) {
                System.out.println("✘ Format salah, pesanan diabaikan.");
                slot--; // beri kesempatan ulang di slot yang sama
                continue;
            }
            try {
                String namaCari = parts[0].trim();
                int qty = Integer.parseInt(parts[1].trim());
                MenuItem item = menu.cari(namaCari); // throws MenuNotFoundException
                pesanan.tambah(item, qty);
                System.out.println("✔ " + item.getNama() + " x" + qty + " ditambahkan.");
            } catch (MenuNotFoundException e) {
                System.out.println("✘ " + e.getMessage() + " Pesanan diabaikan.");
                slot--;
            } catch (NumberFormatException e) {
                System.out.println("✘ Jumlah tidak valid, pesanan diabaikan.");
                slot--;
            }
        }
    }

    // ==================== CETAK STRUK ====================

    static void cetakStruk() {
        double total         = pesanan.hitungTotal();
        boolean diskon10     = total > 100000;
        boolean promoMinuman = total > 50000 && pesanan.adaMinuman();

        double nilaiDiskon10 = diskon10     ? total * 0.10                              : 0;
        double nilaiPromo    = promoMinuman ? pesanan.minumanPertama().getHarga()       : 0;
        double totalSetelah  = total - nilaiDiskon10 - nilaiPromo;
        double pajak         = totalSetelah * 0.10;
        double pelayanan     = 20000;
        double totalBayar    = totalSetelah + pajak + pelayanan;

        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║              STRUK PEMBAYARAN                       ║");
        System.out.println("║              RESTORAN MUNI                          ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  No   Nama Item                Qty    Total          ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");

        for (int i = 0; i < pesanan.size(); i++) {
            MenuItem m = pesanan.getItem(i);
            int qty    = pesanan.getJumlah(i);
            double sub = pesanan.hitungSubtotal(i);
            System.out.printf("║  %-2d   %-22s  %-5d  Rp %,-9.0f ║%n", (i+1), m.getNama(), qty, sub);
            System.out.printf("║       @ Rp %,-37.0f ║%n", m.getHarga());
        }

        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf( "║  Total Keseluruhan                    Rp %,-9.0f ║%n", total);

        if (diskon10) {
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  *** DISKON BERLAKU ***                              ║");
            System.out.printf( "║  Diskon 10%% (total > Rp 100.000)   -Rp %,-9.0f ║%n", nilaiDiskon10);
        }
        if (promoMinuman) {
            if (!diskon10) System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  *** PROMO BELI 1 GRATIS 1 MINUMAN ***               ║");
            System.out.printf( "║  Gratis 1x %-28s  -Rp %,-9.0f ║%n",
                pesanan.minumanPertama().getNama(), nilaiPromo);
        }
        if (diskon10 || promoMinuman) {
            System.out.printf("║  Total Setelah Diskon/Promo           Rp %,-9.0f ║%n", totalSetelah);
        }

        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf( "║  Pajak 10%%                            Rp %,-9.0f ║%n", pajak);
        System.out.printf( "║  Biaya Pelayanan                      Rp %,-9.0f ║%n", pelayanan);
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf( "║  TOTAL BAYAR                          Rp %,-9.0f ║%n", totalBayar);
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  Keterangan:                                         ║");
        if (diskon10 && promoMinuman) {
            System.out.println("║  ✔ Diskon 10% diterapkan (total > Rp 100.000)        ║");
            System.out.println("║  ✔ Promo beli 1 gratis 1 minuman diterapkan          ║");
        } else if (diskon10) {
            System.out.println("║  ✔ Diskon 10% diterapkan (total > Rp 100.000)        ║");
            System.out.println("║  - Promo minuman tidak berlaku                       ║");
        } else if (promoMinuman) {
            System.out.println("║  - Diskon 10% tidak berlaku (total <= Rp 100.000)    ║");
            System.out.println("║  ✔ Promo beli 1 gratis 1 minuman diterapkan          ║");
        } else {
            System.out.println("║  - Tidak ada diskon (total <= Rp 100.000)            ║");
            System.out.println("║  - Tidak ada promo minuman                           ║");
        }
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║         Terima kasih telah berkunjung!               ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
    }

    // ==================== SIMPAN STRUK KE FILE ====================

    static void simpanStrukKeFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("struk.txt", true)); // append mode
        bw.write("====== STRUK PEMBAYARAN — RESTORAN MUNI ======");
        bw.newLine();
        double total = pesanan.hitungTotal();
        for (int i = 0; i < pesanan.size(); i++) {
            MenuItem m = pesanan.getItem(i);
            bw.write(String.format("  %d. %-22s x%-3d  Rp %,.0f",
                (i+1), m.getNama(), pesanan.getJumlah(i), pesanan.hitungSubtotal(i)));
            bw.newLine();
        }
        boolean diskon10     = total > 100000;
        boolean promoMinuman = total > 50000 && pesanan.adaMinuman();
        double nilaiDiskon10 = diskon10     ? total * 0.10                        : 0;
        double nilaiPromo    = promoMinuman ? pesanan.minumanPertama().getHarga() : 0;
        double totalSetelah  = total - nilaiDiskon10 - nilaiPromo;
        double pajak         = totalSetelah * 0.10;
        double totalBayar    = totalSetelah + pajak + 20000;
        bw.write(String.format("  Total          : Rp %,.0f", total)); bw.newLine();
        if (diskon10)     { bw.write(String.format("  Diskon 10%%     : -Rp %,.0f", nilaiDiskon10)); bw.newLine(); }
        if (promoMinuman) { bw.write(String.format("  Promo minuman  : -Rp %,.0f", nilaiPromo));    bw.newLine(); }
        bw.write(String.format("  Pajak 10%%      : Rp %,.0f", pajak));    bw.newLine();
        bw.write(String.format("  Biaya pelayanan: Rp 20.000"));            bw.newLine();
        bw.write(String.format("  TOTAL BAYAR    : Rp %,.0f", totalBayar)); bw.newLine();
        bw.write("==============================================");
        bw.newLine(); bw.newLine();
        bw.close();
    }

    // ==================== HELPER ====================

    static int pilihNomor(Scanner sc, String aksi) {
        while (true) {
            System.out.print("Masukkan nomor menu yang ingin " + aksi + " (0 = batal): ");
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n == 0) { System.out.println("✘ Dibatalkan.\n"); return 0; }
                if (n >= 1 && n <= menu.size()) return n;
                System.out.println("⚠ Nomor tidak valid, masukkan angka 1 - " + menu.size() + ".");
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input tidak valid, masukkan angka.");
            }
        }
    }

    static boolean konfirmasi(Scanner sc) {
        while (true) {
            System.out.print("Yakin? (Ya/Tidak): ");
            String k = sc.nextLine().trim();
            if (k.equalsIgnoreCase("Ya"))    return true;
            if (k.equalsIgnoreCase("Tidak")) return false;
            System.out.println("⚠ Ketik 'Ya' atau 'Tidak'.");
        }
    }
}
