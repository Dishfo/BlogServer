package cs.sicnu.fiveg.pojo;

import java.util.Date;

public class VisitTotal {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visit_total.visit_id
     *
     * @mbg.generated
     */
    private Integer visitId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visit_total.visit_date
     *
     * @mbg.generated
     */
    private Date visitDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visit_total.visit_count
     *
     * @mbg.generated
     */
    private Integer visitCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visit_total.visit_id
     *
     * @return the value of visit_total.visit_id
     *
     * @mbg.generated
     */
    public Integer getVisitId() {
        return visitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visit_total.visit_id
     *
     * @param visitId the value for visit_total.visit_id
     *
     * @mbg.generated
     */
    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visit_total.visit_date
     *
     * @return the value of visit_total.visit_date
     *
     * @mbg.generated
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visit_total.visit_date
     *
     * @param visitDate the value for visit_total.visit_date
     *
     * @mbg.generated
     */
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visit_total.visit_count
     *
     * @return the value of visit_total.visit_count
     *
     * @mbg.generated
     */
    public Integer getVisitCount() {
        return visitCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visit_total.visit_count
     *
     * @param visitCount the value for visit_total.visit_count
     *
     * @mbg.generated
     */
    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }
}