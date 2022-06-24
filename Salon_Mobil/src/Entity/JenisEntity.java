package Entity;

public class JenisEntity {
    protected int kode_jenis;
    protected String nama_jenis;

    public JenisEntity(int kode_jenis, String nama_jenis){
        this.kode_jenis = kode_jenis;
        this.nama_jenis = nama_jenis;
    }
    public JenisEntity(){
    }

    public int getKode_jenis() {
        return kode_jenis;
    }
    public String getNama_jenis() {
        return nama_jenis;
    }

    public void setKode_jenis(int kode_jenis) {
        this.kode_jenis = kode_jenis;
    }
    public void setNama_jenis(String nama_jenis) {
        this.nama_jenis = nama_jenis;
    }
}
