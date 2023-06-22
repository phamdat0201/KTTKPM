package com.datpt.kttkpm_javafx_activemq;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Date;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;


public class GUISender extends Application implements EventHandler<ActionEvent> {

    private TextArea textArea;
    private TextField textField;
    private Session session;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sender");

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));

        VBox contentBox = new VBox(10);
        contentBox.setAlignment(Pos.CENTER);

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefSize(400, 300);

        Label enterTextLabel = new Label("Enter Text:");
        textField = new TextField();
        textField.setPrefSize(300, 40);

        Button sendButton = new Button("Send");
        sendButton.setFont(new javafx.scene.text.Font("Tahoma", 18));
        sendButton.setOnAction(this);
        contentBox.getChildren().addAll(textArea, enterTextLabel, textField, sendButton);
        borderPane.setCenter(contentBox);

        stage.setScene(new Scene(borderPane, 500, 400));
        stage.setResizable(false);
        stage.show();
    }
    public void send() throws Exception {
        // Config environment for JNDI
        Properties settings = new Properties();
        settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");

        // Create context
        Context ctx = new InitialContext(settings);

        // Lookup JMS connection factory
        ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");

        // Lookup destination (If not exist --> ActiveMQ create once)
        Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");

        // Get connection using credentials
        Connection con = factory.createConnection("admin", "admin");

        // Connect to MOM
        con.start();
        // Create session
        Session session = con.createSession(/* transaction */ false, /* ACK */ Session.AUTO_ACKNOWLEDGE);

        // Create producer
        MessageProducer producer = session.createProducer(destination);

        // Create text message
        Message msg = session.createTextMessage("Hello message from ActiveMQ");
        producer.send(msg);

        try {
            String name = textField.getText();
            Person p = new Person(1001, name, new Date());
            String xml = new XMLConvert<Person>(p).object2XML(p);
            String txt = textField.getText().trim();
            msg = session.createTextMessage(txt);
            producer.send(msg);

            textField.setText("");
            textArea.appendText(name + "\n");
            System.out.println(name);
        } finally {  session.close();
            con.close();
            System.out.println("Finished...");
        }
    }

    public void handle(ActionEvent event) {
        try{
            send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}