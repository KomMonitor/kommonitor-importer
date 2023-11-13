package org.n52.kommonitor.importer.io.http;

import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.cache.CacheConfig;
import org.apache.hc.client5.http.impl.cache.CachingHttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;

/**
 * Helper class for executing HTTP requests
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class HttpHelper {

    private static final Logger LOG = LoggerFactory.getLogger(HttpHelper.class);

    private final CloseableHttpClient client;

    public static HttpHelper getBasicHttpHelper() throws IOException {
        return new HttpHelper(getHttpClientBuilder().build());
    }

    public static HttpHelper getProxyHttpHelper(String host, int port) throws IOException {
        CloseableHttpClient client = getHttpClientBuilder()
                .setProxy(new HttpHost(host, port))
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

    public void close() {
        try {
            client.close();
        } catch (IOException ex) {
            // This will never happen, due to close method implementation of Apache lib
            LOG.error("Closing HTTP client failed.", ex);
        }
    }

    private static CachingHttpClientBuilder getHttpClientBuilder() throws IOException {

        final CacheConfig cacheConfig = CacheConfig.custom()
                .setMaxCacheEntries(100)
                .setMaxObjectSize(50000)
                .build();

        return CachingHttpClientBuilder
                .create()
                .setCacheConfig(cacheConfig)
                .setCacheDir(Files.createTempFile("kommonitor_httphelper", "cache").toFile());
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
