package sysinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sysinfo.model.Penjualan;
import sysinfo.repository.PenjualanRepository;

@Controller
public class PenjualanReportController {
    @Autowired
    private PenjualanRepository penjualanRepository;

    @RequestMapping("/report/penjualan")
    public ModelAndView generateReportMember(ModelAndView m) {
        Iterable<Penjualan> data = penjualanRepository.findAll();
        m.addObject("dataSource", data);
        m.addObject("format", "pdf");
        m.setViewName("report_penjualan");
        return m;
    }
}
