package org.n52.kommonitor.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * RoleOverviewType
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-23T17:54:30.264884973+02:00[Europe/Berlin]")
public class RoleOverviewType implements Serializable {

  private static final long serialVersionUID = 1L;

  private String roleId;

  private String roleName;

  /**
   * Default constructor
   * @deprecated Use {@link RoleOverviewType#RoleOverviewType(String, String)}
   */
  @Deprecated
  public RoleOverviewType() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RoleOverviewType(String roleId, String roleName) {
    this.roleId = roleId;
    this.roleName = roleName;
  }

  public RoleOverviewType roleId(String roleId) {
    this.roleId = roleId;
    return this;
  }

  /**
   * the unique role identifier
   * @return roleId
  */
  @NotNull 
  @Schema(name = "roleId", description = "the unique role identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("roleId")
  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

  public RoleOverviewType roleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  /**
   * the role name
   * @return roleName
  */
  @NotNull 
  @Schema(name = "roleName", description = "the role name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("roleName")
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleOverviewType roleOverviewType = (RoleOverviewType) o;
    return Objects.equals(this.roleId, roleOverviewType.roleId) &&
        Objects.equals(this.roleName, roleOverviewType.roleName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleId, roleName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleOverviewType {\n");
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    roleName: ").append(toIndentedString(roleName)).append("\n");
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

