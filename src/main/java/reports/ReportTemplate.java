package reports;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReportTemplate extends JFrame {

    private static final long serialVersionUID = 1L;

    public void showReport(String reportName){

        try {
                JasperDesign jasperDesign = JRXmlLoader.load("reports/" + reportName);


                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null);
                JRViewer viewer = new JRViewer(JasperPrint);

                viewer.setOpaque(true);
                viewer.setVisible(true);


                this.add(viewer);
                this.setSize(900,500); // JFrame size
                this.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage());
            }



        }

}
