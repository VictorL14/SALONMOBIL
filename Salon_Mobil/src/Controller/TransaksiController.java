package Controller;
import Entity.TransaksiEntity;
import java.util.ArrayList;
public class TransaksiController {
    public void insertTransaksi(int id_transaksi, String no_polisi, int kode_kategori, int biaya, String item, String type_mobil, String tanggal){
        TransaksiEntity transaksiEntity = new TransaksiEntity();
        transaksiEntity.setId_transaksi(id_transaksi);
        transaksiEntity.setNo_polisi(no_polisi);
        transaksiEntity.setKode_kategori(kode_kategori);
        transaksiEntity.setBiaya(biaya);
        transaksiEntity.setItem(item);
        transaksiEntity.setType_mobil(type_mobil);
        transaksiEntity.setTanggal(tanggal);
        AllObjectModel.transaksiModel.insertTransaksi(transaksiEntity);
    }

    public ArrayList<TransaksiEntity>getAllTransaksi(){
        return AllObjectModel.transaksiModel.getALLTransaksi();
    }

    public ArrayList<TransaksiEntity>getbyidTransaksi(int id_transaksi){
        return AllObjectModel.transaksiModel.getTransaksi(id_transaksi);
    }

    public void deleteTransaksi(int id_transaksi){
        AllObjectModel.transaksiModel.deleteTransaksi(id_transaksi);
    }

    public void updateTransaksi(int id_transaksi, String no_polisi, int kode_kategori, int biaya, String item, String type_mobil, String tanggal) {
        TransaksiEntity transaksiEntity = new TransaksiEntity();
        transaksiEntity.setId_transaksi(id_transaksi);
        transaksiEntity.setNo_polisi(no_polisi);
        transaksiEntity.setKode_kategori(kode_kategori);
        transaksiEntity.setBiaya(biaya);
        transaksiEntity.setItem(item);
        transaksiEntity.setType_mobil(type_mobil);
        transaksiEntity.setTanggal(tanggal);
        AllObjectModel.transaksiModel.updateTransaksi(transaksiEntity);
    }
}
