package ro.happyhyppo.gcm;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gcm")
public class GCMResource {

    private final Logger log = LoggerFactory.getLogger(GCMResource.class);

    @Inject
    private GCMService gcmService;

    @RequestMapping(value = "/send", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public GCMResponse processNotification(@RequestHeader(value="Authorization") String key, @RequestBody String json) {
        log.debug("Request to send notification " + json + " with key " + key);
        return gcmService.processRequest(json);
    }

}
