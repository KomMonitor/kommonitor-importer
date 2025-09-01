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
 * Definition of an uploaded file
 */

@Schema(name = "UploadedFileType", description = "Definition of an uploaded file")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T12:23:45.798187400+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class UploadedFileType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private @Nullable String contentType;

  public UploadedFileType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UploadedFileType(String name) {
    this.name = name;
  }

  public UploadedFileType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the uploaded file
   * @return name
   */
  @NotNull 
  @Schema(name = "name", description = "name of the uploaded file", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UploadedFileType contentType(@Nullable String contentType) {
    this.contentType = contentType;
    return this;
  }

  /**
   * Content type of the uploaded files
   * @return contentType
   */
  
  @Schema(name = "contentType", description = "Content type of the uploaded files", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contentType")
  public @Nullable String getContentType() {
    return contentType;
  }

  public void setContentType(@Nullable String contentType) {
    this.contentType = contentType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadedFileType uploadedFileType = (UploadedFileType) o;
    return Objects.equals(this.name, uploadedFileType.name) &&
        Objects.equals(this.contentType, uploadedFileType.contentType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, contentType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadedFileType {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
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

