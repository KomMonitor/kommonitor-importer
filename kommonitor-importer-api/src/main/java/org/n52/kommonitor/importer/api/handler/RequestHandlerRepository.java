package org.n52.kommonitor.importer.api.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@Component
public class RequestHandlerRepository {
    @Autowired
    private List<AbstractRequestHandler> requestHandlerList;

    /**
     * Retrieve a certain {@link AbstractRequestHandler} implementation by its class name
     *
     * @param requestType the request type to get a {@link AbstractRequestHandler} for
     * @return an {@link Optional} describing the found {@link AbstractRequestHandler} implementation
     */
    public Optional<AbstractRequestHandler> getRequestHandler(Object requestType) {
        Optional<AbstractRequestHandler> handlerOpt = this.requestHandlerList.stream()
                .filter(i -> i.supports(requestType))
                .findFirst();
        return handlerOpt;
    }
}
