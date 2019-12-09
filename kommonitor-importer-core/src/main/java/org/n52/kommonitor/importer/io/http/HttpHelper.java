package org.n52.kommonitor.importer.io.http;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Helper class for executing HTTP requests
 *
 * @author @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class HttpHelper {

    private CloseableHttpClient client;

    public static HttpHelper getBasicHttpHelper() {
        return new HttpHelper(HttpClients.createDefault());
    }

    public HttpHelper(CloseableHttpClient client) {
        this.client = client;
    }

    public byte[] executeHttpGetRequest(HttpGet getRequest) throws IOException {
        ResponseHandler<byte[]> handler = new ByteArrayResponseHandler();
        return client.execute(getRequest, handler);
    }

    public byte[] executeHttpGetRequest(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return executeHttpGetRequest(request);
    }

    public String executeHttpGetRequestAsString(HttpGet getRequest) throws IOException {
        ResponseHandler<String> handler = new BasicResponseHandler();
        String response = client.execute(getRequest, handler);

        return response;
    }

    public String executeHttpGetRequestAsString(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return executeHttpGetRequestAsString(request);
    }

    public void close() throws IOException {
        client.close();
    }

}
