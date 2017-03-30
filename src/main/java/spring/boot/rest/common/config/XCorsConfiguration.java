package spring.boot.rest.common.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <p>Title: rest-api-scaffold</p>
 * <p>Description: Function Description</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: eBaoTech Yanzhi.Mo</p>
 * <p>Create Time: 2017/03/30</p>
 *
 * @author <p>Update Time: 2017/03/30</p>
 *         <p>Updater: </p>
 *         <p>Update Comments: </p>
 */
@Configuration
public class XCorsConfiguration {

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(false);
        config.setMaxAge((long) 3600);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}
