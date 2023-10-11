package kr.kdev.backend.version;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@RestController
public class VersionApi {

    private final VersionService versionService;

    @GetMapping("/version")
    public Map<String, Object> version() {
        return Map.of("build", versionService.build());
    }
}
