package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.DTO.CJSexoDTO;

public class CJSexoDAO extends CJSQLiteDataHelper implements CJIDAO<CJSexoDTO>{

    @Override
    public boolean create(CJSexoDTO entity) throws Exception {
        String query = " INSERT INTO CJSexo (Nombre) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CJSexoDTO> readAll() throws Exception {
        List <CJSexoDTO> lst = new ArrayList<>();
        String query =" SELECT IdCJSexo       " 
                     +" ,Nombre             " 
                     +" ,Estado             " 
                     +" ,FechaCreacion      " 
                     +" ,FechaModifica      "
                     +" FROM    CJSexo      "
                     +" WHERE   Estado ='A' ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                CJSexoDTO s = new CJSexoDTO( rs.getInt(1)     // IdCJSexo
                                            ,rs.getString(2)  // Nombre             
                                            ,rs.getString(3)  // Estado         
                                            ,rs.getString(4)  // FechaCreacion      
                                            ,rs.getString(5));// FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean update(CJSexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CJSexo SET Nombre = ?, FechaModifica = ? WHERE IdCJSexo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdCJSexo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CJSexo SET Estado = ? WHERE IdCJSexo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public CJSexoDTO readBy(Integer id) throws Exception {
        CJSexoDTO cjS = new CJSexoDTO();
        String query =" SELECT IdCJSexo  " 
                     +" ,Nombre        " 
                     +" ,Estado        " 
                     +" ,FechaCreacion " 
                     +" ,FechaModifica "
                     +" FROM    CJSexo   "
                     +" WHERE   Estado ='A' AND IdSexo =   " + id.toString() ;
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                cjS = new CJSexoDTO( rs.getInt(1)           // IdSexo
                                    ,rs.getString(2)        // Nombre             
                                    ,rs.getString(3)        // Estado         
                                    ,rs.getString(4)        // FechaCrea      
                                    ,rs.getString(5));      // FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return cjS;
    }

}
