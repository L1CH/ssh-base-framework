package im.lich.framework.core.base.model;

public class ResponseModel {
	
	/** 响应数据 */
    private Object data;
    /** 响应分页 */
    private PageModel pagination;
	/** 响应状态 */
    private boolean responseState = true;
    /** 响应消息 */
    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PageModel getPagination() {
		return pagination;
	}

	public void setPagination(PageModel pagination) {
		this.pagination = pagination;
	}

	public boolean isResponseState() {
        return responseState;
    }

    public void setResponseState(boolean responseState) {
        this.responseState = responseState;
    }
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
