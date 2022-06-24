package Model;
import Entity.JenisEntity;
import Helper.KoneksiDB;

import java.sql.*;
import java.util.ArrayList;

public class JenisModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();
    public JenisModel(){
    }

    public ArrayList<JenisEntity>getALLJenis(){
        ArrayList arrayListJenis = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM jenis";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                JenisEntity jenisEntity = new JenisEntity();
                jenisEntity.setKode_jenis(rs.getInt("kode_jenis"));
                jenisEntity.setNama_jenis(rs.getString("nama_jenis"));
                arrayListJenis.add(jenisEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListJenis;
    }

    public ArrayList<JenisEntity>getJenis(int kode_jenis){
        ArrayList arrayListJenis = new ArrayList();
        try{
            sql = "SELECT * FROM jenis WHERE kode_jenis =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1,kode_jenis);
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                JenisEntity jenisEntity = new JenisEntity();
                jenisEntity.setKode_jenis(rs.getInt("kode_jenis"));
                jenisEntity.setNama_jenis(rs.getString("nama_jenis"));
                arrayListJenis.add(jenisEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListJenis;
    }

    public void insertJenis(JenisEntity jenisEntity){
        try {
            sql = "INSERT INTO jenis(kode_jenis, nama_jenis) VALUES(?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1, jenisEntity.getKode_jenis());
            stat.setString(2, jenisEntity.getNama_jenis());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        } 
    }

    public void updateJenis(String nama_jenis, int kode_jenis){
        try{
            sql = "UPDATE jenis SET nama_jenis =? WHERE kode_jenis =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1,nama_jenis);
            stat.setInt(2,kode_jenis);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void deleteJenis(int kode_jenis){
        try{
            sql = "DELETE FROM jenis WHERE kode_jenis =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setInt(1,kode_jenis);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
            System.out.println("failed to delete data!");
            e.printStackTrace();
        }
    }

    public void updateJenis(JenisEntity jenisEntity) {
    }
}
