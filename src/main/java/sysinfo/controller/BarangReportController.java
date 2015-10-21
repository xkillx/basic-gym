package sysinfo.controller;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sysinfo.model.Barang;
import sysinfo.repository.BarangRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BarangReportController {
    @Autowired
    private BarangRepository barangRepository;

    /*@RequestMapping("/report/barang")
    public ModelAndView generateReportMember(ModelAndView m) {
        Iterable<Barang> data = barangRepository.findAll();
        m.addObject("dataSource", data);
        m.addObject("format", "pdf");
        m.setViewName("report_barang");
        return m;
    }*/

    @RequestMapping(value = "/report/barang", method = RequestMethod.GET, produces = "application/pdf")
    public void generateReportBarang(HttpServletResponse response) throws Exception {
        List<Barang> data = barangRepository.findAll();

        InputStream jasperStream = this.getClass().getResourceAsStream("/reports/report_barang.jasper");
        Map<String, Object> params = new HashMap<>();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(data));

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline; filename=report_barang.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }
}
