package org.n52.kommonitor.importer.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * definition of the period of validity of a certain dataset
 */
@ApiModel(description = "definition of the period of validity of a certain dataset")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-21T17:13:28.580+01:00")

public class PeriodOfValidityType  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  public PeriodOfValidityType startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * a timestamp representing the starting date according to ISO 8601 (e.g. 2018-01-30)
   * @return startDate
  **/
  @ApiModelProperty(required = true, value = "a timestamp representing the starting date according to ISO 8601 (e.g. 2018-01-30)")
  @NotNull

  @Valid

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public PeriodOfValidityType endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * an optional timestamp representing the ending date according to ISO 8601 (e.g. 2018-01-30). The parameter can be omitted, if the end date is unknown.
   * @return endDate
  **/
  @ApiModelProperty(value = "an optional timestamp representing the ending date according to ISO 8601 (e.g. 2018-01-30). The parameter can be omitted, if the end date is unknown.")

  @Valid

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PeriodOfValidityType periodOfValidityType = (PeriodOfValidityType) o;
    return Objects.equals(this.startDate, periodOfValidityType.startDate) &&
        Objects.equals(this.endDate, periodOfValidityType.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PeriodOfValidityType {\n");
    
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

