package myapp.springLibrary;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Flyway entity for database
 */
@Entity
@Table(name = "flyway_schema_history", schema = "elearning", catalog = "")
public class FlywaySchemaHistory {
    private int installedRank;
    private String version;
    private String description;
    private String type;
    private String script;
    private Integer checksum;
    private String installedBy;
    private Timestamp installedOn;
    private int executionTime;
    private byte success;

    @Id
    @Column(name = "installed_rank")
    public int getInstalledRank() {
        return installedRank;
    }

    public void setInstalledRank(int installedRank) {
        this.installedRank = installedRank;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "script")
    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Basic
    @Column(name = "checksum")
    public Integer getChecksum() {
        return checksum;
    }

    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    @Basic
    @Column(name = "installed_by")
    public String getInstalledBy() {
        return installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    @Basic
    @Column(name = "installed_on")
    public Timestamp getInstalledOn() {
        return installedOn;
    }

    public void setInstalledOn(Timestamp installedOn) {
        this.installedOn = installedOn;
    }

    @Basic
    @Column(name = "execution_time")
    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    @Basic
    @Column(name = "success")
    public byte getSuccess() {
        return success;
    }

    public void setSuccess(byte success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlywaySchemaHistory that = (FlywaySchemaHistory) o;
        return installedRank == that.installedRank && executionTime == that.executionTime && success == that.success && Objects.equals(version, that.version) && Objects.equals(description, that.description) && Objects.equals(type, that.type) && Objects.equals(script, that.script) && Objects.equals(checksum, that.checksum) && Objects.equals(installedBy, that.installedBy) && Objects.equals(installedOn, that.installedOn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(installedRank, version, description, type, script, checksum, installedBy, installedOn, executionTime, success);
    }
}
