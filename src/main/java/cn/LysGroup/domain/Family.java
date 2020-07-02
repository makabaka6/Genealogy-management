package cn.LysGroup.domain;

import java.io.Serializable;
import java.util.Date;

//族谱的pojo
public class Family implements Serializable {
    private int F_id;
    private String F_name;
    private String F_surname;
    private Date F_datedate;
    private String F_precepts;
    private String F_intro;
    private String F_events;

    @Override
    public String toString() {
        return "Family{" +
                "F_id=" + F_id +
                ", F_name='" + F_name + '\'' +
                ", F_surname='" + F_surname + '\'' +
                ", F_datedate=" + F_datedate +
                ", F_precepts='" + F_precepts + '\'' +
                ", F_intro='" + F_intro + '\'' +
                ", F_events='" + F_events + '\'' +
                '}';
    }

    public int getF_id() {
        return F_id;
    }

    public void setF_id(int f_id) {
        F_id = f_id;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public String getF_surname() {
        return F_surname;
    }

    public void setF_surname(String f_surname) {
        F_surname = f_surname;
    }

    public Date getF_datedate() {
        return F_datedate;
    }

    public void setF_datedate(Date f_datedate) {
        F_datedate = f_datedate;
    }

    public String getF_precepts() {
        return F_precepts;
    }

    public void setF_precepts(String f_precepts) {
        F_precepts = f_precepts;
    }

    public String getF_intro() {
        return F_intro;
    }

    public void setF_intro(String f_intro) {
        F_intro = f_intro;
    }

    public String getF_events() {
        return F_events;
    }

    public void setF_events(String f_events) {
        F_events = f_events;
    }
}
