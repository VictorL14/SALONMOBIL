package Controller;
import Entity.KategoriEntity;
import Entity.JenisEntity;
import java.util.ArrayList;
public class KategoriController {
    public void insertKategori(int kode_kategori, String nama_kategori, int kode_jenis){
        KategoriEntity kategoriEntity = new KategoriEntity();
        kategoriEntity.setKode_kategori(kode_kategori);
        kategoriEntity.setNama_kategori(nama_kategori);
        kategoriEntity.setKode_jenis(kode_jenis);
        AllObjectModel.kategoriModel.insertKategori(kategoriEntity);
    }

    public ArrayList<KategoriEntity> getdataKategori(){
        return AllObjectModel.kategoriModel.getALLKategori();
    }

    /*public ArrayList<KategoriEntity> getbyidKategori(int kode_kategori){
        return AllObjectModel.kategoriModel.getKategori(kode_kategori);
    }*/

    public void joinJenis(){
        KategoriEntity kategoriEntity = new KategoriEntity();
        JenisEntity jenisEntity = new JenisEntity();
        kategoriEntity.getKode_kategori();
        kategoriEntity.getNama_kategori();
        kategoriEntity.getKode_jenis();
        jenisEntity.getKode_jenis();
        jenisEntity.getNama_jenis();
    }

    public void deleteKategori(int kode_kategori){
        AllObjectModel.kategoriModel.deleteKategori(kode_kategori);
    }

    public void updateKategori(int kode_kategori, String nama_kategori, int kode_jenis){
        KategoriEntity kategoriEntity = new KategoriEntity();
        kategoriEntity.setKode_kategori(kode_kategori);
        kategoriEntity.setNama_kategori(nama_kategori);
        kategoriEntity.setKode_jenis(kode_jenis);
        AllObjectModel.kategoriModel.updateKategori(kategoriEntity);
    }
}
