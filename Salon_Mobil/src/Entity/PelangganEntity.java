package Entity;

public class PelangganEntity {
    protected String no_polisi;
    protected String nama_pelanggan;
    protected String alamat;
    protected String no_telp;

    public PelangganEntity(String no_polisi, String nama_pelanggan, String alamat, String no_telp){
        this.no_polisi = no_polisi;
        this.nama_pelanggan = nama_pelanggan;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }

    public PelangganEntity() {
    }
    public String getNo_polisi() {
        return no_polisi;
    }
    public String getNama_pelanggan() {
        return nama_pelanggan;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_polisi(String no_polisi) {
        this.no_polisi = no_polisi;
    }
    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }
}
