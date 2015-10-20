package sysinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sysinfo.model.Barang;
import sysinfo.repository.BarangRepository;

@Controller
public class BarangReportController {
    @Autowired
    private BarangRepository barangRepository;

    @RequestMapping("/report/barang")
    public ModelAndView generateReportMember(ModelAndView m) {
        Iterable<Barang> data = barangRepository.findAll();
        m.addObject("dataSource", data);
        m.addObject("format", "pdf");
        m.setViewName("report_barang");
        return m;
    }
}
