package com.hrevfdz.controllers;

import com.hrevfdz.dao.SuppliersDAO;
import com.hrevfdz.models.StartWork;
import com.hrevfdz.services.IPharmacy;
import com.hrevfdz.util.MessagesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class BoxController implements Serializable {

    private List<StartWork> startWorks;
    private StartWork startWork;
    
    public void listarMontoCaja(){
         FacesMessage msg = null;
        IPharmacy dao = new SuppliersDAO();

        try {
//            supplierses = dao.findAll();
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.ERROR_TITLE, MessagesUtil.ERROR);
        }

        if (msg != null) {
            FacesContext.getCurrentInstance().addMessage(null, msg);
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
