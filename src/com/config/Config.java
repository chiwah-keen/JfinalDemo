package com.config;

import com.action.IndexAction;
import com.action.CmbArticleAction;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.entity.CmbArticleInfo;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;

 
public class Config extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		me.setEncoding("UTF-8");
//		me.setError404View("/jsp/404.jsp");
//		me.setViewType(ViewType.JSP);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/cmbarticle", CmbArticleAction.class);
		me.add("/", IndexAction.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		loadPropertyFile("setting.conf");
		
		DruidPlugin druidPlugin = new DruidPlugin(getProperty("jdbcUrl"),
				getProperty("user"), 
				getProperty("password"));
		
		druidPlugin.set(getPropertyToInt("initialSize"), 
				getPropertyToInt("minIdle"), 
				getPropertyToInt("maxActive"));
		druidPlugin.setMaxWait(getPropertyToInt("maxWait"));
		
		//监控统计
		WallFilter wall = new WallFilter();
		druidPlugin.addFilter(wall);
		//防sql注入
		StatFilter stat = new StatFilter();
		druidPlugin.addFilter(stat);
		me.add(druidPlugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		
		me.add(arp);
		
		arp.addMapping("cmb_crawl_article_info", CmbArticleInfo.class);
		
	}

	@Override
	public void configInterceptor(Interceptors me) {
	}

	@Override
	public void configHandler(Handlers me) {
		
	}

}
