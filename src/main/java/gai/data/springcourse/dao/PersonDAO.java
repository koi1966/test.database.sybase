package gai.data.springcourse.dao;

import gai.data.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
//    private static int PEOPLE_COUNT;

//    private static final String URL = "jdbc:postgresql://localhost:5432/first_db1";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "postgres";

    private static final String URL = "jdbc:jtds:sybase://zhytomyr:5000/gai";
    private static final String USERNAME = "view_user";
    private static final String PASSWORD = "view_user";


    private static Connection connection;
    static {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//
//    }
    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM Person";
            String SQL = "select id, marka as name, family as email from karta where znak='49910ВВ'";
            try (ResultSet resultSet = statement.executeQuery(SQL)) {
                while (resultSet.next()) {
                    Person person = new Person();
     //              person.setId(resultSet.getInt("id"));
                    person.setName(resultSet.getString("name"));
                    person.setEmail(resultSet.getString("email"));
                    people.add(person);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
//        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }


    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);

    }



    public void update(int id, Person updatedPerson) {
//        Person personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }



    public void delete(int id) {
//        people.removeIf(p -> p.getId() == id);
    }
}