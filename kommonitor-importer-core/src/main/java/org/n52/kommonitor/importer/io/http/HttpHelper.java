package org.n52.kommonitor.importer.io.http;

import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.cache.CacheConfig;
import org.apache.hc.client5.http.impl.cache.CachingHttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Helper class for executing HTTP requests
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class HttpHelper {

    private CloseableHttpClient client;

    public static HttpHelper getBasicHttpHelper() throws IOException {

        final CacheConfig cacheConfig = CacheConfig.custom()
                .setMaxCacheEntries(100)
                .setMaxObjectSize(50000)
                .build();

        CloseableHttpClient client = CachingHttpClientBuilder
                .create()
                .setCacheConfig(cacheConfig)
                .setCacheDir(Files.createTempFile("kommonitor_httphelper", "cache").toFile())
                .build();

        return new HttpHelper(client);
    }

    public HttpHelper(CloseableHttpClient client) {
        this.client = client;
    }

    public byte[] executeHttpGetRequest(HttpGet getRequest) throws IOException {
        HttpClientResponseHandler<byte[]> handler = new ByteArrayResponseHandler();
        return client.execute(getRequest, handler);
    }

    public byte[] executeHttpGetRequest(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return executeHttpGetRequest(request);
    }

    public String executeHttpGetRequestAsString(HttpGet getRequest) throws IOException {
        HttpClientResponseHandler<String> handler = new BasicHttpClientResponseHandler();

        return client.execute(getRequest, handler);
    }

    public String executeHttpGetRequestAsString(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return executeHttpGetRequestAsString(request);
    }

    public void close() throws IOException {
        client.close();
    }

    static class ByteArrayResponseHandler implements HttpClientResponseHandler<byte[]> {
        @Override
        public byte[] handleResponse(ClassicHttpResponse httpResponse) throws IOException {
            if (httpResponse.getCode() >= 300) {
                throw new HttpResponseException(
                        httpResponse.getCode(),
                        httpResponse.getReasonPhrase());
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null) {
                throw new ClientProtocolException("HTTP response contains no content.");
            }
            return IOUtils.toByteArray(entity.getContent());
        }
    }


}
