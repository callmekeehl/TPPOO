package gayi.services.implementations;

import gayi.services.SmsService;
import gayi.utils.Connexion;
import gayi.entities.Sms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmsServiceImplementation implements SmsService {

    @Override
    public void ajouterSms(Sms sms) {
        String query = "INSERT INTO Sms (libelle, statut) VALUES (?, ?)";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sms.getLibelle());
            preparedStatement.setString(2, sms.getStatut());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void modifierSms(Sms sms) {
        String query = "UPDATE Sms SET idClient=?, libelle=?, statut=? WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, sms.getIdClient());
            preparedStatement.setString(2, sms.getLibelle());
            preparedStatement.setString(3, sms.getStatut());
            preparedStatement.setInt(4, sms.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerSms(Sms sms) {
        String query = "DELETE FROM Sms WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, sms.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sms getSms(int id) {
        String query = "SELECT * FROM Sms WHERE id=?";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Sms(
                            resultSet.getInt("id"),
                            resultSet.getInt("idClient"),
                            resultSet.getString("libelle"),
                            resultSet.getString("statut")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sms> getAllSms() {
        List<Sms> smsList = new ArrayList<>();
        String query = "SELECT * FROM Sms";
        try (Connection connection = Connexion.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Sms sms = new Sms(
                        resultSet.getInt("id"),
                        resultSet.getInt("idClient"),
                        resultSet.getString("libelle"),
                        resultSet.getString("statut")
                );
                smsList.add(sms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return smsList;
    }
    
    
    public List<Sms> getSmsEnvoyes() {
    List<Sms> smsEnvoyes = new ArrayList<>();
    String query = "SELECT * FROM Sms WHERE statut = 'Envoyé'";
    try (Connection connection = Connexion.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
            Sms sms = new Sms(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClient"),
                    resultSet.getString("libelle"),
                    resultSet.getString("statut")
            );
            smsEnvoyes.add(sms);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return smsEnvoyes;
}

    public List<Sms> getSmsEnAttente() {
    List<Sms> smsEnAttente = new ArrayList<>();
    String query = "SELECT * FROM Sms WHERE statut = 'En attente'";
    try (Connection connection = Connexion.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
            Sms sms = new Sms(
                    resultSet.getInt("id"),
                    resultSet.getInt("idClient"),
                    resultSet.getString("libelle"),
                    resultSet.getString("statut")
            );
            smsEnAttente.add(sms);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return smsEnAttente;
}

    @Override
    public List<Sms> getSmssByStatut(String statut) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Sms> getSmsEnvoyes(String statut) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Sms> getSmsEnAttente(String statut) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
