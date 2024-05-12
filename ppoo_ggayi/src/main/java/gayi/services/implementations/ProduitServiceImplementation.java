package gayi.services.implementations;

import gayi.entities.Produit;
import gayi.services.ProduitService;
import gayi.utils.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitServiceImplementation implements ProduitService {
    @Override
    public void ajouterProduit(Produit produit) {
        String query = "INSERT INTO Produit (libelle, actif) VALUES (?, ?)";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, produit.getLibelle());
            preparedStatement.setString(2, String.valueOf(produit.getActif()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerProduit(Produit produit) {
        String query = "DELETE FROM Produit WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, produit.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierProduit(Produit produit) {
        String query = "UPDATE Produit SET libelle=?, actif=? WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, produit.getLibelle());
            preparedStatement.setString(2, String.valueOf(produit.getActif()));
            preparedStatement.setInt(3, produit.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Produit getProduit(int id) {
        String query = "SELECT * FROM Produit WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Produit(
                            resultSet.getInt("id"),
                            resultSet.getString("libelle"),
                            resultSet.getString("actif").charAt(0)
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM Produit";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                produits.add(new Produit(
                        resultSet.getInt("id"),
                        resultSet.getString("libelle"),
                        resultSet.getString("actif").charAt(0)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }
}
