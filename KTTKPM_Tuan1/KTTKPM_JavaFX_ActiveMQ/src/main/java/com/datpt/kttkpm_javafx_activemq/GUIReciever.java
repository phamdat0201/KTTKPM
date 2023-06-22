package com.datpt.kttkpm_javafx_activemq;

import javafx.application.Application;
import javafx.application.Platform;
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
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;

public class GUIReciever extends Application implements MessageListener {
    private TextArea textArea;
    private TextField textField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Receiver");
        stage.setResizable(false);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));

        VBox contentBox = new VBox(10);
        contentBox.setAlignment(Pos.CENTER);

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefSize(480, 270);

        Label enterTextLabel = new Label("Enter Text:");
        textField = new TextField();
        textField.setPrefSize(280, 40);

        Button sendButton = new Button("Send");
        sendButton.setPrefSize(100, 40);
        sendButton.setOnAction(event -> {
            // Handle send button action
        });
        HBox enterTextContainer = new HBox(10);
        enterTextContainer.setAlignment(Pos.CENTER_LEFT);
        enterTextContainer.getChildren().addAll(enterTextLabel, textField, sendButton);

        contentBox.getChildren().addAll(textArea, enterTextContainer);

        borderPane.setCenter(contentBox);

        stage.setScene(new Scene(borderPane, 500, 400));
        stage.show();

        try {
            receiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiver() throws Exception {
        BasicConfigurator.configure();
        // thiết lập môi trường cho JJNDI
        Properties settings = new Properties();
        settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        // tạo context
        Context ctx = new InitialContext(settings);
        // lookup JMS connection factory
        Object obj = ctx.lookup("ConnectionFactory");
        ConnectionFactory factory = (ConnectionFactory) obj;
//        ConnectionFactory factory = (factory) obj;
        // lookup destination
        Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");
        // tạo connection
        Connection con = factory.createConnection("admin", "admin");
        // nối đến MOM
        con.start();
        // tạo session
        Session session = con.createSession(/* transaction */false, /* ACK */Session.CLIENT_ACKNOWLEDGE);
        // tạo consumer
        MessageConsumer receiver = session.createConsumer(destination);
        // blocked-method for receiving message - sync
        // receiver.receive();
        // Cho receiver lắng nghe trên queue, chừng có message thì notify - async
        System.out.println("Tý was listened on queue...");
        receiver.setMessageListener(new MessageListener() {

            // có message đến queue, phương thức này được thực thi
            public void onMessage(Message msg) {// msg là message nhận được
                try {
                    if (msg instanceof TextMessage) {
                        TextMessage tm = (TextMessage) msg;
                        String txt = tm.getText();
                        textArea.appendText("\nContent: " + txt);
                        msg.acknowledge();// gửi tín hiệu ack
                    } else if (msg instanceof ObjectMessage) {
                        ObjectMessage om = (ObjectMessage) msg;
                        System.out.println(om);
                    }
//others message type....
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onMessage(Message message) {

    }
}
