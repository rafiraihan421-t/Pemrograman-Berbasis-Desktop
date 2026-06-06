public class Diskon extends MenuItem {
    private double diskon; // e.g. 0.10 = diskon 10%

    public Diskon(String nama, double harga, double diskon) {
        super(nama, harga, "diskon");
        this.diskon = diskon;
    }

    public double getDiskon() { return diskon; }

    @Override
    public void tampilMenu() {
        System.out.printf("%-26s | Rp %,.0f | Diskon: %.0f%%%n", getNama(), getHarga(), diskon * 100);
    }
}
