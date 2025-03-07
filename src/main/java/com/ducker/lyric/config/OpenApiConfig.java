package com.ducker.lyric.config;

import com.ducker.lyric.base.WebConstants;
import com.ducker.lyric.config.property.SpringDocProperty;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

@Configuration
@RequiredArgsConstructor
class OpenApiConfig {

    private final SpringDocProperty springDocProperty;

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addServersItem(new Server().url(springDocProperty.getServerUrl()))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
                .info(new Info()
                        .title("Lyric")
                        .version(springDocProperty.getVersion())
                        .termsOfService("https://swagger.io/terms/")
                        .license(new License().
                                name("Apache 2.0").
                                url("https://springdoc.org")));

    }

    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder()
                .group("Authentication")
                .pathsToMatch(WebConstants.API_AUTH_PREFIX_V1 + "/**")
                .build();
    }

    @Bean
    public GroupedOpenApi businessApi() {
        return GroupedOpenApi.builder()
                .group("Lyric APIs")
                .pathsToMatch(WebConstants.API_BASE_PREFIX_V1 + "/**")
                .pathsToExclude(WebConstants.API_AUTH_PREFIX_V1 + "/**")
                .build();
    }


    /**
     * Forward HTTPS requests to Swagger UI
     */
    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }

}
