package cn.LysGroup.controller;

import cn.LysGroup.domain.Member;
import cn.LysGroup.service.memberService;
import cn.LysGroup.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//人员管理类
@Controller
@RequestMapping("/member")
public class memberController {
    @Autowired
    private memberService service;
    @Autowired
    private ResultInfo info;

    /**
     * 添加人员
     * @param member
     * @return
     */
    @RequestMapping("/addMember")
    @ResponseBody
    public ResultInfo addMember(@RequestBody Member member) {
        try {
            //添加人员
            service.addMember(member);
            info.setFlag(true);
            info.setErrorMsg("添加成功");
            return info;
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("添加失败，请联系管理员");
            return info;
        }
    }

    /**
     * s删除人员
     * @param member
     * @return
     */
    @RequestMapping("/deleteMember")
    @ResponseBody
    public ResultInfo deleteMember(@RequestBody Member member) {
        try {
            //删除人员
            int id=member.getM_id();
            service.deleteMember(id);
            info.setFlag(true);
            info.setErrorMsg("删除成功");
            return info;
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("删除失败，请联系管理员");
            return info;
        }
    }

    /**
     * 更新人员
     * @param member
     * @return
     */
    @RequestMapping("/updateMember")
    @ResponseBody
    public ResultInfo updateMember(@RequestBody Member member) {
        try {
            //修改人员
            service.updateMember(member);
            info.setFlag(true);
            info.setErrorMsg("修改成功");
            return info;
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("修改失败，请联系管理员");
            return info;
        }
    }

    /**
     * 查询总人数
     * @param member
     * @return
     */
    @RequestMapping("/findTotal")
    @ResponseBody
    public int findTotal(@RequestBody Member member) {
        try {
            //查询总人数
            int total = service.findTotal(member.getM_fid());
            return total;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 查询男生总人数
     * @param M_fid
     * @return
     */
    @RequestMapping("/findSexTotal")
    @ResponseBody
    public int findSexTotal(int M_fid) {
        try {
            //查询男生总人数
            int total = service.findSexTotal(M_fid);
            return total;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 通过姓名查询
     * @param name
     * @return
     */
    @RequestMapping("/findByName")
    @ResponseBody
    public ResultInfo findByName(String name) {
            Member byName = service.findByName(name);
            if(byName!=null){
                info.setFlag(true);
                info.setData(byName);
                return info;
            }else {
            info.setFlag(false);
            info.setErrorMsg("查询失败，系统无此人");
            return info;
        }
    }
}
