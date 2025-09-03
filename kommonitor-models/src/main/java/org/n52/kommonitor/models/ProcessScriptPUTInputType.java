package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.n52.kommonitor.models.ProcessInputType;
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
 * ProcessScriptPUTInputType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-09-01T16:25:00.685068500+02:00[Europe/Berlin]", comments = "Generator version: 7.15.0")
public class ProcessScriptPUTInputType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String description;

  private String name;

  @Valid
  private List<String> requiredGeoresourceIds = new ArrayList<>();

  @Valid
  private List<String> requiredIndicatorIds = new ArrayList<>();

  private String scriptCodeBase64;

  private @Nullable String scriptType;

  @Valid
  private List<@Valid ProcessInputType> variableProcessParameters = new ArrayList<>();

  public ProcessScriptPUTInputType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProcessScriptPUTInputType(String description, String name, List<String> requiredGeoresourceIds, List<String> requiredIndicatorIds, String scriptCodeBase64, List<@Valid ProcessInputType> variableProcessParameters) {
    this.description = description;
    this.name = name;
    this.requiredGeoresourceIds = requiredGeoresourceIds;
    this.requiredIndicatorIds = requiredIndicatorIds;
    this.scriptCodeBase64 = scriptCodeBase64;
    this.variableProcessParameters = variableProcessParameters;
  }

  public ProcessScriptPUTInputType description(String description) {
    this.description = description;
    return this;
  }

  /**
   * short description of the scripts content (what does it do)
   * @return description
   */
  @NotNull 
  @Schema(name = "description", description = "short description of the scripts content (what does it do)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProcessScriptPUTInputType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the process script
   * @return name
   */
  @NotNull 
  @Schema(name = "name", description = "name of the process script", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProcessScriptPUTInputType requiredGeoresourceIds(List<String> requiredGeoresourceIds) {
    this.requiredGeoresourceIds = requiredGeoresourceIds;
    return this;
  }

  public ProcessScriptPUTInputType addRequiredGeoresourceIdsItem(String requiredGeoresourceIdsItem) {
    if (this.requiredGeoresourceIds == null) {
      this.requiredGeoresourceIds = new ArrayList<>();
    }
    this.requiredGeoresourceIds.add(requiredGeoresourceIdsItem);
    return this;
  }

  /**
   * identifiers of georesources that are used within the script.
   * @return requiredGeoresourceIds
   */
  @NotNull 
  @Schema(name = "requiredGeoresourceIds", description = "identifiers of georesources that are used within the script.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requiredGeoresourceIds")
  public List<String> getRequiredGeoresourceIds() {
    return requiredGeoresourceIds;
  }

  public void setRequiredGeoresourceIds(List<String> requiredGeoresourceIds) {
    this.requiredGeoresourceIds = requiredGeoresourceIds;
  }

  public ProcessScriptPUTInputType requiredIndicatorIds(List<String> requiredIndicatorIds) {
    this.requiredIndicatorIds = requiredIndicatorIds;
    return this;
  }

  public ProcessScriptPUTInputType addRequiredIndicatorIdsItem(String requiredIndicatorIdsItem) {
    if (this.requiredIndicatorIds == null) {
      this.requiredIndicatorIds = new ArrayList<>();
    }
    this.requiredIndicatorIds.add(requiredIndicatorIdsItem);
    return this;
  }

  /**
   * identifiers of indicators that are used within the script.
   * @return requiredIndicatorIds
   */
  @NotNull 
  @Schema(name = "requiredIndicatorIds", description = "identifiers of indicators that are used within the script.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requiredIndicatorIds")
  public List<String> getRequiredIndicatorIds() {
    return requiredIndicatorIds;
  }

  public void setRequiredIndicatorIds(List<String> requiredIndicatorIds) {
    this.requiredIndicatorIds = requiredIndicatorIds;
  }

  public ProcessScriptPUTInputType scriptCodeBase64(String scriptCodeBase64) {
    this.scriptCodeBase64 = scriptCodeBase64;
    return this;
  }

  /**
   * the actual script code (JavaScript) as BASE64 encoded string
   * @return scriptCodeBase64
   */
  @NotNull 
  @Schema(name = "scriptCodeBase64", description = "the actual script code (JavaScript) as BASE64 encoded string", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("scriptCodeBase64")
  public String getScriptCodeBase64() {
    return scriptCodeBase64;
  }

  public void setScriptCodeBase64(String scriptCodeBase64) {
    this.scriptCodeBase64 = scriptCodeBase64;
  }

  public ProcessScriptPUTInputType scriptType(@Nullable String scriptType) {
    this.scriptType = scriptType;
    return this;
  }

  /**
   * a script type reference name used to distuingish process scripts from a client perspective, i.e. setup admin pages due to knowledge about type-specific script parameters and required indicators/georesources
   * @return scriptType
   */
  
  @Schema(name = "scriptType", description = "a script type reference name used to distuingish process scripts from a client perspective, i.e. setup admin pages due to knowledge about type-specific script parameters and required indicators/georesources", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("scriptType")
  public @Nullable String getScriptType() {
    return scriptType;
  }

  public void setScriptType(@Nullable String scriptType) {
    this.scriptType = scriptType;
  }

  public ProcessScriptPUTInputType variableProcessParameters(List<@Valid ProcessInputType> variableProcessParameters) {
    this.variableProcessParameters = variableProcessParameters;
    return this;
  }

  public ProcessScriptPUTInputType addVariableProcessParametersItem(ProcessInputType variableProcessParametersItem) {
    if (this.variableProcessParameters == null) {
      this.variableProcessParameters = new ArrayList<>();
    }
    this.variableProcessParameters.add(variableProcessParametersItem);
    return this;
  }

  /**
   * list of process parameters that can be set by an expert user. They are used within the script to parameterize the indicator computation
   * @return variableProcessParameters
   */
  @NotNull @Valid 
  @Schema(name = "variableProcessParameters", description = "list of process parameters that can be set by an expert user. They are used within the script to parameterize the indicator computation", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("variableProcessParameters")
  public List<@Valid ProcessInputType> getVariableProcessParameters() {
    return variableProcessParameters;
  }

  public void setVariableProcessParameters(List<@Valid ProcessInputType> variableProcessParameters) {
    this.variableProcessParameters = variableProcessParameters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessScriptPUTInputType processScriptPUTInputType = (ProcessScriptPUTInputType) o;
    return Objects.equals(this.description, processScriptPUTInputType.description) &&
        Objects.equals(this.name, processScriptPUTInputType.name) &&
        Objects.equals(this.requiredGeoresourceIds, processScriptPUTInputType.requiredGeoresourceIds) &&
        Objects.equals(this.requiredIndicatorIds, processScriptPUTInputType.requiredIndicatorIds) &&
        Objects.equals(this.scriptCodeBase64, processScriptPUTInputType.scriptCodeBase64) &&
        Objects.equals(this.scriptType, processScriptPUTInputType.scriptType) &&
        Objects.equals(this.variableProcessParameters, processScriptPUTInputType.variableProcessParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, requiredGeoresourceIds, requiredIndicatorIds, scriptCodeBase64, scriptType, variableProcessParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessScriptPUTInputType {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    requiredGeoresourceIds: ").append(toIndentedString(requiredGeoresourceIds)).append("\n");
    sb.append("    requiredIndicatorIds: ").append(toIndentedString(requiredIndicatorIds)).append("\n");
    sb.append("    scriptCodeBase64: ").append(toIndentedString(scriptCodeBase64)).append("\n");
    sb.append("    scriptType: ").append(toIndentedString(scriptType)).append("\n");
    sb.append("    variableProcessParameters: ").append(toIndentedString(variableProcessParameters)).append("\n");
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

