package Entity;

public class TransaksiEntity {
    protected int id_transaksi;
    protected String no_polisi;
    protected int kode_kategori;
    protected int biaya;
    protected String item;
    protected String type_mobil;
    protected String tanggal;

    public TransaksiEntity(int id_transaksi, String no_polisi, int kode_kategori, int biaya, String item, String type_mobil, String tanggal){
        this.id_transaksi = id_transaksi;
        this.no_polisi = no_polisi;
        this.kode_kategori = kode_kategori;
        this.biaya = biaya;
        this.item = item;
        this.type_mobil = type_mobil;
        this.tanggal = tanggal;
    }
    public TransaksiEntity() {
    }
    public int getId_transaksi() {return id_transaksi;}
    public String getNo_polisi() {return no_polisi;}
    public int getKode_kategori() {return kode_kategori;}
    public int getBiaya() {return biaya;}
    public String getItem() {return item;}
    public String getType_mobil() {return type_mobil;}
    public String getTanggal() {return tanggal;}

    public void setId_transaksi(int id_transaksi) {this.id_transaksi = id_transaksi;}
    public void setNo_polisi(String no_polisi) {this.no_polisi = no_polisi;}
    public void setKode_kategori(int kode_kategori) {this.kode_kategori = kode_kategori;}

    public void setBiaya(int biaya) {this.biaya = biaya;}
    public void setItem(String item) {this.item = item;}
    public void setType_mobil(String type_mobil) {this.type_mobil = type_mobil;}
    public void setTanggal(String tanggal) {this.tanggal = tanggal;}
}
