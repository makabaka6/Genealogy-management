package cn.LysGroup.controller;

import cn.LysGroup.domain.Family;
import cn.LysGroup.service.familyService;
import cn.LysGroup.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//族谱管理类
@Controller
@RequestMapping("/family")
public class familyController {
    @Autowired
    private familyService service;
    @Autowired
    private ResultInfo info;

    /**
     * 创建族谱
     * @param family
     * @return info
     */
   @RequestMapping("/create")
   @ResponseBody
    public ResultInfo createFamily(@RequestBody Family family) {
       try {
           //创建族谱
           service.createFamily(family);
           info.setFlag(true);
           info.setErrorMsg("族谱创建成功");
           return info;
       } catch (Exception e) {
           info.setFlag(false);
           info.setErrorMsg("创建成功，请联系管理员");
           return info;
       }
    }

    /**
     * 更新族谱
     * @param family
     * @return
     */
    @RequestMapping("/updateFamily")
    @ResponseBody
    public ResultInfo updateFamily(@RequestBody Family family) {
        try {
            //更新族谱
            service.updateFamily(family);
            info.setFlag(true);
            info.setErrorMsg("族谱更新成功");
            return info;
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("更新失败，请联系管理员");
            return info;
        }
    }

    /**
     * 删除族谱
     * @param family
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultInfo deleteFamily(@RequestBody Family family) {
        try {
            //删除族谱
            service.deleteFamily(family);
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
     * 查询所有的族谱信息
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Family> findAllFamily() {
        //查询所有的族谱
        List<Family> families = service.findAllFamily();
        //返回所有族谱
        return families;
    }

    /**
     * 通过name查询族谱
     * @param name
     * @return
     */
    @RequestMapping("/findByName")
    @ResponseBody
    public Map<String,Object> findByName(String name) {
        HashMap<String, Object> map = new HashMap<>();
        //通过name查询族谱
        Family family = service.findByName(name);
       if(family == null){
            info.setFlag(false);
            info.setErrorMsg("暂时没有该族谱哦!");
            map.put("false",info);
            return map;
        }else {
            map.put("true",family);
            return map;
        }
    }
}
