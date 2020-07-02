package cn.LysGroup.domain;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

    private int M_id;
    private String M_name;
    private int M_fid;
    private int M_father;
    private String M_sex;
    private Date M_date;
    private String M_spose;

    public int getM_id() {
        return M_id;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    public String getM_name() {
        return M_name;
    }

    public void setM_name(String m_name) {
        M_name = m_name;
    }

    public int getM_fid() {
        return M_fid;
    }

    public void setM_fid(int m_fid) {
        M_fid = m_fid;
    }

    public int getM_father() {
        return M_father;
    }

    public void setM_father(int m_father) {
        M_father = m_father;
    }

    public String getM_sex() {
        return M_sex;
    }

    public void setM_sex(String m_sex) {
        M_sex = m_sex;
    }

    public Date getM_date() {
        return M_date;
    }

    public void setM_date(Date m_date) {
        M_date = m_date;
    }

    public String getM_spose() {
        return M_spose;
    }

    public void setM_spose(String m_spose) {
        M_spose = m_spose;
    }

    @Override
    public String toString() {
        return "Member{" +
                "M_id=" + M_id +
                ", M_name='" + M_name + '\'' +
                ", M_fid=" + M_fid +
                ", M_father=" + M_father +
                ", M_sex='" + M_sex + '\'' +
                ", M_date=" + M_date +
                ", M_spose='" + M_spose + '\'' +
                '}';
    }
}
