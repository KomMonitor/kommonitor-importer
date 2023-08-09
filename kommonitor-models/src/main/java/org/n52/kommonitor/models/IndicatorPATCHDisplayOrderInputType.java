package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * IndicatorPATCHDisplayOrderInputType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-09T08:09:32.872238100+02:00[Europe/Berlin]")
public class IndicatorPATCHDisplayOrderInputType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String indicatorId;

  private BigDecimal displayOrder;

  /**
   * Default constructor
   * @deprecated Use {@link IndicatorPATCHDisplayOrderInputType#IndicatorPATCHDisplayOrderInputType(String, BigDecimal)}
   */
  @Deprecated
  public IndicatorPATCHDisplayOrderInputType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public IndicatorPATCHDisplayOrderInputType(String indicatorId, BigDecimal displayOrder) {
    this.indicatorId = indicatorId;
    this.displayOrder = displayOrder;
  }

  public IndicatorPATCHDisplayOrderInputType indicatorId(String indicatorId) {
    this.indicatorId = indicatorId;
    return this;
  }

  /**
   * unique ID of the associated indicator
   * @return indicatorId
  */
  @NotNull 
  @Schema(name = "indicatorId", description = "unique ID of the associated indicator", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("indicatorId")
  public String getIndicatorId() {
    return indicatorId;
  }

  public void setIndicatorId(String indicatorId) {
    this.indicatorId = indicatorId;
  }

  public IndicatorPATCHDisplayOrderInputType displayOrder(BigDecimal displayOrder) {
    this.displayOrder = displayOrder;
    return this;
  }

  /**
   * the new displayOrder value
   * @return displayOrder
  */
  @NotNull @Valid 
  @Schema(name = "displayOrder", description = "the new displayOrder value", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("displayOrder")
  public BigDecimal getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(BigDecimal displayOrder) {
    this.displayOrder = displayOrder;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPATCHDisplayOrderInputType indicatorPATCHDisplayOrderInputType = (IndicatorPATCHDisplayOrderInputType) o;
    return Objects.equals(this.indicatorId, indicatorPATCHDisplayOrderInputType.indicatorId) &&
        Objects.equals(this.displayOrder, indicatorPATCHDisplayOrderInputType.displayOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indicatorId, displayOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPATCHDisplayOrderInputType {\n");
    sb.append("    indicatorId: ").append(toIndentedString(indicatorId)).append("\n");
    sb.append("    displayOrder: ").append(toIndentedString(displayOrder)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

