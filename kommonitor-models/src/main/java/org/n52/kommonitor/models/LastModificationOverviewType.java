package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
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
 * LastModificationOverviewType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T16:25:00.685068500+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class LastModificationOverviewType implements Serializable {

  private static final long serialVersionUID = 1L;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime accessControl;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime georesources;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime indicators;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime processScripts;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime spatialUnits;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime topics;

  public LastModificationOverviewType accessControl(@Nullable OffsetDateTime accessControl) {
    this.accessControl = accessControl;
    return this;
  }

  /**
   * Get accessControl
   * @return accessControl
   */
  @Valid 
  @Schema(name = "access-control", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("access-control")
  public @Nullable OffsetDateTime getAccessControl() {
    return accessControl;
  }

  public void setAccessControl(@Nullable OffsetDateTime accessControl) {
    this.accessControl = accessControl;
  }

  public LastModificationOverviewType georesources(@Nullable OffsetDateTime georesources) {
    this.georesources = georesources;
    return this;
  }

  /**
   * Get georesources
   * @return georesources
   */
  @Valid 
  @Schema(name = "georesources", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("georesources")
  public @Nullable OffsetDateTime getGeoresources() {
    return georesources;
  }

  public void setGeoresources(@Nullable OffsetDateTime georesources) {
    this.georesources = georesources;
  }

  public LastModificationOverviewType indicators(@Nullable OffsetDateTime indicators) {
    this.indicators = indicators;
    return this;
  }

  /**
   * Get indicators
   * @return indicators
   */
  @Valid 
  @Schema(name = "indicators", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("indicators")
  public @Nullable OffsetDateTime getIndicators() {
    return indicators;
  }

  public void setIndicators(@Nullable OffsetDateTime indicators) {
    this.indicators = indicators;
  }

  public LastModificationOverviewType processScripts(@Nullable OffsetDateTime processScripts) {
    this.processScripts = processScripts;
    return this;
  }

  /**
   * Get processScripts
   * @return processScripts
   */
  @Valid 
  @Schema(name = "process-scripts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("process-scripts")
  public @Nullable OffsetDateTime getProcessScripts() {
    return processScripts;
  }

  public void setProcessScripts(@Nullable OffsetDateTime processScripts) {
    this.processScripts = processScripts;
  }

  public LastModificationOverviewType spatialUnits(@Nullable OffsetDateTime spatialUnits) {
    this.spatialUnits = spatialUnits;
    return this;
  }

  /**
   * Get spatialUnits
   * @return spatialUnits
   */
  @Valid 
  @Schema(name = "spatial-units", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("spatial-units")
  public @Nullable OffsetDateTime getSpatialUnits() {
    return spatialUnits;
  }

  public void setSpatialUnits(@Nullable OffsetDateTime spatialUnits) {
    this.spatialUnits = spatialUnits;
  }

  public LastModificationOverviewType topics(@Nullable OffsetDateTime topics) {
    this.topics = topics;
    return this;
  }

  /**
   * Get topics
   * @return topics
   */
  @Valid 
  @Schema(name = "topics", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("topics")
  public @Nullable OffsetDateTime getTopics() {
    return topics;
  }

  public void setTopics(@Nullable OffsetDateTime topics) {
    this.topics = topics;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LastModificationOverviewType lastModificationOverviewType = (LastModificationOverviewType) o;
    return Objects.equals(this.accessControl, lastModificationOverviewType.accessControl) &&
        Objects.equals(this.georesources, lastModificationOverviewType.georesources) &&
        Objects.equals(this.indicators, lastModificationOverviewType.indicators) &&
        Objects.equals(this.processScripts, lastModificationOverviewType.processScripts) &&
        Objects.equals(this.spatialUnits, lastModificationOverviewType.spatialUnits) &&
        Objects.equals(this.topics, lastModificationOverviewType.topics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessControl, georesources, indicators, processScripts, spatialUnits, topics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LastModificationOverviewType {\n");
    sb.append("    accessControl: ").append(toIndentedString(accessControl)).append("\n");
    sb.append("    georesources: ").append(toIndentedString(georesources)).append("\n");
    sb.append("    indicators: ").append(toIndentedString(indicators)).append("\n");
    sb.append("    processScripts: ").append(toIndentedString(processScripts)).append("\n");
    sb.append("    spatialUnits: ").append(toIndentedString(spatialUnits)).append("\n");
    sb.append("    topics: ").append(toIndentedString(topics)).append("\n");
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

