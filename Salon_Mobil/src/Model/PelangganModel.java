package Model;
import Entity.KategoriEntity;
import Entity.PelangganEntity;
import Helper.KoneksiDB;

import java.sql.*;
import java.util.ArrayList;

public class PelangganModel {
    private String sql;
    public Connection conn07302 = KoneksiDB.getconection();

    public ArrayList<PelangganEntity> getALLPelanggan(){
        ArrayList arrayListPelanggan = new ArrayList();
        try{
            Statement stat = conn07302.createStatement();
            sql = "SELECT * FROM pelanggan";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PelangganEntity pelangganEntity  = new PelangganEntity();
                pelangganEntity.setNo_polisi(rs.getString("no_polisi"));
                pelangganEntity.setNama_pelanggan(rs.getString("nama_pelanggan"));
                pelangganEntity.setAlamat(rs.getString("alamat"));
                pelangganEntity.setNo_telp(rs.getString("no_telp"));
                arrayListPelanggan.add(pelangganEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListPelanggan;
    }

    public ArrayList<PelangganEntity>getPelanggan(String no_polisi){
        ArrayList arrayListPelanggan = new ArrayList();
        try{
            sql = "SELECT * FROM pelanggan WHERE no_polisi =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, no_polisi);
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                PelangganEntity pelangganEntity= new PelangganEntity();
                pelangganEntity.setNo_polisi(rs.getString("no_polisi"));
                pelangganEntity.setNama_pelanggan(rs.getString("nama_pelanggan"));
                pelangganEntity.setAlamat(rs.getString("alamat"));
                pelangganEntity.setNo_telp(rs.getString("no_telp"));
                arrayListPelanggan.add(pelangganEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }return arrayListPelanggan;
    }

    public void insertPelanggan(PelangganEntity pelangganEntity){
        try {
            sql = "INSERT INTO pelanggan(no_polisi, nama_pelanggan, alamat, no_telp) VALUES(?,?,?,?)";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, pelangganEntity.getNo_polisi());
            stat.setString(2, pelangganEntity.getNama_pelanggan());
            stat.setString(3, pelangganEntity.getAlamat());
            stat.setString(4, pelangganEntity.getNo_telp());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to insert data!");
            e.printStackTrace();
        }
    }

    public void updatePelanggan(PelangganEntity pelangganEntity){
        try{
            sql = "UPDATE pelanggan SET nama_pelanggan =?, alamat =?, no_telp =? WHERE no_polisi =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, pelangganEntity.getNama_pelanggan());
            stat.setString(2, pelangganEntity.getAlamat());
            stat.setString(3, pelangganEntity.getNo_telp());
            stat.setString(4, pelangganEntity.getNo_polisi());
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        } catch (SQLException e) {
            System.out.println("failed to update data!");
            e.printStackTrace();
        }
    }

    public void deletePelanggan(String no_polisi){
        try{
            sql = "DELETE FROM pelanggan WHERE no_polisi =?";
            PreparedStatement stat = conn07302.prepareStatement(sql);
            stat.setString(1, no_polisi);
            int rows = stat.executeUpdate();
            System.out.println(rows + "row(s) updated!");
        }catch (SQLException e) {
            System.out.println("failed to delete data!");
            e.printStackTrace();
        }
    }


}
