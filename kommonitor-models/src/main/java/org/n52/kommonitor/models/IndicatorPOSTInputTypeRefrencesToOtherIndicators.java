package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * IndicatorPOSTInputTypeRefrencesToOtherIndicators
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T16:25:00.685068500+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class IndicatorPOSTInputTypeRefrencesToOtherIndicators implements Serializable {

  private static final long serialVersionUID = 1L;

  private @Nullable String indicatorId;

  private @Nullable String referenceDescription;

  public IndicatorPOSTInputTypeRefrencesToOtherIndicators indicatorId(@Nullable String indicatorId) {
    this.indicatorId = indicatorId;
    return this;
  }

  /**
   * identifier of the referenced indicator
   * @return indicatorId
   */
  
  @Schema(name = "indicatorId", description = "identifier of the referenced indicator", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("indicatorId")
  public @Nullable String getIndicatorId() {
    return indicatorId;
  }

  public void setIndicatorId(@Nullable String indicatorId) {
    this.indicatorId = indicatorId;
  }

  public IndicatorPOSTInputTypeRefrencesToOtherIndicators referenceDescription(@Nullable String referenceDescription) {
    this.referenceDescription = referenceDescription;
    return this;
  }

  /**
   * short description of how the indicator is referenced to the superior one
   * @return referenceDescription
   */
  
  @Schema(name = "referenceDescription", description = "short description of how the indicator is referenced to the superior one", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("referenceDescription")
  public @Nullable String getReferenceDescription() {
    return referenceDescription;
  }

  public void setReferenceDescription(@Nullable String referenceDescription) {
    this.referenceDescription = referenceDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndicatorPOSTInputTypeRefrencesToOtherIndicators indicatorPOSTInputTypeRefrencesToOtherIndicators = (IndicatorPOSTInputTypeRefrencesToOtherIndicators) o;
    return Objects.equals(this.indicatorId, indicatorPOSTInputTypeRefrencesToOtherIndicators.indicatorId) &&
        Objects.equals(this.referenceDescription, indicatorPOSTInputTypeRefrencesToOtherIndicators.referenceDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indicatorId, referenceDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndicatorPOSTInputTypeRefrencesToOtherIndicators {\n");
    sb.append("    indicatorId: ").append(toIndentedString(indicatorId)).append("\n");
    sb.append("    referenceDescription: ").append(toIndentedString(referenceDescription)).append("\n");
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

