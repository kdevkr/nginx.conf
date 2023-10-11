package kr.kdev.backend.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VersionService {

    @Autowired(required = false)
    private BuildProperties buildProperties;

    @Cacheable(cacheNames = "version", key = "#root.methodName")
    public Map<String, Object> build() {
        Map<String, Object> properties = new HashMap<>();
        if (buildProperties != null) {
            properties.put("artifact", buildProperties.getArtifact());
            properties.put("group", buildProperties.getGroup());
            properties.put("name", buildProperties.getName());
            properties.put("version", buildProperties.getVersion());
            properties.put("time", buildProperties.getTime());
        }
        return properties;
    }
}
