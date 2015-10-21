package sysinfo.controller;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import sysinfo.model.Member;
import sysinfo.repository.MemberRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MemberReportController {

    @Autowired
    private MemberRepository memberRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    /*@RequestMapping(value = "/report/member",  method = RequestMethod.GET)
    public ModelAndView generateReportMember(ModelAndView m) {
        Iterable<Member> data = memberRepository.findAll();
        m.addObject("dataSource", data);
        m.addObject("format", "pdf");
        m.setViewName("report_member");
        return m;
    }*/

    @RequestMapping(value = "/report/member", method = RequestMethod.GET, produces = "application/pdf")
    public void generateReportMemberPerPeriode(@RequestParam(value = "mulai") Date mulai,
                                               @RequestParam(value = "akhir") Date akhir,
                                               HttpServletResponse response) throws Exception {
        List<Member> data = memberRepository.cariMemberdari(mulai, akhir);

        InputStream jasperStream = this.getClass().getResourceAsStream("/reports/report_member.jasper");
        Map<String, Object> params = new HashMap<>();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(data));

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline; filename=report_member.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }

    /*@RequestMapping(value = "/report/member", method = RequestMethod.GET)
    @ResponseBody
    public void getRpt1(HttpServletResponse response) throws Exception {
        List<Member> data = memberRepository.findAll();

        InputStream jasperStream = this.getClass().getResourceAsStream("/reports/report_member.jasper");
        Map<String, Object> params = new HashMap<>();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRBeanCollectionDataSource(data));

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "inline; filename=report_member.pdf");

        final OutputStream outStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
    }*/
}
