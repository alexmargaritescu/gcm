package ro.happyhyppo.gcm;

import java.util.ArrayList;
import java.util.List;


public class GCMResponse {

    private int success;
    
    private int failure;
    
    private int canonical_ids;
    
    private long multicast_id;
    
    private List<CGMResult> results = new ArrayList<CGMResult>();
    
    private List<Long> retryMulticastIds = new ArrayList<Long>();

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }

    public int getCanonical_ids() {
        return canonical_ids;
    }

    public void setCanonical_ids(int canonical_ids) {
        this.canonical_ids = canonical_ids;
    }

    public long getMulticast_id() {
        return multicast_id;
    }

    public void setMulticast_id(long multicast_id) {
        this.multicast_id = multicast_id;
    }

    public List<CGMResult> getResults() {
        return results;
    }

    public void setResults(List<CGMResult> results) {
        this.results = results;
    }

    public List<Long> getRetryMulticastIds() {
        return retryMulticastIds;
    }

    public void setRetryMulticastIds(List<Long> retryMulticastIds) {
        this.retryMulticastIds = retryMulticastIds;
    }
    
    
    
}
