package sysinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sysinfo.model.Member;
import sysinfo.repository.MemberRepository;

@Controller
public class MemberReportController {

    @Autowired
    private MemberRepository memberRepository;

    @RequestMapping("/report/member")
    public ModelAndView generateReportMember(ModelAndView m) {
        Iterable<Member> data = memberRepository.findAll();
        m.addObject("dataSource", data);
        m.addObject("format", "pdf");
        m.setViewName("report_member");
        return m;
    }
}
