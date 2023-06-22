module com.datpt.kttkpm_javafx_activemq {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires log4j;
    requires java.naming;
    requires activemq.all;

    opens com.datpt.kttkpm_javafx_activemq to javafx.fxml, java.xml.bind;
    exports com.datpt.kttkpm_javafx_activemq;
}