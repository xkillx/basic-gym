package sysinfo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sysinfo.model.NonMember;
import sysinfo.repository.NonMemberRepository;

@Controller
public class NonMemberReportController {
    @Autowired
    private NonMemberRepository nonMemberRepository;

    @RequestMapping("/report/nonmember")
    public ModelAndView generateReportNonMember(ModelAndView m) {
        Iterable<NonMember> data = nonMemberRepository.findAll();
        m.addObject("dataSource", data);
        m.addObject("format", "pdf");
        m.setViewName("report_nonmember");
        return m;
    }
}
