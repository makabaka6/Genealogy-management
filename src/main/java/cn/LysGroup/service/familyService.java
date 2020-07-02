package cn.LysGroup.service;

import cn.LysGroup.domain.Family;

import java.util.List;

//族谱管理的service
public interface familyService {
    /**
     * 创建族谱
     * @param family
     */
    void createFamily(Family family);

    /**
     * 修改族谱的信息
     * @param family
     */
    void updateFamily(Family family);

    /**
     * 删除族谱
     * @param id
     */
    void deleteFamily(Family family);

    /**
     * 查询所有族谱
     * @return
     */
    List<Family> findAllFamily();

    /**
     * 查询一个族谱
     * @param name
     * @return
     */
    Family findByName(String name);
}
