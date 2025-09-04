package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterDAO {
    public List<Character> getHeroes() throws SQLException {
        List<Character> heroes = new ArrayList<>();
        String sql = "SELECT * FROM Character";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Character hero = new Character();
                hero.setId(rs.getInt("id"));
                hero.setType(rs.getString("type"));
                hero.setName(rs.getString("name"));
                hero.setLifePoints(rs.getInt("lifePoints"));
                hero.setStrength(rs.getInt("strength"));
                hero.setOffensiveEquipment(rs.getString("offensiveEquipment"));
                hero.setDefensiveEquipment(rs.getString("defensiveEquipment"));
                heroes.add(hero);
            }
        }
        return heroes;
    }

    public void createHero(Character character) throws SQLException {
        String sql = "INSERT INTO Character (type, name, lifePoints, strength, offensiveEquipment, defensiveEquipment) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, character.getType());
            pstmt.setString(2, character.getName());
            pstmt.setInt(3, character.getLifePoints());
            pstmt.setInt(4, character.getStrength());
            pstmt.setString(5, character.getOffensiveEquipment());
            pstmt.setString(6, character.getDefensiveEquipment());
            pstmt.executeUpdate();
        }
    }

    public void editHero(Character character) throws SQLException {
        String sql = "UPDATE Character SET type=?, name=?, lifePoints=?, strength=?, offensiveEquipment=?, defensiveEquipment=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, character.getType());
            pstmt.setString(2, character.getName());
            pstmt.setInt(3, character.getLifePoints());
            pstmt.setInt(4, character.getStrength());
            pstmt.setString(5, character.getOffensiveEquipment());
            pstmt.setString(6, character.getDefensiveEquipment());
            pstmt.setInt(7, character.getId());
            pstmt.executeUpdate();
        }
    }

    public void changeLifePoints(int characterId, int newLifePoints) throws SQLException {
        String sql = "UPDATE Character SET lifePoints=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newLifePoints);
            pstmt.setInt(2, characterId);
            pstmt.executeUpdate();
        }
    }
}
