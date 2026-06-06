//abstraksi minuman
//inheritance dari class menuitem
public class Minuman extends MenuItem {
//    menggunakan private encapsulation
    private String jenisMinuman;

    public Minuman(String nama, double harga, String jenisMinuman) {
        super(nama, harga, "minuman");
        this.jenisMinuman = jenisMinuman;
    }

    public String getJenisMinuman() { return jenisMinuman; }
    //    polymorphisme karena class sama tetapi beda perilaku
    @Override
    public void tampilMenu() {
        System.out.printf("%-26s | Rp %,.0f | %s%n", getNama(), getHarga(), jenisMinuman);
    }
}
