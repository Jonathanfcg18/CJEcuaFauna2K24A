package CJDataAccess;

import CJDataAccess.CJDTO.CJHormigaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class CJHormigaDAO extends CJSQLiteDataHelper implements CJIDAO<CJHormigaDTO> {

    private static final String DEFAULT_TIPO = "Larva";
    private static final String DEFAULT_ESTADO = "A";
    private static final String ESTADO_VIVO = "VIVA";
    private static final String ESTADO_MUERTO = "MUERTA";
    
    @Override
    public boolean cjCreate(CJHormigaDTO entity) throws Exception {
        String sql = "INSERT INTO CJHormiga (IdCJSexo, IdCJProvincia, Tipo, GenoAlimento, IngestaNativa, Estado, FechaCreacion) "
                   + "VALUES (?, ?, ?, ?, ?, ?, datetime('now','localtime'))";
        
        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Set default values
            int randomProvinciaId = getRandomProvinciaId(conn);
            String estado = DEFAULT_ESTADO;
            
            stmt.setInt(1, 3); // IdCJSexo default to 3
            stmt.setInt(2, randomProvinciaId); // Random IdCJProvincia
            stmt.setString(3, DEFAULT_TIPO); // Tipo default to "Larva"
            stmt.setString(4, ""); // GenoAlimento empty
            stmt.setString(5, ""); // IngestaNativa empty
            stmt.setString(6, estado); // Estado default to "A"

            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<CJHormigaDTO> cjReadAll() throws Exception {
        String sql = "SELECT * FROM CJHormiga";
        List<CJHormigaDTO> result = new ArrayList<>();

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                result.add(mapResultSetToDTO(rs, conn));
            }
        }
        return result;
    }

    @Override
    public CJHormigaDTO cjReadBy(Integer id) throws Exception {
        String sql = "SELECT * FROM CJHormiga WHERE IdCJHormiga = ?";
        CJHormigaDTO dto = null;

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    dto = mapResultSetToDTO(rs, conn);
                }
            }
        }
        return dto;
    }

    @Override
    public boolean cjUpdate(CJHormigaDTO entity) throws Exception {
        String sql = "UPDATE CJHormiga SET IdCJSexo = ?, IdCJProvincia = ?, Tipo = ?, GenoAlimento = ?, IngestaNativa = ?, Estado = ?, FechaModifica = datetime('now','localtime') WHERE IdCJHormiga = ?";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, entity.getIdCJSexo());
            stmt.setInt(2, entity.getIdCJProvincia());
            stmt.setString(3, entity.getTipo());
            stmt.setString(4, entity.getGenoAlimento());
            stmt.setString(5, entity.getIngestaNativa());
            stmt.setString(6, entity.getEstado().equals(ESTADO_VIVO) ? DEFAULT_ESTADO : "X");
            stmt.setInt(7, entity.getIdCJHormiga());

            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean cjDelete(int id) throws Exception {
        String sql = "DELETE FROM CJHormiga WHERE IdCJHormiga = ?";

        try (Connection conn = openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    private int getRandomProvinciaId(Connection conn) throws SQLException {
        String sql = "SELECT IdCJLocalidad FROM CJLocalidad ORDER BY RANDOM() LIMIT 1";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("IdCJLocalidad");
            }
        }
        return 0; // Or throw an exception if no provincia is found
    }

    private CJHormigaDTO mapResultSetToDTO(ResultSet rs, Connection conn) throws SQLException {
        CJHormigaDTO dto = new CJHormigaDTO();
        dto.setIdCJHormiga(rs.getInt("IdCJHormiga"));
        dto.setIdCJSexo(rs.getInt("IdCJSexo"));
        dto.setIdCJProvincia(rs.getInt("IdCJProvincia"));
        dto.setTipo(rs.getString("Tipo"));
        dto.setGenoAlimento(rs.getString("GenoAlimento"));
        dto.setIngestaNativa(rs.getString("IngestaNativa"));
        dto.setEstado(rs.getString("Estado").equals(DEFAULT_ESTADO) ? ESTADO_VIVO : ESTADO_MUERTO);
        dto.setFechaCreacion(rs.getString("FechaCreacion"));
        dto.setFechaModifica(rs.getString("FechaModifica"));
        return dto;
    }
}
