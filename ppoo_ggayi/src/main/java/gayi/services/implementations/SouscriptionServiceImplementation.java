package gayi.services.implementations;

import gayi.services.SouscriptionService;
import gayi.utils.Connexion;
import gayi.entities.Souscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SouscriptionServiceImplementation implements SouscriptionService {

    @Override
    public void ajouterSouscription(Souscription souscription) {
        String query = "INSERT INTO Souscription (dateHeureSous, actif, idClient, idProduit) VALUES (?, ?, ?, ?)";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(souscription.getDateHeureSous().getTime()));
            preparedStatement.setString(2, String.valueOf(souscription.getActif()));
            preparedStatement.setInt(3, souscription.getIdClient());
            preparedStatement.setInt(4, souscription.getIdProduit());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierSouscription(Souscription souscription) {
        String query = "UPDATE Souscription SET dateHeureSous=?, actif=?, idClient=?, idProduit=? WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(souscription.getDateHeureSous().getTime()));
            preparedStatement.setString(2, String.valueOf(souscription.getActif()));
            preparedStatement.setInt(3, souscription.getIdClient());
            preparedStatement.setInt(4, souscription.getIdProduit());
            preparedStatement.setInt(5, souscription.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerSouscription(Souscription souscription) {
        String query = "DELETE FROM Souscription WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, souscription.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Souscription getSouscription(int id) {
        String query = "SELECT * FROM Souscription WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Souscription(
                            resultSet.getInt("id"),
                            resultSet.getTimestamp("dateHeureSous"),
                            resultSet.getString("actif").charAt(0),
                            resultSet.getInt("idClient"),
                            resultSet.getInt("idProduit")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Souscription> getAllSouscriptions() {
        List<Souscription> souscriptions = new ArrayList<>();
        String query = "SELECT * FROM Souscription";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                souscriptions.add(new Souscription(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("dateHeureSous"),
                        resultSet.getString("actif").charAt(0),
                        resultSet.getInt("idClient"),
                        resultSet.getInt("idProduit")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return souscriptions;
    }
}

