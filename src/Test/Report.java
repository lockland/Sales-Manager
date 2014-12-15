package Test;

import dao.DataBaseSqLite;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lockland
 */
public class Report {

    DataBaseSqLite db;

    public Report (DataBaseSqLite db) {
        this.db = db;
    }
    
    public static void main(String[] args) {
        DataBaseSqLite db = new DataBaseSqLite();

        try {
            
            String report = db.getClass().getResource("/report/sales_manager.jrxml").getPath();
            String imagePath = report.replace("/sales_manager.jrxml", "");
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("CliID", 7);
            params.put("VendaID", 9);
            params.put("imagePath", imagePath);
            
            //String report = "D:\\lockland\\Dropbox\\FTEC\\Java\\NetBeansProjects\\sales_manager\\src\\report\\sales_manager.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(report);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, db.connect());
            JasperViewer.viewReport(jp);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
}
