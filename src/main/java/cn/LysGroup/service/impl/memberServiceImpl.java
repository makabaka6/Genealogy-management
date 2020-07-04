package cn.LysGroup.service.impl;

import cn.LysGroup.dao.memberDao;
import cn.LysGroup.domain.Member;
import cn.LysGroup.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class memberServiceImpl implements memberService {
    @Autowired
    private memberDao dao;
    @Override
    public void addMember(Member member) {
        dao.addMember(member);
    }

    @Override
    public void deleteMember(int id) {
        dao.deleteMember(id);
    }

    @Override
    public void updateMember(Member member) {
        dao.updateMember(member);
    }

    @Override
    public int findTotal(int M_fid) {
        int total = dao.findTotal(M_fid);
        return total;
    }

    @Override
    public int findSexTotal(int M_fid) {
        int sexTotal = dao.findSexTotal(M_fid);
        return sexTotal;
    }

    @Override
    public Member findByName(String name) {
        Member byName = dao.findByName(name);
        return byName;
    }
}
