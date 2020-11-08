package com.tianque.doraemon.bv;

import com.tianque.doraemon.bv.config.properties.AjCaptchaProperties;
import com.tianque.doraemon.bv.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan("com.tianque.doraemon")
public class BehaviorVerificationApplication {

	@Autowired
	private AjCaptchaProperties captchaProperties;

	public static void main(String[] args) {
		SpringApplication.run(BehaviorVerificationApplication.class, args);
	}

	@PostConstruct
	private void init() {
		initializeBaseMap(captchaProperties.getJigsaw(), captchaProperties.getPicClick());
	}

	private void initializeBaseMap(String jigsaw, String picClick) {
		ImageUtils.cacheBootImage(getResourcesImagesFile(jigsaw + "/original/*.png"),
				getResourcesImagesFile(jigsaw + "/slidingBlock/*.png"),
				getResourcesImagesFile(picClick + "/*.png"));
	}

	private Map<String, String> getResourcesImagesFile(String path) {
		Map<String, String> imgMap = new HashMap<>();
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			Resource[] resources = resolver.getResources(path);
			for (Resource resource : resources) {
				byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
				String string = Base64Utils.encodeToString(bytes);
				String filename = resource.getFilename();
				imgMap.put(filename, string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgMap;
	}

}

