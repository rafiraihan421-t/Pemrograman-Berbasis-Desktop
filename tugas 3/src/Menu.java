import java.util.ArrayList;
import java.io.*;

public class Menu {
    private ArrayList<MenuItem> daftarMenu = new ArrayList<>();

    // ==================== CRUD ====================

    public void tambah(MenuItem item) {
        daftarMenu.add(item);
    }

    public void hapus(int index) {
        if (index < 0 || index >= daftarMenu.size())
            throw new IndexOutOfBoundsException("Index menu tidak valid: " + index);
        daftarMenu.remove(index);
    }

    public MenuItem get(int index) {
        if (index < 0 || index >= daftarMenu.size())
            throw new IndexOutOfBoundsException("Index menu tidak valid: " + index);
        return daftarMenu.get(index);
    }

    public int size() {
        return daftarMenu.size();
    }

    public ArrayList<MenuItem> getDaftar() {
        return daftarMenu;
    }

    // ==================== CARI ====================

    public MenuItem cari(String nama) throws MenuNotFoundException {
        String namaInput = nama.trim().toLowerCase();
        for (MenuItem item : daftarMenu) {
            if (item.getNama().toLowerCase().equals(namaInput)) return item;
        }
        throw new MenuNotFoundException("Menu '" + nama + "' tidak ditemukan.");
    }

    // ==================== FILE I/O ====================

    public void simpanKeFile(String namaFile) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile));
        for (MenuItem item : daftarMenu) {
            String tipe;
            String extra;
            if (item instanceof Makanan) {
                tipe  = "makanan";
                extra = ((Makanan) item).getJenisMakanan();
            } else if (item instanceof Minuman) {
                tipe  = "minuman";
                extra = ((Minuman) item).getJenisMinuman();
            } else {
                tipe  = "diskon";
                extra = String.valueOf(((Diskon) item).getDiskon());
            }
            // Format: tipe|nama|harga|extra
            bw.write(tipe + "|" + item.getNama() + "|" + item.getHarga() + "|" + extra);
            bw.newLine();
        }
        bw.close();
    }
// function operasi file
    public void muatDariFile(String namaFile) throws IOException {
        File f = new File(namaFile);
        if (!f.exists()) return;
        daftarMenu.clear();
        BufferedReader br = new BufferedReader(new FileReader(namaFile));
        String baris;
        while ((baris = br.readLine()) != null) {
            String[] parts = baris.split("\\|");
            if (parts.length != 4) continue;
            String tipe  = parts[0].trim();
            String nama  = parts[1].trim();
            double harga = Double.parseDouble(parts[2].trim());
            String extra = parts[3].trim();
            if (tipe.equals("makanan")) {
                daftarMenu.add(new Makanan(nama, harga, extra));
            } else if (tipe.equals("minuman")) {
                daftarMenu.add(new Minuman(nama, harga, extra));
            } else if (tipe.equals("diskon")) {
                daftarMenu.add(new Diskon(nama, harga, Double.parseDouble(extra)));
            }
        }
        br.close();
    }
}
