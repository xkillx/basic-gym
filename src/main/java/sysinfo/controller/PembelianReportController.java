package sysinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sysinfo.model.Pembelian;
import sysinfo.repository.PembelianRepository;

@Controller
public class PembelianReportController {
    @Autowired
    private PembelianRepository pembelianRepository;

    @RequestMapping("/report/pembelian")
    public ModelAndView generateReportMember(ModelAndView m) {
        Iterable<Pembelian> data = pembelianRepository.findAll();
        m.addObject("dataSource", data);
        m.addObject("format", "pdf");
        m.setViewName("report_pembelian");
        return m;
    }
}
