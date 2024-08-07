package org.scoula.controller.member.v2;

import lombok.extern.slf4j.Slf4j;
import org.scoula.dto.member.MemberDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MemberShowControllerV2 {
    private final MemberDtoListV2 memberDtoList;

    @Autowired
    public MemberShowControllerV2(MemberDtoListV2 memberDtoList) {
        this.memberDtoList = memberDtoList;
    }

    @GetMapping("/member/v2/show")
    public String process(Model model) {
        log.info("========> 회원 조회 페이지 호출, ");

        model.addAttribute("memberList", memberDtoList.getList());
        return "member-show2";
    }
}
