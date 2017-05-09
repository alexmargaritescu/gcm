package ro.happyhyppo.gcm;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GCMService {

    private final Logger log = LoggerFactory.getLogger(GCMService.class);

    @SuppressWarnings("unchecked")
    public GCMResponse processRequest(String json) {
        List<String> registration_ids;
        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(json, new TypeReference<HashMap<String, Object>>() {
            });
            registration_ids = (List<String>) (map.get("registration_ids"));
            Map<String, Object> data = (Map<String, Object>) map.get("data");
            log.debug(data.toString());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
        GCMResponse response = new GCMResponse();
        int success = registration_ids.size();
        int failure = 0;
        for (String registration_id : registration_ids) {
            boolean error = registration_id.contains("error");
            if (error) {
                success--;
                failure++;
            }
            CGMResult result = new CGMResult();
            result.setMessage_id("OK");
            result.setRegistration_id(registration_id);
            if (error) {
                result.setError("On purpose");
            }
            response.getResults().add(result);
        }
        response.setSuccess(success);
        response.setFailure(failure);
        return response;
    }

}
