package sysinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sysinfo.model.PerpanjangMember;
import sysinfo.repository.PerpanjangMemberRepository;

@Controller
public class PerpanjangReportController {
    @Autowired
    private PerpanjangMemberRepository perpanjangMemberRepository;

    @RequestMapping("/report/perpanjang")
    public ModelAndView generateReportMember(ModelAndView m) {
        Iterable<PerpanjangMember> data = perpanjangMemberRepository.findAll();
        m.addObject("dataSource", data);
        m.addObject("format", "pdf");
        m.setViewName("report_perpanjang");
        return m;
    }
}
