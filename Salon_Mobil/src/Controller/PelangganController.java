package Controller;
import Entity.PelangganEntity;
import java.util.ArrayList;
public class PelangganController {
    public void insertPelanggan(String no_polisi, String nama_pelanggan, String alamat, String no_telp){
        PelangganEntity pelangganEntity  = new PelangganEntity();
        pelangganEntity.setNo_polisi(no_polisi);
        pelangganEntity.setNama_pelanggan(nama_pelanggan);
        pelangganEntity.setAlamat(alamat);
        pelangganEntity.setNo_telp(no_telp);
        AllObjectModel.pelangganModel.insertPelanggan(pelangganEntity);
    }

    public ArrayList<PelangganEntity>getAllPelanggan(){
        return AllObjectModel.pelangganModel.getALLPelanggan();
    }
    public ArrayList<PelangganEntity>getbyidPelanggan(String no_polisi){
        return AllObjectModel.pelangganModel.getPelanggan(no_polisi);
    }
    public void deletePelanggan(String no_polisi){
        AllObjectModel.pelangganModel.deletePelanggan(no_polisi);
    }
    public void updatePelanggan(String no_polisi, String nama_pelanggan, String alamat, String no_telp){
        PelangganEntity pelangganEntity  = new PelangganEntity();
        pelangganEntity.setNo_polisi(no_polisi);
        pelangganEntity.setNama_pelanggan(nama_pelanggan);
        pelangganEntity.setAlamat(alamat);
        pelangganEntity.setNo_telp(no_telp);
        AllObjectModel.pelangganModel.updatePelanggan(pelangganEntity);
    }
}
