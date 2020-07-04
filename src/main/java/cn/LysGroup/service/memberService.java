package cn.LysGroup.service;

import cn.LysGroup.domain.Member;

public interface memberService {
    /**
     *  添加成员
     * @param member
     */
    void addMember(Member member);

    /**
     * 删除成员
     * @param id
     */
    void deleteMember(int id);

    /**
     * 更新成员
     * @param member
     */
    void updateMember(Member member);

    /**
     * 查询族谱总人数
     * @param M_fid
     * @return
     */
    int findTotal(int M_fid);
    /**
     * 查询当前族谱总的男生人数
     * @return
     */
    int findSexTotal(int M_fid);

    /**
     * 查询人员信息
     * @param name
     * @return
     */
    Member findByName(String name);


}
