package com.boliangshenghe.weibodata.common.freemarker; 

import java.io.IOException;
import java.util.Map;

import com.boliangshenghe.weibodata.common.freemarker.OverrideDirective.TemplateDirectiveBodyOverrideWraper;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * @since 2012-11-28 下午3:47:46 
 */
public class SuperDirective implements TemplateDirectiveModel{
	public final static String DIRECTIVE_NAME = "super";
	
	public void execute(Environment env,
            Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
		
		TemplateDirectiveBodyOverrideWraper current = (TemplateDirectiveBodyOverrideWraper)env.getVariable(DirectiveUtils.OVERRIDE_CURRENT_NODE);
		if(current == null) {
			throw new TemplateException("<@super/> direction must be child of override", env);
		}
		TemplateDirectiveBody parent = current.parentBody;
		if(parent == null) {
			throw new TemplateException("not found parent for <@super/>", env);
		}
		parent.render(env.getOut());
		
	}
	
}
