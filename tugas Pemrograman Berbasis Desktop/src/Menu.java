
//point pertama kelas menu
public class Menu {
    private String nama;
    private double harga;
    private String kategori; // "makanan" atau "minuman"
//function menu
    public Menu(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }
//function mengambil nama
    public String getNama() {
        return nama;
    }
//function mengambil harga
    public double getHarga() {
        return harga;
    }
//function mengambil kategory seperti makanan/minuman
    public String getKategori() {
        return kategori;
    }

    public void setNama(String nama)    { this.nama = nama; }
    public void setHarga(double harga)  { this.harga = harga; }
    public void setKategori(String kat) { this.kategori = kat; }
}
