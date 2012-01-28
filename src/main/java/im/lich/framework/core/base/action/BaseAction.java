package im.lich.framework.core.base.action;

import im.lich.framework.core.base.model.PageModel;
import im.lich.framework.core.base.model.ResponseModel;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * base action
 * 
 * @author ethan
 */
public class BaseAction extends ActionSupport implements ServletContextAware, ServletResponseAware,
		ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 1L;

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private ResponseModel responseModel = new ResponseModel();

	protected ServletContext servletContext;

	protected HttpServletRequest httpServletRequest;

	protected HttpServletResponse httpServletResponse;

	protected HttpSession httpSession;

	protected Map<String, Object> session;

	public ResponseModel getResponseModel() {
		return responseModel;
	}

	public void setResponseModel(ResponseModel responseModel) {
		this.responseModel = responseModel;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.httpServletResponse = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
		this.httpSession = request.getSession();
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String responseModel(Object data) {
		responseModel.setData(data);
		return ActionSupport.SUCCESS;
	}

	public String responseModel(Object data, PageModel pagination) {
		responseModel.setData(data);
		responseModel.setPagination(pagination);
		return ActionSupport.SUCCESS;
	}

	public String responseModel(Object data, PageModel pagination, String message) {
		responseModel.setData(data);
		responseModel.setMessage(message);
		responseModel.setPagination(pagination);
		return ActionSupport.SUCCESS;
	}

	public String responseModel(boolean responseState, String message) {
		responseModel.setResponseState(responseState);
		responseModel.setMessage(message);
		return ActionSupport.SUCCESS;
	}
}
