package org.n52.kommonitor.importer.converter;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ConverterMonitor {

    private Map<String, List<String>> failedConversions;

    public ConverterMonitor() {
        this.failedConversions = new HashMap<>();
    }

    public Map<String, List<String>> getFailedConversions() {
        return failedConversions;
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
            failedConversions.put(id, Arrays.asList(cause));
        }
    }

}
