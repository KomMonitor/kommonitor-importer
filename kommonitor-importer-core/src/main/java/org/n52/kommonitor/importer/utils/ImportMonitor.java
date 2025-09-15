package org.n52.kommonitor.importer.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private Map<String, List<String>> failedAggregations;

    public ImportMonitor() {
        this.failedConversions = new HashMap<>();
        this.incidents = new HashMap<>();
        this.failedAggregations = new HashMap<>();
    }

    public Map<String, List<String>> getFailedConversions() {
        return failedConversions;
    }

    public Map<String, List<String>> getIncidents() {
        return incidents;
    }

    public Map<String, List<String>> getFailedAggregations() {
        return failedAggregations;
    }

    /**
     * Adds information about a failed resource conversion.
     *
     * @param id    the ID of the resource for which the conversion failed
     * @param cause cause of the conversion fail
     */
    public void addFailedConversion(String id, String cause) {
        addFailure(failedConversions, id, cause);
    }

    /**
     * Adds information about a not critical incident during resource conversion.
     *
     * @param id    the ID of the resource for which the incident occurred
     * @param cause cause of the incident
     */
    public void addConversionIncident(String id, String cause) {
        addFailure(incidents, id, cause);
    }

    /**
     * Adds information about a failed aggregation.
     *
     * @param id    the ID of the resource for which the conversion failed
     * @param cause cause of the conversion fail
     */
    public void addFailedAggregation(String id, String cause) {
        addFailure(failedAggregations, id, cause);
    }


    private void addFailure(Map<String, List<String>> failureMap, String id, String cause) {
        if (failureMap.containsKey(id)) {
            failureMap.get(id).add(cause);
        } else {
            List<String> causes = new ArrayList<>();
            causes.add(cause);
            failureMap.put(id, causes);
        }
    }

    /**
     * Get a list of all error messages that have been monitored
     *
     * @return list of error messages as String
     */
    public List<String> getErrorMessages() {
        List<String> aggregationErrorMessages = failedAggregations.keySet().stream()
                .map(k -> String.format("Failed aggregation for spatial unit '%s'. Cause(s): %s", k, failedAggregations.get(k)))
                .toList();

        List<String> conversionErrorMessages = failedConversions.keySet().stream()
                .map(k -> String.format("Failed conversion for resource '%s'. Cause(s): %s", k, failedConversions.get(k)))
                .toList();

        return Stream.of(aggregationErrorMessages, conversionErrorMessages)
                .flatMap(Collection::stream)
                .toList();
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
