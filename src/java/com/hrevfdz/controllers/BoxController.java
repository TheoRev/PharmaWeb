package com.hrevfdz.controllers;

import com.hrevfdz.models.StartWork;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BoxController implements Serializable {

    private List<StartWork> startWorks;
    private StartWork startWork;
    
    public void listarMontoCaja(){
        try {
            
        } catch (Exception e) {
        }
    }

    public List<StartWork> getStartWorks() {
        return startWorks;
    }

    public void setStartWorks(List<StartWork> startWorks) {
        this.startWorks = startWorks;
    }

    public StartWork getStartWork() {
        return startWork;
    }

    public void setStartWork(StartWork startWork) {
        this.startWork = startWork;
    }

}
