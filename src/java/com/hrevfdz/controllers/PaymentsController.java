package com.hrevfdz.controllers;

import com.hrevfdz.dao.AccessDAO;
import com.hrevfdz.dao.LaboratoryDAO;
import com.hrevfdz.dao.PaymentsDAO;
import com.hrevfdz.dao.StockProductoDAO;
import com.hrevfdz.dao.SuppliersDAO;
import com.hrevfdz.models.Access;
import com.hrevfdz.models.Laboratory;
import com.hrevfdz.models.Payments;
import com.hrevfdz.models.StockProducto;
import com.hrevfdz.models.Suppliers;
import com.hrevfdz.services.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import com.hrevfdz.util.MessagesUtil;
import com.hrevfdz.util.QueriesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PaymentsController implements Serializable {

    private List<Payments> paymentses;
    private Payments payments;
    private Access access;
    private List<StockProducto> productos;
    private StockProducto producto;
//    private List<StockProducto> stockProductos;

    private String accion;

    @PostConstruct
    public void init() {
        payments = new Payments();
        access = new Access();
        doFindAll();
        doGetProductos();
        doGetUserActive();
    }

    public void doCreate() {
        FacesMessage msg = null;
        IPharmacy<Payments> dao = new PaymentsDAO();

        try {
            boolean result = dao.Create(payments);

            if (result) {
                paymentses.add(paymentses.size(), payments);
                doFindAll();
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.SUCCESS_TITLE, MessagesUtil.SAVE_SUCCESS);
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.FAIL_TITLE, MessagesUtil.SAVE_FAIL);
            }
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.ERROR_TITLE, e.getMessage());
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void doUpdate(Payments p) {
        FacesMessage msg = null;
        IPharmacy<Payments> dao = new PaymentsDAO();

        try {
            boolean result = dao.Update(p);

            if (result) {
                paymentses.clear();
                doFindAll();
                payments = new Payments();
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.SUCCESS_TITLE, MessagesUtil.UPDATE_SUCCESS);
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.FAIL_TITLE, MessagesUtil.UPDATE_FAIL);
            }
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.ERROR_TITLE, e.getMessage());
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void doDelete(Payments p) {
        FacesMessage msg = null;
        IPharmacy<Payments> dao = new PaymentsDAO();

        try {
            boolean result = dao.Delete(p);

            if (result) {
                paymentses.clear();
                doFindAll();
                payments = new Payments();
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.SUCCESS_TITLE, MessagesUtil.UPDATE_SUCCESS);
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.FAIL_TITLE, MessagesUtil.UPDATE_FAIL);
            }
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.ERROR_TITLE, e.getMessage());
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void doGetUserActive() {
        FacesMessage msg = null;
        IPharmacy<Access> dao = new AccessDAO();

        try {
            final String query = "SELECT a FROM Access a WHERE a.id = (SELECT MAX(t.id) FROM Access t)";
            access = dao.findBy(query);
            this.payments.setUserId(access.getUserId());
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.ERROR_TITLE, e.getMessage());
        }

        if (msg != null) {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void doGetProductos() {
        FacesMessage msg = null;
        IPharmacy<StockProducto> dao = new StockProductoDAO();

        try {
            final String query = "SELECT p FROM StockProducto p WHERE p.cantidad > 0  ORDER BY p.nombre";
            productos = dao.findByQuery(query);
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.ERROR_TITLE, e.getMessage());
        }

        if (msg != null) {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }



//    public void doGetProducts() {
//        FacesMessage msg = null;
//        IPharmacy<StockProducto> dao = new StockProductoDAO();
//
//        try {
//            final String query = "SELECT sp FROM StockProducto sp";
//            stockProductos = dao.findByQuery(query);
//        } catch (Exception e) {
//            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.ERROR_TITLE, e.getMessage());
//        }
//
//        if (msg != null) {
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
//    }

    public void doNew() {
        accion = AccionUtil.CREATE;
        payments = new Payments();
        doGetProductos();
        doGetUserActive();
        doFindAll();
    }

    public void doUpgrade(Payments p) {
        accion = AccionUtil.UPDATE;
        payments = p;
        doGetProductos();
        doGetUserActive();
        doFindAll();
    }

    public void doExecute() {
        switch (accion) {
            case AccionUtil.CREATE:
                doCreate();
                break;
            case AccionUtil.UPDATE:
                doUpdate(payments);
                break;
        }
    }

    public void doFindAll() {
        FacesMessage msg = null;
        IPharmacy<Payments> dao = new PaymentsDAO();

        try {
            final String query = "SELECT p FROM Payments p";
            paymentses = dao.findByQuery(query);
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, MessagesUtil.ERROR_TITLE, MessagesUtil.ERROR + ": " + e.getMessage());
        }

        if (msg != null) {
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public List<Payments> getPaymentses() {
        return paymentses;
    }

    public void setPaymentses(List<Payments> paymentses) {
        this.paymentses = paymentses;
    }

    public Payments getPayments() {
        return payments;
    }

    public void setPayments(Payments payments) {
        this.payments = payments;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public List<StockProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<StockProducto> productos) {
        this.productos = productos;
    }    

    public StockProducto getProducto() {
        return producto;
    }

    public void setProducto(StockProducto producto) {
        this.producto = producto;
    }

}
