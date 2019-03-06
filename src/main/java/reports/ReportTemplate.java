package reports;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import connectors.MainDataBaseConnector;
import entities.db.dbFlattableEntity;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JFrame;

public class ReportTemplate extends JFrame {
    private MainDataBaseConnector connection;

    private String m_where;
    private String m_report_source = "/employees/";
    private String m_sql_stmt;
    private Map parametersMap = new HashMap();

    protected void showReport() {
        /*try {
            List temp = connection.getSession().find(getClass(dbFlattableEntity));
            InputStream is = getClass().getResourceAsStream(m_report_source);

            JRDesignQuery jrDesignQuery = new JRDesignQuery();
            jrDesignQuery.setText(m_sql_stmt);

            JasperDesign jasperDesign = JRXmlLoader.load(is);
            jasperDesign.setQuery(jrDesignQuery);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametersMap, connection.getSession());
            JasperViewer.viewReport(jasperPrint, false);*

        } catch (SQLException | JRException e) {
            System.out.println("Exception message " + e.getMessage());
        }*/
    }
}
