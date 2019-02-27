package entities.db;

import persistence.abstracts.SalaryVariations;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "salariestable", schema = "curse", catalog = "")
public class dbSalariestableEntity extends SalaryVariations implements Serializable {
    private static final long serialVersionUID = 1L;

    //region Fields
    private int salaryId;
    private Boolean work;
    private Boolean farm;
    private Boolean grants;
    private Boolean pension;
    private Boolean allowance;
    private Boolean disabled;
    private Boolean unemployment;
    private Boolean govSupport;
    private Boolean savings;
    private Boolean leasing;
    private Boolean alimony;
    private Boolean other;
    private String otherString;
    //endregion

    //region GETTERs and SETTERs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalaryId", nullable = false)
    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    @Basic
    @Column(name = "Work", nullable = true)
    public Boolean getWork() {
        return work;
    }

    public void setWork(Boolean work) {
        this.work = work;
    }

    @Basic
    @Column(name = "Farm", nullable = true)
    public Boolean getFarm() {
        return farm;
    }

    public void setFarm(Boolean farm) {
        this.farm = farm;
    }

    @Basic
    @Column(name = "Grants", nullable = true)
    public Boolean getGrants() {
        return grants;
    }

    public void setGrants(Boolean grants) {
        this.grants = grants;
    }

    @Basic
    @Column(name = "Pension", nullable = true)
    public Boolean getPension() {
        return pension;
    }

    public void setPension(Boolean pension) {
        this.pension = pension;
    }

    @Basic
    @Column(name = "Allowance", nullable = true)
    public Boolean getAllowance() {
        return allowance;
    }

    public void setAllowance(Boolean allowance) {
        this.allowance = allowance;
    }

    @Basic
    @Column(name = "Disabled", nullable = true)
    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @Basic
    @Column(name = "Unemployment", nullable = true)
    public Boolean getUnemployment() {
        return unemployment;
    }

    public void setUnemployment(Boolean unemployment) {
        this.unemployment = unemployment;
    }

    @Basic
    @Column(name = "GovSupport", nullable = true)
    public Boolean getGovSupport() {
        return govSupport;
    }

    public void setGovSupport(Boolean govSupport) {
        this.govSupport = govSupport;
    }

    @Basic
    @Column(name = "Savings", nullable = true)
    public Boolean getSavings() {
        return savings;
    }

    public void setSavings(Boolean savings) {
        this.savings = savings;
    }

    @Basic
    @Column(name = "Leasing", nullable = true)
    public Boolean getLeasing() {
        return leasing;
    }

    public void setLeasing(Boolean leasing) {
        this.leasing = leasing;
    }

    @Basic
    @Column(name = "Alimony", nullable = true)
    public Boolean getAlimony() {
        return alimony;
    }

    public void setAlimony(Boolean alimony) {
        this.alimony = alimony;
    }

    @Basic
    @Column(name = "Other", nullable = true)
    public Boolean getOther() {
        return other;
    }

    public void setOther(Boolean other) {
        this.other = other;
    }

    @Basic
    @Column(name = "OtherString", nullable = true)
    public String getOtherString() {
        return otherString;
    }

    public void setOtherString(String otherString){
        this.otherString = otherString;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dbSalariestableEntity that = (dbSalariestableEntity) o;
        return salaryId == that.salaryId &&
                Objects.equals(work, that.work) &&
                Objects.equals(farm, that.farm) &&
                Objects.equals(grants, that.grants) &&
                Objects.equals(pension, that.pension) &&
                Objects.equals(allowance, that.allowance) &&
                Objects.equals(disabled, that.disabled) &&
                Objects.equals(unemployment, that.unemployment) &&
                Objects.equals(govSupport, that.govSupport) &&
                Objects.equals(savings, that.savings) &&
                Objects.equals(leasing, that.leasing) &&
                Objects.equals(alimony, that.alimony) &&
                Objects.equals(other, that.other) &&
                Objects.equals(otherString, that.otherString);

    }

    @Override
    public int hashCode() {

        return Objects.hash(salaryId, work, farm, grants, pension, allowance, disabled, unemployment, govSupport, savings, leasing, alimony, other, otherString);
    }

    public String createStringVersion(){
        String result = "";
        if (work != null && work){
            result += variations.get(0) + ", ";
        }
        if (farm != null && farm) {
            result += variations.get(1) + ", ";
        }
        if (grants != null && grants){
            result += variations.get(2) + ", ";
        }
        if (pension != null && pension){
            result += variations.get(3) + ", ";
        }
        if (allowance != null && allowance){
            result += variations.get(4) + ", ";
        }
        if (disabled != null && disabled) {
            result += variations.get(5) + ", ";
        }
        if (unemployment != null && unemployment) {
            result += variations.get(6) + ", ";
        }
        if (govSupport != null && govSupport) {
            result += variations.get(7) + ", ";
        }
        if (savings != null && savings){
            result += variations.get(8) + ", ";
        }
        if (leasing != null && leasing){
            result += variations.get(9) + ", ";
        }
        if (alimony != null && alimony){
            result += variations.get(10) + ", ";
        }
        if (other != null && other){
            result += otherString + ", ";
        }
        if (!result.isEmpty()){
            result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
            result = result.substring(0, result.length() - 2);
        } else {
            result = " ";
        }
        return result;
    }

    public String giveMainSource (Integer index){
        if (index == null){
            return " ";
        } else {
            return variations.get(index-1);
        }
    }
}
