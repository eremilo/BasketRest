package in.rbaskets.baskets.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasketModel {
    @JsonProperty("forward_url")
    private String forwardUrl;
    @JsonProperty("proxy_response")
    private boolean proxyResponse;
    @JsonProperty("insecure_tls")
    private boolean insecureTls;
    @JsonProperty("expand_path")
    private boolean expandPath;
    @JsonProperty("capacity")
    private int capacity;

    public BasketModel() {
    }

    @Override
    public String toString() {
        return "BasketRequest{" +
                "forwardUrl='" + forwardUrl + '\'' +
                ", proxyResponse=" + proxyResponse +
                ", insecureTls=" + insecureTls +
                ", expandPath=" + expandPath +
                ", capacity=" + capacity +
                '}';
    }

    public static class Builder {
        private BasketModel basketModel;

        public Builder() {
            basketModel = new BasketModel();
        }

        public Builder forwardUrl(String forwardUrl) {
            basketModel.forwardUrl = forwardUrl;
            return this;
        }

        public Builder proxyResponse(Boolean proxyResponse) {
            basketModel.proxyResponse = proxyResponse;
            return this;
        }

        public Builder insecureTls(Boolean insecureTls) {
            basketModel.insecureTls = insecureTls;
            return this;
        }

        public Builder expandPath(Boolean expandPath) {
            basketModel.expandPath = expandPath;
            return this;
        }

        public Builder capacity(int capacity) {
            basketModel.capacity = capacity;
            return this;
        }

        public BasketModel build() {
            return basketModel;
        }
    }
}
