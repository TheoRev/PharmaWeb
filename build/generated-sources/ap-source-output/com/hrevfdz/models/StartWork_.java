package com.hrevfdz.models;

import com.hrevfdz.models.Payments;
import com.hrevfdz.models.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-25T17:31:51")
@StaticMetamodel(StartWork.class)
public class StartWork_ { 

    public static volatile SingularAttribute<StartWork, Date> fecha;
    public static volatile SingularAttribute<StartWork, BigDecimal> capital;
    public static volatile ListAttribute<StartWork, Payments> paymentsList;
    public static volatile SingularAttribute<StartWork, Integer> id;
    public static volatile SingularAttribute<StartWork, Users> userId;

}