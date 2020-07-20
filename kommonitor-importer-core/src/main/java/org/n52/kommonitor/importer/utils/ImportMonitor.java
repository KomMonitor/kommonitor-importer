package org.n52.kommonitor.importer.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Monitoring class that holds information about a converting process and the affected resources.
 * <p>
 * Note, that the @RequestScope annotation ensures that an instance of this class will be bound to the current HTTP request.
 * Though, there are no concurrency issues when monitoring multiple converting processes at the same time.
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
@RequestScope
public class ImportMonitor {

    private Map<String, List<String>> failedConversions;

    private Map<String, List<String>> incidents;

    public ImportMonitor() {
        this.failedConversions = new HashMap<>();
        this.incidents = new HashMap<>();
    }

    public Map<String, List<String>> getFailedConversions() {
        return failedConversions;
    }

    public Map<String, List<String>> getIncidents() {
        return incidents;
    }

    /**
     * Adds information about a failed resource conversion.
     *
     * @param id    the ID of the resource for which the conversion failed
     * @param cause cause of the conversion fail
     */
    public void addFailedConversion(String id, String cause) {
        if (failedConversions.containsKey(id)) {
            failedConversions.get(id).add(cause);
        } else {
            List<String> causes = new ArrayList();
            causes.add(cause);
            failedConversions.put(id, causes);
        }
    }

    /**
     * Adds information about a not critical incident during resource conversion.
     *
     * @param id    the ID of the resource for which the incident occurred
     * @param cause cause of the incident
     */
    public void addConversionIncident(String id, String cause) {
        if (incidents.containsKey(id)) {
            incidents.get(id).add(cause);
        } else {
            List<String> causes = new ArrayList();
            causes.add(cause);
            incidents.put(id, causes);
        }
    }

    /**
     * Get a list of all error messages that have been monitored
     *
     * @return list of error messages as String
     */
    public List<String> getErrorMessages() {
        return failedConversions.keySet().stream()
                .map(k -> String.format("Failed conversion for resource '%s'. Cause(s): %s", k, failedConversions.get(k)))
                .collect(Collectors.toList());
    }

    /**
     * Get a list of all warning messages that have been monitored
     *
     * @return list of warning messages as String
     */
    public List<String> getWarningMessages() {
        return incidents.keySet().stream()
                .map(k -> String.format("Non critical incidents during conversion for resource '%s'. Cause(s): %s", k, incidents.get(k)))
                .collect(Collectors.toList());
    }

}
