//class execption jika ada error seperti menu tidak ditemukangg
public class MenuNotFoundException extends Exception {
    public MenuNotFoundException(String pesan) {
        super(pesan);
    }
}
