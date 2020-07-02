package cn.LysGroup.service.impl;

import cn.LysGroup.dao.familyDao;
import cn.LysGroup.domain.Family;
import cn.LysGroup.service.familyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class familyServiceImpl implements familyService {
    @Autowired
    private familyDao dao;
    @Override
    public void createFamily(Family family) {
        //创建族谱
        dao.createFamily(family);
    }

    @Override
    public void updateFamily(Family family) {
        //更新族谱
        dao.updateFamily(family);
    }

    @Override
    public void deleteFamily(Family family) {
        //获取要删除族谱的id
        int id = family.getF_id();
        //删除族谱
        dao.deleteFamily(id);
    }

    @Override
    public List<Family> findAllFamily() {
        //查询所有的族谱
        List<Family> families = dao.findAllFamily();
        //返回所有族谱
        return families;
    }

    @Override
    public Family findByName(String name) {
        //通过name查询族谱
        Family family = dao.findByName(name);
        return family;
    }
}
