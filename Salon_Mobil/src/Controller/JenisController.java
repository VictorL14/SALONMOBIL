package Controller;
import Entity.JenisEntity;
import Model.JenisModel;

import java.util.ArrayList;
public class JenisController {
    public void insertJenis(int kode_jenis, String nama_jenis){
        JenisEntity jenisEntity = new JenisEntity();
        jenisEntity.setKode_jenis(kode_jenis);
        jenisEntity.setNama_jenis(nama_jenis);
        AllObjectModel.jenisModel.insertJenis(jenisEntity);
    }

    public ArrayList<JenisEntity> getAllJenis(){
        return AllObjectModel.jenisModel.getALLJenis();
    }

    public ArrayList<JenisEntity> getbyidJenis(int kode_jenis){
        return AllObjectModel.jenisModel.getJenis(kode_jenis);
    }

    public void deleteJenis(int kode_jenis){
        AllObjectModel.jenisModel.deleteJenis(kode_jenis);
    }

    public void updateJenis(int kode_jenis, String nama_jenis){
        JenisEntity jenisEntity = new JenisEntity();
        jenisEntity.setKode_jenis(kode_jenis);
        jenisEntity.setNama_jenis(nama_jenis);
        AllObjectModel.jenisModel.updateJenis(jenisEntity);
    }
}
