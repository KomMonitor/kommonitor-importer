package org.n52.kommonitor.models;

import java.util.Objects;
import java.util.ArrayList;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;
import jakarta.annotation.Generated;

/**
 * array of periods of validity, each consisting of a start and end date
 */
@ApiModel(description = "array of periods of validity, each consisting of a start and end date")
@Validated
@Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-01-13T17:03:30.872+01:00")

public class AvailablePeriodsOfValidityType extends ArrayList<PeriodOfValidityType> implements Serializable {
  private static final long serialVersionUID = 1L;


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailablePeriodsOfValidityType {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

