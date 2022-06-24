package Entity;

public class KategoriEntity {
    protected int kode_kategori;
    protected String nama_kategori;
    protected int kode_jenis;

    public KategoriEntity(int kode_kategori, String nama_kategori, int kode_jenis){
        this.kode_kategori = kode_kategori;
        this.nama_kategori = nama_kategori;
        this.kode_jenis = kode_jenis;
    }

    public KategoriEntity(){
    }

    public int getKode_kategori() {
        return kode_kategori;
    }
    public String getNama_kategori() {
        return nama_kategori;
    }
    public int getKode_jenis() {
        return kode_jenis;
    }

    public void setKode_kategori(int kode_kategori) {
        this.kode_kategori = kode_kategori;
    }
    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
    public void setKode_jenis(int kode_jenis) {
        this.kode_jenis = kode_jenis;
    }
}
