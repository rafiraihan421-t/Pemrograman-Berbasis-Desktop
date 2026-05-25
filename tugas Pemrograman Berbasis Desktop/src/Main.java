import java.util.Scanner;

public class Main {

    // ===================== DATA MENU (dynamic array) =====================
    static Menu[] daftarMenu = {
        new Menu("Nasi Padang",  25000, "makanan"),
        new Menu("Ayam Bakar",   30000, "makanan"),
        new Menu("Mie Goreng",   20000, "makanan"),
        new Menu("Soto Ayam",    18000, "makanan"),
        new Menu("Nasi Goreng",  22000, "makanan"),
        new Menu("Es Teh Manis",  5000, "minuman"),
        new Menu("Jus Alpukat",  15000, "minuman"),
        new Menu("Es Jeruk",      7000, "minuman"),
        new Menu("Air Mineral",   4000, "minuman"),
        new Menu("Kopi Susu",    12000, "minuman")
    };
    static int jumlahMenu = 10;

    // Array pesanan
    static String[] namaPesanan   = new String[4];
    static int[]    jumlahPesanan = new int[4];
    static int      totalItemPesan = 0;

    // ==================== UTILITAS ARRAY MENU ====================

    // Tambah menu baru ke array (resize manual)
    static void tambahKeArray(Menu m) {
        Menu[] baru = new Menu[jumlahMenu + 1];
        if (jumlahMenu >= 1) baru[0] = daftarMenu[0];
        if (jumlahMenu >= 2) baru[1] = daftarMenu[1];
        if (jumlahMenu >= 3) baru[2] = daftarMenu[2];
        if (jumlahMenu >= 4) baru[3] = daftarMenu[3];
        if (jumlahMenu >= 5) baru[4] = daftarMenu[4];
        if (jumlahMenu >= 6) baru[5] = daftarMenu[5];
        if (jumlahMenu >= 7) baru[6] = daftarMenu[6];
        if (jumlahMenu >= 8) baru[7] = daftarMenu[7];
        if (jumlahMenu >= 9) baru[8] = daftarMenu[8];
        if (jumlahMenu >= 10) baru[9] = daftarMenu[9];
        if (jumlahMenu >= 11) baru[10] = daftarMenu[10];
        if (jumlahMenu >= 12) baru[11] = daftarMenu[11];
        if (jumlahMenu >= 13) baru[12] = daftarMenu[12];
        if (jumlahMenu >= 14) baru[13] = daftarMenu[13];
        if (jumlahMenu >= 15) baru[14] = daftarMenu[14];
        if (jumlahMenu >= 16) baru[15] = daftarMenu[15];
        if (jumlahMenu >= 17) baru[16] = daftarMenu[16];
        if (jumlahMenu >= 18) baru[17] = daftarMenu[17];
        if (jumlahMenu >= 19) baru[18] = daftarMenu[18];
        if (jumlahMenu >= 20) baru[19] = daftarMenu[19];
        baru[jumlahMenu] = m;
        daftarMenu = baru;
        jumlahMenu++;
    }

    // Hapus menu dari array berdasarkan index (resize manual)
    static void hapusDariArray(int index) {
        Menu[] baru = new Menu[jumlahMenu - 1];
        int j = 0;
        if (index != 0  && jumlahMenu > 0)  { if (j < jumlahMenu - 1) baru[j++] = daftarMenu[0]; }
        else if (jumlahMenu > 0 && index != 0) baru[j++] = daftarMenu[0];

        // Salin manual semua elemen kecuali index yang dihapus
        int i = 0;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; } i++;
        if (i != index && i < jumlahMenu) { baru[j] = daftarMenu[i]; j++; }

        daftarMenu = baru;
        jumlahMenu--;
    }

    // ==================== TAMPILKAN MENU ====================

    static void tampilkanMenu() {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║         SELAMAT DATANG DI RESTORAN MUNI         ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println();
        tampilkanDaftarMenu();
    }

    // Tampilkan daftar menu dikelompokkan per kategori (tanpa heading welcome)
    static void tampilkanDaftarMenu() {
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│                  MENU MAKANAN                    │");
        System.out.println("├────┬────────────────────────────┬────────────────┤");
        System.out.println("│ No │ Nama Menu                  │ Harga          │");
        System.out.println("├────┼────────────────────────────┼────────────────┤");

        int noMakanan = 1;
        int idx = 0;
        boolean adaMakanan = false;
        while (idx < jumlahMenu) {
            if (daftarMenu[idx].getKategori().equals("makanan")) {
                System.out.printf("│ %-2d │ %-26s │ Rp %,-10.0f │%n",
                    noMakanan++, daftarMenu[idx].getNama(), daftarMenu[idx].getHarga());
                adaMakanan = true;
            }
            idx++;
        }
        if (!adaMakanan) {
            System.out.println("│ (Belum ada menu makanan)                         │");
        }
        System.out.println("└────┴────────────────────────────┴────────────────┘");

        System.out.println();
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│                  MENU MINUMAN                    │");
        System.out.println("├────┬────────────────────────────┬────────────────┤");
        System.out.println("│ No │ Nama Menu                  │ Harga          │");
        System.out.println("├────┼────────────────────────────┼────────────────┤");

        int noMinuman = 1;
        idx = 0;
        boolean adaMinuman = false;
        while (idx < jumlahMenu) {
            if (daftarMenu[idx].getKategori().equals("minuman")) {
                System.out.printf("│ %-2d │ %-26s │ Rp %,-10.0f │%n",
                    noMinuman++, daftarMenu[idx].getNama(), daftarMenu[idx].getHarga());
                adaMinuman = true;
            }
            idx++;
        }
        if (!adaMinuman) {
            System.out.println("│ (Belum ada menu minuman)                         │");
        }
        System.out.println("└────┴────────────────────────────┴────────────────┘");
        System.out.println();
    }

    // Tampilkan daftar menu dengan nomor global (untuk manajemen ubah/hapus)
    static void tampilkanMenuBernomor() {
        System.out.println("┌────┬────────────────────────────┬────────────────┬──────────┐");
        System.out.println("│ No │ Nama Menu                  │ Harga          │ Kategori │");
        System.out.println("├────┼────────────────────────────┼────────────────┼──────────┤");
        int i = 0;
        while (i < jumlahMenu) {
            System.out.printf("│ %-2d │ %-26s │ Rp %,-10.0f │ %-8s │%n",
                (i + 1), daftarMenu[i].getNama(), daftarMenu[i].getHarga(), daftarMenu[i].getKategori());
            i++;
        }
        System.out.println("└────┴────────────────────────────┴────────────────┴──────────┘");
        System.out.println();
    }

    // ==================== CARI MENU ====================

    static Menu cariMenu(String nama) {
        String namaInput = nama.trim().toLowerCase();
        int i = 0;
        while (i < jumlahMenu) {
            if (daftarMenu[i].getNama().toLowerCase().equals(namaInput)) return daftarMenu[i];
            i++;
        }
        return null;
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
                System.out.println("⚠ Pilihan tidak valid, silakan masukkan 1, 2, atau 0.\n");
            }
        }
    }

    // ==================== MENU PELANGGAN ====================

    static void menuPelanggan(Scanner sc) {
        // Reset pesanan
        namaPesanan   = new String[4];
        jumlahPesanan = new int[4];
        totalItemPesan = 0;

        tampilkanMenu();
        inputPesanan(sc);

        if (totalItemPesan == 0) {
            System.out.println("Tidak ada pesanan. Kembali ke menu utama.\n");
            return;
        }
        cetakStruk();

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
                System.out.println("⚠ Pilihan tidak valid, silakan masukkan 1, 2, 3, 4, atau 0.\n");
            }
        }
    }

    // ==================== TAMBAH MENU BARU ====================

    static void tambahMenuBaru(Scanner sc) {
        System.out.println("\n── TAMBAH MENU BARU ──");

        // Input nama
        System.out.print("Nama menu baru: ");
        String nama = sc.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("⚠ Nama tidak boleh kosong. Dibatalkan.\n");
            return;
        }

        // Input harga
        double harga = 0;
        boolean hargaValid = false;
        while (!hargaValid) {
            System.out.print("Harga (Rp): ");
            String inputHarga = sc.nextLine().trim();
            try {
                harga = Double.parseDouble(inputHarga);
                if (harga <= 0) {
                    System.out.println("⚠ Harga harus lebih dari 0, coba lagi.");
                } else {
                    hargaValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input harga tidak valid, coba lagi.");
            }
        }

        // Input kategori
        String kategori = "";
        boolean katValid = false;
        while (!katValid) {
            System.out.print("Kategori (makanan/minuman): ");
            String inputKat = sc.nextLine().trim().toLowerCase();
            if (inputKat.equals("makanan") || inputKat.equals("minuman")) {
                kategori = inputKat;
                katValid = true;
            } else {
                System.out.println("⚠ Kategori harus 'makanan' atau 'minuman', coba lagi.");
            }
        }

        // Konfirmasi
        System.out.println("\nKonfirmasi penambahan menu:");
        System.out.printf("  Nama     : %s%n", nama);
        System.out.printf("  Harga    : Rp %,.0f%n", harga);
        System.out.printf("  Kategori : %s%n", kategori);

        boolean konfirmValid = false;
        while (!konfirmValid) {
            System.out.print("Yakin ingin menambahkan menu ini? (Ya/Tidak): ");
            String konfirm = sc.nextLine().trim();
            if (konfirm.equalsIgnoreCase("Ya")) {
                tambahKeArray(new Menu(nama, harga, kategori));
                System.out.println("✔ Menu '" + nama + "' berhasil ditambahkan.\n");
                konfirmValid = true;
            } else if (konfirm.equalsIgnoreCase("Tidak")) {
                System.out.println("✘ Penambahan dibatalkan.\n");
                konfirmValid = true;
            } else {
                System.out.println("⚠ Input tidak valid, ketik 'Ya' atau 'Tidak'.");
            }
        }
    }

    // ==================== UBAH HARGA MENU ====================

    static void ubahHargaMenu(Scanner sc) {
        System.out.println("\n── UBAH HARGA MENU ──");
        System.out.println("Daftar menu saat ini:");
        tampilkanMenuBernomor();

        // Pilih nomor menu
        int nomorMenu = 0;
        boolean nomorValid = false;
        while (!nomorValid) {
            System.out.print("Masukkan nomor menu yang ingin diubah harganya (0 = batal): ");
            String inputNo = sc.nextLine().trim();
            try {
                nomorMenu = Integer.parseInt(inputNo);
                if (nomorMenu == 0) {
                    System.out.println("✘ Dibatalkan.\n");
                    return;
                }
                if (nomorMenu >= 1 && nomorMenu <= jumlahMenu) {
                    nomorValid = true;
                } else {
                    System.out.println("⚠ Nomor tidak valid, masukkan angka 1 - " + jumlahMenu + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input tidak valid, masukkan angka.");
            }
        }

        Menu menuDipilih = daftarMenu[nomorMenu - 1];
        System.out.printf("Menu dipilih: %s (Harga saat ini: Rp %,.0f)%n",
            menuDipilih.getNama(), menuDipilih.getHarga());

        // Input harga baru
        double hargaBaru = 0;
        boolean hargaValid = false;
        while (!hargaValid) {
            System.out.print("Harga baru (Rp): ");
            String inputHarga = sc.nextLine().trim();
            try {
                hargaBaru = Double.parseDouble(inputHarga);
                if (hargaBaru <= 0) {
                    System.out.println("⚠ Harga harus lebih dari 0, coba lagi.");
                } else {
                    hargaValid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input tidak valid, coba lagi.");
            }
        }

        // Konfirmasi
        System.out.println("\nKonfirmasi perubahan harga:");
        System.out.printf("  Menu      : %s%n", menuDipilih.getNama());
        System.out.printf("  Harga lama: Rp %,.0f%n", menuDipilih.getHarga());
        System.out.printf("  Harga baru: Rp %,.0f%n", hargaBaru);

        boolean konfirmValid = false;
        while (!konfirmValid) {
            System.out.print("Yakin ingin mengubah harga? (Ya/Tidak): ");
            String konfirm = sc.nextLine().trim();
            if (konfirm.equalsIgnoreCase("Ya")) {
                menuDipilih.setHarga(hargaBaru);
                System.out.println("✔ Harga '" + menuDipilih.getNama() + "' berhasil diubah.\n");
                konfirmValid = true;
            } else if (konfirm.equalsIgnoreCase("Tidak")) {
                System.out.println("✘ Perubahan dibatalkan.\n");
                konfirmValid = true;
            } else {
                System.out.println("⚠ Input tidak valid, ketik 'Ya' atau 'Tidak'.");
            }
        }
    }

    // ==================== HAPUS MENU ====================

    static void hapusMenu(Scanner sc) {
        System.out.println("\n── HAPUS MENU ──");

        if (jumlahMenu == 0) {
            System.out.println("⚠ Tidak ada menu untuk dihapus.\n");
            return;
        }

        System.out.println("Daftar menu saat ini:");
        tampilkanMenuBernomor();

        // Pilih nomor menu
        int nomorMenu = 0;
        boolean nomorValid = false;
        while (!nomorValid) {
            System.out.print("Masukkan nomor menu yang ingin dihapus (0 = batal): ");
            String inputNo = sc.nextLine().trim();
            try {
                nomorMenu = Integer.parseInt(inputNo);
                if (nomorMenu == 0) {
                    System.out.println("✘ Dibatalkan.\n");
                    return;
                }
                if (nomorMenu >= 1 && nomorMenu <= jumlahMenu) {
                    nomorValid = true;
                } else {
                    System.out.println("⚠ Nomor tidak valid, masukkan angka 1 - " + jumlahMenu + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input tidak valid, masukkan angka.");
            }
        }

        Menu menuDipilih = daftarMenu[nomorMenu - 1];

        // Konfirmasi
        System.out.println("\nKonfirmasi penghapusan:");
        System.out.printf("  Menu yang akan dihapus: %s (Rp %,.0f — %s)%n",
            menuDipilih.getNama(), menuDipilih.getHarga(), menuDipilih.getKategori());

        boolean konfirmValid = false;
        while (!konfirmValid) {
            System.out.print("Yakin ingin menghapus menu ini? (Ya/Tidak): ");
            String konfirm = sc.nextLine().trim();
            if (konfirm.equalsIgnoreCase("Ya")) {
                String namaHapus = menuDipilih.getNama();
                hapusDariArray(nomorMenu - 1);
                System.out.println("✔ Menu '" + namaHapus + "' berhasil dihapus.\n");
                konfirmValid = true;
            } else if (konfirm.equalsIgnoreCase("Tidak")) {
                System.out.println("✘ Penghapusan dibatalkan.\n");
                konfirmValid = true;
            } else {
                System.out.println("⚠ Input tidak valid, ketik 'Ya' atau 'Tidak'.");
            }
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

        int slot = 0;

        // ---- Pesanan ke-1 ----
        if (slot < 4) {
            System.out.print("Pesanan " + (slot + 1) + ": ");
            String input1 = sc.nextLine().trim();
            if (!input1.equalsIgnoreCase("selesai") && !input1.isEmpty()) {
                String[] parts1 = input1.split("=");
                if (parts1.length == 2) {
                    String namaMenu1 = parts1[0].trim();
                    int qty1 = Integer.parseInt(parts1[1].trim());
                    Menu m1 = cariMenu(namaMenu1);
                    if (m1 != null) {
                        namaPesanan[slot]   = m1.getNama();
                        jumlahPesanan[slot] = qty1;
                        slot++;
                        System.out.println("✔ " + m1.getNama() + " x" + qty1 + " ditambahkan.");
                    } else { System.out.println("✘ Menu tidak ditemukan, pesanan diabaikan."); }
                } else { System.out.println("✘ Format salah, pesanan diabaikan."); }
            } else { totalItemPesan = slot; return; }
        }

        // ---- Pesanan ke-2 ----
        if (slot < 4) {
            System.out.print("Pesanan " + (slot + 1) + ": ");
            String input2 = sc.nextLine().trim();
            if (!input2.equalsIgnoreCase("selesai") && !input2.isEmpty()) {
                String[] parts2 = input2.split("=");
                if (parts2.length == 2) {
                    String namaMenu2 = parts2[0].trim();
                    int qty2 = Integer.parseInt(parts2[1].trim());
                    Menu m2 = cariMenu(namaMenu2);
                    if (m2 != null) {
                        namaPesanan[slot]   = m2.getNama();
                        jumlahPesanan[slot] = qty2;
                        slot++;
                        System.out.println("✔ " + m2.getNama() + " x" + qty2 + " ditambahkan.");
                    } else { System.out.println("✘ Menu tidak ditemukan, pesanan diabaikan."); }
                } else { System.out.println("✘ Format salah, pesanan diabaikan."); }
            } else { totalItemPesan = slot; return; }
        }

        // ---- Pesanan ke-3 ----
        if (slot < 4) {
            System.out.print("Pesanan " + (slot + 1) + ": ");
            String input3 = sc.nextLine().trim();
            if (!input3.equalsIgnoreCase("selesai") && !input3.isEmpty()) {
                String[] parts3 = input3.split("=");
                if (parts3.length == 2) {
                    String namaMenu3 = parts3[0].trim();
                    int qty3 = Integer.parseInt(parts3[1].trim());
                    Menu m3 = cariMenu(namaMenu3);
                    if (m3 != null) {
                        namaPesanan[slot]   = m3.getNama();
                        jumlahPesanan[slot] = qty3;
                        slot++;
                        System.out.println("✔ " + m3.getNama() + " x" + qty3 + " ditambahkan.");
                    } else { System.out.println("✘ Menu tidak ditemukan, pesanan diabaikan."); }
                } else { System.out.println("✘ Format salah, pesanan diabaikan."); }
            } else { totalItemPesan = slot; return; }
        }

        // ---- Pesanan ke-4 ----
        if (slot < 4) {
            System.out.print("Pesanan " + (slot + 1) + ": ");
            String input4 = sc.nextLine().trim();
            if (!input4.equalsIgnoreCase("selesai") && !input4.isEmpty()) {
                String[] parts4 = input4.split("=");
                if (parts4.length == 2) {
                    String namaMenu4 = parts4[0].trim();
                    int qty4 = Integer.parseInt(parts4[1].trim());
                    Menu m4 = cariMenu(namaMenu4);
                    if (m4 != null) {
                        namaPesanan[slot]   = m4.getNama();
                        jumlahPesanan[slot] = qty4;
                        slot++;
                        System.out.println("✔ " + m4.getNama() + " x" + qty4 + " ditambahkan.");
                    } else { System.out.println("✘ Menu tidak ditemukan, pesanan diabaikan."); }
                } else { System.out.println("✘ Format salah, pesanan diabaikan."); }
            }
        }

        totalItemPesan = slot;
    }

    // ==================== PERHITUNGAN ====================

    static double hitungSubtotal(int indexPesanan) {
        String nama = namaPesanan[indexPesanan];
        int    qty  = jumlahPesanan[indexPesanan];
        Menu   m    = cariMenu(nama);
        if (m == null) return 0;
        return m.getHarga() * qty;
    }

    static double hitungTotalKeseluruhan() {
        double total = 0;
        if (totalItemPesan >= 1) total += hitungSubtotal(0);
        if (totalItemPesan >= 2) total += hitungSubtotal(1);
        if (totalItemPesan >= 3) total += hitungSubtotal(2);
        if (totalItemPesan >= 4) total += hitungSubtotal(3);
        return total;
    }

    static boolean adaMinuman() {
        boolean ada = false;
        if (totalItemPesan >= 1) {
            Menu m = cariMenu(namaPesanan[0]);
            if (m != null && m.getKategori().equals("minuman")) ada = true;
        }
        if (totalItemPesan >= 2) {
            Menu m = cariMenu(namaPesanan[1]);
            if (m != null && m.getKategori().equals("minuman")) ada = true;
        }
        if (totalItemPesan >= 3) {
            Menu m = cariMenu(namaPesanan[2]);
            if (m != null && m.getKategori().equals("minuman")) ada = true;
        }
        if (totalItemPesan >= 4) {
            Menu m = cariMenu(namaPesanan[3]);
            if (m != null && m.getKategori().equals("minuman")) ada = true;
        }
        return ada;
    }

    static String namaMinumanPertama() {
        if (totalItemPesan >= 1) {
            Menu m = cariMenu(namaPesanan[0]);
            if (m != null && m.getKategori().equals("minuman")) return m.getNama();
        }
        if (totalItemPesan >= 2) {
            Menu m = cariMenu(namaPesanan[1]);
            if (m != null && m.getKategori().equals("minuman")) return m.getNama();
        }
        if (totalItemPesan >= 3) {
            Menu m = cariMenu(namaPesanan[2]);
            if (m != null && m.getKategori().equals("minuman")) return m.getNama();
        }
        if (totalItemPesan >= 4) {
            Menu m = cariMenu(namaPesanan[3]);
            if (m != null && m.getKategori().equals("minuman")) return m.getNama();
        }
        return "-";
    }

    static double hargaMinumanPertama() {
        if (totalItemPesan >= 1) {
            Menu m = cariMenu(namaPesanan[0]);
            if (m != null && m.getKategori().equals("minuman")) return m.getHarga();
        }
        if (totalItemPesan >= 2) {
            Menu m = cariMenu(namaPesanan[1]);
            if (m != null && m.getKategori().equals("minuman")) return m.getHarga();
        }
        if (totalItemPesan >= 3) {
            Menu m = cariMenu(namaPesanan[2]);
            if (m != null && m.getKategori().equals("minuman")) return m.getHarga();
        }
        if (totalItemPesan >= 4) {
            Menu m = cariMenu(namaPesanan[3]);
            if (m != null && m.getKategori().equals("minuman")) return m.getHarga();
        }
        return 0;
    }

    // ==================== CETAK STRUK ====================

    static void cetakStruk() {
        double totalKeseluruhan  = hitungTotalKeseluruhan();
        boolean diskon10Persen   = totalKeseluruhan > 100000;
        boolean promoMinuman     = totalKeseluruhan > 50000 && adaMinuman();

        double nilaiDiskon10     = diskon10Persen ? totalKeseluruhan * 0.10 : 0;
        double nilaiPromoMinuman = promoMinuman    ? hargaMinumanPertama()  : 0;
        double totalSetelahDiskon = totalKeseluruhan - nilaiDiskon10 - nilaiPromoMinuman;

        double pajak10Persen  = totalSetelahDiskon * 0.10;
        double biayaPelayanan = 20000;
        double totalBayar     = totalSetelahDiskon + pajak10Persen + biayaPelayanan;

        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║              STRUK PEMBAYARAN                       ║");
        System.out.println("║              RESTORAN MUNI                          ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  No   Nama Item                Qty    Total          ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");

        if (totalItemPesan >= 1) {
            Menu m = cariMenu(namaPesanan[0]);
            if (m != null) {
                double sub = m.getHarga() * jumlahPesanan[0];
                System.out.printf("║  1    %-22s  %-5d  Rp %,-9.0f ║%n", m.getNama(), jumlahPesanan[0], sub);
                System.out.printf("║       @ Rp %,-37.0f ║%n", m.getHarga());
            }
        }
        if (totalItemPesan >= 2) {
            Menu m = cariMenu(namaPesanan[1]);
            if (m != null) {
                double sub = m.getHarga() * jumlahPesanan[1];
                System.out.printf("║  2    %-22s  %-5d  Rp %,-9.0f ║%n", m.getNama(), jumlahPesanan[1], sub);
                System.out.printf("║       @ Rp %,-37.0f ║%n", m.getHarga());
            }
        }
        if (totalItemPesan >= 3) {
            Menu m = cariMenu(namaPesanan[2]);
            if (m != null) {
                double sub = m.getHarga() * jumlahPesanan[2];
                System.out.printf("║  3    %-22s  %-5d  Rp %,-9.0f ║%n", m.getNama(), jumlahPesanan[2], sub);
                System.out.printf("║       @ Rp %,-37.0f ║%n", m.getHarga());
            }
        }
        if (totalItemPesan >= 4) {
            Menu m = cariMenu(namaPesanan[3]);
            if (m != null) {
                double sub = m.getHarga() * jumlahPesanan[3];
                System.out.printf("║  4    %-22s  %-5d  Rp %,-9.0f ║%n", m.getNama(), jumlahPesanan[3], sub);
                System.out.printf("║       @ Rp %,-37.0f ║%n", m.getHarga());
            }
        }

        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf( "║  Total Keseluruhan                    Rp %,-9.0f ║%n", totalKeseluruhan);

        if (diskon10Persen) {
            System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  *** DISKON BERLAKU ***                              ║");
            System.out.printf( "║  Diskon 10%% (total > Rp 100.000)   -Rp %,-9.0f ║%n", nilaiDiskon10);
        }
        if (promoMinuman) {
            if (!diskon10Persen) System.out.println("╠══════════════════════════════════════════════════════╣");
            System.out.println("║  *** PROMO BELI 1 GRATIS 1 MINUMAN ***               ║");
            System.out.printf( "║  Gratis 1x %-28s  -Rp %,-9.0f ║%n", namaMinumanPertama(), nilaiPromoMinuman);
        }
        if (diskon10Persen || promoMinuman) {
            System.out.printf("║  Total Setelah Diskon/Promo           Rp %,-9.0f ║%n", totalSetelahDiskon);
        }

        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf( "║  Pajak 10%%                            Rp %,-9.0f ║%n", pajak10Persen);
        System.out.printf( "║  Biaya Pelayanan                      Rp %,-9.0f ║%n", biayaPelayanan);
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf( "║  TOTAL BAYAR                          Rp %,-9.0f ║%n", totalBayar);
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  Keterangan:                                         ║");

        if (diskon10Persen && promoMinuman) {
            System.out.println("║  ✔ Diskon 10% diterapkan (total > Rp 100.000)        ║");
            System.out.println("║  ✔ Promo beli 1 gratis 1 minuman diterapkan          ║");
        } else if (diskon10Persen) {
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

    // ==================== MAIN ====================

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuUtama(sc);
        sc.close();
    }
}
