package com.example.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	    clients.inMemory()
				.withClient("serviceClient")
				.secret("{noop}secret")
				.autoApprove(true)
				.authorizedGrantTypes("client_credentials")
				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
				.scopes("READ", "WRITE", "TRUST")
				.and()
				.withClient("resServer")
				.secret("{noop}secret")
				.autoApprove(true)
				.authorizedGrantTypes("client_credentials")
				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
				.scopes("READ", "WRITE", "TRUST");
	}
 
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(new InMemoryTokenStore());
	}
 
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()")
				.checkTokenAccess("permitAll()");
	}

}


