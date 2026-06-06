import java.util.ArrayList;

public class Pesanan {
    private ArrayList<MenuItem> items    = new ArrayList<>();
    private ArrayList<Integer>  jumlah   = new ArrayList<>();

    public void tambah(MenuItem item, int qty) {
        items.add(item);
        jumlah.add(qty);
    }

    public void reset() {
        items.clear();
        jumlah.clear();
    }

    public int size() { return items.size(); }

    public MenuItem getItem(int i)   { return items.get(i); }
    public int      getJumlah(int i) { return jumlah.get(i); }

    public double hitungSubtotal(int i) {
        return items.get(i).getHarga() * jumlah.get(i);
    }

    public double hitungTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) total += hitungSubtotal(i);
        return total;
    }

    public boolean adaMinuman() {
        for (MenuItem item : items)
            if (item.getKategori().equals("minuman")) return true;
        return false;
    }

    public MenuItem minumanPertama() {
        for (MenuItem item : items)
            if (item.getKategori().equals("minuman")) return item;
        return null;
    }
}
