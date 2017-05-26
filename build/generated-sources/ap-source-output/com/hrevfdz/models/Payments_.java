package com.hrevfdz.models;

import com.hrevfdz.models.StartWork;
import com.hrevfdz.models.StockProducto;
import com.hrevfdz.models.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-25T17:31:51")
@StaticMetamodel(Payments.class)
public class Payments_ { 

    public static volatile SingularAttribute<Payments, String> descripcion;
    public static volatile SingularAttribute<Payments, Date> fecha;
    public static volatile SingularAttribute<Payments, Integer> codigo;
    public static volatile SingularAttribute<Payments, BigDecimal> monto;
    public static volatile SingularAttribute<Payments, StockProducto> codStock;
    public static volatile SingularAttribute<Payments, Users> userId;
    public static volatile SingularAttribute<Payments, StartWork> idSw;

}