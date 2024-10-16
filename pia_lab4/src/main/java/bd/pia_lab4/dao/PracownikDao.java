package bd.pia_lab4.dao;

import bd.pia_lab4.beans.Pracownik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * DAO (Data Access Object) for Pracownik entity.
 */
public class PracownikDao {

    private JdbcTemplate template;

    // Setter do wstrzyknięcia JdbcTemplate
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Zapis nowego pracownika do bazy danych
    public int save(Pracownik p) {
        // Użycie parametrów zapytania, aby uniknąć SQL Injection
        String sql = "insert into pracownik (nazwisko, pensja, firma) values (?, ?, ?)";
        return template.update(sql, p.getNazwisko(), p.getPensja(), p.getFirma());
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM pracownik WHERE id = ?";
        template.update(sql, id);
    }
    
    public void update(Pracownik pracownik) {
        String sql = "UPDATE pracownik SET nazwisko = ?, pensja = ?, firma = ? WHERE id = ?";
        template.update(sql, pracownik.getNazwisko(), pracownik.getPensja(), pracownik.getFirma(), pracownik.getId());
    }

    public Pracownik getPracownikById(int id) {
        String sql = "SELECT * FROM pracownik WHERE id = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Pracownik.class));
    }
    
    // Pobranie listy wszystkich pracowników z bazy danych
    public List<Pracownik> getAll() {
        return template.query("SELECT * FROM pracownik", (ResultSet rs, int row) -> {
            Pracownik e = new Pracownik();
            e.setId(rs.getInt(1));           // Ustawienie ID
            e.setNazwisko(rs.getString(2));  // Ustawienie nazwiska
            e.setPensja((float) rs.getDouble(3));    // Ustawienie pensji
            e.setFirma(rs.getString(4));     // Ustawienie firmy
            return e;
        });
    }
}
