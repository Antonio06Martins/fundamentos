package solid.LiskovSubstitutionPrinciple;

import java.util.Date;

public class Cliente {
    private Date registrationDate;

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
